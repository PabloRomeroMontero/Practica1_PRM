package com.iessaladillo.pablo.practica1_prm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextName;
    private EditText editTextSurname;
    private TextView txtMessage;
    private CheckBox cbxPolite;
    private Button bttnGreet;
    private Button bttnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        editTextName = findViewById(R.id.editTxtName);
        editTextSurname = findViewById(R.id.editTxtSurname);
        txtMessage = findViewById(R.id.txtMessage);
        cbxPolite = findViewById(R.id.cbxPolite);
        bttnGreet = findViewById(R.id.bttnGreet);
        bttnReset = findViewById(R.id.bttnReset);
        bttnGreet.setOnClickListener(this);
        bttnReset.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.bttnGreet) {
            greet();
        }
        if (id == R.id.bttnReset) {
            reset();
        }
    }

    private void greet() {
        if (cbxPolite.isChecked()) {
            txtMessage.setText(getString(R.string.main_polite_greet, editTextName.getText().toString(), editTextSurname.getText().toString()));

        } else {
            txtMessage.setText(getString(R.string.main_no_polite_greet, editTextName.getText().toString(), editTextSurname.getText().toString()));
        }
    }

    private void reset() {
        editTextName.setText(R.string.main_empty);
        editTextSurname.setText(R.string.main_empty);
        txtMessage.setText(R.string.main_empty);
        cbxPolite.setChecked(false);
    }
}
