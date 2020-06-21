package Metier.Cartes.Suspects;

import Metier.Cartes.Armes.Type_Arme;
import Metier.Cartes.Carte;
import Metier.Cartes.Type_Cartes;
import javafx.scene.image.PixelFormat;

public class Suspect extends Carte {

    private Type_Suspects typeSuspect;

    public Suspect(Type_Cartes type) {
        super(type);
    }

    public void setTypeSuspect(Type_Suspects typeSuspect) {
        this.typeSuspect = typeSuspect;
    }
    public Type_Suspects getTypeSuspect() {
        return typeSuspect;
    }

    @Override
    public String toString()
    {
        return super.toString()+ " Suspect ";
    }
}
