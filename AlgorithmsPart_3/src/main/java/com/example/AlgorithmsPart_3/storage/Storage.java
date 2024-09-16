package com.example.AlgorithmsPart_3.storage;

import java.util.Arrays;

public class Storage {
    private int[] elements;
    private int size;

    // Конструктор, инициализирующий массив
    public Storage() {
        elements = new int[10]; // начальный размер 10
        size = 0;
    }

    // Метод для добавления элемента в массив
    public void add(int value) {
        if (size == elements.length) {
            grow();
        }
        elements[size] = value;
        size++;
    }

    // Приватный метод для увеличения размера массива в 1.5 раза
    private void grow() {
        int newSize = (int) (elements.length * 1.5);
        elements = Arrays.copyOf(elements, newSize);
    }

    // Метод для получения массива элементов
    public int[] getElements() {
        return Arrays.copyOf(elements, size); // возвращаем копию массива размером size
    }

    // Рекурсивная сортировка (QuickSort)
    public void sort() {
        quickSort(elements, 0, size - 1);
    }

    // Вспомогательный метод для быстрой сортировки
    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1); // сортировка левой части
            quickSort(array, pivotIndex + 1, high); // сортировка правой части
        }
    }

    // Разделение массива и выбор опорного элемента
    private int partition(int[] array, int low, int high) {
        int pivot = array[high]; // выбор последнего элемента как опорного
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    // Метод для обмена элементов массива
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}