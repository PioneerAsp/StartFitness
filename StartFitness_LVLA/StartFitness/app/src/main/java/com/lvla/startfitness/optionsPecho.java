package com.lvla.startfitness;

public class optionsPecho {
    private String name;
    private String description;
    //private int imageResourceId;

    //Array de la descripción de los ejercicios para pecho
    /**Este es el arreglo de las opciones para el ejercicio de pecho*/
    public static final optionsPecho[] optionsP = {
            new optionsPecho("ejercicio 1","3 series de 20 repeticioes"),
            new optionsPecho("ejercicio 2","3 series de 20 repeticioes"),
            new optionsPecho("ejercicio 3","3 series de 20 repeticioes")
    };
    //Cada ejercicio tiene un nombre, una descipción y una imagen/GIF
    /**Este es el constructor de la clase*/
    private optionsPecho(String name, String description){
        this.name = name;
        this.description = description;
    //  this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    /*public String getImageResourceId() {
        return description;
    }*/
    public String toString() {
        return this.name;
    }

}
