package at.ac.fhcampuswien;

import java.io.IOException;
import java.util.Scanner;

public class Menu {


    private AppController controller = new AppController();
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
                getTopHeadlinesAustria(controller);
                System.out.println();
                start();
            }
            case "b" -> {
                getAllNewsBitcoin(controller);
                System.out.println();
                start();
            }
            case "y" -> {
                getArticleCount(controller);
                System.out.println();
                start();
            }
            /* Nico working on it
            case "l" -> {
                getLongestAuthor(controller);
                System.out.println();
                start();
            }*/
            case "r" -> {
                getTitlesLessThan15(controller);
                System.out.println();
                start();
            }
            case "m" -> {
                mostArticleSource(controller);
                System.out.println();
                start();
            }
            case "n" -> {
                newYorkTimes(controller);
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
        } catch (NullPointerException | NewsAPIException e){
            System.out.println("Sorry! There are no top headlines in Austria!");
            System.out.println(e.getMessage());
        }
    }

    private void getAllNewsBitcoin(AppController ctrl) {
        try {
            System.out.println(ctrl.getAllNewsBitcoin());
        } catch (NullPointerException | NewsAPIException e){
            System.out.println("Sadly, there are no news about bitcoin!");
        }
    }

    private void getArticleCount(AppController ctrl){
        System.out.println("No. of Articles: " + ctrl.getArticleCount());
    }
/*    (Nico [nicht niggo]: working on it
    private void getLongestAuthor(AppController ctrl){
        System.out.println("Longest Author name: " + ctrl.getLongestName());
    }
    */

    private void getTitlesLessThan15(AppController ctrl){
        if (ctrl.getTitlesLessThan15() == null){
            System.out.println("There are no articles with titles smaller than 15 characters!");
        }else {
            System.out.println("Articles with titles smaller than 15 characters: " + ctrl.getTitlesLessThan15());
        }
    }

    private void mostArticleSource(AppController ctrl) {
        String result = ctrl.outputMostArticleSource();
        if (result == null) {
            System.out.println("Not available");
        }
        else {
            System.out.println("Most articles by : " + result);
        }
    }

    private void newYorkTimes(AppController ctrl) {
        long result = ctrl.checkForSpecificSource("New York Times");
        if (result == 0) {
            System.out.println("None");
        }
        else {
            System.out.println("Articles published at New York Times : " + result);
        }
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
        /* Nico working on it
        System.out.println("l: Longest Author name");
        */
        System.out.println("m: Most Article Source");
        System.out.println("n: New York Times");
        System.out.println("r: Articles with titles smaller than 15 characters");
        System.out.println("q: Quit program");
        System.out.println();
    }
}