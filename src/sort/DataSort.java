/**
 * program: Class handles sorting using some sort algorithm
 * date created: 3/10/2022
 * author: Van Truong
 * version: 1.0.0
 */

package sort;

import io.DataFileHandler;

import java.util.Arrays;

public class DataSort {
    /**
     * phương thức sắp xếp mảng sử dụng thuật toán bubble sort và ghi kết quả vào text file
     *
     * @param path  (tham số đường dẫn lưu text file)
     * @param array (tham số mảng cần sắp xếp)
     */
    public static void bubbleSort(String path, double[] array) {
        System.out.println(Arrays.toString(array));//hiển thị mảng trước sắp xếp
        System.out.println("Bubble sort:");
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSwap = false;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {//hoán vị
                    swap(array, j - 1, j);
                    isSwap = true;
                }
            }
            if (!isSwap) {//thoát nếu mảng đã được sắp xếp
                break;
            }
            System.out.println(Arrays.toString(array));//hiển thị kết quả sắp xếp từng bước
        }
        DataFileHandler.writeData(path, array);//ghi dữ liệu vào text file
    }

    /**
     * phương thức sắp xếp mảng sử dụng thuật toán bubble sort
     *
     * @param array (tham số mảng cần sắp xếp)
     */
    public static void bubbleSort(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSwap = false;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {//hoán vị
                    swap(array, j - 1, j);
                    isSwap = true;
                }
            }
            if (!isSwap) {//thoát nếu mảng đã được sắp xếp
                break;
            }
        }
    }

    /**
     * phương thức sắp xếp mảng sử dụng thuật toán selection sort và ghi kết quả vào text file
     *
     * @param path  (tham số đường dẫn lưu text file)
     * @param array (tham số mảng cần sắp xếp)
     */
    public static void selectionSort(String path, double[] array) {
        System.out.println(Arrays.toString(array));//hiển thị mảng trước sắp xếp
        System.out.println("Selection sort:");
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {//hoán vị
                swap(array, min, i);
            }
            System.out.println(Arrays.toString(array));//hiển thị kết quả sắp xếp từng bước
        }
        DataFileHandler.writeData(path, array);//ghi dữ liệu vào text file
    }

    /**
     * phương thức sắp xếp mảng sử dụng thuật toán selection sort
     *
     * @param array (tham số mảng cần sắp xếp)
     */
    public static void selectionSort(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {//hoán vị
                swap(array, min, i);
            }
        }
    }

    /**
     * phương thức sắp xếp mảng sử dụng thuật toán insertion sort và ghi kết quả vào text file
     *
     * @param path  (tham số đường dẫn lưu text file)
     * @param array (tham số mảng cần sắp xếp)
     */
    public static void insertionSort(String path, double[] array) {
        System.out.println(Arrays.toString(array));//hiển thị mảng trước sắp xếp
        System.out.println("Insertion sort:");
        for (int i = 1; i < array.length; i++) {
            double temp = array[i];
            int j = i;
            boolean isSwap = false;
            while (j > 0 && array[j - 1] > temp) {
                array[j] = array[j - 1];
                j--;
                isSwap = true;
            }
            if (isSwap) {
                array[j] = temp;
                System.out.println(Arrays.toString(array));//hiển thị kết quả sắp xếp từng bước
            }
        }
        DataFileHandler.writeData(path, array);//ghi dữ liệu vào text file
    }

    /**
     * phương thức sắp xếp mảng sử dụng thuật toán insertion sort
     *
     * @param array (tham số mảng cần sắp xếp)
     */
    public static void insertionSort(double[] array) {
        for (int i = 1; i < array.length; i++) {
            double temp = array[i];
            int j = i;
            boolean isSwap = false;
            while (j > 0 && array[j - 1] > temp) {
                array[j] = array[j - 1];
                j--;
                isSwap = true;
            }
            if (isSwap) {
                array[j] = temp;
            }
        }
    }

    /**
     * phương thức hoán vị phần tử vị trí i, j trong mảng
     *
     * @param array (tham số mảng cần hoán vị)
     * @param i     (tham số vị trí phần tử cần hoán vị)
     * @param j     (tham số vị trí phần tử cần hoán vị)
     */
    private static void swap(double[] array, int i, int j) {
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
