package com.julioalfaro.ejemplotransferenciadatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtSaludo;
    private Button btnLogout;
    private String usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSaludo = findViewById(R.id.txtSaludo);
        btnLogout = findViewById(R.id.btnLogoaut);
        btnLogout.setOnClickListener(this);
        usuario = App.getInstance().getPreference().getString("user", "");//((App)getApplication()).getPreference().getString("user", "");
        if (usuario.equals("")) {
            finish();
        }
        txtSaludo.setText("Hola " + usuario);
    }

    @Override
    public void onClick(View v) {
        SharedPreferences.Editor edit;
        if (v.getId() == R.id.btnLogoaut) {
            edit = ((App)getApplication()).getPreference().edit();
            edit.putString("user", "");
            edit.commit();
            finish();
        }
    }
}
