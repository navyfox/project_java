//IntelliJ IDEA 2016.1.1
//Build #IC-145.597, built on March 29, 2016
//JRE: 1.8.0_40-release-b132 x86_64
//JVM: OpenJDK 64-Bit Server VM by JetBrains s.r.o
//JDK 1.7.0_79
//Language level 7 (Diamonds, ARM, multi-catch etc.)
/**
 * Created by RIM on 13.05.16.
 */
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int[][] array = getArrayFromFile("/Users/RIM/schoolThumbtack/firstTask/src/input.txt");

        Integer sampleColumnCount = 0;

        for(int j = 0; j < array.length; j++) {
            sampleColumnCount += containSample(array[j]) ? 0 : 1;
        }

        Writer wr = new FileWriter ("/Users/RIM/schoolThumbtack/firstTask/src/output.txt");
        wr.write(sampleColumnCount.toString());
        wr.close();
        System.out.print(sampleColumnCount);
    }

    private static boolean containSample(int[] array) {
        for(int i = 0; i < array.length - 1; i++) {
            for(int k = i + 1; k < array.length; k++) {
                if (array[i] == array[k]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int[][] getArrayFromFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] array = new int[m][n];

        for(int j = 0; j < n; j++) {
            for(int i = 0; i < m; i++) {
                array[i][j] = scanner.nextInt();
            }
        }

        scanner.close();
        return array;
    }
}

