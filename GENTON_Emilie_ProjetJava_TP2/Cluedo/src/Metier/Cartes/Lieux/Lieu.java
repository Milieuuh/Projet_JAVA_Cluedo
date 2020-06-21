package Metier.Cartes.Lieux;

import Metier.Cartes.Carte;
import Metier.Cartes.Suspects.Type_Suspects;
import Metier.Cartes.Type_Cartes;

public class Lieu extends Carte
{
    private Type_Lieux typeLieux;

    public Lieu(Type_Cartes type) {
        super(type);
    }

    public void setTypeLieux(Type_Lieux typeLieux) {
        this.typeLieux = typeLieux;
    }
    public Type_Lieux getTypeLieux() {
        return typeLieux;
    }


    @Override
    public String toString()
    {
        return super.toString()+ " Lieu ";
    }

}
