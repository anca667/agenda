/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author ancy
 */
public class DBConnect {

    /**
     * @param args the command line arguments
     */
    
    private final static String host = "jdbc:derby://localhost:1527/Test";
    private final static String uName = "add";
    private final static String uPass = "admin";
    
    private static Connection con ;
    
    private static DBConnect _instance;
    
    public static DBConnect getInstance(){
        if(_instance == null){
            _instance = new DBConnect();
        }
        return _instance;
    }
    
    private DBConnect(){
        runConnection();
    }
    
    private void runConnection(){
        try{
            con = DriverManager.getConnection(host, uName, uPass);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public Vector<Owner> getOwners(){
        Vector<Owner> owners = new Vector<Owner>();
        try{
            Statement st = con.createStatement();
            String query = "SELECT * FROM OWNER";
            ResultSet rs  = st.executeQuery(query);
            while(rs.next())
            {
                int id = rs.getInt("ID");
                String user = rs.getString("USERNAME");
                String pwd = rs.getString("PASSWORD");
                
                owners.add(new Owner(user,pwd,id));
            }
        }catch(Exception ex){
             System.out.println(ex.getMessage());
        }
        
        return owners;
    }
    
    public boolean addOwner(Owner owner){
        try{
            Statement statement = con.createStatement();
            int id = owner.getId();
            String sql = "INSERT INTO APP.OWNER " +
                    " VALUES(" +  String.valueOf(id) + ", '" + owner.getUsername() + "' , '" + owner.getPassword() + "')"; 
            int hRes = statement.executeUpdate(sql);
            if(hRes > 0){
                return true;
            }
            return false;
        }catch(Exception ex){
            return false;
        }
    }
    
    public Vector<Person> getPersonFromOwnerId(int id){
        Vector<Person> persons = new Vector<Person>();
        try{
            Statement st = con.createStatement();
            String query = "SELECT * FROM APP.PERSON WHERE OWNER_ID = " + 
                    String.valueOf(id) +
                    " ORDER BY LAST_NAME,FIRST_NAME";
            ResultSet rs  = st.executeQuery(query);
            while(rs.next())
            {
                int _id = rs.getInt("ID");
                String firstname = rs.getString("FIRST_NAME");
                String lastname = rs.getString("LAST_NAME");
                String phone = rs.getString("TELEPHONE");
                String picPath = rs.getString("PICTURE_PATH");
                String email = rs.getString("EMAIL");
                int _oId = rs.getInt("OWNER_ID");
                
                persons.add(new Person(_id,firstname, lastname, picPath, phone, email,_oId));
            }
        }catch(Exception ex){
             System.out.println(ex.getMessage());
        }
        return persons;
    }
    
    public OwnerDetails getDetailsFrom(Owner owner){
        
        try{
            Statement pStatement = con.createStatement();
            String selectQuery = "SELECT * FROM APP.OWNER_DETAILS WHERE OWNER_ID = " + String.valueOf(owner.getId());
            ResultSet rs  = pStatement.executeQuery(selectQuery);
            while(rs.next()){
                int id = rs.getInt("ID");
                String firstName = rs.getString("FIRST_NAME");
                String lastName = rs.getString("LAST_NAME");
                String email = rs.getString("EMAIL");
                String picPath = rs.getString("PICTURE_PATH");
                return new OwnerDetails(id, firstName, lastName, email, picPath, owner);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public boolean addOwnerDetails(OwnerDetails details,boolean update) {
        if(update)
        {
            try{
                Statement statement = con.createStatement();
                String sql = "UPDATE APP.OWNER_DETAILS SET " +
                        "FIRST_NAME = " + "'" + details.getFirstName()+ "'" +
                        ",LAST_NAME = " + "'" + details.getLastName() + "'" +
                        ",EMAIL = " + "'" + details.getEmail() + "'" +
                        ",PICTURE_PATH = " + "'" + details.getPicturePath() + "'" +
                        " WHERE ID = " + String.valueOf(details.getId());
                
                int hRes = statement.executeUpdate(sql);
                
                if(hRes > 0){
                    return true;
                }
                return false;
            }catch(Exception ex){
                return false;
            }
        }
        else
        {
           try{
                Statement statement = con.createStatement();
                String sql = "INSERT INTO APP.OWNER_DETAILS VALUES ( " +
                        String.valueOf(details.getId()) + 
                        ",'" + details.getPicturePath() + "'," +
                        "'" + details.getEmail() + "'" +
                        ",'" + details.getFirstName() + "'" +
                        ",'" + details.getLastName() + "'," +
                        String.valueOf(details.getOwnerId()) + ")";
                
                int hRes = statement.executeUpdate(sql);
                if(hRes > 0){
                    return true;
                }
                return false;
            }catch(Exception ex){
                return false;
            }
        }
    }
    
    public int getIdForNewOwnerDetails(){
        try{
            Statement st = con.createStatement();
            String query = "SELECT MAX(ID) AS MAX_ID FROM OWNER_DETAILS";
            ResultSet rs  = st.executeQuery(query);
            rs.next();
            return rs.getInt("MAX_ID");
        }catch(Exception ex){
            return -1;
        }
    }
    
   /*
    
    public static void main(String[] args) {
        
        try{  
    //Connect to the database  
    String host = "jdbc:derby://localhost:1527/Test";
    String uName="app";
    String uPass="admin";
    Connection con = DriverManager.getConnection( host, uName, uPass );
    
    Statement stmt = con.createStatement( );
    String SQL = "SELECT * FROM PERSON";
    ResultSet rs = stmt.executeQuery( SQL );
    
    while(rs.next()){
    int ID=rs.getInt("ID");
    String EMAIL= rs.getString("Email");
    String FIRST = rs.getString("First_Name");
    String LAST = rs.getString("LAST_NAME");
    String TELEPHONE = rs.getString("Telephone");
    
    
    //int DATA = rs.getInt("data");
    //String TITLE = rs.getString("title");
    //String DESCRIPTION = rs.getString("description");
    //int ID_OWNER = rs.getInt("ID");
    
    String p=ID+" "+FIRST+" "+LAST+" "+EMAIL+" "+TELEPHONE;
    System.out.println(p);   }
    
    
  }catch ( SQLException err ) {
           System.out.println( err.getMessage( ) );}

        // TODO code application logic here
    }
 */
    
}
