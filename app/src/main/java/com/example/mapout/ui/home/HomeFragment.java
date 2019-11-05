package com.example.mapout.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.mapout.Category1Activity;
import com.example.mapout.R;
import com.example.mapout.VenueActivity;

public class HomeFragment extends Fragment {



    private HomeViewModel homeViewModel;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView category1 = root.findViewById(R.id.category1_text);
        category1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Category1Activity.class);
                startActivity(i);
            }
        });
        final TextView category2 = root.findViewById(R.id.category2_text);
        category2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), VenueActivity.class);
                startActivity(i);
            }
        });

        final TextView category3 = root.findViewById(R.id.category3_text);
        category3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), VenueActivity.class);
                startActivity(i);
            }
        });




        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);

//        //final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }

}