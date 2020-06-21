package Metier;

import Metier.Cases.Case;

import java.util.ArrayList;

public class Pion {


    /////////////////////////////////////ATTRIBUTS
    private Case saCase;
    private ArrayList<Case> listeCasesAtteignables;
    private Joueur joueur;

    //////////////////////////////////////CONSTRUCTEUR
    public Pion(Joueur joueur, Case laCase)
    {
        saCase = laCase;
        this.joueur= joueur;
        listeCasesAtteignables = new ArrayList<>();
    }


    ////////////////////////////////////////////GETTER ET SETTER
    public Case getSaCase() {
        return saCase;
    }

    public void setSaCase(Case saCase) {
        this.saCase = saCase;
    }


    public ArrayList<Case> getListeCasesAtteignables() {
        return listeCasesAtteignables;
    }

    public void setListeCasesAtteignables(ArrayList<Case> listeCasesAtteignables) {
        this.listeCasesAtteignables = listeCasesAtteignables;
    }


}
