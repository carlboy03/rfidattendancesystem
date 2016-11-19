package models;

import com.avaje.ebean.Model;

import org.joda.time.DateTime;

import javax.persistence.Entity;


public class Person extends Model{
    public int      idPerson;
    public String   name;
    public String   middleName;
    public String   lastName;
    public DateTime birthDate;
    public String   phone;
    public String   mail;
    public String   pass;
    public String   rfid;

    Person(){
        idPerson    = 0;
        name        = "";
        middleName  = "";
        lastName    = "";
        birthDate   = null;
        phone       = "";
        mail        = "";
        pass        = "";
        rfid       = "";
    }

    Person(int idPerson, String name, String middleName, String lastName, DateTime birthDate,
           String phone, String mail, String pass, String rfid){
        this.idPerson = idPerson;
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.mail = mail;
        this.pass = pass;
        this.rfid = rfid;
    }
    public void setName(String name){
       this.name=name;
    }

}