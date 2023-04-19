import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class FileWRUD {

    public static void main(String[] args) throws IOException {

        File file = new File("file1.txt");

        int[][] arr = new int[36][3];
        for (int z = 0; z < 3; z++) {
            for (int i = 0; i < 36; i++) {
                if ((i + 1) % 3 == 0) {
                    arr[i][z] = 1;
                } else {
                    arr[i][z] = 0;
                }
            }
        }

        // записываем в файл ________________________________________________________

       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true));
        for (int q=0; q<3; q++) {
            for (int j = 0; j < 36; j++) {
                bufferedWriter.write(arr[j][q]);

            }
            bufferedWriter.newLine();
        }
        bufferedWriter.close();

        // считываем из файла __________________________________________________________

        int[][] arr1 = new int[36][3];
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        for (int q=0; q<3; q++) {
            for (int j = 0; j < 36; j++) {
                arr1[j][q] = Integer.parseInt(bufferedReader.read());
                System.out.println(arr1);
            }

        }
        bufferedReader.close();





        System.out.println();


    }
}
