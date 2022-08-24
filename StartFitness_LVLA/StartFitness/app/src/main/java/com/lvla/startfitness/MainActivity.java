package com.lvla.startfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity {
    //private SQLiteDatabase db;
    /**Cursor para cada sección**/
/*    private Cursor favoriteCursor;
    private Cursor favoriteCursorEspalda;
    private Cursor favoriteCursorBrazo;
    private Cursor favoriteCursorPierna;
    private Cursor favoriteCursorHombro;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  setupFavoriteListView();
    }
    public void onExercises(View view){
        Intent intent = new Intent(MainActivity.this, ExercisesCategoryActivity.class);
        startActivity(intent);
    }
    public void onGyms(View view){
        Intent intent = new Intent(MainActivity.this, GymCategoryActivity.class);
        startActivity(intent);
    }
    public void onFavorite(View view){
        Intent intent = new Intent(MainActivity.this, FavCategoryActivity.class);
        startActivity(intent);
    }
}