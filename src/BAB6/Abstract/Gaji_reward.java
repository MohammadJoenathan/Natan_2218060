/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB6.Abstract;

/**
 *
 * @author ASUS
 */
public abstract class Gaji_reward extends Gaji_abs_reward{
    
    int menit, waktu;
    double tunj_bonus, gajipokok, tunj_anak, anak;
//
//    @Override
//    double tunjanganAnak() {
//        if 
//    @Override
//    double tunjanganAnak() {
//        if (anak == 1){
//            tunj_anak = gajipokok * 0.1;
//            return tunj_anak;
//        }
//        if (anak > 1){
//            tunj_anak = gajipokok * 0.3;
//            return tunj_anak;
//        }
//    }(anak == 1){
//            tunj_anak = gajipokok * 0.1;
//            return tunj_anak;
//        }
//        if (anak > 1){
//            tunj_anak = gajipokok * 0.3;
//            return tunj_anak;
//        }
//    }
    
    @Override
    abstract double lembur();    
    
}
