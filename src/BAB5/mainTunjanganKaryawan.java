/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB5;

/**
 *
 * @author ASUS
 */
public class mainTunjanganKaryawan {
    
    public static void main(String[] args) {
        Manager manager = new Manager(8000000);
        StaffMarketing staff = new StaffMarketing(4500000);
        
        System.out.println("Tunjangan Manager : " + manager.hitungTunjangan());
        System.out.println("Tunjangan Staff Marketing : " + staff.hitungTunjangan());
    }
    
}
