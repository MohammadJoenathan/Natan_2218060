/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB3;

/**
 *
 * @author ASUS
 */
public class Lingkaran {
    
    // atribut
    int r;
    double phi;
    double luas;
    
    // construktor
    public Lingkaran(int r) {
        this.r = r;
        // r = 7;
        phi = 3.14;
    }
    
    // method
    void Deskripsi() {
        System.out.println("Ini adalah hasil menghitung");
    }
    
    // method untuk menghitung luas
    double HitLuasLingkaran() {
        luas = (phi * r * r);
        return luas;
    }
    
}
