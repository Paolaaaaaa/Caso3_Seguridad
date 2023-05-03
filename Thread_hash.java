import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;

public class Thread_hash extends Thread {
    private String filename;
    private long start;
    private long end;
    private Map<String, Integer> wordCount;

    public Thread_hash(String filename, long start, long end, Map<String, Integer> wordCount) {
        this.filename = filename;
        this.start = start;
        this.end = end;
        this.wordCount = wordCount;
    }

    public void run() {
        try {
            RandomAccessFile file = new RandomAccessFile(filename, "r");
            file.seek(start);

            // Move the start position to the beginning of the next word
            if (start > 0) {
                while (file.getFilePointer() > start && Character.isLetterOrDigit((char)file.readByte())) {
                    file.seek(file.getFilePointer() - 2);
                }
                if (file.getFilePointer() > start) {
                    file.seek(file.getFilePointer() - 1);
                }
            }

            StringBuilder word = new StringBuilder();
            int c;
            while (file.getFilePointer() < end && (c = file.read()) != -1) {
                if (Character.isLetterOrDigit(c)) {
                    word.append((char) c);
                } else if (word.length() > 0) {
                    String strWord = word.toString().toLowerCase();
                    wordCount.put(strWord, wordCount.getOrDefault(strWord, 0) + 1);
                    word.setLength(0);
                }
            }

            // Handle last word in file
            if (word.length() > 0) {
                String strWord = word.toString().toLowerCase();
                wordCount.put(strWord, wordCount.getOrDefault(strWord, 0) + 1);
            }

            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
