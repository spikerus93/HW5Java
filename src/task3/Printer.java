package task3;

//Необходимо разработать программу для сортировки массива целых чисел с использованием сортировки кучей (Heap Sort). Программа должна работать следующим образом:
//
//Принимать на вход массив целых чисел для сортировки. Если массив не предоставлен, программа использует массив по умолчанию.
//
//Сначала выводить исходный массив на экран.
//
//Затем применять сортировку кучей (Heap Sort) для сортировки элементов массива в порядке возрастания.
//
//Выводить отсортированный массив на экран.
//
//Ваше решение должно содержать два основных метода: buildTree, который строит сортирующее дерево на основе массива, и heapSort, который выполняет собственно сортировку кучей. Основная часть кода предоставлена вам.
//
//Программа должна быть способной сортировать массив, даже если он состоит из отрицательных чисел и имеет дубликаты.
//
//На входе:
//
//
//'5 8 12 3 6 9'
//На выходе:
//
//
//Initial array:
//[5, 8, 12, 3, 6, 9]
//Sorted array:
//[3, 5, 6, 8, 9, 12]

import java.util.Arrays;

class HeapSort {
    public static void buildTree (int[] tree, int sortLength) {
        for (int i = 0; i < sortLength; i++) {
            int max = i;
            int l = 2*i + 1;
            int r = 2*i + 2;

            if (l < sortLength && tree[l] > tree[max]) {
                max = l;
            }
            if (r < sortLength && tree[r] > tree[max]) {
                    max = r;
            }
            if (!(i == max)) {
                int temp = tree[i];
                tree[i] = tree[max];
                tree[max] = temp;
                i--;
                buildTree(tree, sortLength);
            }

        }

    }
    public static void heapSort (int[] sortArray, int sortLength) {
        buildTree(sortArray, sortLength);

        int size = sortLength;
        while (size > 0) {
            int temp = sortArray[0];
            sortArray[0] = sortArray[size-1];
            sortArray[size-1] = temp;
            size--;
            buildTree(sortArray, size);
        }
    }
}

public class Printer {
    public static void main (String[] args) {
        int[] initArray;

        if (args.length == 0) {
            initArray =  new int[] {17, 32, 1, 4, 25, 17, 0, 3, 10, 7, 64, 1};
        } else {
            initArray = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println("Initial array: ");
        System.out.println(Arrays.toString(initArray));
        HeapSort.heapSort(initArray, initArray.length);
        System.out.println("Sorted array: ");
        System.out.println(Arrays.toString(initArray));
    }
}
