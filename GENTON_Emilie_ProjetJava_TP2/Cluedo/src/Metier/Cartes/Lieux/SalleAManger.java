package Metier.Cartes.Lieux;

import Metier.Cartes.Type_Cartes;

public class SalleAManger extends Lieu {

    public SalleAManger(Type_Cartes type) {
        super(type);
        this.setTypeLieux(Type_Lieux.Salle_a_manger);
    }


    @Override
    public String toString()
    {
        return "la salle à manger";
    }

}
