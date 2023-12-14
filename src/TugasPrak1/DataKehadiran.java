/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasPrak1;

/**
 *
 * @author ASUS
 */
public class DataKehadiran extends PembayaranGaji{
    
    // Atribut
    String tanggal, jamMasuk, jamKeluar;
    private int totalJamKerja;
    
    public void tanggal(String tanggal){
        this.tanggal = tanggal;
    }
    public void jamMasuk(String jamMasuk){
        this.jamMasuk = jamMasuk;
    }
    public void jamKeluar(String jamKeluar){
        this.jamKeluar = jamKeluar;
    }
    public void totalJamKerja(int totalJamKerja){
        this.totalJamKerja = totalJamKerja;
    }
    
    public int getTotalJamKerja() {
        return totalJamKerja;
    }
    
    public void setTotalJamKerja(int totalJamKerja) {
        this.totalJamKerja = totalJamKerja;
    }
    
    public String tanggal(){ 
        return tanggal; 
    } 
    public String jamMasuk(){ 
        return jamMasuk; 
    } 
    public String jamKeluar(){ 
        return jamKeluar; 
    } 
    public int gettotalJamKerja(){ 
        return totalJamKerja; 
    }
    // Implementasi dari method abstrak di kelas DataAbsensi
    @Override
    void email(String Email) {
        this.email = Email;
    } 
}
