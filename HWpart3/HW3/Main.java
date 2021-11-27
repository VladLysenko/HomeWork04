package HW3;


import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        readFileAsByteArrayAndShowInConsole();
        unionFilesToOne();

    }

    static void readFileAsByteArrayAndShowInConsole() {
        try (ByteArrayInputStream in = new ByteArrayInputStream(Files.readAllBytes(Paths.get("dzOne.txt")))) {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
                System.out.println(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void unionFilesToOne() {
        ArrayList<InputStream> al = new ArrayList<>();
        try {
            for (int i = 0; i < 10; i++) {
                al.add(new FileInputStream(i + ".txt"));
            }
            BufferedInputStream in = new BufferedInputStream(new SequenceInputStream(Collections.enumeration(al)));
            int x;
            while ((x = in.read()) != -1) {
                System.out.print((char) x);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        static void readBigFile () {
            final int PAGE_SIZE = 1800;
            try {
                RandomAccessFile raf = new RandomAccessFile("1.txt", "rw");
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter page:");
                int p = sc.nextInt() - 1;
                raf.seek(p * PAGE_SIZE);
                for (int i = 0; i < PAGE_SIZE; i++) {
                    System.out.print((char) raf.read());
                }
                raf.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }