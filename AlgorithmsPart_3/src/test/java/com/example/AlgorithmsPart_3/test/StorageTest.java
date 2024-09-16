package com.example.AlgorithmsPart_3.test;

import com.example.AlgorithmsPart_3.storage.Storage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StorageTest {
    private Storage storage;

    @BeforeEach
    void setUp() {
        storage = new Storage();
    }

    @Test
    void testAddAndGrow() {
        for (int i = 0; i < 30; i++) {
            storage.add(i);
        }

        assertEquals(30, storage.getElements().length);
    }

    @Test
    void testSort() {
        storage.add(5);
        storage.add(2);
        storage.add(9);
        storage.add(1);
        storage.add(7);

        storage.sort();
        int[] sorted = storage.getElements();
        assertArrayEquals(new int[]{1, 2, 5, 7, 9}, sorted);
    }

    @Test
    void testEmptyStorage() {
        assertEquals(0, storage.getElements().length);
        storage.sort(); // Проверка, что сортировка работает и для пустого массива
    }
}