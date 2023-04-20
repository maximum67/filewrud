import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class FileWRUD {

    public static void main(String[] args) throws IOException {

        File file1 = new File("file1");
        File file2 = new File("file2");

        String[] str = new String[5];
        Scanner sc = new Scanner(System.in);

        str = sc.nextLine().split(",");

        FileReader fileReader = new FileReader(file1);
        int counter = fileReader.read();
        counter++;
        fileReader.close();
        FileWriter fileWriter = new FileWriter(file1,false);
        fileWriter.write(counter);
        fileWriter.close();

        String[] arr = new String[36];

        for (int i=0; i<36; i++) {
            if (i==(Integer.parseInt(str[0])-1)||
                i==(Integer.parseInt(str[1])-1)||
                i==(Integer.parseInt(str[2])-1)||
                i==(Integer.parseInt(str[3])-1)||
                i==(Integer.parseInt(str[4])-1)) {
                arr[i]="1";
            }else {
                arr[i]="0";
            }
        }

        // записываем в файл ________________________________________________________



       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2,true));
            for (int j = 0; j < 36; j++) {
                bufferedWriter.write(arr[j]);
            }
            bufferedWriter.newLine();
        bufferedWriter.close();

        // считываем из файла __________________________________________________________

        int[][] arr1 = new int[counter][36];
        FileInputStream fileInputStream = new FileInputStream(file2);

        for (int q=0; q<3; q++) {
            for (int j = 0; j < 36; j++) {
                arr1[q][j] = Integer.parseInt(String.valueOf(fileInputStream.read()));
            }
        }
        fileInputStream.close();

        for (int q=0; q<counter; q++) {
            for (int j = 0; j < 36; j++) {
                System.out.print(arr1[q][j]);
            }
            System.out.println();
        }


//            System.out.println();




    }
}
