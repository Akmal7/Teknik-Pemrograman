package No3;

import java.util.Scanner;

class ParallelSum {
    private long totalSum = 0;

    public synchronized void addPartial(long value) {
        totalSum += value;
    }

    public long getTotalSum() {
        return totalSum;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner (System.in);

        System.out.print("Masukkan jumlah thread: ");
        int jumlahThread = input.nextInt();

        System.out.print("Masukkan angka akhir: ");
        int angkaAkhir = input.nextInt();

        ParallelSum result = new ParallelSum();

        Thread[] threads = new Thread[jumlahThread];

        int range = angkaAkhir / jumlahThread;

        for (int i = 0; i < jumlahThread; i++) {
            int start = i * range + 1;
            int end = (i == jumlahThread - 1) ? angkaAkhir : (i + 1) * range;

            int threadNumber = i + 1;

            threads[i] = new Thread(() -> {
                long partialSum = 0;

                System.out.println("Thread " + threadNumber +
                        " menghitung dari " + start + " sampai " + end);

                for (int j = start; j <= end; j++) {
                    partialSum += j;
                }

                System.out.println("Thread " + threadNumber +
                        " hasil parsial: " + partialSum);

                result.addPartial(partialSum);

            });
        }

        // Menjalankan semua thread
        for (Thread t : threads) {
            t.start();
        }

        // Menunggu semua thread selesai
        for (Thread t : threads) {
            t.join();
        }

        System.out.println("=== HASIL AKHIR ===");
        System.out.println("Total penjumlahan: " + result.getTotalSum());
    
    input.close();
    }
}