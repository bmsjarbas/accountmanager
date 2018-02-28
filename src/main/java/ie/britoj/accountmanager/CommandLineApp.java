package ie.britoj.accountmanager;

import ie.britoj.accountmanager.domain.entities.Account;

import java.io.PrintStream;
import java.util.Scanner;

public class CommandLineApp {

    private final Scanner scanner;

    public CommandLineApp(Scanner scanner, PrintStream outputStream) {
        this.scanner = scanner;
        System.setOut(outputStream);
    }

    public void run() {
        printMainMenu();

        boolean validMainMenuSelection = false;
        String mainMenuSelection = "";
        while (!validMainMenuSelection) {
            if (scanner.hasNext()) {
                mainMenuSelection = scanner.next();
                validMainMenuSelection = mainMenuSelection.equals("oa") || mainMenuSelection.equals("ex");
                if (!validMainMenuSelection) {
                    System.out.println("invalid option");
                }
            }
        }

        if (mainMenuSelection.equals("oa")) {
            System.out.println("Please inform the holder account name:");
            String accountHolder = scanner.next();
            Account account = new Account(accountHolder);
            printAccountMenu();

        }
    }


    private void printMainMenu() {
        System.out.println("Please select a option:");
        System.out.println("oa - open an account");
        System.out.println("ex - exit");
    }

    private void printAccountMenu() {
        System.out.println("Please select a option:");
        System.out.println("de - deposit");
        System.out.println("wi - withdraw");
        System.out.println("st - statement");
        System.out.println("ex - exit");
    }
}
