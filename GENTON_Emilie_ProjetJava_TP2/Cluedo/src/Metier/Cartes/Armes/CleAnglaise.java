package Metier.Cartes.Armes;

import Metier.Cartes.Type_Cartes;

public class CleAnglaise extends Arme {

    public CleAnglaise(Type_Cartes type) {
        super(type);
        setTypeArme(Type_Arme.CleAnglaise);
    }

    @Override
    public String toString() {
        return "la clé anglaise";
    }
}
