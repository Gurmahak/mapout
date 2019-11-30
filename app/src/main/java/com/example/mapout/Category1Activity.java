package com.example.mapout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Category1Activity extends AppCompatActivity {

    ListView listView;
    String[] title;
    int pos;

    ArrayList<String> Name = new ArrayList<String>();


    int[] IMAGES = {R.drawable.bricksstudio, R.drawable.thepermanent, R.drawable.penthouse,R.drawable.bricksstudio, R.drawable.thepermanent, R.drawable.catering};
    String[] NAMES = {"Brix Studio","The Permanent","Penthouse Events","Spice 72","McDonalds","Pizza Hut"};
    String[] DESCRIPTIONS = {"211 Columbia St, Vancouver.","330 W Pender St, Burnaby.","333 Terminal Avenue, Richmond.","72 Scott Road, Surrey.","9625 128 Street, Surrey.","Newton Center, Surrey."};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category1);

        listView = findViewById(R.id.listView);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);


        OkHttpClient client = new OkHttpClient();

        String Url = "https://gbhatti.operatoroverload.com/.json";
        Request req = new Request.Builder().url(Url).build();
        listView = findViewById(R.id.listView);

        ArrayList<String> url = new ArrayList<String>();

        Thread t = new Thread() {

            @Override
            public void run() {

                try {
                    Response response = client.newCall(req).execute();
                    String text = response.body().string();
                    Log.d("response", text);

                    JSONObject object = (JSONObject) new JSONTokener(text).nextValue();

                    JSONArray listings = object.getJSONObject("data").getJSONArray("children");

                    ArrayList<String> titles = new ArrayList<>(listings.length());

                    for (int i = 0; i < listings.length(); i++) {
                        JSONObject item = listings.getJSONObject(i);
                        titles.add(item.getJSONObject("data").getString("title"));
                        url.add(item.getJSONObject("data").getString("permalink"));

                    }
                    runOnUiThread(() -> {
                       title = titles.toArray(new String[titles.size()]);
                      for (int i=0; i<title.length; i++) {
                          Name.add(title[i]);
                      }
                        Log.d("string Value:", (Name.get(0)));
                    });
                } catch (IOException | JSONException e) {
                    runOnUiThread(() -> {
                        Toast.makeText(Category1Activity.this, e.toString(), Toast.LENGTH_LONG).show();
                    });
                }
            }
        };
        t.start();



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object item = listView.getItemAtPosition(position);

                pos = position;

                Intent intent = new Intent(Category1Activity.this, Plan1Activity.class);
                String Name2 = NAMES[pos];
                String Location2 = DESCRIPTIONS[pos];
                int sendImage = IMAGES[position];

                intent.putExtra("Name", Name2);
                intent.putExtra("Location", Location2);
                intent.putExtra("category", "Venue");
                intent.putExtra("Image", sendImage);
                startActivity(intent);
            }
        });
    }


    class CustomAdapter extends BaseAdapter{

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


            view = getLayoutInflater().inflate(R.layout.customlayout,null);
            ImageView imageview =view.findViewById(R.id.imageView_img);
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
                Intent i = new Intent(Category1Activity.this, loginGoogle.class);
                startActivity(i);
                return  true;

            case R.id.settings:
                //Toast.makeText(this, "Settings",Toast.LENGTH_SHORT).show();
                Intent i3 = new Intent(Category1Activity.this, MainActivity.class);
                startActivity(i3);

                return  true;

            case R.id.profile1:
                // Toast.makeText(this, "Profile1",Toast.LENGTH_SHORT).show();
                Intent i2 = new Intent(Category1Activity.this, SaveActivity.class);
                startActivity(i2);

                return  true;

            case R.id.contact:
                // Toast.makeText(this, "Contacts",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Category1Activity.this, ContactActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }



    }

}