package com.example.mapout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Plan1Activity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan1);

        TextView name =findViewById(R.id.name);
        TextView location =findViewById(R.id.location);
        TextView people =findViewById(R.id.people);
        TextView budget=findViewById(R.id.budget);

//        int budget1=Integer.parseInt(people.getText().toString());
//
//        int people1=Integer.parseInt(budget.getText().toString());
//
//        Log.d("Budget", String.valueOf(budget1));


        Spinner tv = findViewById(R.id.spinner);
        ArrayList<String> category = new ArrayList<>();



        Intent intent = getIntent();
        String name1= intent.getStringExtra("Name");
       String location1= intent.getStringExtra("Location");
       int imageUrl = intent.getIntExtra("Image", 0);

        String categoryType = intent.getStringExtra("category");
        //Log.d("message", location1);


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
                // Toast.makeText(this, "Profile",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Plan1Activity.this, loginGoogle.class);
                startActivity(i);
                return  true;

            case R.id.settings:
                Toast.makeText(this, "Settings",Toast.LENGTH_SHORT).show();
                return  true;

            case R.id.profile1:
                // Toast.makeText(this, "Profile1",Toast.LENGTH_SHORT).show();
                Intent i2 = new Intent(Plan1Activity.this, SaveActivity.class);
                startActivity(i2);

                return  true;

            case R.id.contact:
                // Toast.makeText(this, "Contacts",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Plan1Activity.this, ContactActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }



    }

}
