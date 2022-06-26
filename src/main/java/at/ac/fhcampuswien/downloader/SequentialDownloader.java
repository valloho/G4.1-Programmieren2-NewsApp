package at.ac.fhcampuswien.downloader;

import at.ac.fhcampuswien.NewsAPIException;

import java.util.List;

public class SequentialDownloader extends Downloader{

    private static SequentialDownloader downloader = null;
    private SequentialDownloader(){};

    public static SequentialDownloader getInstance() {
        if(downloader == null) {
            downloader = new SequentialDownloader();
        }
        return downloader;
    }

    // returns number of downloaded article urls
    @Override
    public int process(List<String> urls) throws NewsAPIException {
        int count = 0;
        for (String url : urls) {
            try {
                String fileName = saveUrl2File(url);
                if(fileName != null)
                    count++;
            } catch (NewsAPIException e){
                System.err.println(e.getMessage());
                throw new NewsAPIException(e.getMessage());
            } catch (Exception e){
                throw new NewsAPIException("Different problem occurred in " + this.getClass().getName() + ". Message: " + e.getMessage());
            }
        }
        return count;
    }
}
