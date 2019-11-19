package com.example.papbfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText _inputTextMessage;
    private Button _buttonSendMessage;
    public TextView _textCurrentFragment;

    public Fragment1 fragment1 = new Fragment1();
    public Fragment2 fragment2 = new Fragment2();

    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();

        // set listener
        _buttonSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // setup bundle, put some messages
                Bundle bundle = new Bundle();
                bundle.putString("KEY_MESSAGE", _inputTextMessage.getText().toString());
                setFragment(fragment1, bundle, "FRAGMENT1");
                _textCurrentFragment.setText("Current Fragment : One");
            }
        });
    }

    private void setupViews() {
        _inputTextMessage = findViewById(R.id.edit_text_message);
        _buttonSendMessage = findViewById(R.id.button_send_message);
        _textCurrentFragment = findViewById(R.id.text_fragment_status);
        _textCurrentFragment.setText("Current Fragment : null");
    }

    public void setFragment(Fragment fragment, Bundle bundle, String tag) {
        ft = getSupportFragmentManager().beginTransaction();
        fragment.setArguments(bundle);
        ft.replace(R.id.main_frame, fragment, tag);
        ft.addToBackStack(null);
        ft.commit();
    }
}
