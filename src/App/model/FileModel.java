package App.model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileModel {

    public String createDir(String path) {
        try {
            Path directoryPath = Files.createDirectory(Paths.get(path));
            return  "New Dir: " + directoryPath;
        } catch (FileAlreadyExistsException e) {
            return "Directory already exists!";
        } catch (IOException e) {
            return "Something wrong " + e.getMessage();
        }
    }

    public String createFile(String filePath) {
        try {
            Path newFile = Files.createFile(Path.of(filePath));
            return newFile + " created!";
        } catch (FileAlreadyExistsException e) {
            return "File already exists!";
        } catch (IOException e) {
            return "Something wrong " + e.getMessage();
        }
    }

    public String writeToFile(String content, String path) {
        try {
            Path filePath = Files.writeString(Paths.get(path), content);
            return filePath + " - file has written successfully";
        } catch (IOException e) {
            return e.getMessage();
        }
    }
    public String pureWriteToFile(String content, String path) {
        FileChannel fileChannel;
        try (FileOutputStream fos = new FileOutputStream(path)) {
            byte[] contentBytes = content.getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(contentBytes.length);
            buffer.put(contentBytes);
            fileChannel = fos.getChannel();
            buffer.flip();
            fileChannel.write(buffer);
            return "The content has written.";
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    public String readFromFile(String path) {
        try {
            return Files.readString(Paths.get(path));
        } catch (IOException e) {
            return "Something wrong " + e.getMessage();
        }
    }
}
