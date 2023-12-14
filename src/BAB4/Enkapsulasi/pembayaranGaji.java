/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB4.Enkapsulasi;

/**
 *
 * @author Aharfi
 */
public class pembayaranGaji {
    private String nomorRekening,input;
    private double saldo;
    public pembayaranGaji(){
        this.nomorRekening = "G2218045";
        this.saldo = 5000000;
    }
    public String getNomorRek(){
        return nomorRekening;
    }
    public void setNomorRekening(String nomorRekening){
        this.nomorRekening = nomorRekening;
    }
    public double getSaldo(){
        return saldo;
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    public String getInput(){
        return input;
    }
    public void setInput(String input){
        this.input = input;
    }
    public double cekSaldo(){
        if(getNomorRek().equals(getInput())){
            return getSaldo();
        }else{
            return 0;
        }
           
    }
}
