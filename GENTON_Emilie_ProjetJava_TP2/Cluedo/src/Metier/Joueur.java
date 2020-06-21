package Metier;

import Metier.Cartes.Carte;
import Metier.Cases.Case;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Joueur
{
    /////////////////////////////////////////////////ATTRIBUTS
    private String nom;
    private Color couleurPion;
    private Pion pion ;

    private ArrayList<Case> listeCases;
    private ArrayList<Carte> listeCarte;
    private ArrayList<Carte> listeCartesProposition;
    private ArrayList<String> listeCarteCochees;

    private boolean aLanceLesDes=false;
    private boolean aFaitProposition=false;
    private boolean bonneAccusation=false;
    private boolean sestDeplace;

    private Case caseVoulue;
    private int resLanceDes;
    private ArrayList<Joueur> listeJoueurs;
    private ArrayList<Carte> cartesPouvantEtreMontrees;
    private Carte carteMontree;
    private Joueur joueurMontrantLaCarte;

    /////////////////////////////////////////////////CONSTRUCTEUR
    public Joueur(ArrayList<Case> listeCases, String nom, ArrayList<Carte> listeCarte, Color couleur)
    {
        this.listeCases = listeCases;
        this.listeCarteCochees = new ArrayList<>();
        this.listeCarte = listeCarte;
        this.nom = nom;
        this.couleurPion = couleur;
        this.listeCartesProposition = new ArrayList<>();
        this.cartesPouvantEtreMontrees = new ArrayList<>();
    }

    public int verifieSiPionDansPiece(Case laCase)
    {
        int compteur= 1;
        for(int i=1; i<listeJoueurs.size(); i++)
        {
            if(laCase == this.listeJoueurs.get(i).getPion().getSaCase())
            {
                compteur ++;
            }

        }
        return compteur;
    }

    /**
     * PERMET DE REGARDER LES CASES OU LE PION PEUT SE DEPLACER EN FONCTION DU LANCE DE DES
     * @param des  le nombre obtenu au lancer de dés
     * @return la liste des cases atteignables
     */
    public ArrayList<Case> CasePossibleAAtteindre(int des)
    {
        ArrayList<Case> listeCaseAccessible = new ArrayList<>();
        Case laCase =  this.pion.getSaCase();

        if(des==1)
        {
            for(int l=0; l<laCase.getListeCasesVoisines().size(); l++)
            {
                if(this.verifieSiPionDansPiece(laCase.getListeCasesVoisines().get(l))==1 || laCase.getListeCasesVoisines().get(l).toString()!="Classique")
                {
                    listeCaseAccessible.add(laCase.getListeCasesVoisines().get(l));
                }
            }

        }
        else if(des==2)
        {
            for(int l=0; l<laCase.getListeCasesVoisines().size(); l++)
                {
                    if(this.verifieSiPionDansPiece(laCase.getListeCasesVoisines().get(l))==1 || laCase.getListeCasesVoisines().get(l).toString()!="Classique") {
                        listeCaseAccessible.add(laCase.getListeCasesVoisines().get(l));
                    }

                    for(int z=0; z<laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().size(); z++)
                    {
                        if(laCase!=laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z))
                        {
                            if(this.verifieSiPionDansPiece(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z))==1 || laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).toString()!="Classique") {
                                listeCaseAccessible.add(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z));
                            }
                        }
                    }
            }
        }
        else if(des==3)
        {
            for(int l=0; l<laCase.getListeCasesVoisines().size(); l++)
            {
                if(this.verifieSiPionDansPiece(laCase.getListeCasesVoisines().get(l))==1|| laCase.getListeCasesVoisines().get(l).toString()!="Classique") {
                    listeCaseAccessible.add(laCase.getListeCasesVoisines().get(l));
                }

                for(int z=0; z<laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().size(); z++)
                {
                    if(!listeCaseAccessible.contains(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z)))
                    {
                        if(this.verifieSiPionDansPiece(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z))==1 || laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).toString()!="Classique") {
                            listeCaseAccessible.add(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z));
                        }
                    }

                    for(int a=0; a<laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().size(); a++)
                    {
                        if(!listeCaseAccessible.contains(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a)))
                        {
                            if(this.verifieSiPionDansPiece(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a))==1|| laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).toString()!="Classique") {
                                listeCaseAccessible.add(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a));
                            }
                        }
                    }
                }
            }
        }
        else if(des==4)
        {
            for(int l=0; l<laCase.getListeCasesVoisines().size(); l++)
            {
                if(this.verifieSiPionDansPiece(laCase.getListeCasesVoisines().get(l))==1|| laCase.getListeCasesVoisines().get(l).toString()!="Classique") {
                    listeCaseAccessible.add(laCase.getListeCasesVoisines().get(l));
                }
                for(int z=0; z<laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().size(); z++)
                {
                    if(!listeCaseAccessible.contains(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z))|| laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).toString()!="Classique")
                    {
                        if(this.verifieSiPionDansPiece(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z))==1) {
                            listeCaseAccessible.add(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z));
                        }
                    }
                    for(int a=0; a<laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().size(); a++)
                    {
                        if(!listeCaseAccessible.contains(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a)))
                        {
                            if(this.verifieSiPionDansPiece(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a))==1 || laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).toString()!="Classique") {
                                listeCaseAccessible.add(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a));
                            }
                        }
                        for(int b=0; b<laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().size(); b++)
                        {
                            if(!listeCaseAccessible.contains(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().get(b)))
                            {
                                if(this.verifieSiPionDansPiece(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().get(b))==1|| laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().get(b).toString()!="Classique") {
                                    listeCaseAccessible.add(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().get(b));
                                }
                            }
                        }
                    }
                }
            }

        }
        else if(des==5)
        {
            for(int l=0; l<laCase.getListeCasesVoisines().size(); l++)
            {
                if(this.verifieSiPionDansPiece(laCase.getListeCasesVoisines().get(l))==1 || laCase.getListeCasesVoisines().get(l).toString()!="Classique") {
                    listeCaseAccessible.add(laCase.getListeCasesVoisines().get(l));
                }
                for(int z=0; z<laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().size(); z++)
                {
                    if(!listeCaseAccessible.contains(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z))|| laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).toString()!="Classique")
                    {
                        if(this.verifieSiPionDansPiece(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z))==1) {
                            listeCaseAccessible.add(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z));
                        }
                    }
                    for(int a=0; a<laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().size(); a++)
                    {
                        if(!listeCaseAccessible.contains(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a)))
                        {
                            if(this.verifieSiPionDansPiece(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a))==1 || laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).toString()!="Classique") {
                                listeCaseAccessible.add(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a));
                            }
                        }
                        for(int b=0; b<laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().size(); b++)
                        {
                            if(!listeCaseAccessible.contains(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().get(b)))
                            {
                                if(this.verifieSiPionDansPiece(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().get(b))==1|| laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().get(b).toString()!="Classique") {
                                    listeCaseAccessible.add(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().get(b));
                                }
                            }
                            for(int c=0; c<laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().get(b).getListeCasesVoisines().size(); c++)
                            {
                                if(!listeCaseAccessible.contains(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().get(b).getListeCasesVoisines().get(c)))
                                {
                                    if(this.verifieSiPionDansPiece(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().get(b).getListeCasesVoisines().get(c))==1|| laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().get(b).getListeCasesVoisines().get(c).toString()!="Classique") {
                                        listeCaseAccessible.add(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().get(b).getListeCasesVoisines().get(c));
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
        else if(des==6)
        {
            for(int l=0; l<laCase.getListeCasesVoisines().size(); l++)
            {
                if(this.verifieSiPionDansPiece(laCase.getListeCasesVoisines().get(l))==1 || laCase.getListeCasesVoisines().get(l).toString()!="Classique") {
                    listeCaseAccessible.add(laCase.getListeCasesVoisines().get(l));
                }
                for(int z=0; z<laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().size(); z++)
                {
                    if(!listeCaseAccessible.contains(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z))|| laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).toString()!="Classique")
                    {
                        if(this.verifieSiPionDansPiece(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z))==1) {
                            listeCaseAccessible.add(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z));
                        }
                    }
                    for(int a=0; a<laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().size(); a++)
                    {
                        if(!listeCaseAccessible.contains(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a)))
                        {
                            if(this.verifieSiPionDansPiece(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a))==1 || laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).toString()!="Classique") {
                                listeCaseAccessible.add(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a));
                            } }
                        for(int b=0; b<laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().size(); b++)
                        {
                            if(!listeCaseAccessible.contains(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().get(b)))
                            {
                                if(this.verifieSiPionDansPiece(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().get(b))==1|| laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().get(b).toString()!="Classique") {
                                    listeCaseAccessible.add(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().get(b));
                                }
                            }
                            for(int c=0; c<laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().get(b).getListeCasesVoisines().size(); c++)
                            {
                                if(!listeCaseAccessible.contains(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().get(b).getListeCasesVoisines().get(c)))
                                {
                                    if(this.verifieSiPionDansPiece(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().get(b).getListeCasesVoisines().get(c))==1|| laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().get(b).getListeCasesVoisines().get(c).toString()!="Classique") {
                                        listeCaseAccessible.add(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().get(b).getListeCasesVoisines().get(c));
                                    }
                                }
                                for(int d=0; d<laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().get(b).getListeCasesVoisines().get(c).getListeCasesVoisines().size(); d++)
                                {
                                    if(!listeCaseAccessible.contains(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().get(b).getListeCasesVoisines().get(c).getListeCasesVoisines().get(d)))
                                    {
                                        if(this.verifieSiPionDansPiece(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().get(b).getListeCasesVoisines().get(c).getListeCasesVoisines().get(d))==1 || laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().get(b).getListeCasesVoisines().get(c).getListeCasesVoisines().get(d).toString()!="Classique") {
                                            listeCaseAccessible.add(laCase.getListeCasesVoisines().get(l).getListeCasesVoisines().get(z).getListeCasesVoisines().get(a).getListeCasesVoisines().get(b).getListeCasesVoisines().get(c).getListeCasesVoisines().get(d));
                                        }

                                    }
                                }
                            }

                        }
                    }
                }
            }

        }

        return listeCaseAccessible;

    }


    ///////////////////////////////////////////////////GETTER SETTER
    public Pion getPion() {
        return pion;
    }

    public void setPion(Pion pion) {
        this.pion = pion;
    }

    public ArrayList<Case> getListeCases() {
        return listeCases;
    }


    public ArrayList<Carte> getListeCarte() {
        return listeCarte;
    }


    public boolean getaLanceLesDes() {
        return aLanceLesDes;
    }

    public void setaLanceLesDes(boolean aLanceLesDes) {
        this.aLanceLesDes = aLanceLesDes;
    }


    public int getResultLanceDes() {
        return resLanceDes;
    } // renvoie l'addition des deux dés


    public void setResultLanceDes(int aresLanceDes) {
        this.resLanceDes = aresLanceDes;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Color getCouleurPion() {
        return couleurPion;
    }

    public boolean isSestDeplace() {
        return sestDeplace;
    }

    public void setSestDeplace(boolean sestDeplace) {
        this.sestDeplace = sestDeplace;
    }

    public Case getCaseVoulue() {
        return caseVoulue;
    }

    public void setCaseVoulue(Case caseVoulue) {
        this.caseVoulue = caseVoulue;
    }

    public ArrayList<String> getListeCarteCochees() {
        return listeCarteCochees;
    }

    public void setListeCarteCochees(ArrayList<String> listeCarteCochees) {
        this.listeCarteCochees = listeCarteCochees;
    }

    public boolean getBonneAccusation() {
        return bonneAccusation;
    }

    public void setBonneAccusation(boolean bonneAccusation) {
        this.bonneAccusation = bonneAccusation;
    }

    public boolean getaFaitProposition() {
        return aFaitProposition;
    }

    public void setaFaitProposition(boolean aFaitProposition) {
        this.aFaitProposition = aFaitProposition;
    }

    public ArrayList<Joueur> getListeJoueurs() {
        return listeJoueurs;
    }

    public void setListeJoueurs(ArrayList<Joueur> listeJoueurs) {
        this.listeJoueurs = listeJoueurs;
    }


    public ArrayList<Carte> getListeCartesProposition() {
        return listeCartesProposition;
    }

    public ArrayList<Carte> getCartesPouvantEtreMontrees() {
        return cartesPouvantEtreMontrees;
    }

    public Carte getCarteMontree() {
        return carteMontree;
    }

    public void setCarteMontree(Carte carteMontree) {
        this.carteMontree = carteMontree;
    }


    public Joueur getJoueurMontrantLaCarte() {
        return joueurMontrantLaCarte;
    }

    public void setJoueurMontrantLaCarte(Joueur joueurMontrantLaCarte) {
        this.joueurMontrantLaCarte = joueurMontrantLaCarte;
    }



}
