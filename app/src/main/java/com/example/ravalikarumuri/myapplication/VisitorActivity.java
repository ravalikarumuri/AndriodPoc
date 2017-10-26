package com.example.ravalikarumuri.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VisitorActivity extends AppCompatActivity {
    private EditText efname;
    private EditText elname;
   private EditText eEmailid;
   private EditText emobilenumber;
   private EditText epurpose;
   private EditText epersonToMeet;
   Button btnNext;
    final Visitor visitor = new Visitor();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor);
        registerViews();
/*
        final Visitor visitor=new Visitor();
        final EditText efname =  (EditText) findViewById(R.id.fname);
       // visitor.setFirstname(efname.getText().toString());
        final EditText elname=(EditText) findViewById(R.id.lname);
        //visitor.setLastname(elname.getText().toString());
        final EditText emobilenumber=(EditText) findViewById(R.id.mobilenumber);
         //visitor.setMobilenumber(emobilenumber.getText().toString());
        final EditText eEmailid=(EditText) findViewById(R.id.emailid);
        //visitor.setEmailId(eEmailid.getText().toString());
        final EditText epurpose=(EditText) findViewById(R.id.purpose);
        //visitor.setPurpose(epurpose.getText().toString());
        final EditText epersonToMeet=(EditText) findViewById(R.id.persontomeet);
        //visitor.setWhomToMeet(epersonToMeet.getText().toString());
         Button btnNext= (Button) findViewById(R.id.savedetails);
        btnNext.setOnClickListener(new View.OnClickListener() {
         @Override
        public void onClick(View view) {
             visitor.setFirstname(efname.getText().toString());
             visitor.setLastname(elname.getText().toString());
             visitor.setMobilenumber(emobilenumber.getText().toString());
             visitor.setEmailId(eEmailid.getText().toString());
             visitor.setPurpose(epurpose.getText().toString());
             visitor.setWhomToMeet(epersonToMeet.getText().toString());
        Intent intent=new Intent(VisitorActivity.this,CameraActivity.class);
         intent.putExtra("VisitorDetails",visitor);
        startActivity(intent);
         }
        });*/
    }

    private void registerViews() {
        //final Visitor visitor = new Visitor();
        efname = (EditText) findViewById(R.id.fname);
        // TextWatcher would let us check validation error on the fly
        efname.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                Validation.hasText(efname);
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        visitor.setFirstname(efname.getText().toString());
        elname = (EditText) findViewById(R.id.lname);
        // TextWatcher would let us check validation error on the fly
        elname.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                Validation.hasText(elname);
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        visitor.setLastname(elname.getText().toString());
        eEmailid = (EditText) findViewById(R.id.emailid);
        eEmailid.addTextChangedListener(new TextWatcher() {
            // after every change has been made to this editText, we would like to check validity
            public void afterTextChanged(Editable s) {
                Validation.isEmailAddress(eEmailid, true);
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        visitor.setEmailId(eEmailid.getText().toString());
        emobilenumber = (EditText) findViewById(R.id.mobilenumber);
        emobilenumber.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                Validation.isPhoneNumber(emobilenumber, false);
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        visitor.setMobilenumber(emobilenumber.getText().toString());
        epurpose = (EditText) findViewById(R.id.purpose);
        // TextWatcher would let us check validation error on the fly
        epurpose.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                Validation.hasText(epurpose);
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        visitor.setPurpose(epurpose.getText().toString());
        epersonToMeet = (EditText) findViewById(R.id.persontomeet);
        // TextWatcher would let us check validation error on the fly
        epersonToMeet.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                Validation.hasText(epersonToMeet);
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        visitor.setWhomToMeet(epersonToMeet.getText().toString());

        btnNext = (Button) findViewById(R.id.savedetails);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VisitorActivity.this, CameraActivity.class);
                visitor.setFirstname(efname.getText().toString());
                visitor.setLastname(elname.getText().toString());
                visitor.setMobilenumber(emobilenumber.getText().toString());
                visitor.setEmailId(eEmailid.getText().toString());
                visitor.setPurpose(epurpose.getText().toString());
                visitor.setWhomToMeet(epersonToMeet.getText().toString());

                //Validation class will check the error and display the error on respective fields
               // but it won't resist the form submission, so we need to check again before submit

                if (checkValidation()) {
                    submitForm();

                    intent.putExtra("VisitorDetails", visitor);
                   startActivity(intent);
                    finish();
                } else
                    Toast.makeText(VisitorActivity.this, "Form contains error", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void submitForm() {

        // Submit your form here. your form is valid
        Toast.makeText(this, "Submitting form...", Toast.LENGTH_LONG).show();
    }

    private boolean checkValidation() {
        boolean ret = true;

        if (!Validation.hasText(elname)) ret = false;
        if (!Validation.hasText(efname)) ret = false;
        if (!Validation.hasText(epurpose)) ret = false;
        if (!Validation.hasText(epersonToMeet)) ret = false;
        if (!Validation.isEmailAddress(eEmailid, true)) ret = false;
        if (!Validation.isPhoneNumber(emobilenumber, false)) ret = false;

        return ret;
    }

}
