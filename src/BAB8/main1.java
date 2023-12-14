/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB8;

/**
 *
 * @author ASUS
 */
public class main1 {
    
    public static void main (String[]agrs){
        Mobil mobil = new Mobil("Toyota");
        mobil.berjalan();
        mobil.carabergerak();
        mobil.kecepatanMax();
        System.out.println("============================");
        Pesawat pesawat = new Pesawat(" Boieng 737 ");
        pesawat.carabergerak();
        pesawat.kecepatanMax();
        pesawat.berjalan();
        pesawat.terbang();
    }
    
}
