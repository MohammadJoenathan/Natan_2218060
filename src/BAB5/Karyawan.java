/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB5;

/**
 *
 * @author ASUS
 */
public class Karyawan {
    
    public double gajiDasar;
    
    public Karyawan(double gajiDasar){
        this.gajiDasar = gajiDasar;
    }
    
    public double hitungTunjangan(){
        return gajiDasar * 0.1;
    }
    
}
