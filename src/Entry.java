/**
 * program: Search & Sort algorithm
 * date created: 3/10/2022
 * author: Van Truong
 * version: 1.0.0
 */

import io.DataFileHandler;
import search.DataSearch;
import sort.DataSort;
import sort.SortAlgorithmAnalysis;

import java.util.Arrays;
import java.util.Scanner;

public class Entry {
    private static final String URL_INPUT_OUTPUT = "src/files/input.txt";
    private static final String URL_AFTER_BUBBLE_SORT = "src/files/input1.txt";
    private static final String URL_AFTER_SELECTION_SORT = "src/files/input2.txt";
    private static final String URL_AFTER_INSERTION_SORT = "src/files/input3.txt";
    private static final String URL_AFTER_LINEAR_SEARCH = "src/files/input4.txt";
    private static final String URL_AFTER_BINARY_SEARCH = "src/files/input5.txt";

    private static Scanner scanner;
    private static double[] array;

    /**
     * phương thức main
     *
     * @param args (tham số lưu trữ đối số dòng lệnh Java)
     */
    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        while (true) {
            switch (inputMenu()) {
                case "1"://input
                    DataFileHandler.writeData(URL_INPUT_OUTPUT, scanner);//nhập giá trị và ghi dữ liệu vào file input.txt
                    break;

                case "2"://output
                    array = DataFileHandler.readData(URL_INPUT_OUTPUT);//đọc dữ liệu từ file input.text và nhập giá trị vào mảng
                    if (array != null) {
                        System.out.println(Arrays.toString(array));
                    }
                    break;

                case "3"://bubble sort
                    if (array != null) {
                        double[] copiedArray = array.clone();//sao chép mảng
                        DataSort.bubbleSort(URL_AFTER_BUBBLE_SORT, copiedArray);//sắp xếp mảng sử dụng bubble sort
                    } else {
                        System.out.println("Array does not exist, please create new");
                    }
                    break;

                case "4"://selection sort
                    if (array != null) {
                        double[] copiedArray = array.clone();//sao chép mảng
                        DataSort.selectionSort(URL_AFTER_SELECTION_SORT, copiedArray);//sắp xếp mảng sử dụng selection sort
                    } else {
                        System.out.println("Array does not exist, please create new");
                    }
                    break;

                case "5"://insertion sort
                    if (array != null) {
                        double[] copiedArray = array.clone();//sao chép mảng
                        DataSort.insertionSort(URL_AFTER_INSERTION_SORT, copiedArray);//sắp xếp mảng sử dụng insertion sort
                    } else {
                        System.out.println("Array does not exist, please create new");
                    }
                    break;

                case "6"://search > value
                    if (array != null) {
                        DataSearch.linearSearch(URL_AFTER_LINEAR_SEARCH, scanner, array);//tìm kiếm tuyến tính
                    } else {
                        System.out.println("Array does not exist, please create new");
                    }
                    break;

                case "7"://search = value
                    if (array != null) {
                        double[] copiedArray = array.clone();//sao chép mảng
                        DataSort.insertionSort(copiedArray);//sắp xếp mảng
                        DataSearch.binarySearch(URL_AFTER_BINARY_SEARCH, scanner, copiedArray);//tìm kiếm nhị phân
                    } else {
                        System.out.println("Array does not exist, please create new");
                    }
                    break;

                case "8"://calculate runtime of 3 algorithms
                    SortAlgorithmAnalysis.testTimeSortAlgorithm(scanner);//tính thời gian một số thuật toán sắp xếp
                    break;

                case "0"://exit
                    displayExitInfo();
                    System.exit(0);//dừng chương trình
                    break;

                default:
                    System.out.println("Please enter a number from 0 to 8");
                    break;
            }
        }
    }

    /**
     * phương thức nhập lựa chọn menu
     *
     * @return (trả về giá trị chỉ mục lựa chọn menu)
     */
    private static String inputMenu() {
        System.out.println("+------------------------------------------+");
        System.out.printf("| %-40s |%n", "1. Input");
        System.out.printf("| %-40s |%n", "2. Output");
        System.out.printf("| %-40s |%n", "3. Bubble sort");
        System.out.printf("| %-40s |%n", "4. Selection sort");
        System.out.printf("| %-40s |%n", "5. Insertion sort");
        System.out.printf("| %-40s |%n", "6. Search > value");
        System.out.printf("| %-40s |%n", "7. Search = value");
        System.out.printf("| %-40s |%n", "8. Calculate runtime of 3 algorithms");
        System.out.printf("| %-40s |%n", "0. Exit");
        System.out.println("+------------------------------------------+");
        System.out.print("Your answer: ");
        String answer = scanner.nextLine();
        System.out.println("+------------------------------------------+");
        return answer;
    }

    /**
     * phương thức hiển thị thông báo thoát
     */
    private static void displayExitInfo() {
        System.out.println("+------------------------------------------+");
        System.out.printf("| %-40s |%n", "Exit successfully");
        System.out.println("+------------------------------------------+");
    }
}
