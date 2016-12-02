package models;

import com.avaje.ebean.*;

import org.joda.time.DateTime;

import javax.persistence.Entity;


public class Person extends Model{
    public int      person_id;
    public String   person_name;
    public String   person_last_name;
    public int  person_type;
    public String   person_uprm_id;
    public String   rfid;
    public String person_email;
    public String person_password;

    public Person(){
        int   person_id=-1;
        String   person_name;
        String   person_last_name;
        int  person_type;
        String   person_uprm_id;
        String   rfid;
        String person_email;
        String person_password;
    }

    public Person (
            int      person_id,
            String   person_name,
            String   person_last_name,
            int  person_type,
            String   pass,
            String   rfid,
            String person_email, String person_password)
    {
        this.person_id=person_id;
        this.person_name=person_name;
        this.person_last_name=person_last_name;
        this.person_type=person_type;
        this.person_uprm_id=pass;
        this.rfid=rfid;
        this.person_email=person_email;
        this.person_password=person_password;
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

    public String getPerson_uprm_id() {
        return person_uprm_id;
    }

    public void setPerson_uprm_id(String person_uprm_id) {
        this.person_uprm_id = person_uprm_id;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getPerson_email() {
        return person_email;
    }

    public void setPerson_email(String person_email) {
        this.person_email = person_email;
    }

    public String getPerson_password() {
        return person_password;
    }

    public void setPerson_password(String person_password) {
        this.person_password = person_password;
    }
}

