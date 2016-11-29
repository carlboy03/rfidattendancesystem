package models;

import com.avaje.ebean.*;

import org.joda.time.DateTime;

import javax.persistence.Entity;


public class Person extends Model{
    public int      person_id;
    public String   person_name;
    public String   person_last_name;
    public int  person_type;
    public String   pass;
    public String   rfid;

    public Person(){
        int   person_id;
        String   person_name;
         String   person_last_name;
         int  person_type;
         String   pass;
         String   rfid;
    }

    public Person ( int      person_id,
             String   person_name,
             String   person_last_name,
                    int  person_type,
             String   pass,
             String   rfid)
    {
        this.person_id=person_id;
        this.person_name=person_name;
        this.person_last_name=person_last_name;
        this.person_type=person_type;
        this.pass=pass;
        this.rfid=rfid;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getPerson_last_name() {
        return person_last_name;
    }

    public void setPerson_last_name(String person_last_name) {
        this.person_last_name = person_last_name;
    }

    public int getPerson_type() {
        return person_type;
    }

    public void setPerson_type(int person_type) {
        this.person_type = person_type;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }
}

