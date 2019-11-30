package com.example.mapout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Category3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category3);

        TextView tv1 = findViewById(R.id.item1_text);
        TextView tv2 = findViewById(R.id.item2_text);
        TextView tv3 = findViewById(R.id.item3_text);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Category3Activity.this, Plan1Activity.class);
                startActivity(i);

            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Category3Activity.this, Plan1Activity.class);
                startActivity(i);

            }
        });

        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Category3Activity.this, Plan1Activity.class);
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

        switch (item.getItemId()) {
            case R.id.profile:
                // Toast.makeText(this, "Profile",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Category3Activity.this, loginGoogle.class);
                startActivity(i);
                return true;

            case R.id.settings:
                //Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                Intent i3 = new Intent(Category3Activity.this, MainActivity.class);
                startActivity(i3);
                return true;

            case R.id.profile1:
                // Toast.makeText(this, "Profile1",Toast.LENGTH_SHORT).show();
                Intent i2 = new Intent(Category3Activity.this, SaveActivity.class);
                startActivity(i2);

                return true;

            case R.id.contact:
                // Toast.makeText(this, "Contacts",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Category3Activity.this, ContactActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }

    }
