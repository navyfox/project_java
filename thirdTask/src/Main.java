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
        Integer[] numbers = getRowFromFile("/Users/RIM/schoolThumbtack/thirdTask/src/input.txt");

        int begin = 0;
        int end = 0;

        boolean orderUp = false;
        int i = 0;
        int tempBegin = 0;
        int tempEnd = 0;

        while ((i < numbers.length - 1) && (numbers[i] == numbers[i+1])) {
            i++;
        }

        if(i == numbers.length - 1) {
            begin = 0;
            end = numbers.length - 1;
        } else {
            orderUp = numbers[i] < numbers[i + 1];
        }

        for(; i < numbers.length - 1;) {

            while ((i < numbers.length - 1) && ((orderUp && (numbers[i] <= numbers[i+1])) || (!orderUp && (numbers[i] >= numbers[i+1])))){
                i++;
            }

            tempEnd = i;

            if (end - begin < tempEnd - tempBegin) {
                end = tempEnd;
                begin = tempBegin;
            }

            while ((tempEnd > 1) && (numbers[tempEnd] == numbers[tempEnd-1])) {
                tempEnd--;
            }

            if ( (end - begin >= (numbers.length - 1) - tempEnd)){
                break;
            }

            tempBegin = tempEnd;
            orderUp = !orderUp;
        }

        Writer wr = new FileWriter ("/Users/RIM/schoolThumbtack/thirdTask/src/output.txt");
        for(i = begin; i <= end; i++) {
            wr.write(numbers[i] + " ");
            System.out.print(numbers[i] + " ");
        }
        wr.close();
    }

    private static Integer[] getRowFromFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner((new File(fileName)));
        List<Integer> nums = new ArrayList<>();
        while(scanner.hasNextInt()) {
            nums.add(scanner.nextInt());
        }
        scanner.close();
        return nums.toArray(new Integer[nums.size()]);
    }
}
