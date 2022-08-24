package com.lvla.startfitness;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;

public class ExercisesCategoryActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_category);

        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> listView, View v, int position, long id) {
                        if(position == 0){
                            Intent intent = new Intent(ExercisesCategoryActivity.this, PechoCategoryActivity.class);
                            startActivity(intent);
                        }
                        if(position == 1){
                            Intent intent = new Intent(ExercisesCategoryActivity.this, EspaldaCategoryActivity.class);
                            startActivity(intent);
                        }
                        if(position == 2){
                            Intent intent = new Intent(ExercisesCategoryActivity.this, BrazoCategoryActivity.class);
                            startActivity(intent);
                        }
                        if(position == 3){
                            Intent intent = new Intent(ExercisesCategoryActivity.this, HombroCategoryActivity.class);
                            startActivity(intent);
                        }
                        if(position == 4) {
                            Intent intent = new Intent(ExercisesCategoryActivity.this, PiernaCategoryActivity.class);
                            startActivity(intent);
                        }
                    }
                };
        //Agregamos un Listener al listView La lista de ejercicios cambiará con respecto a lo establecido en los Values_strings
        ListView listView = (ListView) findViewById(R.id.list_options_exercises);
        listView.setOnItemClickListener(itemClickListener);
    }
}