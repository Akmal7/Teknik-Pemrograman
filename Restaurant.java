/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author akmal
 */
public class Restaurant {

    private String[] namaMakanan;
    private double[] hargaMakanan;
    private int[] stok;
    private int jumlahMenu;

    public Restaurant() {
        namaMakanan = new String[10];
        hargaMakanan = new double[10];
        stok = new int[10];
        jumlahMenu = 0;
    }

    public String getNamaMakanan(int index) {
        return namaMakanan[index];
    }

    public double getHargaMakanan(int index) {
        return hargaMakanan[index];
    }

    public int getStok(int index) {
        return stok[index];
    }

    public void setStok(int index, int stokBaru) {
        if (stokBaru >= 0) {
            stok[index] = stokBaru;
        } else {
            System.out.println("Stok tidak bisa negatif!");
        }
    }

    public void tambahMenuMakanan(String nama, double harga, int stokAwal) {
        if (stokAwal < 0) {
            System.out.println("Stok awal tidak bisa negatif!");
            return;
        }

        namaMakanan[jumlahMenu] = nama;
        hargaMakanan[jumlahMenu] = harga;
        stok[jumlahMenu] = stokAwal;
        jumlahMenu++;
    }

    public void tampilMenuMakanan() {
        for (int i = 0; i < jumlahMenu; i++) {
            System.out.println(
                namaMakanan[i] + " [" + stok[i] + "] \tRp. " + hargaMakanan[i]
            );
        }
    }

    public void pesanMakanan(String nama, int jumlahPesan) {

        for (int i = 0; i < jumlahMenu; i++) {

            if (namaMakanan[i].equalsIgnoreCase(nama)) {

                if (jumlahPesan <= stok[i]) {
                    stok[i] -= jumlahPesan;
                    System.out.println("Pesanan berhasil! Sisa stok: " + stok[i]);
                } else {
                    System.out.println("Pesanan gagal! Stok tidak cukup.");
                }

                return;
            }
        }

        System.out.println("Menu tidak ada.");
    }
}