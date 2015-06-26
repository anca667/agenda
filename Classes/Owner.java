/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author ancy
 */
public class Owner {
    private String username;
    private String password;
    private final int id;
    
    public String getUsername() { return username; }
    public String getPassword() { return password; }
   
    //toDO: details for the Owner
    public Owner(String user , String pwd , int id){
        username = user;
        password = pwd;
        this.id = id;
    }
    
    public boolean login(String user,String pwd){
        return username.compareTo(user) == 0 &&
                pwd.compareTo(password) == 0;
    }
    
    public boolean isSameUsername(String user){
        return username.compareTo(user) == 0 ? true : false;
    }
}
