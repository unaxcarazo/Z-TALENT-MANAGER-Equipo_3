/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s.z_talent_manager.util;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author DAW1
 */
public class PasswordUtils {
    public static String getHash(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    
    public static boolean checkPw(String password, String hash){
        return BCrypt.checkpw(password, hash);
    }
    
    public static void main(String[] args) {
        System.out.println(getHash("zuser"));
    } 

 
        
    
}

