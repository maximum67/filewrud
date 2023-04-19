import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class FileWRUD {

    public static void main(String[] args) throws IOException {

        File file = new File("file");

        int[][] arr = new int[3][36];
        for (int z = 0; z < 3; z++) {
            for (int i = 0; i < 36; i++) {
                if ((i + 1) % 3 == 0) {
                    arr[z][i] = 1;
                } else {
                    arr[z][i] = 0;
                }
            }
        }

        // записываем в файл ________________________________________________________

       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,false));
        for (int q=0; q<3; q++) {
            for (int j = 0; j < 36; j++) {
                bufferedWriter.write(arr[q][j]);
            }
            bufferedWriter.newLine();
        }
        bufferedWriter.close();

        // считываем из файла __________________________________________________________

        int[][] arr1 = new int[3][36];
        FileInputStream fileInputStream = new FileInputStream(file);

        for (int q=0; q<3; q++) {
            for (int j = 0; j < 36; j++) {
                arr1[q][j] = (Integer)fileInputStream.read();

            }
            fileInputStream.read();
        }
        fileInputStream.close();

        for (int q=0; q<3; q++) {
            for (int j = 0; j < 36; j++) {
                System.out.print(arr1[q][j]);
            }
            System.out.println();
        }
//        for (int q=0; q<3; q++) {
//            for (int j = 0; j < 36; j++) {
//                System.out.print(arr[q][j]);
//            }
//            System.out.println();
//        }




//        System.out.println();


    }
}
