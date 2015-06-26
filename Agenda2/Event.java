/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda2;

import java.util.Date;
import java.util.Vector;

/**
 *
 * @author ancy
 */
public class Event {
    private int ownerId;
    private String title;
    private String description;
    private Date date;
    private Vector<Person> persons;
    
    private String sqlDate;
    
    public String getSqlDate(){
        return sqlDate;
    }
    public void setSqlDate(String value){
        sqlDate = value;
    }
    
    
    public Event(){
        persons = new Vector<Person>();
    }
    
    public Event(int _id , int _ownerId ,String _title , String _description , Date _date) {
         persons = new Vector<Person>();
        int id = _id;
         ownerId = _ownerId;
         title = _title;
         description = _description;
         date = _date;
    }

    public void setOwnerId(int value){
        this.ownerId = value;
    }
    
    public int getOwnerId(){
        return this.ownerId;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public void setTitle(String value){
        this.title = value;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public void setDescription(String value){
        this.description = value;
    }
    
    public void setDate(Date date) {
        this.date = date; 
    }
    
    public Date getDate() { 
        return date; 
    }
    
    public void addPerson(Person p) {
        persons.add(p);
    }
    
    public boolean removePerson(Person p){
       return persons.remove(p);
    }
}
