package ui;

import java.util.Scanner;

public class Console {
    Scanner console;

    public Console() {
        console = new Scanner(System.in);
    }
    public String requestString() {
        String input = console.nextLine();
        input = (input == null || input == "") ? requestString() : input.trim();
        return input;
    }
    public String requestString(String request) {
        System.out.print(request + ": ");
        String input = console.nextLine();
        input = (input == null || input == "") ? requestString(request) : input.trim();
        return input;
    }

    public int requestInt() {
        Integer input = console.nextInt();
        input = (input == null) ? requestInt() : input;
        return input;
    }

    public int requestInt(String request) {
        System.out.print(request + ": ");
        Integer input = console.nextInt();
        input = (input == null) ? requestInt(request) : input;
        return input;
    }
    public void printLineGrapic() {
        System.out.println("=============");
    }
}

