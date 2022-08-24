package com.lvla.startfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HombroActivity extends AppCompatActivity {

    public static final String EXTRA_HOMBROID = "hombroId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hombro);

        //Get the exercise from the intent
        int hombroId = (Integer)getIntent().getExtras().get(EXTRA_HOMBROID);
        /**optionsPecho optionspecho = optionsPecho.optionsP[pechoId];
         * Creando un Cursor para navergar*/
        SQLiteOpenHelper sfDataBaseHelper = new SFDataBaseHelper(this);
        try{
            SQLiteDatabase db = sfDataBaseHelper.getReadableDatabase();
            Cursor cursor = db.query("HOMBRO",
                    new String[]{"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID", "FAVORITE"},
                    "_id= ?",
                    new String[] {Integer.toString(hombroId)},
                    null, null, null);
            if(cursor.moveToFirst()){
                /**Obten los detalles de la rutina de pecho*/
                String nameText = cursor.getString(0);
                String descrptionText = cursor.getString(1);
                int photoId = cursor.getInt(2);
                boolean isFavorite = (cursor.getInt(3)==1);

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

                /*Ejercicio Favorito ¿?*/
                CheckBox favorite  = (CheckBox) findViewById(R.id.favoriteHombro);
                favorite.setChecked(isFavorite);
            }
            cursor.close();
            db.close();
        } catch (SQLiteException e){
            Toast toast = Toast.makeText(this,"Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /**Actualizamos el checkbox cada que esté agregado como favorioto*/
    public void onFavoriteClicked(View view){
        int hombroId = (Integer) getIntent().getExtras().get(EXTRA_HOMBROID);

        /*Obteniendo el valor del checkbox*/
        CheckBox favorite = (CheckBox)findViewById(R.id.favoriteHombro);
        ContentValues hombroValues = new ContentValues();
        hombroValues.put("FAVORITE", favorite.isChecked());

        /*Obteniendo la referencia de la base de datos para actualizar la columna de favoritos*/
        SQLiteOpenHelper sfDataBaseHelper = new SFDataBaseHelper(this);
        try{
            SQLiteDatabase db = sfDataBaseHelper.getWritableDatabase();
            db.update("HOMBRO",
                    hombroValues,
                    "_id = ?",
                    new String[]{Integer.toString(hombroId)});
            db.close();
        } catch(SQLiteException e){
            Toast toast = Toast.makeText(this,"Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    /**Cuando querramos mandar un menssage por whatsapp*/
    public void onSendMessage(View view){
        TextView nameR = (TextView)findViewById(R.id.name);
        TextView descR = (TextView)findViewById(R.id.description);
        String messageText = nameR.getText().toString();
        messageText=messageText.concat("\n" + descR.getText().toString());
        sendMessage(messageText);
    }

    private void sendMessage(String message){
        // Creating new intent
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.setPackage("com.whatsapp");
        // Give your message here
        intent.putExtra(Intent.EXTRA_TEXT, message);
        // Checking whether Whatsapp
        // is installed or not
        if (intent.resolveActivity(getPackageManager()) == null) {
            Toast.makeText(
                    this,
                    "Please install whatsapp first.",
                    Toast.LENGTH_SHORT)
                    .show();
            return;
        }
        // Starting Whatsapp
        startActivity(intent);
    }
}