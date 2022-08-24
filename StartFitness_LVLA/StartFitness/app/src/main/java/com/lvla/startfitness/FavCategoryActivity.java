package com.lvla.startfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class FavCategoryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_category);

        AdapterView.OnItemClickListener itemClickListenerFav =
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> listView, View v, int position, long id) {
                        if (position == 0) {//Pecho
                            Intent intent = new Intent(FavCategoryActivity.this, FavActivity.class);
                            startActivity(intent);
                        }
                        if (position == 1) {//Espalda
                            Intent intent = new Intent(FavCategoryActivity.this, FavEActivity.class);
                            startActivity(intent);
                        }
                        if (position == 2) {//Brazo
                            Intent intent = new Intent(FavCategoryActivity.this, FavBActivity.class);
                            startActivity(intent);
                        }
                        if (position == 3) {//Hombro
                            Intent intent = new Intent(FavCategoryActivity.this, FavHActivity.class);
                            startActivity(intent);
                        }
                        if (position == 4) {//Pierna
                            Intent intent = new Intent(FavCategoryActivity.this, FavPiActivity.class);
                            startActivity(intent);
                        }
                    }
                };
        ListView listV = (ListView) findViewById(R.id.list_options_exercises_fav);
        listV.setOnItemClickListener(itemClickListenerFav);
    }
}
