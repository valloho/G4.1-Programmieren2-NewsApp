package at.ac.fhcampuswien.downloader;

import at.ac.fhcampuswien.NewsAPIException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ParallelDownloader extends Downloader{

    private static ParallelDownloader instance;
    int count;

    private ParallelDownloader(){};


    public static ParallelDownloader getInstance(){
        if(instance == null) {
            instance = new ParallelDownloader();
        }
        return instance;
    }

    // returns number of downloaded article urls
    @Override
    public int process(List<String> urls) throws NewsAPIException {
        // TODO implement download function using multiple threads
        // Hint: use ExecutorService with Callables

        int process = Runtime.getRuntime().availableProcessors();
        ExecutorService thread = Executors.newFixedThreadPool(process);

        List<Callable<String>> CallableList = new ArrayList<>();

        for (String url : urls) {
            Callable<String> callable = () -> saveUrl2File(url);
            CallableList.add(callable);
        }

        try {
            List<Future<String>> futures = thread.invokeAll(CallableList);
            for (Future<String> future : futures) {
                if (future.get() != null) {
                    count++;
                }
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new NewsAPIException(e.getMessage());
        }

        thread.shutdown();
        return count;
    }
}
