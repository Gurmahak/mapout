package com.example.mapout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SaveActivity extends AppCompatActivity {

    static ArrayList<String> NAME = new ArrayList<>();
    static ArrayList<String> DESCRIPTION = new ArrayList<>();
    static ArrayList<Integer> IMAGE = new ArrayList<>();
    static Intent intent, i1, i2, i3;

    String[]NAMES;
    String[]DESCRIPTIONS;
    Integer[]IMAGES;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        Button checkout=findViewById(R.id.checkout);

        ListView listView= findViewById(R.id.save_listview);
        SaveActivity.CustomAdapter customAdapter = new SaveActivity.CustomAdapter();
        listView.setAdapter(customAdapter);

        intent = getIntent();
        String name1= intent.getStringExtra("name");
        String location1= intent.getStringExtra("address");
        int image = intent.getIntExtra("image", 0);

        NAME.add(name1);
        DESCRIPTION.add(location1);
        IMAGE.add(image);

        NAMES = NAME.toArray(new String[NAME.size()]);
        DESCRIPTIONS = DESCRIPTION.toArray(new String[DESCRIPTION.size()]);
        IMAGES = IMAGE.toArray(new Integer[IMAGE.size()]);




        Button btn = findViewById(R.id.newBook);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                i1 = new Intent(SaveActivity.this, MainActivity.class);
                startActivity(i1);
            }
        });

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i2 = new Intent(SaveActivity.this, FinalActivity.class);
                startActivity(i2);

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()

        {
            @Override
            public void onItemClick (AdapterView < ? > parent, View view,int position, long id){
                Object item = listView.getItemAtPosition(position);

                pos = position;

                i3 = new Intent(SaveActivity.this, Category1Activity.class);
                String Name2 = NAMES[pos];
                String Location2 = DESCRIPTIONS[pos];
                int sendImage = IMAGES[position];

                i3.putExtra("Name", Name2);
                i3.putExtra("Location", Location2);
                i3.putExtra("category", "Catering");
                i3.putExtra("Image", sendImage);
                startActivity(i3);
            }
        });

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.topmenu, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.profile:
                // Toast.makeText(this, "Profile",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(SaveActivity.this, loginGoogle.class);
                startActivity(i);
                return  true;

            case R.id.settings:
                //Toast.makeText(this, "Settings",Toast.LENGTH_SHORT).show();
                Intent i3 = new Intent(SaveActivity.this, MainActivity.class);
                startActivity(i3);
                return  true;

            case R.id.profile1:
                // Toast.makeText(this, "Profile1",Toast.LENGTH_SHORT).show();
                Intent i2 = new Intent(SaveActivity.this, SaveActivity.class);
                startActivity(i2);

                return  true;

            case R.id.contact:
                // Toast.makeText(this, "Contacts",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SaveActivity.this, ContactActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }



    }



    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 1 ;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {


            view = getLayoutInflater().inflate(R.layout.customlayout, null);
            ImageView imageview = view.findViewById(R.id.imageView_img);
            TextView textView_name = view.findViewById(R.id.textView_title);
            TextView textView_description = view.findViewById(R.id.textView_subtitle);

            imageview.setImageResource(IMAGES[position]);
            textView_name.setText(NAMES[position]);
            textView_description.setText(DESCRIPTIONS[position]);

            return view;
        }

    }
}

