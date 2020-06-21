package Metier.Cases;

import java.util.ArrayList;

public abstract class Case {

    //ATTRIBUTS
    private int numero ;
    private ArrayList<Case> listeCasesVoisines;

    //CONSTRUCTEUR
    public Case(int numero) {
        this.numero = numero;
        listeCasesVoisines = new ArrayList<>();
    }


    public int getNumero(){
        return this.numero;
    }

    public abstract String toString();

    public ArrayList<Case> getListeCasesVoisines() {
        return listeCasesVoisines;
    }



}
