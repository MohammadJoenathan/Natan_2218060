/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB8;

/**
 *
 * @author ASUS
 */
public class Main2 {
    public static void main(String[] args) {
        Payment pay1 = new Payment(750000);
        
        pay1.titlePurchase(1);
        System.out.println("Credit Balance  : " + pay1.creditBalance);
        System.out.println("E-Money Balance : " + pay1.emoneyBalance);
        System.out.println("Cash Balance    : " + pay1.cashBalance);
        System.out.println("=====================================");
        System.out.println("Total Payment   : " + pay1.total);
        System.out.println("=====================================");
        System.out.println("Payment with Credit, Ending Balance  : " + pay1.creditProses());
        System.out.println("Payment with E-Money, Ending Balance : " + pay1.emoneyProses());
        System.out.println("Payment with Cash, Ending Balance    : " + pay1.cashProses());
    }  
}
