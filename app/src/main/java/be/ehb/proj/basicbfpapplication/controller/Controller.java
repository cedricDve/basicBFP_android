package be.ehb.proj.basicbfpapplication.controller;

import android.content.Context;

import be.ehb.proj.basicbfpapplication.model.Profile;
import be.ehb.proj.basicbfpapplication.tools.Serialiser;

public class Controller { // all static for Serialiser that is static
    private static Profile profil; // nieuw object aanmaken > import nodig
    private static Controller instance = null;
    private static String nameProfil = "saveprofil";

    private Controller(){
        super();
    }
    public static final Controller getInstance(Context context){
        if( Controller.instance == null)
        { // nog niet gegenereerd => hier kan ik wel een new aanmaken
            Controller.instance = new Controller();
            getSerialise(context); // static method
        }
        //anders return bestaande
        return Controller.instance;
    }// zo heb je steeds 1 instance > Singleton
    public void Profile(float weight, float height, int age, int sex, Context context){
        profil = new Profile(weight, height, age, sex);
        Serialiser.serialise(nameProfil,profil, context);
    }
    public float getBFP(){ // bfp gaan inlezen
        return profil.getValueBFP();
    }
    public String getMessage(){ //messag gaan inlezen
        return profil.getMessage();
    }

    /**
     * Recuperation of Serializble object from the profil
     * @param context
     */
    private static void getSerialise(Context context){
        profil = (Profile) Serialiser.deSerialise(nameProfil,context);
    }
    public float getHeight(){
        if(profil == null)
        {
            return Float.parseFloat(null);
        } else {
            return profil.getHeight();
        }
    }
    public float getWeight(){
        if(profil == null)
        {
            return Float.parseFloat(null);
        } else {
            return profil.getWeight();
        }
    }
    public Integer getAge(){
        if(profil == null)
        {
            return null;
        } else {
            return profil.getAge();
        }
    }
    public float getSex(){
        if(profil == null)
        {
            return Float.parseFloat(null);
        } else {
            return profil.getSex();
        }
    }
}
