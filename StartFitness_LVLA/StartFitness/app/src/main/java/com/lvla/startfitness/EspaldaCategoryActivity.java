package com.lvla.startfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class EspaldaCategoryActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espalda_category);
        /*ArrayAdapter<optionsEspalda> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                optionsEspalda.optionsP);*/
        /**Creamos una lista que se adapte al número de opciones en el xml sin necesidad de agregar la lista en XML, lo hace por medio de java code*/
        ListView listOptionEspalda = (ListView) findViewById(R.id.list_options_espalda);
        SQLiteOpenHelper sfDataBaseHelper = new SFDataBaseHelper(this);
        try{
            db = sfDataBaseHelper.getReadableDatabase();
            cursor=db.query("ESPALDA",
                    new String[]{"_id", "NAME"},
                    null,null,null,null,null);
            SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1,
                    cursor,
                    new String[]{"NAME"},
                    new int[]{android.R.id.text1},
                    0);
            listOptionEspalda.setAdapter(listAdapter);
        }catch (SQLiteException e){
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }


        /*Creamos el Listener para que cambie y despliege la información del ejercicio*/
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> listOptionEspalda, View v, int position, long id) {
                        /**Pasamos el ejercicio seleccionado por el usuario a la siguietne clase que despliega su información*/
                        Intent intent = new Intent(EspaldaCategoryActivity.this, EspaldaActivity.class);
                        intent.putExtra(EspaldaActivity.EXTRA_ESPALDAID, (int)id); /*Pasa el Número de ID de la posición seleccionado y lo manda en un mesnaje (Intent)*/
                        startActivity(intent);
                    }
                };
        listOptionEspalda.setOnItemClickListener(itemClickListener);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        cursor.close();
        db.close();
    }
}