package Metier.Cartes.Armes;

import Metier.Cartes.Carte;
import Metier.Cartes.Type_Cartes;

public class Arme extends Carte {
    private Type_Arme typeArme;

    public Arme(Type_Cartes type) {
        super(type);
    }

    public Type_Arme getTypeArme() {
        return typeArme;
    }

    public void setTypeArme(Type_Arme typeArme) {
        this.typeArme = typeArme;
    }

    @Override
    public String toString() {
        return super.toString()+"Arme " ;
    }
}
