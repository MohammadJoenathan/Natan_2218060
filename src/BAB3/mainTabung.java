/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB3;

/**
 *
 * @author ASUS
 */
public class mainTabung {
    
    public static void main(String[] args) {
        Lingkaran lkr = new Lingkaran(7); // memanggil construktor
        
        lkr.Deskripsi();
        System.out.println("Hasilnya adalah : " + lkr.HitLuasLingkaran());
        System.out.println("==========================================");
        Tabung tbg = new Tabung(7,20);
        tbg.Keterangan();
        System.out.println("Volume adalah : " + tbg.HitvolumeTabung());
        
    }
    
}
