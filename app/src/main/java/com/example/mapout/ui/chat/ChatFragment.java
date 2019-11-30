package com.example.mapout.ui.chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mapout.MainActivity;
import com.example.mapout.R;

public class ChatFragment extends Fragment {

    private ChatViewModel chatViewModel;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        chatViewModel =
                ViewModelProviders.of(this).get(ChatViewModel.class);
        View root = inflater.inflate(R.layout.fragment_chat, container, false);
        //final TextView textView = root.findViewById(R.id.text_chat);

        //Intent i = new Intent(root.getContext(), ChatActivity.class);
        //startActivity(i);

        Button btn = root.findViewById(R.id.chatbutton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CharSequence text = "    Message Sent.\n Contact You Soon";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(root.getContext(), text, duration);
                toast.show();

                Intent i = new Intent(getContext(), MainActivity.class);
                startActivity(i);
            }
        });


        chatViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
               // textView.setText(s);
            }});

        return root;
    }


}