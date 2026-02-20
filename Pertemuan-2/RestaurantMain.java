/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author akmal
 */
public class RestaurantMain {

    public static void main(String[] args) {

        Restaurant menu = new Restaurant();

        System.out.println("\n--- Jumlah Menu Awal ---");
        menu.tambahMenuMakanan("Pizza", 250000, 20);
        menu.tambahMenuMakanan("Spaghetti", 80000, 15);
        menu.tambahMenuMakanan("Steak", 150000, 5);

        menu.tampilMenuMakanan();

        System.out.println("\n--- Pemesanan ---");

        menu.pesanMakanan("Pizza", 5);
        menu.pesanMakanan("Steak", 10); 

        System.out.println("\n--- Jumlah Menu Setelah Pemesanan ---");
        menu.tampilMenuMakanan();
    }
}