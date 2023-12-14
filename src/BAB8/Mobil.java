/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB8;

/**
 *
 * @author ASUS
 */
public class Mobil extends kendaraan implements Berjalan{
    
    public Mobil(String merek) {
        super(merek);
    }

    @Override
    void carabergerak() {
        System.out.println("bergerak maju melalui roda yang bersentuhan langsung dengan permukaan tanah.");
    }

    @Override
    void kecepatanMax() {
        System.out.println("500km/h");
    }

    @Override
    public void berjalan() {
        System.out.println("Mobil " + getMerek() + " sedang berjalan di jalan raya");
    }
}
