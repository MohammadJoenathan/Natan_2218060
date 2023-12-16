/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasPrak1;

/**
 *
 * @author ASUS
 */
public class DataLembur extends PembayaranGaji implements AlasanLembur{
    
    // Atribut
    String tanggal;
    int durasiLembur;
    private int gajiLembur;

    public DataLembur() 
    {
        totalGaji = 4000000; // Memberikan nilai awal pada totalGaji
    } 
    
    public void tanggal(String tanggal){
        this.tanggal = tanggal;
    }
    public void durasiLembur(int durasiLembur){
        this.durasiLembur = durasiLembur;
    }
    public void gajiLembur(int gajiLembur){
        this.gajiLembur = gajiLembur;
    }

    public int getGajiLembur() {
        return gajiLembur;
    }

    public void setGajiLembur(int gajiLembur) {
        this.gajiLembur = gajiLembur;
    }
    
    public String tanggal(){ 
        return tanggal; 
    } 
    public int durasiLembur(){ 
        return durasiLembur; 
    } 
    public int gajiLembur(){ 
        return gajiLembur; 
    }

    @Override
    public int Pajak() { // Penerapan Polymorfisme yaitu Dynamic Polimorfisme
        return ((getGajiLembur() - pajak));
    }
    
    @Override
    public int hitGaji(){
        return hitGaji(Pajak()); // Hasil perhitungan pajak akan digunakan pada perhitungan gaji
    }

    @Override
    public String Alasan1() { // Penerapan Interface
        return "Beban Kerja Yang Banyak";
    }
    @Override
    public String Alasan2() { // Penerapan Interface
        return "Deadline Yang Ketat";
    }
    @Override
    public String Alasan3() { // Penerapan Interface
        return "Menambah Penghasilan";
    }
}