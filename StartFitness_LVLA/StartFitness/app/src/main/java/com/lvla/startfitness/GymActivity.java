package com.lvla.startfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GymActivity extends AppCompatActivity {
    public static final String EXTRA_GYMID = "gymId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym);

        //Get the exercise from the intent
        int gymId = (Integer)getIntent().getExtras().get(EXTRA_GYMID);
        /**optionsPecho optionspecho = optionsPecho.optionsP[pechoId];
         * Creando un Cursor para navergar*/
        SQLiteOpenHelper sfDataBaseHelper = new SFDataBaseHelper(this);
        try{
            SQLiteDatabase db = sfDataBaseHelper.getReadableDatabase();
            /*agregarle favoritos comentarizado*/
            Cursor cursor = db.query("GYM",
                    new String[]{"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID"},
                    "_id= ?",
                    new String[] {Integer.toString(gymId)},
                    null, null, null);
            if(cursor.moveToFirst()){
                /**Obten los detalles de la rutina de pecho*/
                String nameText = cursor.getString(0);
                String descrptionText = cursor.getString(1);
                int photoId = cursor.getInt(2);
                //boolean isFavorite = (cursor.getInt(3)==1);

                /*Nombre del ejercicio*/
                TextView name = (TextView) findViewById(R.id.name);
                name.setText(nameText);

                /*Descripción del ejercicio*/
                TextView descriptionText  = (TextView) findViewById(R.id.description);
                descriptionText.setText(descrptionText);

                /*Foto del ejercicio*/
                ImageView photo = (ImageView) findViewById(R.id.photo);
                photo.setImageResource(photoId);
                photo.setContentDescription(nameText);

                /*Ejercicio Favorito ¿?
                CheckBox favorite  = (CheckBox) findViewById(R.id.favoriteGym);
                favorite.setChecked(isFavorite);*/
            }
            cursor.close();
            db.close();
        } catch (SQLiteException e){
            Toast toast = Toast.makeText(this,"Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void onMap(View view){
        TextView gymName= (TextView)findViewById(R.id.name);
        TextView dir= (TextView)findViewById(R.id.description);
        String address = gymName.getText().toString();
        address = "geo:0,0?q=" + address.concat(" "+dir.getText().toString());
        /*Desplegar en google maps*/
        Uri gmmIntentUri = Uri.parse(address);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
    /**Actualizamos el checkbox cada que esté agregado como favorioto*/
    /*public void onFavoriteClicked(View view){
        int gymId = (Integer) getIntent().getExtras().get(EXTRA_GYMID);

        //Obteniendo el valor del checkbox
        CheckBox favorite = (CheckBox)findViewById(R.id.favoriteGym);
        ContentValues gymValues = new ContentValues();
        gymValues.put("FAVORITE", favorite.isChecked());

        //Obteniendo la referencia de la base de datos para actualizar la columna de favoritos
        SQLiteOpenHelper sfDataBaseHelper = new SFDataBaseHelper(this);
        try{
            SQLiteDatabase db = sfDataBaseHelper.getWritableDatabase();
            db.update("GYM",
                    gymValues,
                    "_id = ?",
                    new String[]{Integer.toString(gymId)});
            db.close();
        } catch(SQLiteException e){
            Toast toast = Toast.makeText(this,"Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }*/

}