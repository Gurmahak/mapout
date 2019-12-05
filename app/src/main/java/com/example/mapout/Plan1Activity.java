package com.example.mapout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Plan1Activity extends AppCompatActivity {

    // database
    DatabaseHelper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan1);

        //database

        dbh = new DatabaseHelper(this);

        TextView name =findViewById(R.id.name);
        TextView location =findViewById(R.id.location);
        EditText people =findViewById(R.id.people);
        EditText budget=findViewById(R.id.budget);

        String bande = people.getText().toString();
        Spinner tv = findViewById(R.id.spinner);
        ArrayList<String> category = new ArrayList<>();



        Intent intent = getIntent();
        String name1= intent.getStringExtra("Name");
        String location1= intent.getStringExtra("Location");
        int imageUrl = intent.getIntExtra("Image", 0);
        String categoryType = intent.getStringExtra("category");

        if (name1 == null && location1 == null && categoryType == null) {
            name.setHint("Name");
            location.setHint("Location");
            category.add("Venues");
            category.add("Catering");
            category.add("Entertainment");

        }

        else {
            name.setText(name1);
            location.setText(location1);
            category.add(categoryType);
        }


        ArrayAdapter<String> spinAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, category);

        tv.setAdapter(spinAdapter);

        Button btn =findViewById(R.id.submitbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Plan1Activity.this, SaveActivity.class);
                i.putExtra("name", name1);
                i.putExtra("address", location1);
                i.putExtra("image", imageUrl);
                startActivity(i);

                // database part
                boolean isAdded = dbh.addRecord(name1,
                        location1,
                        imageUrl,
                        bande
                );
//                if (isAdded)
//                    Toast.makeText(Plan1Activity.this, "Data added", Toast.LENGTH_SHORT).show();
//                else
//                    Toast.makeText(Plan1Activity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.topmenu, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.profile:
                Intent i = new Intent(Plan1Activity.this, loginGoogle.class);
                startActivity(i);
                return  true;

            case R.id.settings:
                Intent i3 = new Intent(Plan1Activity.this, MainActivity.class);
                startActivity(i3);
                return  true;

            case R.id.profile1:
                Intent i2 = new Intent(Plan1Activity.this, SaveActivity.class);
                startActivity(i2);
                return  true;

            case R.id.contact:
                Intent intent = new Intent(Plan1Activity.this, ContactActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
