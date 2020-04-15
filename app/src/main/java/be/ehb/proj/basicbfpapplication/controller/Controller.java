package be.ehb.proj.basicbfpapplication.controller;

import be.ehb.proj.basicbfpapplication.model.Profile;

public class Controller {
    private Profile profil; // nieuw object aanmaken > import nodig
   private static Controller instance = null;
    private Controller(){
        super();
    }
    public static final Controller getInstance(){
        if( Controller.instance == null)
        { // nog niet gegenereerd => hier kan ik wel een new aanmaken
            Controller.instance = new Controller();
        }
        //anders return bestaande
        return Controller.instance;
    }// zo heb je steeds 1 instance > Singleton
    public void Profile(float weight, float height, int age, int sex){
        profil = new Profile(weight, height, age, sex);
    }
    public float getBFP(){ // bfp gaan inlezen
        return profil.getValueBFP();
    }
    public String getMessage(){ //messag gaan inlezen
        return profil.getMessage();
    }
}
