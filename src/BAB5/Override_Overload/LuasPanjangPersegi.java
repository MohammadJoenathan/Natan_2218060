/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB5.Override_Overload;

/**
 *
 * @author ASUS
 */
public class LuasPanjangPersegi extends BangunDatar{
    int panjang;
    int lebar;

    @Override
    public double Luas() {
        return Luas(panjang, lebar);
    }
  
}
