package com.example.mapout.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.mapout.Plan1Activity;
import com.example.mapout.R;

public class NotificationsFragment extends Fragment {

    //private NotificationsViewModel notificationsViewModel;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        final Button Plan = root.findViewById(R.id.plan_btn);
        Plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Plan1Activity.class);
                startActivity(i);
            }});

//        notificationsViewModel =
//                ViewModelProviders.of(this).get(NotificationsViewModel.class);
//
//        final TextView textView = root.findViewById(R.id.text_chat);
//        notificationsViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}