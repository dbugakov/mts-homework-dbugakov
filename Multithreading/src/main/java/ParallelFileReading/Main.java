package ParallelFileReading;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        RandomAccessFile testFile = new RandomAccessFile("test.txt", "r");
        long numSplits = 3;
        long fileSize = testFile.length();
        long bytesPerSplit = fileSize / numSplits;
        long remainingBytes = fileSize % numSplits;
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numSplits; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                try {
                    BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("split.Thread" + finalI));
                    if (finalI == numSplits - 1 && remainingBytes > 0) {
                        readWrite(testFile, outputStream, bytesPerSplit + remainingBytes);
                    } else readWrite(testFile, outputStream, bytesPerSplit);
                    outputStream.close();
                    BufferedReader reader = new BufferedReader(new FileReader("split.Thread" + finalI));
                    String line;
                    System.out.println("Поток №" + finalI + " результат:");
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                    reader.close();
                    File splitFile = new File("split.Thread" + finalI);
                    splitFile.delete();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }, "Thread " + i);
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.start();
            thread.join();
        }
        testFile.close();
    }

    static void readWrite(RandomAccessFile raf, BufferedOutputStream bw, long numBytes) throws IOException {
        byte[] buf = new byte[(int) numBytes];
        int val = raf.read(buf);
        if (val != -1) {
            bw.write(buf);
        }
    }
}
