package com.julioalfaro.ejemplotransferenciadatos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtUser, txtPass;
    private Button btnLogin;
    private SharedPreferences p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUser = findViewById(R.id.txtUser);
        txtPass = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        p = App.getInstance().getPreference();//((App) getApplication()).getPreference();
        if (!p.getString("user", "").equals("")) {
            startActivityForResult(new Intent(this, MainActivity.class), 99);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 99) {
            if (!p.getString("user", "").equals("")) {
                finish();
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        SharedPreferences.Editor edit;
        if (v.getId() == R.id.btnLogin) {
            if (txtUser.getText().toString().equals("jalfaro") && txtPass.getText().toString().equals("123")) {
                intent = new Intent(this, MainActivity.class);
                App.getInstance().setUsuario(txtUser.getText().toString());
                edit = p.edit();
                edit.putString("user", txtUser.getText().toString());
                edit.commit();
                startActivityForResult(intent, 99);
            } else {
                Toast.makeText(this, getResources().getString(R.string.bad_user_message), Toast.LENGTH_LONG).show();
            }
        }

    }
}
