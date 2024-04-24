package com.example.mfmoodandfeelingdiary.Models;

public class User {
    private String fname,lname, email, pass, date, mood , text;

    public User() {}

    public User(String fname,String lname, String email, String pass, String date, String mood, String text){
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.pass = pass;
        this.date = date;
        this.mood = mood;
        this.text = text;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname(){return lname; }

    public void setLname(String lname) {this.lname = lname;}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDate(){return date;}

    public void setDate(String date){this.date = date;}

    public String getMood(){return mood;}

    public void setMood(String mood){this.mood = mood;}

    public String getText(){return text;}

    public void setText(String text){this.text = text;}



}
