import java.io.*;
import java.util.Scanner;

public class FileWRUD {

    public static void main(String[] args) throws IOException {

        File file1 = new File("file1");
        File file2 = new File("file2");

        // проверка при первом зауске программы для корректного заполнения файла _____________________
        DataInputStream dataInputStream1 = new DataInputStream(new FileInputStream(file1));
        int counter = dataInputStream1.read();
        dataInputStream1.close();
         if (counter==-1){
             System.out.println("Первый запуск, формирование файлов");
             counter++;
             FileWriter fileWriter1 = new FileWriter(file1,false);
             fileWriter1.write(counter);
             fileWriter1.close();
            System.exit(0);
         }
        // __________________________________________________________________________________________

            String[] str = new String[5];
            Scanner sc = new Scanner(System.in);
            str = sc.nextLine().split(",");
            int[] arr = new int[36];
            for (int i = 0; i < 36; i++) {
                if (i == (Integer.parseInt(str[0]) - 1) ||
                        i == (Integer.parseInt(str[1]) - 1) ||
                        i == (Integer.parseInt(str[2]) - 1) ||
                        i == (Integer.parseInt(str[3]) - 1) ||
                        i == (Integer.parseInt(str[4]) - 1)) {
                    arr[i] = 1;
                } else {
                    arr[i] = 0;
                }
            }
            // записываем в файл ________________________________________________________
            DataOutputStream dataOutputStream1 = new DataOutputStream(new FileOutputStream(file2,true));
            for (int i = 0; i < 36; i++) {
                dataOutputStream1.writeInt(arr[i]);
            }
            dataOutputStream1.close();


            // увеличиваем счетчик комбинаций ____________________________________________
            DataInputStream dataInputStream3 = new DataInputStream(new FileInputStream(file1));
            counter = dataInputStream3.read();
            counter++;
            dataInputStream3.close();
            FileWriter fileWriter2 = new FileWriter(file1, false);
            fileWriter2.write(counter);
            fileWriter2.close();
        System.out.println("Сохранено "+counter+ " вариантов комбинаций");
            // считываем из файла ___________________________________________________________
        DataInputStream dataInputStream4 = new DataInputStream(new FileInputStream(file2));
        int[][] arr2 = new int[counter][36];
        for (int j=0; j < counter; j++) {
            for (int i = 0; i < 36; i++) {
                arr2[j][i] = dataInputStream4.readInt();
                System.out.print(arr2[j][i]);
                System.out.print(" ");
            }
            System.out.println();
        }
        dataInputStream4.close();

    }

}