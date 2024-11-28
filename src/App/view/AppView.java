package App.view;

import java.util.Scanner;

public class AppView {
    private final Scanner scanner = new Scanner(System.in);

    public String getFileContent() {
        System.out.print("Enter file content: ");

        return scanner.nextLine().trim();
    }
    public String getFileName() {
        System.out.print("Enter file name: ");

        return scanner.nextLine().trim();
    }
    public void closeScanner() {
        scanner.close();
    }
    public void writeOutput(String item) {
        System.out.print(item + " ");
    }
}
