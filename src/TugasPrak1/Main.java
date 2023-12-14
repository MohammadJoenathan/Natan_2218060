/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasPrak1;

/**
 *
 * @author Mohammad Joenathan T. A. P
 */
public class Main {
    public static void main(String[] args) {
        
        PembayaranGaji gaji = new PembayaranGaji();
        
        gaji.idKaryawan("DRKR-014");
        gaji.namaKaryawan("Mohammad Natan");
        gaji.jabatan("Direktur Utama");
//        gaji.gajiPokok("7.000.000");
//        gaji.tunjangan("750.000");
//        gaji.pajak("500.000");
//        gaji.totalGaji("7.250.000");
        gaji.metodePembayaran("Transfer Bank");
        System.out.println("SLIP GAJI KARYAWAN");
        System.out.println("=====================================");
        System.out.println("ID Karyawan       : " + gaji.idKaryawan());
        System.out.println("Nama Karyawan     : " + gaji.namaKaryawan());
        System.out.println("Jabatan           : " + gaji.jabatan());
        System.out.println("Gaji Pokok        : " + gaji.gajiPokok());
        System.out.println("Tunjangan         : " + gaji.tunjangan());
        System.out.println("Pajak             : " + gaji.Pajak());
        System.out.println("Total Gaji        : " + gaji.totalGaji());
        System.out.println("Metode Pembayaran : " + gaji.metodePembayaran());
    }
}
