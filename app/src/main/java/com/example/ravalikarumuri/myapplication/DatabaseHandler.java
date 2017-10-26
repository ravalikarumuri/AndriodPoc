package com.example.ravalikarumuri.myapplication;

import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ravalikarumuri.myapplication.Visitor;

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "VisitorManagement";

    // Contacts table name
    private static final String TABLE_CONTACTS = "visitors";

    // Contacts Table Columns names
    private static final String KEY_ID="id";
    private static final String KEY_FNAME = "firstname";
    private static final String KEY_LNAME = "lastname";
    private static final String KEY_PH_NO = "mobilenumber";
    private static final String KEY_EMAILID="EmailId";
    private static final String KEY_PURPOSE="purpose";
    private static final String KEY_WHOMTOMEET="whomToMeet";
    private static final String KEY_IMAGE="image";
    private static final String KEY_SIGNATURE="signature";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("+KEY_ID +" INTEGER AUTO INCREMENT PRIMARY KEY,"
                + KEY_FNAME + " TEXT," + KEY_LNAME + " TEXT,"
                + KEY_PH_NO + " TEXT," + KEY_EMAILID +" TEXT,"+ KEY_PURPOSE +" TEXT," + KEY_WHOMTOMEET+ " TEXT,"+ KEY_IMAGE +" BLOB,"+ KEY_SIGNATURE+ " BLOB "+")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new contact
    void addContact(Visitor contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_FNAME, contact.getFirstname());
        values.put(KEY_LNAME,contact.getLastname());
        values.put(KEY_EMAILID,contact.getEmailId());
        values.put(KEY_PH_NO,contact.getMobilenumber());
        values.put(KEY_PURPOSE,contact.getPurpose());
        values.put(KEY_WHOMTOMEET,contact.getWhomToMeet());
        values.put(KEY_IMAGE,contact.getImage());
        values.put(KEY_SIGNATURE,contact.getSignature()); // Contact Phone
        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    Visitor getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor;
        cursor = db.query(TABLE_CONTACTS, new String[] { KEY_FNAME,
                        KEY_LNAME, KEY_PH_NO,KEY_EMAILID,KEY_PURPOSE,KEY_WHOMTOMEET,KEY_IMAGE,KEY_SIGNATURE }, KEY_ID+ "=?",
                new String[] { String.valueOf(id) }, null, null, null,null);
        if (cursor != null)
            cursor.moveToFirst();
        Visitor contact = new Visitor(cursor.getString(1), cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getBlob(7),cursor.getBlob(8));
        // return contact
        return contact;
    }

    // Getting All Contacts
    public ArrayList<Visitor> getAllContacts() {
        ArrayList<Visitor> contactList = new ArrayList<Visitor>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Visitor contact = new Visitor();
                contact.setFirstname(cursor.getString(1));
                contact.setLastname(cursor.getString(2));
                contact.setMobilenumber(cursor.getString(3));
                contact.setEmailId(cursor.getString(4));
                contact.setPurpose(cursor.getString(5));
                contact.setWhomToMeet(cursor.getString(6));
                contact.setImage(cursor.getBlob(7));
                contact.setSignature(cursor.getBlob(8));


                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    // Updating single contact
    public int updateContact(Visitor contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FNAME, contact.getFirstname());
        values.put(KEY_LNAME,contact.getLastname());
        values.put(KEY_PH_NO,contact.getMobilenumber());
        values.put(KEY_EMAILID,contact.getEmailId());
        values.put(KEY_PURPOSE,contact.getPurpose());
        values.put(KEY_WHOMTOMEET,contact.getWhomToMeet());
        values.put(KEY_IMAGE,contact.getImage());
        values.put(KEY_SIGNATURE,contact.getSignature());
        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getId()) });
    }

    // Deleting single contact
    public void deleteContact(Visitor contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getId()) });
        db.close();
    }


    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

}