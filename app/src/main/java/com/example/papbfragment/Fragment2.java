package com.example.papbfragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Fragment2 extends Fragment {

    private TextView _textMessage;

    private EditText inputText;
    private Button sendBtn;

    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        _textMessage = view.findViewById(R.id.text_message_fragment2);
        inputText = view.findViewById(R.id.edit_text_message_fragment2);
        sendBtn = view.findViewById(R.id.button_send_message_fragment2);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getArguments();

        assert bundle != null;
        _textMessage.setText(bundle.getString("KEY_MESSAGE"));

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toActivity = new Intent(getActivity(), MainActivity.class);
                toActivity.putExtra("KEY_MESSAGE", inputText.getText().toString());
                startActivity(toActivity);
            }
        });
    }
}
