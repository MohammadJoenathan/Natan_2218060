/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB7;

/**
 *
 * @author ASUS
 */
public class S0001 extends Pembayaran{
    
    public String name, alamat;
    public int saldo;
    public String kode;
    double diskon, bayar, total;
    
    public S0001(){
        this.name = "Mohammad Harifin";
        this.kode = "S0001";
        this.saldo = 500000;
        this.alamat = "Malang, JL. Singosari No 23";
    }
    
    public double hasil() {
        return diskon;
    }

    @Override
    double cekKode(String input) {
        if (input.compareTo(kode) == 0) {
            diskon = 0.1;
        } else {
            diskon = 0;
        }
        return diskon;
    }

    @Override
    double hitPembayaran(double bayar) {
        diskon = bayar * diskon;
        total = bayar - diskon;
        return total;
    }
    double potSaldo() {
        return this.saldo - total;
    }

    @Override
    void tampilkanMember() {
        System.out.println("Member S0001 dengan diskon 10%");
    }
}
