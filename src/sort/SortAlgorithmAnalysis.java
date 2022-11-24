/**
 * program: Class handles calculating running time of some sort algorithms
 * date created: 3/10/2022
 * author: Van Truong
 * version: 1.0.0
 */

package sort;

import java.util.Scanner;

public class SortAlgorithmAnalysis {
    private static double[] sortedArray;
    private static double[] reverseArray;
    private static double[] randomArray;

    private static long[] bubbleSortTime;
    private static long[] selectionSortTime;
    private static long[] insertionSortTime;

    /**
     * phương thức tính thời gian một số thuật toán sắp xếp
     *
     * @param scanner (tham số luồng đọc dữ liệu từ người dùng)
     */
    public static void testTimeSortAlgorithm(Scanner scanner) {
        //tạo mảng test n phần tử
        createTestArray(scanner);

        //tính thời gian thuật toán bubble sort
        testTimeBubbleSort();

        //tính thời gian thuật toán selection sort
        testTimeSelectionSort();

        //tính thời gian thuật toán insertion sort
        testTimeInsertionSort();

        //hiển thị kết quả ra màn hình
        displayResult();
    }

    /**
     * phương thức tạo mảng test
     *
     * @param scanner (tham số luồng đọc dữ liệu từ người dùng)
     */
    private static void createTestArray(Scanner scanner) {
        //nhập số phần tử mảng
        int n;
        do {
            System.out.print("Enter the number of elements (>0): ");
            n = Integer.parseInt(scanner.nextLine());
        } while (n <= 0);

        //tạo các mảng test n phần tử
        sortedArray = new double[n];
        reverseArray = new double[n];
        randomArray = new double[n];

        //ghi giá trị vào các mảng test
        for (int i = 0; i < n; i++) {
            sortedArray[i] = i;
            reverseArray[i] = n - 1 - i;
            randomArray[i] = (int) (Math.random() * n);
        }
    }

    /**
     * phương thức tính thời gian thuật toán bubble sort trong 3 trường hợp best case, worst case, average case
     */
    private static void testTimeBubbleSort() {
        //khởi tạo mảng lưu thời gian sắp xếp
        bubbleSortTime = new long[3];

        //sao chép mảng để sắp xếp
        double[] copiedSortedArray = sortedArray.clone();
        double[] copiedReverseArray = reverseArray.clone();
        double[] copiedRandomArray = randomArray.clone();

        //tính thời gian sắp xếp mảng sorted
        calcTimeBubbleSort(copiedSortedArray, 0);

        //tính thời gian sắp xếp mảng reverse
        calcTimeBubbleSort(copiedReverseArray, 1);

        //tính thời gian sắp xếp mảng random
        calcTimeBubbleSort(copiedRandomArray, 2);
    }

    /**
     * phương thức tính thời gian thuật toán selection sort trong 3 trường hợp best case, worst case, average case
     */
    private static void testTimeSelectionSort() {
        //khởi tạo mảng lưu thời gian sắp xếp
        selectionSortTime = new long[3];

        //sao chép mảng để sắp xếp
        double[] copiedSortedArray = sortedArray.clone();
        double[] copiedReverseArray = reverseArray.clone();
        double[] copiedRandomArray = randomArray.clone();

        //tính thời gian sắp xếp mảng sorted
        calcTimeSelectionSort(copiedSortedArray, 0);

        //tính thời gian sắp xếp mảng reverse
        calcTimeSelectionSort(copiedReverseArray, 1);

        //tính thời gian sắp xếp mảng random
        calcTimeSelectionSort(copiedRandomArray, 2);
    }

    /**
     * phương thức tính thời gian thuật toán insertion sort trong 3 trường hợp best case, worst case, average case
     */
    private static void testTimeInsertionSort() {
        //khởi tạo mảng lưu thời gian sắp xếp
        insertionSortTime = new long[3];

        //sao chép mảng để sắp xếp
        double[] copiedSortedArray = sortedArray.clone();
        double[] copiedReverseArray = reverseArray.clone();
        double[] copiedRandomArray = randomArray.clone();

        //tính thời gian sắp xếp mảng sorted
        calcTimeInsertionSort(copiedSortedArray, 0);

        //tính thời gian sắp xếp mảng reverse
        calcTimeInsertionSort(copiedReverseArray, 1);

        //tính thời gian sắp xếp mảng random
        calcTimeInsertionSort(copiedRandomArray, 2);
    }

    /**
     * phương thức tính thời gian bắt đầu và kết thúc thuật toán bubble sort
     *
     * @param array (tham số mảng cần sắp xếp)
     * @param i     (tham số vị trí lưu giá trị thời gian trong mảng kết quả)
     */
    private static void calcTimeBubbleSort(double[] array, int i) {
        long start = System.nanoTime();
        DataSort.bubbleSort(array);//bubble sort
        long end = System.nanoTime();
        bubbleSortTime[i] = end - start;//gán thời gian thực hiện sắp xếp vào mảng
    }

    /**
     * phương thức tính thời gian bắt đầu và kết thúc thuật toán selection sort
     *
     * @param array (tham số mảng cần sắp xếp)
     * @param i     (tham số vị trí lưu giá trị thời gian trong mảng kết quả)
     */
    private static void calcTimeSelectionSort(double[] array, int i) {
        long start = System.nanoTime();
        DataSort.selectionSort(array);//selection sort
        long end = System.nanoTime();
        selectionSortTime[i] = end - start;//gán thời gian thực hiện sắp xếp vào mảng
    }

    /**
     * phương thức tính thời gian bắt đầu và kết thúc thuật toán insertion sort
     *
     * @param array (tham số mảng cần sắp xếp)
     * @param i     (tham số vị trí lưu giá trị thời gian trong mảng kết quả)
     */
    private static void calcTimeInsertionSort(double[] array, int i) {
        long start = System.nanoTime();
        DataSort.insertionSort(array);//insertion sort
        long end = System.nanoTime();
        insertionSortTime[i] = end - start;//gán thời gian thực hiện sắp xếp vào mảng
    }

    /**
     * phương thức hiển thị kết quả test
     */
    private static void displayResult() {
        displayResult("Best case (Sorted array):", 0);
        System.out.println("+------------------------------------------+");
        displayResult("Worst case (Reverse array):", 1);
        System.out.println("+------------------------------------------+");
        displayResult("Average case (Random array):", 2);
    }

    /**
     * phương thức hiển thị kết quả test
     *
     * @param title (tham số tiêu đề test)
     * @param i     (tham số vị trí lưu giá trị thời gian trong mảng kết quả)
     */
    private static void displayResult(String title, int i) {
        System.out.println(title);
        System.out.printf("| %-15s %16d (nanosec)%n", "Bubble sort:", bubbleSortTime[i]);
        System.out.printf("| %-15s %16d (nanosec)%n", "Selection sort:", selectionSortTime[i]);
        System.out.printf("| %-15s %16d (nanosec)%n", "Insertion sort:", insertionSortTime[i]);
    }
}
