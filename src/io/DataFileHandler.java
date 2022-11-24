/**
 * program: Class handles writing and reading array data
 * date created: 3/10/2022
 * author: Van Truong
 * version: 1.0.0
 */

package io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataFileHandler {
    /**
     * phương thức nhập dữ liệu và ghi dữ liệu vào text file
     *
     * @param path    (tham số đường dẫn lưu text file)
     * @param scanner (tham số luồng đọc dữ liệu từ người dùng)
     */
    public static void writeData(String path, Scanner scanner) {
        //nhập số phần tử mảng
        int n;
        do {
            System.out.print("Enter the number of elements (>0): ");
            n = Integer.parseInt(scanner.nextLine());
        } while (n <= 0);//kiểm tra số phần tử hợp lệ

        //nhập giá trị mảng
        double[] array = new double[n];
        for (int i = 0; i < array.length; i++) {
            while (true) {
                try {
                    System.out.printf("Enter number no. %d: ", i + 1);
                    array[i] = Double.parseDouble(scanner.nextLine());
                    break;
                } catch (Exception ignored) {

                }
            }
        }

        //ghi dữ liệu vào text file
        writeData(path, array);
    }

    /**
     * phương thức ghi dữ liệu từ một mảng vào text file
     *
     * @param path  (tham số đường dẫn lưu text file)
     * @param array (tham số mảng lưu dữ liệu)
     */
    public static void writeData(String path, double[] array) {
        //tạo text file
        createNewFile(path);

        //ghi giá trị vào file
        try {
            //tạo đối tượng luồng và liên kết nguồn dữ liệu
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(osw);

            for (double item : array) {
                String number = String.valueOf(item);
                bw.write(number);//ghi giá trị số thực vào text file
                bw.newLine();
            }
            System.out.printf("Wrote data to file \"%s\"%n", path);

            //đóng luồng
            bw.close();
            osw.close();
            fos.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    /**
     * phương thức ghi dữ liệu từ một danh sách vào text file
     *
     * @param path (tham số đường dẫn lưu text file)
     * @param list (tham số danh sách lưu dữ liệu)
     */
    public static void writeData(String path, List<Double> list) {
        //tạo text file
        createNewFile(path);

        //ghi giá trị vào file
        try {
            //tạo đối tượng luồng và liên kết nguồn dữ liệu
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(osw);

            for (double item : list) {
                String number = String.valueOf(item);
                bw.write(number);//ghi giá trị số thực vào text file
                bw.newLine();
            }
            System.out.printf("Wrote data to file \"%s\"%n", path);

            //đóng luồng
            bw.close();
            osw.close();
            fos.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    /**
     * phương thức đọc dữ liệu từ text file
     *
     * @param path (tham số đường dẫn lưu text file)
     * @return (trả về mảng dữ liệu đọc từ text file)
     */
    public static double[] readData(String path) {
        double[] array = null;
        try {
            //tạo đối tượng luồng và liên kết nguồn dữ liệu
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);

            List<String> list = new ArrayList<String>();//tạo List lưu giá trị hợp lệ từ text file
            String number;
            while ((number = br.readLine()) != null) {//duyệt text file và thêm giá trị hợp lệ vào List
                if (isDouble(number)) {//kiểm tra giá trị hợp lệ
                    list.add(number);
                }
            }

            if (list.size() > 0) {//text file có giá trị hợp lệ
                array = new double[list.size()];//tạo mảng có số phần tử bằng List
                for (int i = 0; i < array.length; i++) {
                    array[i] = Double.parseDouble(list.get(i));//copy giá trị từ List vào mảng
                }
                System.out.printf("Read data from file \"%s\"%n", path);
            } else {//text file không có giá trị hợp lệ
                System.out.printf("No valid value in file \"%s\"%n", path);
            }

            //đóng luồng
            br.close();
            isr.close();
            fis.close();
        } catch (IOException error) {
            System.out.printf("File \"%s\" doesn't exist%n", path);
        }
        return array;
    }

    /**
     * phương thức kiểm tra số thực hợp lệ
     *
     * @param number (tham số chuỗi số cần kiểm tra)
     * @return (trả về true nếu chuỗi số là số thực, ngược lại trả về false)
     */
    public static boolean isDouble(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (Exception error) {
            return false;
        }
    }

    /**
     * phương thức tạo mới text file
     *
     * @param path (tham số đường dẫn lưu text file)
     */
    private static void createNewFile(String path) {
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
