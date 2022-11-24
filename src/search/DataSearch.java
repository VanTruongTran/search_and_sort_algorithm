/**
 * program: Class handles searching value using some search algorithm
 * date created: 3/10/2022
 * author: Van Truong
 * version: 1.0.0
 */

package search;

import io.DataFileHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DataSearch {
    /**
     * phương thức tìm kiếm giá trị sử dụng thuật toán linear search và ghi dữ liệu vào text file
     *
     * @param path    (tham số đường dẫn lưu text file)
     * @param scanner (tham số luồng đọc dữ liệu từ người dùng)
     * @param array   (tham số mảng tìm kiếm)
     */
    public static void linearSearch(String path, Scanner scanner, final double[] array) {
        System.out.println(Arrays.toString(array));
        System.out.println("Linear search:");

        //nhập giá trị tìm kiếm
        double value = inputValue(scanner);

        //tìm kiếm giá trị > value
        List<Double> indexList = new ArrayList<Double>();//tạo List chứa index vị trí lớn hơn giá trị value
        boolean flag = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > value) {
                if (flag) {
                    System.out.print("index: ");
                    flag = false;
                }
                System.out.printf("%d    ", i);//hiển thị kết quả
                indexList.add(Double.valueOf(i));//thêm index vào List
            }
        }

        if (indexList.size() > 0) {//tìm thấy giá trị > value
            System.out.println();
            DataFileHandler.writeData(path, indexList);//ghi dữ liệu vào text file
        } else {//không tìm thấy giá trị > value
            System.out.printf("Don't find value greater than %,.2f%n", value);
        }
    }

    /**
     * phương thức tìm kiếm giá trị sử dụng thuật toán binary search và ghi dữ liệu vào text file
     *
     * @param path    (tham số đường dẫn lưu text file)
     * @param scanner (tham số luồng đọc dữ liệu từ người dùng)
     * @param array   (tham số mảng tìm kiếm)
     */
    public static void binarySearch(String path, Scanner scanner, final double[] array) {
        System.out.println(Arrays.toString(array));
        System.out.println("Binary search:");

        //nhập giá trị tìm kiếm
        double value = inputValue(scanner);

        //tìm kiếm giá trị = value
        List<Double> indexList = new ArrayList<Double>();//tạo List chứa index vị trí đầu tiên có giá trị = value
        boolean flag = false;
        int left = 0;
        int right = array.length - 1;
        int mid;
        do {
            mid = (left + right) / 2;
            if (array[mid] == value) {
                flag = true;
                break;
            } else if (array[mid] > value) {
                right = mid - 1;
            } else {//array[mid] < value
                left = mid + 1;
            }
        } while (left <= right);

        //tìm vị trí index đầu tiên có giá trị = value
        if (flag) {//tìm thấy giá trị = value
            while (mid > 0 && array[mid - 1] == array[mid]) {
                mid--;
            }

            System.out.printf("first index: %d%n", mid);//hiển thị kết quả
            indexList.add(Double.valueOf(mid));//thêm index vào List
            DataFileHandler.writeData(path, indexList);//ghi dữ liệu vào text file
        } else {//không tìm thấy giá trị = value
            System.out.printf("Don't find value %,.2f%n", value);
        }
    }

    /**
     * phương thức nhập giá trị tìm kiếm
     *
     * @param scanner (tham số luồng đọc dữ liệu từ người dùng)
     * @return (trả về giá trị cần tìm kiếm)
     */
    private static double inputValue(Scanner scanner) {
        double value;
        while (true) {
            try {
                System.out.print("Enter value: ");
                value = Double.parseDouble(scanner.nextLine());
                return value;
            } catch (Exception ignored) {

            }
        }
    }
}
