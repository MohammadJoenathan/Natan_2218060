/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB8;

/**
 *
 * @author ASUS
 */
public abstract class orangtua {
    
    String nama;
    int usia;
    
    public orangtua(String nama, int usia) {
        this.nama =  nama;
        this.usia =  usia;
    }
    
    abstract void tidur();
    abstract void makan();
    abstract void bekerja();
    abstract void berenang();
    
}
