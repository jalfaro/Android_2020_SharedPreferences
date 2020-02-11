package com.julioalfaro.ejemplotransferenciadatos;

import android.app.Application;
import android.content.SharedPreferences;

public class App extends Application {
    private static String usuario;
    private static App instance;
    private SharedPreferences p;


    @Override
    public void onCreate() {
        super.onCreate();
        this.usuario = "Anonimo";
        this.instance = this;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public static App getInstance() {
        return instance;
    }

    public SharedPreferences getPreference() {
        if (p == null) {
            p = getSharedPreferences("xx", MODE_PRIVATE);
        }
        return p;
    }
}

