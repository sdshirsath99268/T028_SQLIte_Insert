package com.example.t028_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewContactActivity extends AppCompatActivity {

    EditText name , contact , email;
    Button save;
    Context context = this ;
    UserDbHelper userDbHelper ;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        name = (EditText) findViewById(R.id.editTextName);
        contact = (EditText) findViewById(R.id.editTextContact);
        email = (EditText) findViewById(R.id.editTextEmail);
        save = (Button) findViewById(R.id.buttonSave);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NAME = name.getText().toString();
                String CONTACT = contact.getText().toString();
                String EMAIL = email.getText().toString();

                userDbHelper = new UserDbHelper(context);
                sqLiteDatabase = userDbHelper.getWritableDatabase();

                userDbHelper.addInformation(NAME , CONTACT , EMAIL , sqLiteDatabase);
                userDbHelper.close();
                Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();

            }
        });
    }
}