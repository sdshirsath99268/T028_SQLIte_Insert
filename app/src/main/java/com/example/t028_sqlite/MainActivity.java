package com.example.t028_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button add , view , search , delete ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = (Button) findViewById(R.id.addContact);
        view = (Button) findViewById(R.id.viewContact);
        search = (Button) findViewById(R.id.searchContact);
        delete = (Button) findViewById(R.id.updateContact);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewContactActivity.class);
                startActivity(intent);
            }
        });
    }
}