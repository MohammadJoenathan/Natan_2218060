/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB4.Enkapsulasi;

/**
 *
 * @author Aharfi
 */
public class mainGaji {
    public static void main(String[]args){
        pembayaranGaji gaji = new pembayaranGaji();
        gaji.setInput("G2218045");
        System.out.println("Rekening yang anda masukkan : " + gaji.getInput());
        System.out.println("Jumlah saldo anda : " + gaji.cekSaldo());
    }
}
