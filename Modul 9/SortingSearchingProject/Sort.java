package SortingSearchingProject;

import java.util.Arrays;

public class Sort {

    /*
    // --- BUBBLE SORT ---
    public static int[] bubble(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int k = i + 1; k < list.length; k++) {
                if (list[k] < list[i]) {       // ← kondisi kunci
                    int t = list[i];
                    list[i] = list[k];
                    list[k] = t;
                }
            }
        }
        return list;
    }

    // --- INSERTION SORT ---
    public static int[] insertion(int[] list) {
        for (int i = 1; i < list.length; ++i) {
            int key = list[i];
            int k = i - 1;
            while (k >= 0 && list[k] > key) {  // ← kondisi kunci
                list[k + 1] = list[k];
                k = k - 1;
            }
            list[k + 1] = key;
        }
        return list;
    }

    // --- SELECTION SORT ---
    public static int[] selection(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int minIndex = i;
            for (int k = i + 1; k < list.length; k++) {
                if (list[k] < list[minIndex])  // ← kondisi kunci
                    minIndex = k;
            }
            int t = list[minIndex];
            list[minIndex] = list[i];
            list[i] = t;
        }
        return list;
    }
    */

    /*
    // --- NO 5 VERSI DESCENDING --- 
    // BUBBLE — versi descending
    public static int[] bubble(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int k = i + 1; k < list.length; k++) {
                if (list[k] > list[i]) {       // ← diubah dari < ke >
                    int t = list[i];
                    list[i] = list[k];
                    list[k] = t;
                }
            }
        }
        return list;
    }

    // INSERTION — versi descending
    public static int[] insertion(int[] list) {
        for (int i = 1; i < list.length; ++i) {
            int key = list[i];
            int k = i - 1;
            while (k >= 0 && list[k] < key) {  // ← diubah dari > ke <
                list[k + 1] = list[k];
                k = k - 1;
            }
            list[k + 1] = key;
        }
        return list;
    }

    // SELECTION — versi descending
    public static int[] selection(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int minIndex = i;
            for (int k = i + 1; k < list.length; k++) {
                if (list[k] > list[minIndex])  // ← diubah dari < ke >
                    minIndex = k;
            }
            int t = list[minIndex];
            list[minIndex] = list[i];
            list[i] = t;
        }
        return list;
    }
    */


    // NO 6 TAMBAH COUNTER tukarAtauGeser
    // BUBBLE — dengan counter
    public static int[] bubble(int[] list) {
        int tukarAtauGeser = 0;                        // ← tambahkan
        for (int i = 0; i < list.length - 1; i++) {
            for (int k = i + 1; k < list.length; k++) {
                if (list[k] < list[i]) {
                    int t = list[i];
                    list[i] = list[k];
                    list[k] = t;
                    tukarAtauGeser++;                  // ← tambahkan
                }
            }
        }
        System.out.println("bubble    tukarAtauGeser = " + tukarAtauGeser);  // ← tambahkan
        return list;
    }

    // INSERTION — dengan counter
    public static int[] insertion(int[] list) {
        int tukarAtauGeser = 0;                        // ← tambahkan
        for (int i = 1; i < list.length; ++i) {
            int key = list[i];
            int k = i - 1;
            while (k >= 0 && list[k] > key) {
                list[k + 1] = list[k];
                k = k - 1;
                tukarAtauGeser++;                      // ← tambahkan
            }
            list[k + 1] = key;
        }
        System.out.println("insertion tukarAtauGeser = " + tukarAtauGeser);  // ← tambahkan
        return list;
    }

    // SELECTION — dengan counter
    public static int[] selection(int[] list) {
        int tukarAtauGeser = 0;                        // ← tambahkan
        for (int i = 0; i < list.length - 1; i++) {
            int minIndex = i;
            for (int k = i + 1; k < list.length; k++) {
                if (list[k] < list[minIndex])
                    minIndex = k;
            }
            int t = list[minIndex];
            list[minIndex] = list[i];
            list[i] = t;
            tukarAtauGeser++;                          // ← tambahkan (selalu swap, N-1 kali)
        }
        System.out.println("selection tukarAtauGeser = " + tukarAtauGeser);  // ← tambahkan
        return list;
    }
    

    public static void main(String[] args) {

        // Soal 2 & 3 — array 30 elemen unik, tidak terurut
        int[] arr = {64, 23, 87, 12, 45, 78, 34, 91, 56, 7,
                     43, 67, 29, 83, 15, 72, 38, 95, 51, 26,
                     61, 18, 79, 42, 88, 33, 54, 69, 11, 47};

        System.out.println("Sebelum: " + Arrays.toString(arr));

        // Soal 4 — panggil satu per satu (pakai .clone() agar arr asli tidak rusak)
        System.out.println("bubble()  : " + Arrays.toString(bubble(arr.clone())));
        System.out.println("insertion(): " + Arrays.toString(insertion(arr.clone())));
        System.out.println("selection(): " + Arrays.toString(selection(arr.clone())));
    }
}