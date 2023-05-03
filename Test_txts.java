import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Test_txts {
    public static void main(String[] args) {
        String filename = "test.txt";
        int numThreads = 2;
        Map<String, Integer> wordCount = new HashMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            // Calculate chunk size for each thread
            long fileSize = reader.lines().mapToLong(String::length).sum();
            long chunkSize = fileSize / numThreads;

            // Create and start threads
            Thread_hash[] threads = new Thread_hash[numThreads];
            for (int i = 0; i < numThreads; i++) {
                long start = i * chunkSize;
                long end = (i == numThreads - 1) ? fileSize : start + chunkSize;
                threads[i] = new Thread_hash(filename, start, end, wordCount);
                threads[i].start();
            }

            // Wait for threads to finish
            for (int i = 0; i < numThreads; i++) {
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Print word count
            for (String word : wordCount.keySet()) {
                System.out.println(word + ": " + wordCount.get(word));
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

