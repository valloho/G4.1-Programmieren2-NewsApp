package at.ac.fhcampuswien;

import java.util.Scanner;

public class Menu {

    //private final AppController controller = new AppController();
    private static final String INVALID_USER_INPUT_MESSAGE = "Your input was invalid. Try again!";
    private static final String EXIT_MESSAGE = "Thank you for using our app! Goodbye :)";

    public void start(){
        Scanner scanner = new Scanner(System.in);
        printMenu();
        handleInput(scanner.next());
    }

    private void handleInput(String input){
        switch (input) {
            case "a" -> {
                getTopHeadlinesAustria(AppController.getInstance());
                System.out.println();
                start();
            }
            case "b" -> {
                getAllNewsBitcoin(AppController.getInstance());
                System.out.println();
                start();
            }
            case "y" -> {
                getArticleCount(AppController.getInstance());
                System.out.println();
                start();
            }
            case "q" -> printExitMessage();
            default -> {
                printInvalidInputMessage();
                System.out.println();
                start();
            }
        }
    }

    private void getTopHeadlinesAustria(AppController ctrl){
        try {
            System.out.println(ctrl.getTopHeadLinesAustria());
        } catch (NullPointerException e){
            System.out.println("There are no top headlines in Austria!");
        }
    }

    private void getAllNewsBitcoin(AppController ctrl){
        try {
            System.out.println(ctrl.getAllNewsBitcoin());
        } catch (NullPointerException e){
            System.out.println("There are no news about bitcoin!");
        }
    }

    private void getArticleCount(AppController ctrl){
        System.out.println("No. of Articles: " + ctrl.getArticleCount());
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
        System.out.println();
    }
}