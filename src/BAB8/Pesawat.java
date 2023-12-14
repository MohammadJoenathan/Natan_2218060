/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB8;

/**
 *
 * @author ASUS
 */
public class Pesawat extends kendaraan implements Berjalan, Terbang{
    public Pesawat (String merek){
        super (merek);
    }
    @Override
    void carabergerak(){
        System.out.println("Pesawat bergerak dalam udara dengan mengunakan mesin-mesin yang memungkinkan untuk terbang");
    }
    @Override
    public void kecepatanMax(){
        System.out.println("900 km/h");
    }
    @Override
    public void berjalan(){
        System.out.println("Pesawat"+ getMerek()+ "berjalan maju melalui roda yang bersentuhan langsung dengan permukaan tanah");
    }
    @Override
    public void terbang (){
        System.out.println("Pesawat"+ getMerek()+ "mesin yang berkecepatan tinggi, baling-baling dan sayap aerodinamic memungkinkan pesawat untuk lepas landas");
    }
}
