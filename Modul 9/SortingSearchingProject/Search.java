package SortingSearchingProject;

public class Search {

    /*
    // --- LINEAR SEARCH ---
    public static int linearSearch(int[] arr, int search) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == search) return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int search) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == search) return mid;
            if (arr[mid] < search) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    } */


    // --- LINEAR — dengan counter
    public static int linearSearch(int[] arr, int search) {
        int check = 0;                                         // ← tambahkan
        for (int i = 0; i < arr.length; i++) {
            check++;                                           // ← tambahkan
            if (arr[i] == search) {
                System.out.println("linearSearch check = " + check);  // ← tambahkan
                return i;
            }
        }
        System.out.println("linearSearch check = " + check);  // ← tambahkan
        return -1;
    }

    // --- BINARY — dengan counter
    public static int binarySearch(int[] arr, int search) {
        int check = 0;                                         // ← tambahkan
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            check++;                                           // ← tambahkan
            int mid = low + (high - low) / 2;
            if (arr[mid] == search) {
                System.out.println("binarySearch check = " + check);  // ← tambahkan
                return mid;
            }
            if (arr[mid] < search) low = mid + 1;
            else high = mid - 1;
        }
        System.out.println("binarySearch check = " + check);  // ← tambahkan
        return -1;
    }

    public static void main(String[] args) {

        // Soal 1 — array 30 elemen, sorted ascending, ada nilai 88 di index 22
        int[] arr = {3, 7, 11, 15, 18, 22, 26, 29, 33, 37,
                     41, 45, 49, 53, 57, 61, 65, 69, 73, 77,
                     81, 85, 88, 91, 93, 95, 96, 97, 98, 99};

        // Soal 2 — linearSearch, cari 88
        int hasil = linearSearch(arr, 88);
        System.out.println("linearSearch(88) = " + hasil);   // 22

        // Soal 3 — linearSearch, cari nilai yang tidak ada
        int hasil2 = linearSearch(arr, 50);
        System.out.println("linearSearch(50) = " + hasil2);  // -1

        // Soal 4 — binarySearch, cari 88
        int hasil3 = binarySearch(arr, 88);
        System.out.println("binarySearch(88) = " + hasil3);  // 22

        // Soal 5 — binarySearch, cari nilai yang tidak ada
        int hasil4 = binarySearch(arr, 50);
        System.out.println("binarySearch(50) = " + hasil4);  // -1
    }
}