package at.ac.fhcampuswien;

import at.ac.fhcampuswien.downloader.ParallelDownloader;
import at.ac.fhcampuswien.downloader.SequentialDownloader;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    private static final String INVALID_USER_INPUT_MESSAGE = "Your input was invalid. Try again!";
    private static final String EXIT_MESSAGE = "Thank you for using our app! Goodbye :)";

    AppController controller = new AppController();

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

            case "l" -> {
                getLongestAuthor(AppController.getInstance());
                System.out.println();
                start();
            }
            case "r" -> {
                getTitlesLessThan15(AppController.getInstance());
                System.out.println();
                start();
            }
            case "m" -> {
                mostArticleSource(AppController.getInstance());
                System.out.println();
                start();
            }
            case "n" -> {
                newYorkTimes(AppController.getInstance());
                System.out.println();
                start();
            }
            case "d" -> {
                getOrderedBasedOnDescription(AppController.getInstance());
                System.out.println();
                start();
            }
            case "s" -> {
                getOrderedBasedOnDescriptionShort(AppController.getInstance());
                System.out.println();
                start();
            }
            case "h" -> {
                downloadURLs();
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

    private void downloadURLs(){
        try {
            SequentialDownloader sequentialDownloader = SequentialDownloader.getInstance();
            ParallelDownloader parallelDownloader = ParallelDownloader.getInstance();

            // TODO print time in ms it took to download URLs sequentially
            long start_sequent = System.currentTimeMillis();
            int resultSequential = controller.downloadURLs(sequentialDownloader);
            long end_sequent = System.currentTimeMillis();

            // TODO implement the process() function in ParallelDownloader class
            long start_parallel = System.currentTimeMillis();
            int resultParallel = controller.downloadURLs(parallelDownloader);
            long end_parallel = System.currentTimeMillis();

            // TODO print time in ms it took to download URLs parallel
            System.out.println("It takes " + (end_sequent - start_sequent) + " milliseconds for " + resultSequential + " Articles in Sequential!");
            System.out.println("It takes " + (end_parallel - start_parallel) + " milliseconds for " + resultParallel + " Articles in Parallel!");

        } catch (NewsAPIException e){
            System.out.println(e.getMessage());
        }
    }

    private void getTopHeadlinesAustria(AppController ctrl){
        try {
            System.out.println(ctrl.getTopHeadLinesAustria());
        } catch (NullPointerException | NewsAPIException e){
            System.out.println("Sorry! There are no top headlines in Austria!");
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
    private void getLongestAuthor(AppController ctrl){
        System.out.println("Longest Author name: " + ctrl.getLongestName());
    }

    private void getTitlesLessThan15(AppController ctrl){
        try {
            System.out.println("Articles with titles smaller than 15 characters: " + ctrl.getTitlesLessThan15());
        } catch (NullPointerException e){
            System.out.println("There are no articles with titles smaller than 15 characters!");
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

    private void getOrderedBasedOnDescription(AppController ctrl){
        try {
            System.out.println("Sorted articles based on description: \n" + ctrl.getOrderedBasedOnDescription());
        }catch (NullPointerException e){
            System.out.println("There are no articles yet!");
        }
    }

    private void getOrderedBasedOnDescriptionShort(AppController ctrl){
        try {
            System.out.println("Sorted articles based on description - short version: \n" + ctrl.getOrderedBasedOnDescriptionShort());
        }catch (NullPointerException e){
            System.out.println("There are no articles yet!");
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
        System.out.println("l: Longest Author name");
        System.out.println("m: Most Article Source");
        System.out.println("n: New York Times");
        System.out.println("r: Articles with titles smaller than 15 characters");
        System.out.println("d: Sort articles based on description length");
        System.out.println("s: Sort articles based on description length - shorter version");
        System.out.println("h: Download URLs");
        System.out.println("q: Quit program");
        System.out.println();
    }
}