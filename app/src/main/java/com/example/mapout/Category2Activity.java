package com.example.mapout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Category2Activity extends AppCompatActivity {

    ListView listView;
    String[] title;
    int pos;

    ArrayList<String> Name = new ArrayList<String>();


    int[] IMAGES = {R.drawable.bricksstudio, R.drawable.thepermanent, R.drawable.penthouse, R.drawable.bricksstudio, R.drawable.thepermanent, R.drawable.catering};
    String[] NAMES = {"Emelle's Catering", "Crown Street Catering Services", "The Butler Did It Catering Co", "Drew's Catering & Events", "Savoury City Catering", "Culinary Capers Catering"};
    String[] DESCRIPTIONS = {"177 W 7th Ave, Vancouver.", "1805 Maritime Mews, Vancouver.", "620 Clark Dr, Vancouver.", "1312 SW Marine Dr, Vancouver.", "3925 Fraser St, Vancouver.", "1545 W 3rd Ave, Vancouver."};






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category2);

        listView= findViewById(R.id.listView1);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);




    listView.setOnItemClickListener(new AdapterView.OnItemClickListener()

    {
        @Override
        public void onItemClick (AdapterView < ? > parent, View view,int position, long id){
        Object item = listView.getItemAtPosition(position);

        pos = position;

        Intent intent = new Intent(Category2Activity.this, Plan1Activity.class);
        String Name2 = NAMES[pos];
        String Location2 = DESCRIPTIONS[pos];
        int sendImage = IMAGES[position];

        intent.putExtra("Name", Name2);
        intent.putExtra("Location", Location2);
        intent.putExtra("category", "Catering");
        intent.putExtra("Image", sendImage);
        startActivity(intent);
    }
    });
}






class CustomAdapter extends BaseAdapter {

    @Override
    public int getCount() {
        return IMAGES.length;
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
                Intent i = new Intent(Category2Activity.this, loginGoogle.class);
                startActivity(i);
                return  true;

            case R.id.settings:
                //Toast.makeText(this, "Settings",Toast.LENGTH_SHORT).show();
                Intent i3 = new Intent(Category2Activity.this, MainActivity.class);
                startActivity(i3);

                return  true;

            case R.id.profile1:
                // Toast.makeText(this, "Profile1",Toast.LENGTH_SHORT).show();
                Intent i2 = new Intent(Category2Activity.this, SaveActivity.class);
                startActivity(i2);

                return  true;

            case R.id.contact:
                // Toast.makeText(this, "Contacts",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Category2Activity.this, ContactActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }



    }



}





