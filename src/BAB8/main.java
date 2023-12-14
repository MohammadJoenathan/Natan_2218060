/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB8;

/**
 *
 * @author ASUS
 */
public class main {
    
    public static void main(String[] args) {
        Anak anak = new Anak("Bilbert", 20);
        System.out.println("Object anak bernama " +anak.nama+"Berusia " +anak.usia);
        anak.tidur();
        anak.makan();
        anak.bekerja();
        anak.berenang();
        anak.ngoding();
    }
}
