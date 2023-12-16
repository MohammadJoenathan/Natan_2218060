/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasPrak1;

/**
 *
 * @author ASUS
 */
public class PembayaranGaji extends Abstract{
    // atribut
    public String idKaryawan, namaKaryawan, email;
    protected String jabatan, metodePembayaran;
    protected int gajiPokok, tunjangan;
    public int totalGaji;
    public int pajak;
    
    // Overloading setter untuk idKaryawan
    public void idKaryawan(String idKaryawan){
        this.idKaryawan = idKaryawan;
    }
    // Overloading setter untuk namaKaryawan
    public void namaKaryawan(String namaKaryawan){
        this.namaKaryawan = namaKaryawan;
    }
    public void jabatan(String jabatan){
        this.jabatan = jabatan;
    }
    public void gajiPokok(int gajiPokok){
        this.gajiPokok = gajiPokok;
    }
    public void tunjangan(int tunjangan){
        this.tunjangan = tunjangan;
    }
    public void pajak(int pajak){
        this.pajak = pajak;
    }
    public void totalGaji(int totalGaji){
        this.totalGaji = totalGaji;
    }
    public void metodePembayaran(String metodePembayaran){
        this.metodePembayaran = metodePembayaran;
    }
     
    public int getTotalGaji() {
        return totalGaji;
    }

    public void setTotalGaji(int totalGaji) {
        this.totalGaji = totalGaji;
    }
    
    public PembayaranGaji() {
        this.pajak = 25000;
    }
    
    //method untuk overriding dan overloading
    public int hitGaji()
    {
        return 0;
    }
    public int hitGaji(int gajiLembur)
    {
        totalGaji = totalGaji + gajiLembur;
        return totalGaji;
    }
    
    public String idKaryawan(){ 
        return idKaryawan; 
    } 
    public String namaKaryawan(){ 
        return namaKaryawan; 
    } 
    public String jabatan(){ 
        return jabatan; 
    } 
    public int gajiPokok(){ 
        return gajiPokok; 
    } 
    public int tunjangan(){ 
        return tunjangan; 
    } 
    public int totalGaji(){ 
        return totalGaji; 
    }
    public String metodePembayaran(){ 
        return metodePembayaran; 
    }
    public String Email(){ 
        return email; 
    }
    int Pajak(){ // Penerapan Polymorfisme 
        return pajak;
    } 
    
    // Implementasi dari method abstrak di kelas PembayaranGaji
    @Override
    void email(String Email) {
        this.email = Email;
    }
    
}
