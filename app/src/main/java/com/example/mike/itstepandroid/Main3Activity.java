package com.example.mike.itstepandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button3:
                final EditText editText = (EditText) findViewById(R.id.editText);
                Toast.makeText(this, editText.getText(), Toast.LENGTH_LONG).show();
                editText.setText("");
                break;
        }
    }
}
