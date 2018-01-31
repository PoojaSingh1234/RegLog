package com.example.user.reglog;

/**
 * Created by USER on 31-01-2018.
 */

public class User {

    private String Name, Email, City;
    private int ID,Mobile, Aadhar;

    public User(int ID,String Name, String Email, int Mobile, String City, int Aadhar) {
        this.ID = ID;
        this.Name = Name;
        this.Email = Email;
        this.Mobile = Mobile;
        this.City = City;
        this.Aadhar = Aadhar;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getCity() {
        return City;
    }

    public int getMobile() {
        return Mobile;
    }

    public int getAadhar() {
        return Aadhar;
    }
}
