package com.example.papbfragment;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;


public class Fragment1 extends Fragment {

    private EditText _inputTextMessage;
    private Button _buttonSendMessage;
    private TextView _textMessage;

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);

        _inputTextMessage = view.findViewById(R.id.edit_text_message_fragment1);
        _buttonSendMessage = view.findViewById(R.id.button_send_message_fragment1);
        _textMessage = view.findViewById(R.id.text_message_fragment1);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle message = getArguments();
        assert message != null;
        _textMessage.setText(message.getString("KEY_MESSAGE"));

        _buttonSendMessage.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("KEY_MESSAGE", _inputTextMessage.getText().toString());
                ((MainActivity) Objects.requireNonNull(getActivity())).setFragment(((MainActivity) getActivity()).fragment2, bundle, "FRAGMENT2");
                ((MainActivity) getActivity())._textCurrentFragment.setText("Current Fragment : Two");
            }
        });

    }
}
