/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB9.Exception;

/**
 *
 * @author ASUS
 */
public class Login {
    private String username, password;
    String nama;
    public Login(){
        nama = "Mohammad Natan";
        username = "Natan";
        password = "Natan123";
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    boolean CekLogin(String Username, String password){
        if(username.equals(getUsername()) && password.equals(getPassword())) {
            return true;
        }
        return false;
    }
}
