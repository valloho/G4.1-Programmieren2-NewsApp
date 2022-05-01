package at.ac.fhcampuswien;

import java.util.Scanner;

public class Menu {


    private AppController controller = new AppController();
    private static final String INVALID_USER_INPUT_MESSAGE = "Your input was invalid. Try again!";
    private static final String EXIT_MESSAGE = "Thank you for using our app! Goodbye :)";

    public void start(){
        Scanner scanner = new Scanner(System.in);
        printMenu();
        System.out.println();
        handleInput(scanner.next());
    }

    private void handleInput(String input){
        switch (input) {
            case "a" -> getTopHeadlinesAustria(controller);
            case "b" -> getAllNewsBitcoin(controller);
            case "y" -> getArticleCount(controller);
            case "q" -> printExitMessage();
            default -> {
                printInvalidInputMessage();
                System.out.println();
                start();
            }
        }
    }

    private void getTopHeadlinesAustria(AppController ctrl){
        ctrl.getTopHeadLinesAustria();
    }

    private void getAllNewsBitcoin(AppController ctrl){
        ctrl.getAllNewsBitcoin();
    }

    private void getArticleCount(AppController ctrl){
        ctrl.getArticleCount();
    }

    private static void printInvalidInputMessage(){
        System.out.println(INVALID_USER_INPUT_MESSAGE);
    }

    private static void printExitMessage(){
        System.out.println(EXIT_MESSAGE);
    }

    private static void printMenu(){
        System.out.println("****************************");
        System.out.println("*    Welcome to NewsApp    *");
        System.out.println("****************************");
        System.out.println("Enter what you wanna do:");
        System.out.println("a: Get top headlines austria");
        System.out.println("b: Get all news about bitcoin");
        System.out.println("y: Count articles");
        System.out.println("q: Quit program");
    }
}