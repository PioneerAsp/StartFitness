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
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class FavEActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    /**Cursor para cada sección**/
    private Cursor favoriteCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_eactivity);
        setupFavoriteListView();
    }
    private void setupFavoriteListView(){
        ListView listFavorites = (ListView) findViewById(R.id.list_favorites_espalda);
        try{
            SQLiteOpenHelper sfDataBaseHelper = new SFDataBaseHelper(this);
            db = sfDataBaseHelper.getReadableDatabase();
            favoriteCursor = db.query("ESPALDA",
                    new String[]{"_id", "NAME"},
                    "FAVORITE = 1",
                    null,null,null,null);
            CursorAdapter favoriteAdapter =
                    new SimpleCursorAdapter(FavEActivity.this,
                            android.R.layout.simple_list_item_1,
                            favoriteCursor,
                            new String[]{"NAME"},
                            new int[]{android.R.id.text1},0);
            listFavorites.setAdapter(favoriteAdapter);
        }catch(SQLiteException e){
            Toast toast = Toast.makeText(this,"Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
        listFavorites.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View v, int position, long id) {
                Intent intent = new Intent(FavEActivity.this, EspaldaActivity.class);
                intent.putExtra(EspaldaActivity.EXTRA_ESPALDAID, (int)id);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onRestart(){
        super.onRestart();
        Cursor newCursor = db.query("ESPALDA",
                new String[]{"_id", "NAME"},
                "FAVORITE = 1",
                null,null,null,null);
        ListView listFavorites = (ListView) findViewById(R.id.list_favorites_espalda);
        CursorAdapter adapter = (CursorAdapter) listFavorites.getAdapter();
        adapter.changeCursor(newCursor);
        favoriteCursor=newCursor;
    }
    /*Close the cursor and te database in the destroy method*/
    @Override
    public void onDestroy(){
        super.onDestroy();
        favoriteCursor.close();
        db.close();
    }
}