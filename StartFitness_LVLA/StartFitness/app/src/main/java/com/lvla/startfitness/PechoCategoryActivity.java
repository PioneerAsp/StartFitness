package com.lvla.startfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.content.Intent;
import android.view.ScaleGestureDetector;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.List;
public class PechoCategoryActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pecho_category);
        /*ArrayAdapter<optionsPecho> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                optionsPecho.optionsP);*/
        /**Creamos una lista que se adapte al número de opciones en el xml sin necesidad de agregar la lista en XML, lo hace por medio de java code*/
        ListView listOptionPecho = (ListView) findViewById(R.id.list_options_pecho);
        SQLiteOpenHelper sfDataBaseHelper = new SFDataBaseHelper(this);
        try{
            db = sfDataBaseHelper.getReadableDatabase();
            cursor=db.query("PECHO",
                    new String[]{"_id", "NAME"},
                    null,null,null,null,null);
            SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1,
                    cursor,
                    new String[]{"NAME"},
                    new int[]{android.R.id.text1},
                    0);
            listOptionPecho.setAdapter(listAdapter);
        }catch (SQLiteException e){
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }


        /*Creamos el Listener para que cambie y despliege la información del ejercicio*/
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listOptionPecho, View v, int position, long id) {
                /**Pasamos el ejercicio seleccionado por el usuario a la siguietne clase que despliega su información*/
                Intent intent = new Intent(PechoCategoryActivity.this, PechoActivity.class);
                intent.putExtra(PechoActivity.EXTRA_PECHOID, (int)id); /**Pasa el Número de ID de la posición seleccionado y lo manda en un mesnaje (Intent)*/
                startActivity(intent);
            }
        };
        listOptionPecho.setOnItemClickListener(itemClickListener);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        cursor.close();
        db.close();
    }
}