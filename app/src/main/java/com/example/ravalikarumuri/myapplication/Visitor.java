package com.example.ravalikarumuri.myapplication;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by ravali.karumuri on 19-12-2016.
 */

public class Visitor implements Serializable
{   int id;
    String firstname;
    String lastname;
    String mobilenumber;
    String EmailId;
    String purpose;
    String whomToMeet;
    byte[] image;
    byte[] signature;
    public Visitor()
    {

    }
    public Visitor(int _id, String _firstname, String _lastname,String _mobilenumber,String _EmailId,String _purpose,String _whomToMeet,byte[] _image,byte[] _signature){
        this.id = _id;
        this.firstname = _firstname;
        this.lastname=_lastname;
        this.mobilenumber=_mobilenumber;
        this.EmailId=_EmailId;
        this.purpose=_purpose;
        this.whomToMeet=_whomToMeet;
        this.image=_image;
        this.signature=_signature;
    }
    public Visitor( String _firstname, String _lastname,String _mobilenumber,String _EmailId,String _purpose,String _whomToMeet,byte[] _image,byte[] _signature){

        this.firstname = _firstname;
        this.lastname=_lastname;
        this.mobilenumber=_mobilenumber;
        this.EmailId=_EmailId;
        this.purpose=_purpose;
        this.whomToMeet=_whomToMeet;
        this.image=_image;
        this.signature=_signature;
    }
    // constructor
    public Visitor(String _firstname, String _lastname,String _mobilenumber,String _EmailId,String _purpose,String _whomToMeet){
        this.firstname = _firstname;
        this.lastname=_lastname;
        this.mobilenumber=_mobilenumber;
        this.EmailId=_EmailId;
        this.purpose=_purpose;
        this.whomToMeet=_whomToMeet;
    }
    public int getId() {
        return id;
    }

    public String getEmailId() {
        return EmailId;
    }

    public byte[] getSignature() {
        return signature;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
    public String getMobilenumber() {
        return mobilenumber;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getWhomToMeet() {
        return whomToMeet;
    }

    public byte[] getImage() {
        return image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setEmailId(String emailId) {
        EmailId = emailId;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setWhomToMeet(String whomToMeet) {
        this.whomToMeet = whomToMeet;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }
}
