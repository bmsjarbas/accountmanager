import ie.britoj.accountmanager.CommandLineApp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        CommandLineApp app = new CommandLineApp(scanner, System.out);
        app.run();
    }
}
