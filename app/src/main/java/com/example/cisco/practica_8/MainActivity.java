package com.example.cisco.practica_8;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etNombres;
    EditText etApellidos;
    EditText etEdad;

    SharedPreferences preferencias;
    private final String ID_PREFERENCIA="PrefPractica";
    private final String ID_NOMBRES="Nombres";
    private final String ID_APELLIDOS="Apellidos";
    private final String ID_EDAD="Edad";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombres=(EditText) findViewById(R.id.etNombres);
        etApellidos=(EditText) findViewById(R.id.etApellidos);
        etEdad=(EditText) findViewById(R.id.etEdad);
        preferencias=getSharedPreferences(ID_PREFERENCIA, Context.MODE_PRIVATE);
    }
    public void guardar(View v){
        String nombres = etNombres.getText().toString();
        String apellidos = etApellidos.getText().toString();
        //String edad= (etEdad.getText().toString());
        int edad = Integer.parseInt(etEdad.getText().toString());
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString(ID_NOMBRES,nombres);
        editor.putString(ID_APELLIDOS,apellidos);
        //editor.putString(ID_EDAD,edad);
        editor.putInt(ID_EDAD,edad);
        editor.commit();
    }

    public void consultar(View v){
        if(preferencias.contains(ID_NOMBRES)){
            etNombres.setText(preferencias.getString(ID_NOMBRES,""));
        }
        if(preferencias.contains(ID_APELLIDOS)){
            etApellidos.setText(preferencias.getString(ID_APELLIDOS,""));
        }
        if(preferencias.contains(ID_EDAD)){
            //etEdad.setText(preferencias.getString(ID_EDAD,""));
            etEdad.setText(String.valueOf(preferencias.getInt(ID_EDAD,0)));
        }
    }
    public void limpiar(View v){
        SharedPreferences.Editor editor = preferencias.edit();
        etApellidos.setText(null);
        etNombres.setText(null);
        etEdad.setText("0");
        editor.clear();
        //editor.remove(ID_NOMBRES);
        //editor.remove(ID_APELLIDOS);
        editor.commit();
    }
}
