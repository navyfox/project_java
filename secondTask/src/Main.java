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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("/Users/RIM/schoolThumbtack/secondTask/src/input.txt"));
        String text = scanner.nextLine();
        int length = scanner.nextInt();
        scanner.close();

        String[] wordsArray = filterWordsByLength(text.split("\\s+"), length);

        Writer wr = new FileWriter ("/Users/RIM/schoolThumbtack/secondTask/src/output.txt");

        if (wordsArray.length < 2) {
            wr.write("нет");
            wr.close();
            return;
        }

        String word1 = null;
        String word2 = null;
        int bestDistance = 0;

        for(int i = 0; i < wordsArray.length - 1; i++) {
            for(int j = i + 1; j < wordsArray.length; j++) {
                int distance = compareWords(wordsArray[i], wordsArray[j]);
                if(distance > bestDistance) {
                    bestDistance = distance;
                    word1 = wordsArray[i];
                    word2 = wordsArray[j];
                }
            }
        }

        wr.write(word1 + " " + word2);
        wr.close();
        System.out.println(word1 + " " + word2);
    }

    private static int compareWords(String word1, String word2) {
        int distantion = 0;
        for(int i = 0; i < word1.length(); i++) {
            if(word1.charAt(i) != word2.charAt(i)) {
                distantion++;
            }
        }
        return distantion;
    }

    private static String[] filterWordsByLength(String[] words, int length) {
        List<String> list = new ArrayList<String>();

        for(int i = 0; i < words.length; i++){
            if (length == words[i].length()) {
                list.add(words[i]);
            }
        }

        length = list.size();
        System.out.println(length);
        return list.toArray(new String[list.size()]);
    }
}
