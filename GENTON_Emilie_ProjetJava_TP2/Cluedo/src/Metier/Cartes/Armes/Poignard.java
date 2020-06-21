package Metier.Cartes.Armes;

import Metier.Cartes.Type_Cartes;

public class Poignard extends Arme {

    public Poignard(Type_Cartes typeArme) {
        super(typeArme);
        this.setTypeArme(Type_Arme.Poignard);
    }

    @Override
    public String toString() {
        return "le poignard" ;
    }
}
