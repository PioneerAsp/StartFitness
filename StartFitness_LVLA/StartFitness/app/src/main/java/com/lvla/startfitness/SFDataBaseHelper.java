package com.lvla.startfitness;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SFDataBaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "startfitness";
    private static final int DB_VERSION = 1;

    public SFDataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        /*Gimnacios*/
        db.execSQL("CREATE TABLE GYM (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "DESCRIPTION TEXT, "
                + "IMAGE_RESOURCE_ID INTEGER,"
                + "POS TEXT);");
        /**Aqui se intertan todos los ejercicios de que queramos*/
        insertGym(db,"24/7 FITNESS", "Paseo del Río, Río Tijuana 3a. Etapa, Rio Tijuana 3ra Etapa, Tijuana, B.C.",R.drawable.fitness_24,"geo:32.48980104499792, -116.93086685329182?q=gyms");
        insertGym(db,"BODY FITNESS", "Plaza Monarca, Ruta Independencia 5561-local 4, Lago Sur, 22210 Tijuana, B.C.",R.drawable.body_fitness,"geo:32.49962665683112, -116.91968502880293?q=gyms");
        insertGym(db,"ULTRA GYM & FITNESS PAPALOTE", "Lago Sur, 22217 Tijuana, B.C.",R.drawable.fitness_papalote,"geo:32.4977181557125, -116.93238230181979?q=gyms");
        insertGym(db,"RAY WILSON's FAMILY FITNESS", "Blvd. Rampa Aeropuerto #16000 e/ Lázaro Cárdenas y Calle Conocida Col, Universidadotay, 22390 Tijuana, B.C.",R.drawable.family_fitnes,"geo:32.53146229914241, -116.94975463250793?q=gyms");
        // En caso de agregarle un favorito db.execSQL("ALTER TABLE GYM ADD COLUMN FAVORITE NUMERIC;");

        /*Pecho*/
        db.execSQL("CREATE TABLE PECHO (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "DESCRIPTION TEXT, "
                + "IMAGE_RESOURCE_ID INTEGER);");
        /**Aqui se intertan todos los ejercicios de que queramos HUGE CHEST WORKOUT*/
        insertPecho(db,"BENCH PRESS", "4 SETS X 10 REPS, REST 1 MINUTE BETWEEN SETS",R.drawable.bench_press);
        insertPecho(db,"INCLINE BENCH PRESS", "4 SETS X 10 REPS, REST 1 MINUTE BETWEEN SETS",R.drawable.incline_bench_press);
        insertPecho(db,"DUMBBELL BENCH PRESS", "4 SETS X 10 REPS, REST 1 MINUTE BETWEEN SETS",R.drawable.dumbbell_bench_press);
        insertPecho(db,"PEC DECK FLY", "4 SETS X 10 REPS",R.drawable.pec_deck);
        insertPecho(db,"DUMBBELL INCLINE FLY", "4 SETS X 10 REPS, REST 1 MINUTE BETWEEN SETS",R.drawable.dumbbell_incline_fly);
        insertPecho(db,"DIPS FOR CHEST", "4 SETS X 10 REPS, REST 1 MINUTE BETWEEN SETS",R.drawable.dips_for_chest);
        db.execSQL("ALTER TABLE PECHO ADD COLUMN FAVORITE NUMERIC;");

        /*Espalda*/
        db.execSQL("CREATE TABLE ESPALDA (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "DESCRIPTION TEXT, "
                + "IMAGE_RESOURCE_ID INTEGER);");
        /**Aqui se intertan todos los ejercicios de que queramos*/
        insertEspalda(db,"PULL UPS", "4 SETS X 15 REPS, REST 2 MINUTE BETWEEN SETS",R.drawable.pull_ups);
        insertEspalda(db,"LAT PULLDOWN", "4 SETS X 15 REPS, REST 2 MINUTE BETWEEN SETS",R.drawable.lat_pulldown);
        insertEspalda(db,"UNDERHAND REVERSE GRIP LAT PULLDOWNS", "4 SETS X 15 REPS, REST 2 MINUTE BETWEEN SETS",R.drawable.underhand_revers_grip);
        insertEspalda(db,"STRAIGHT ARM PULLDOWN", "4 SETS X 15 REPS, REST 2 MINUTE BETWEEN SETS",R.drawable.straight_arm_pulldown);
        insertEspalda(db,"BENT OVER ROWS", "4 SETS X 15 REPS, REST 2 MINUTE BETWEEN SETS",R.drawable.bent_over_rows);
        insertEspalda(db,"MACHINE OR CABLE ROWS", "4 SETS X 15 REPS, REST 2 MINUTE BETWEEN SETS",R.drawable.machine_or_cable_row);
        db.execSQL("ALTER TABLE ESPALDA ADD COLUMN FAVORITE NUMERIC;");

        /*Brazo*/
        db.execSQL("CREATE TABLE BRAZO (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "DESCRIPTION TEXT, "
                + "IMAGE_RESOURCE_ID INTEGER);");
        /**Aqui se intertan todos los ejercicios de que queramos*/
        insertBrazo(db,"BARBELL BICEP CURL", "4 SETS X 15 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.barbell_bicep_curl);
        insertBrazo(db,"DUMBBELL PREACHER CURL", "4 SETS X 15 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.dumbell_preacher_curl);
        insertBrazo(db,"CABLE BICEP CURL", "4 SETS X 15 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.cable_bicep_curl);
        insertBrazo(db,"CABLE TRICEPS PUSHDOWN", "4 SETS X 15 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.cable_triceps_pushdown);
        insertBrazo(db,"DIPS", "4 SETS X 15 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.dips);
        insertBrazo(db,"DUMBBELL OVERHEAD TRICEPS EXTENSION", "4 SETS X 15 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.dumbbell_overhead_triceps_extension);
        insertBrazo(db,"SKULL CRUSHER", "4 SETS X 15 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.skull_crusher);
        db.execSQL("ALTER TABLE BRAZO ADD COLUMN FAVORITE NUMERIC;");

        /*Pierna*/
        db.execSQL("CREATE TABLE PIERNA (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "DESCRIPTION TEXT, "
                + "IMAGE_RESOURCE_ID INTEGER);");
        /**Aqui se intertan todos los ejercicios de que queramos*/
        insertPierna(db,"BARBELL BACK SQUAT", "4 SETS X 15 REPS, REST 1.5-2 MINUTES BETWEEN SETS",R.drawable.barbell_back_squat);
        insertPierna(db,"LEG EXTENSION", "4 SETS X 15 REPS, REST 1.5-2 MINUTES BETWEEN SETS",R.drawable.leg_extension);
        insertPierna(db,"ROMANIAN DEADLIFT", "4 SETS X 15 REPS, REST 1.5-2 MINUTES BETWEEN SETS",R.drawable.romanian_dead);
        insertPierna(db,"DUMBBELL LUNGUE", "4 SETS X 15 REPS, REST 1.5-2 MINUTES BETWEEN SETS",R.drawable.dumbbell_lunge);
        insertPierna(db,"STANDING CALF RAISES", "4 SETS X 15 REPS, REST 1.5-2 MINUTES BETWEEN SETS",R.drawable.standing_calf_raises);
        insertPierna(db,"BARBELL GLUTE BRIDGE", "4 SETS X 15 REPS, REST 1.5-2 MINUTES BETWEEN SETS",R.drawable.barbell_glute_bridge);
        insertPierna(db,"LEG PRESS MACHINE", "4 SETS X 15 REPS, REST 1.5-2 MINUTES BETWEEN SETS",R.drawable.leg_press_machine);
        insertPierna(db,"BOX JUMP", "4 SETS X 15 REPS, REST 1.5-2 MINUTES BETWEEN SETS",R.drawable.box_jump);
        db.execSQL("ALTER TABLE PIERNA ADD COLUMN FAVORITE NUMERIC;");

        /*Hombro*/
        db.execSQL("CREATE TABLE HOMBRO (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "DESCRIPTION TEXT, "
                + "IMAGE_RESOURCE_ID INTEGER);");
        /**Aqui se intertan todos los ejercicios de que queramos*/
        insertHombro(db,"OVERHEAD PRESS", "2 SETS X 15 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.overhead_press);
        insertHombro(db,"BARBELL OVERHEAD PRESS", "3 SETS X 15 REPS, REST 2 MINUTES BETWEEN SETS",R.drawable.barbbell_overhead_press);
        insertHombro(db,"REAR LATERAL RAISE", "2-3 SETS X 7 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.rear_lateral_raise);
        insertHombro(db,"MIDDLE DELT RAISE", "2-3 SETS X 7 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.middle_delt_raise);
        insertHombro(db,"FRONT DELT RAISE", "2-3 SETS X 7 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.front_delt_raise);
        insertHombro(db,"DUMBBELL CHEAT LATERALS", "3 SETS X  FAILURE, REST 2 MINUTES BETWEEN SETS",R.drawable.dumbbell_cheat_lateral);
        insertHombro(db,"DUMBBELL PUSH PRESS", "3 SETS X  FAILURE, REST 2 MINUTES BETWEEN SETS",R.drawable.dumbbell_push_press);
        insertHombro(db,"BANDED FACE PULL", "3 SETS X  15 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.band_face_pull);
        db.execSQL("ALTER TABLE HOMBRO ADD COLUMN FAVORITE NUMERIC;");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion){
        if(oldVersion < 1){
            /*Gimnacios*/
            db.execSQL("CREATE TABLE GYM (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");
            /**Aqui se intertan todos los ejercicios de que queramos*/
            insertGym(db,"24/7 FITNESS", "P.º del Río 6672, Río Tijuana 3a. Etapa, Rio Tijuana 3ra Etapa, 22226 Tijuana, B.C.",R.drawable.fitness_24,"geo:32.48980104499792, -116.93086685329182?q=gyms");
            insertGym(db,"BODY FITNESS", "Plaza Monarca, Ruta Independencia 5561-local 4, Lago Sur, 22210 Tijuana, B.C.",R.drawable.body_fitness,"geo:32.49962665683112, -116.91968502880293?q=gyms");
            insertGym(db,"ULTRA GYM & FITNESS PAPALOTE", "Lago Sur, 22217 Tijuana, B.C.",R.drawable.fitness_papalote,"geo:32.4977181557125, -116.93238230181979?q=gyms");
            insertGym(db,"RAY WILSON's FAMILY FITNESS", "Blvd. Rampa Aeropuerto #16000 Lázaro Cárdenas y Calle Conocida Col, Universidadotay, 22390 Tijuana, B.C.",R.drawable.family_fitnes,"geo:32.53146229914241, -116.94975463250793?q=gyms");
            // En caso de agregarle un favorito db.execSQL("ALTER TABLE GYM ADD COLUMN FAVORITE NUMERIC;");

            /*Pecho*/
            db.execSQL("CREATE TABLE PECHO (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");
            /**Aqui se intertan todos los ejercicios de que queramos*/
            insertPecho(db,"BENCH PRESS", "4 SETS X 10 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.bench_press);
            insertPecho(db,"INCLINE BENCH PRESS", "4 SETS X 10 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.startfitness_logo);
            insertPecho(db,"DUMBBELL BENCH PRESS", "4 SETS X 10 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.startfitness_logo);
            insertPecho(db,"PEC DECK FLY", "4 SETS X 10 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.startfitness_logo);
            insertPecho(db,"DUMBBELL INCLINE FLY", "4 SETS X 10 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.startfitness_logo);
            insertPecho(db,"DIPS FOR CHEST", "4 SETS X 10 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.startfitness_logo);
            db.execSQL("ALTER TABLE PECHO ADD COLUMN FAVORITE NUMERIC;");

            /*Espalda*/
            db.execSQL("CREATE TABLE ESPALDA (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");
            /**Aqui se intertan todos los ejercicios de que queramos*/
            insertEspalda(db,"PULL UPS", "4 SETS X 15 REPS, REST 2 MINUTE BETWEEN SETS",R.drawable.pull_ups);
            insertEspalda(db,"LAT PULLDOWN", "4 SETS X 15 REPS, REST 2 MINUTE BETWEEN SETS",R.drawable.lat_pulldown);
            insertEspalda(db,"UNDERHAND REVERSE GRIP LAT PULLDOWNS", "4 SETS X 15 REPS, REST 2 MINUTE BETWEEN SETS",R.drawable.underhand_revers_grip);
            insertEspalda(db,"STRAIGHT ARM PULLDOWN", "4 SETS X 15 REPS, REST 2 MINUTE BETWEEN SETS",R.drawable.straight_arm_pulldown);
            insertEspalda(db,"BENT OVER ROWS", "4 SETS X 15 REPS, REST 2 MINUTE BETWEEN SETS",R.drawable.bent_over_rows);
            insertEspalda(db,"MACHINE OR CABLE ROWS", "4 SETS X 15 REPS, REST 2 MINUTE BETWEEN SETS",R.drawable.machine_or_cable_row);
            db.execSQL("ALTER TABLE ESPALDA ADD COLUMN FAVORITE NUMERIC;");

            /*Brazo*/
            db.execSQL("CREATE TABLE BRAZO (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");
            /**Aqui se intertan todos los ejercicios de que queramos*/
            insertBrazo(db,"BARBELL BICEP CURL", "4 SETS X 15 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.barbell_bicep_curl);
            insertBrazo(db,"DUMBBELL PREACHER CURL", "4 SETS X 15 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.dumbell_preacher_curl);
            insertBrazo(db,"CABLE BICEP CURL", "4 SETS X 15 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.cable_bicep_curl);
            insertBrazo(db,"CABLE TRICEPS PUSHDOWN", "4 SETS X 15 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.cable_triceps_pushdown);
            insertBrazo(db,"DIPS", "4 SETS X 15 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.dips);
            insertBrazo(db,"DUMBBELL OVERHEAD TRICEPS EXTENSION", "4 SETS X 15 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.dumbbell_overhead_triceps_extension);
            insertBrazo(db,"SKULL CRUSHER", "4 SETS X 15 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.skull_crusher);
            db.execSQL("ALTER TABLE BRAZO ADD COLUMN FAVORITE NUMERIC;");

            /*Pierna*/
            db.execSQL("CREATE TABLE PIERNA (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");
            /**Aqui se intertan todos los ejercicios de que queramos*/
            insertPierna(db,"BARBELL BACK SQUAT", "4 SETS X 15 REPS, REST 1.5-2 MINUTES BETWEEN SETS",R.drawable.barbell_back_squat);
            insertPierna(db,"LEG EXTENSION", "4 SETS X 15 REPS, REST 1.5-2 MINUTES BETWEEN SETS",R.drawable.leg_extension);
            insertPierna(db,"ROMANIAN DEADLIFT", "4 SETS X 15 REPS, REST 1.5-2 MINUTES BETWEEN SETS",R.drawable.romanian_dead);
            insertPierna(db,"DUMBBELL LUNGUE", "4 SETS X 15 REPS, REST 1.5-2 MINUTES BETWEEN SETS",R.drawable.dumbbell_lunge);
            insertPierna(db,"STANDING CALF RAISES", "4 SETS X 15 REPS, REST 1.5-2 MINUTES BETWEEN SETS",R.drawable.standing_calf_raises);
            insertPierna(db,"BARBELL GLUTE BRIDGE", "4 SETS X 15 REPS, REST 1.5-2 MINUTES BETWEEN SETS",R.drawable.barbell_glute_bridge);
            insertPierna(db,"LEG PRESS MACHINE", "4 SETS X 15 REPS, REST 1.5-2 MINUTES BETWEEN SETS",R.drawable.leg_press_machine);
            insertPierna(db,"BOX JUMP", "4 SETS X 15 REPS, REST 1.5-2 MINUTES BETWEEN SETS",R.drawable.box_jump);
            db.execSQL("ALTER TABLE PIERNA ADD COLUMN FAVORITE NUMERIC;");

            /*Hombro*/
            db.execSQL("CREATE TABLE HOMBRO (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");
            /**Aqui se intertan todos los ejercicios de que queramos*/
            insertHombro(db,"OVERHEAD PRESS", "2 SETS X 15 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.overhead_press);
            insertHombro(db,"BARBELL OVERHEAD PRESS", "3 SETS X 15 REPS, REST 2 MINUTES BETWEEN SETS",R.drawable.barbbell_overhead_press);
            insertHombro(db,"REAR LATERAL RAISE", "2-3 SETS X 7 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.rear_lateral_raise);
            insertHombro(db,"MIDDLE DELT RAISE", "2-3 SETS X 7 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.middle_delt_raise);
            insertHombro(db,"FRONT DELT RAISE", "2-3 SETS X 7 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.front_delt_raise);
            insertHombro(db,"DUMBBELL CHEAT LATERALS", "3 SETS X  FAILURE, REST 2 MINUTES BETWEEN SETS",R.drawable.dumbbell_cheat_lateral);
            insertHombro(db,"DUMBBELL PUSH PRESS", "3 SETS X  FAILURE, REST 2 MINUTES BETWEEN SETS",R.drawable.dumbbell_push_press);
            insertHombro(db,"BANDED FACE PULL", "3 SETS X  15 REPS, REST 60 SECONDS BETWEEN SETS",R.drawable.band_face_pull);
            db.execSQL("ALTER TABLE HOMBRO ADD COLUMN FAVORITE NUMERIC;");
        }
        if(oldVersion < 2){
            //db.execSQL("ALTER TABLE PECHO ADD COLUMN FAVORITE NUMERIC;");
            System.out.println("Era esto x x");
        }
    }
    /**Metodo para agregar ejercicios y gimnacios*/
    private static void insertGym(SQLiteDatabase db, String name, String description, int resourceId, String pos){
        ContentValues gymValues = new ContentValues();
        gymValues.put("NAME", name);
        gymValues.put("DESCRIPTION", description);
        gymValues.put("IMAGE_RESOURCE_ID", resourceId);
        gymValues.put("POS", pos);
        db.insert("GYM", null, gymValues);
    }

    private static void insertPecho(SQLiteDatabase db, String name, String description, int resourceId){
        ContentValues pechoValues = new ContentValues();
        pechoValues.put("NAME", name);
        pechoValues.put("DESCRIPTION", description);
        pechoValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("PECHO", null, pechoValues);
    }
    private static void insertEspalda(SQLiteDatabase db, String name, String description, int resourceId){
        ContentValues espaldaValues = new ContentValues();
        espaldaValues.put("NAME", name);
        espaldaValues.put("DESCRIPTION", description);
        espaldaValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("ESPALDA", null, espaldaValues);
    }

    private static void insertBrazo(SQLiteDatabase db, String name, String description, int resourceId){
        ContentValues brazoValues = new ContentValues();
        brazoValues.put("NAME", name);
        brazoValues.put("DESCRIPTION", description);
        brazoValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("BRAZO", null, brazoValues);
    }

    private static void insertPierna(SQLiteDatabase db, String name, String description, int resourceId){
        ContentValues piernaValues = new ContentValues();
        piernaValues.put("NAME", name);
        piernaValues.put("DESCRIPTION", description);
        piernaValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("PIERNA", null, piernaValues);
    }
    private static void insertHombro(SQLiteDatabase db, String name, String description, int resourceId){
        ContentValues hombroValues = new ContentValues();
        hombroValues.put("NAME", name);
        hombroValues.put("DESCRIPTION", description);
        hombroValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("HOMBRO", null, hombroValues);
    }
}
