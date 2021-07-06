package com.example.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etGpa = findViewById(R.id.etGpa);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String name = prefs.getString("name","");
        Float gpa = prefs.getFloat("gpa",0);
        etName.setText(name);
        etGpa.setText(String.valueOf(gpa));
    }

    @Override
    protected void onPause() {
        super.onPause();

        String name = etName.getText().toString();
        Float gpa = Float.parseFloat(etGpa.getText().toString());
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefsEdit = prefs.edit();
        prefsEdit.putString("name",name);
        prefsEdit.putFloat("gpa",gpa);
        prefsEdit.commit();
    }
}