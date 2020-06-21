package Metier;

import Metier.Cartes.Armes.*;
import Metier.Cartes.Carte;
import Metier.Cartes.Lieux.*;
import Metier.Cartes.Suspects.*;
import Metier.Cartes.Type_Cartes;
import Metier.Cases.Case;
import Metier.Cases.CaseClassique;
import Metier.Cases.CaseSalle;
import Metier.Cases.Type_Case;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;


//PERMET D'INITIALISER LA PARTIE
public class InitialisationPartie
{
    ////////////////////////////////ATTRIBUTS
    private ArrayList<Case> listeCases = new ArrayList<>();
    private ArrayList<Joueur> listeJoueurs = new ArrayList<>();
    private ArrayList<Carte> listeDesCartes = new ArrayList<>();

    private ArrayList<Carte> listeCartesArme = new ArrayList<Carte>();
    private ArrayList<Carte> listeCartesLieu = new ArrayList<Carte>();
    private ArrayList<Carte> listeCartesSuspect = new ArrayList<Carte>();

    private Automate automate;
    private ArrayList<Carte> talon = new ArrayList<>();
    private ArrayList<Carte> listeCartesSansTalon ;
    private ArrayList<Carte> listeCartesJoueur1 ;
    private ArrayList<Carte> listeCartesJoueur2 ;
    private ArrayList<Carte> listeCartesJoueur3 ;
    private ArrayList<Carte> listeCartesJoueur4 ;
    private ArrayList<Carte> listeCartesJoueur5 ;
    private ArrayList<Carte> listeCartesJoueur6 ;
    private ArrayList<ArrayList<Carte>> listeDeListesCartesJoueur ;

    public InitialisationPartie(int nombreDeJoueur)
    {
        creationCase();
        creationCartes();

        genereTalon();
        distribuerCarte(nombreDeJoueur);
        creationDesJoueur(nombreDeJoueur);

        automate = new Automate(this.listeJoueurs, this.listeDesCartes, this.talon, this.listeCases, this.listeCartesArme, this.listeCartesSuspect, this.listeCartesLieu);
    }

    /**
     * genère le talon aléatoirement
     */
    public void genereTalon()
    {

        for(int i=0; i<listeDesCartes.size(); i++)
        {
            if(listeDesCartes.get(i).getType() ==Type_Cartes.Carte_Arme)
            {
                listeCartesArme.add(listeDesCartes.get(i));
            }
            else if (listeDesCartes.get(i).getType()==Type_Cartes.Carte_Lieu)
            {
                listeCartesLieu.add(listeDesCartes.get(i));
            }
            else if (listeDesCartes.get(i).getType()==Type_Cartes.Carte_Suspect)
            {
                listeCartesSuspect.add(listeDesCartes.get(i));
            }
        }

        Random nombre = new Random();
        int numCarteArme = nombre.nextInt(listeCartesArme.size());
        int numCarteLieu = nombre.nextInt(listeCartesLieu.size());
        int numCarteSuspect = nombre.nextInt(listeCartesSuspect.size());

        this.talon.add(listeCartesArme.get(numCarteArme));
        this.talon.add(listeCartesLieu.get(numCarteLieu));
        this.talon.add(listeCartesSuspect.get(numCarteSuspect));

        //LISTE DES CARTES SANS LE TALON POUR LA DISTRIBUTION
        this.listeCartesSansTalon = new ArrayList<>();
        this .listeCartesSansTalon.addAll(this.listeDesCartes) ;
        this.listeCartesSansTalon.remove(listeCartesArme.get(numCarteArme));
        this.listeCartesSansTalon.remove(listeCartesLieu.get(numCarteLieu));
        this.listeCartesSansTalon.remove(listeCartesSuspect.get(numCarteSuspect));

        System.out.println("----------------------------TALON---------------------");
        System.out.println("1- "+listeCartesArme.get(numCarteArme).toString());
        System.out.println("2- "+listeCartesLieu.get(numCarteLieu).toString());
        System.out.println("3- "+listeCartesSuspect.get(numCarteSuspect).toString());



    }

    /**
     * Distribution des cartes aux différents joueurs
     * @param nombre = le nombre de joueur
     */
    public void distribuerCarte(int nombre)
    {
        int nbCarte = (Integer) this.listeCartesSansTalon.size()/nombre;
        int reste = this.listeCartesSansTalon.size()%nombre;

        //MELANGE DE LA LISTE
        Collections.shuffle(this.listeCartesSansTalon);

        this.initialiserListeCarteJoueur(nombre);

        //REMPLISSAGE DES LISTE DE CARTES DES JOUEURS
        ArrayList<Carte> temp = this.listeCartesSansTalon;


        System.out.println("\n---------------------LISTE DES CARTES EN JEU----------------");
        for(int i=0; i<this.listeDesCartes.size(); i++)
        {
            System.out.println(listeDesCartes.get(i).toString()+" ");
        }

        for(int i=0; i<nombre;i++)
        {
            remplirListeCarteJoueur(nbCarte, listeDeListesCartesJoueur.get(i), temp);

            for(int j=0; j<nbCarte; j++)
            {
                temp.remove(0);
            }
        }

        if(!temp.isEmpty())
        {
            for(int i=0; i<temp.size(); i++)
            {
                listeDeListesCartesJoueur.get(i).add(temp.get(i));
            }
        }
        afficherInfosPartie();

    }

    private void afficherInfosPartie()
    {
        //AFFICHAGE DES CARTES DU JOUEUR 1
        System.out.println("-----------------CARTES DU JOUEUR 1--------------");
        for(int i=0; i<listeCartesJoueur1.size();i++)
        {
            System.out.println(listeCartesJoueur1.get(i).toString() +", ");
        }

        System.out.println("-----------------CARTES DU JOUEUR 2--------------");
        for(int i=0; i<listeCartesJoueur2.size();i++)
        {
            System.out.println(listeCartesJoueur2.get(i).toString() +", ");
        }

        System.out.println("");

    }


    public void remplirListeCarteJoueur(int nbCarte, ArrayList<Carte> listeCartesJoueurX, ArrayList<Carte> listeDesCartesNonDonnees)
    {
        for(int i=0; i<nbCarte; i++)
        {
            listeCartesJoueurX.add(listeDesCartesNonDonnees.get(i));

        }
    }

    public void initialiserListeCarteJoueur(int nbJoueur)
    {
        //INITIALISATION DES ARRAYLIST
        listeDeListesCartesJoueur = new ArrayList<>();
        listeCartesJoueur1 = new ArrayList<>();  //2 joueurs minimum
        listeCartesJoueur2 = new ArrayList<>();

        listeDeListesCartesJoueur.add(listeCartesJoueur1);
        listeDeListesCartesJoueur.add(listeCartesJoueur2);

        if(nbJoueur==3)
        {
            listeCartesJoueur3 = new ArrayList<>();
            listeDeListesCartesJoueur.add(listeCartesJoueur3);
        }
        else if(nbJoueur==4)
        {
            listeCartesJoueur3 = new ArrayList<>();
            listeCartesJoueur4 = new ArrayList<>();
            listeDeListesCartesJoueur.add(listeCartesJoueur3);
            listeDeListesCartesJoueur.add(listeCartesJoueur4);
        }
        else if(nbJoueur==5)
        {
            listeCartesJoueur3 = new ArrayList<>();
            listeCartesJoueur4 = new ArrayList<>();
            listeCartesJoueur5 = new ArrayList<>();
            listeDeListesCartesJoueur.add(listeCartesJoueur3);
            listeDeListesCartesJoueur.add(listeCartesJoueur4);
            listeDeListesCartesJoueur.add(listeCartesJoueur5);
        }
        else if(nbJoueur==6)
        {
            listeCartesJoueur3 = new ArrayList<>();
            listeCartesJoueur4 = new ArrayList<>();
            listeCartesJoueur5 = new ArrayList<>();
            listeCartesJoueur6 = new ArrayList<>();
            listeDeListesCartesJoueur.add(listeCartesJoueur3);
            listeDeListesCartesJoueur.add(listeCartesJoueur4);
            listeDeListesCartesJoueur.add(listeCartesJoueur5);
            listeDeListesCartesJoueur.add(listeCartesJoueur6);
        }
    }

    public void creationCase()
    {
        for(int i=0; i<=70; i++)
        {
            if(i==0)
            {
                listeCases.add(new CaseSalle(i, Type_Case.Hall));
            }
            else if(i==5)
            {
                listeCases.add(new CaseSalle(i, Type_Case.Bureau));
            }
            else if(i==30)
            {
                listeCases.add(new CaseSalle(i, Type_Case.Cuisine));
            }
            else if(i==35)
            {
                listeCases.add(new CaseSalle(i, Type_Case.Chambre));
            }
            else if(i==39)
            {
                listeCases.add(new CaseSalle(i, Type_Case.Bibliotheque));
            }
            else if(i==57)
            {
                listeCases.add(new CaseSalle(i, Type_Case.Salon));
            }
            else if(i==58)
            {
                listeCases.add(new CaseSalle(i, Type_Case.Salle_a_manger));
            }
            else {
                listeCases.add(new CaseClassique(i));
            }

        }

        //POUR LES CASES VOISINES
        //LE HALL
        listeCases.get(0).getListeCasesVoisines().add(listeCases.get(6));
        listeCases.get(0).getListeCasesVoisines().add(listeCases.get(19));

        //CASE 1
        listeCases.get(1).getListeCasesVoisines().add(listeCases.get(6));
        listeCases.get(1).getListeCasesVoisines().add(listeCases.get(2));

        //CASE 2
        listeCases.get(2).getListeCasesVoisines().add(listeCases.get(1));
        listeCases.get(2).getListeCasesVoisines().add(listeCases.get(7));
        listeCases.get(2).getListeCasesVoisines().add(listeCases.get(3));

        //CASE 3
        listeCases.get(3).getListeCasesVoisines().add(listeCases.get(2));
        listeCases.get(3).getListeCasesVoisines().add(listeCases.get(8));
        listeCases.get(3).getListeCasesVoisines().add(listeCases.get(4));

        //CASE 4
        listeCases.get(4).getListeCasesVoisines().add(listeCases.get(3));
        listeCases.get(4).getListeCasesVoisines().add(listeCases.get(9));

        //CASE 5
        listeCases.get(5).getListeCasesVoisines().add(listeCases.get(14));

        //CASE 6
        listeCases.get(6).getListeCasesVoisines().add(listeCases.get(0));
        listeCases.get(6).getListeCasesVoisines().add(listeCases.get(1));
        listeCases.get(6).getListeCasesVoisines().add(listeCases.get(7));
        listeCases.get(6).getListeCasesVoisines().add(listeCases.get(10));

        //CASE 7
        listeCases.get(7).getListeCasesVoisines().add(listeCases.get(2));
        listeCases.get(7).getListeCasesVoisines().add(listeCases.get(6));
        listeCases.get(7).getListeCasesVoisines().add(listeCases.get(8));
        listeCases.get(7).getListeCasesVoisines().add(listeCases.get(11));

        //CASE 8
        listeCases.get(8).getListeCasesVoisines().add(listeCases.get(3));
        listeCases.get(8).getListeCasesVoisines().add(listeCases.get(7));
        listeCases.get(8).getListeCasesVoisines().add(listeCases.get(9));
        listeCases.get(8).getListeCasesVoisines().add(listeCases.get(12));

        //CASE 9
        listeCases.get(9).getListeCasesVoisines().add(listeCases.get(4));
        listeCases.get(9).getListeCasesVoisines().add(listeCases.get(8));
        listeCases.get(9).getListeCasesVoisines().add(listeCases.get(13));

        //CASE 10
        listeCases.get(10).getListeCasesVoisines().add(listeCases.get(6));
        listeCases.get(10).getListeCasesVoisines().add(listeCases.get(11));
        listeCases.get(10).getListeCasesVoisines().add(listeCases.get(22));

        //CASE 11
        listeCases.get(11).getListeCasesVoisines().add(listeCases.get(10));
        listeCases.get(11).getListeCasesVoisines().add(listeCases.get(7));
        listeCases.get(11).getListeCasesVoisines().add(listeCases.get(23));
        listeCases.get(11).getListeCasesVoisines().add(listeCases.get(12));

        //CASE 12
        listeCases.get(12).getListeCasesVoisines().add(listeCases.get(13));
        listeCases.get(12).getListeCasesVoisines().add(listeCases.get(11));
        listeCases.get(12).getListeCasesVoisines().add(listeCases.get(24));
        listeCases.get(12).getListeCasesVoisines().add(listeCases.get(8));

        //CASE 13
        listeCases.get(13).getListeCasesVoisines().add(listeCases.get(14));
        listeCases.get(13).getListeCasesVoisines().add(listeCases.get(12));
        listeCases.get(13).getListeCasesVoisines().add(listeCases.get(25));
        listeCases.get(13).getListeCasesVoisines().add(listeCases.get(9));

        //CASE 14
        listeCases.get(14).getListeCasesVoisines().add(listeCases.get(5));
        listeCases.get(14).getListeCasesVoisines().add(listeCases.get(13));
        listeCases.get(14).getListeCasesVoisines().add(listeCases.get(26));
        listeCases.get(14).getListeCasesVoisines().add(listeCases.get(15));

        //CASE 15
        listeCases.get(15).getListeCasesVoisines().add(listeCases.get(14));
        listeCases.get(15).getListeCasesVoisines().add(listeCases.get(27));
        listeCases.get(15).getListeCasesVoisines().add(listeCases.get(16));

        //CASE 16
        listeCases.get(16).getListeCasesVoisines().add(listeCases.get(15));
        listeCases.get(16).getListeCasesVoisines().add(listeCases.get(28));
        listeCases.get(16).getListeCasesVoisines().add(listeCases.get(17));

        //CASE 17
        listeCases.get(17).getListeCasesVoisines().add(listeCases.get(16));
        listeCases.get(17).getListeCasesVoisines().add(listeCases.get(29));

        //CASE 18
        listeCases.get(18).getListeCasesVoisines().add(listeCases.get(19));

        //CASE 19
        listeCases.get(19).getListeCasesVoisines().add(listeCases.get(18));
        listeCases.get(19).getListeCasesVoisines().add(listeCases.get(20));
        listeCases.get(19).getListeCasesVoisines().add(listeCases.get(0));

        //CASE 20
        listeCases.get(20).getListeCasesVoisines().add(listeCases.get(19));
        listeCases.get(20).getListeCasesVoisines().add(listeCases.get(21));

        //CASE 21
        listeCases.get(21).getListeCasesVoisines().add(listeCases.get(20));
        listeCases.get(21).getListeCasesVoisines().add(listeCases.get(22));

        //CASE 22
        listeCases.get(22).getListeCasesVoisines().add(listeCases.get(21));
        listeCases.get(22).getListeCasesVoisines().add(listeCases.get(23));
        listeCases.get(22).getListeCasesVoisines().add(listeCases.get(31));
        listeCases.get(22).getListeCasesVoisines().add(listeCases.get(10));

        //CASE 23
        listeCases.get(23).getListeCasesVoisines().add(listeCases.get(22));
        listeCases.get(23).getListeCasesVoisines().add(listeCases.get(24));
        listeCases.get(23).getListeCasesVoisines().add(listeCases.get(11));
        listeCases.get(23).getListeCasesVoisines().add(listeCases.get(32));

        //CASE 24
        listeCases.get(24).getListeCasesVoisines().add(listeCases.get(12));
        listeCases.get(24).getListeCasesVoisines().add(listeCases.get(23));
        listeCases.get(24).getListeCasesVoisines().add(listeCases.get(25));
        listeCases.get(24).getListeCasesVoisines().add(listeCases.get(33));

        //CASE 25
        listeCases.get(25).getListeCasesVoisines().add(listeCases.get(24));
        listeCases.get(25).getListeCasesVoisines().add(listeCases.get(26));
        listeCases.get(25).getListeCasesVoisines().add(listeCases.get(13));
        listeCases.get(25).getListeCasesVoisines().add(listeCases.get(34));

        //CASE 26
        listeCases.get(26).getListeCasesVoisines().add(listeCases.get(25));
        listeCases.get(26).getListeCasesVoisines().add(listeCases.get(27));
        listeCases.get(26).getListeCasesVoisines().add(listeCases.get(14));

        //CASE 27
        listeCases.get(27).getListeCasesVoisines().add(listeCases.get(26));
        listeCases.get(27).getListeCasesVoisines().add(listeCases.get(28));
        listeCases.get(27).getListeCasesVoisines().add(listeCases.get(35));
        listeCases.get(27).getListeCasesVoisines().add(listeCases.get(15));

        //CASE 28
        listeCases.get(28).getListeCasesVoisines().add(listeCases.get(27));
        listeCases.get(28).getListeCasesVoisines().add(listeCases.get(16));
        listeCases.get(28).getListeCasesVoisines().add(listeCases.get(29));

        //CASE 29
        listeCases.get(29).getListeCasesVoisines().add(listeCases.get(17));
        listeCases.get(29).getListeCasesVoisines().add(listeCases.get(28));

        //CASE 30
        listeCases.get(30).getListeCasesVoisines().add(listeCases.get(36));
        listeCases.get(30).getListeCasesVoisines().add(listeCases.get(49));

        //CASE 31
        listeCases.get(31).getListeCasesVoisines().add(listeCases.get(32));
        listeCases.get(31).getListeCasesVoisines().add(listeCases.get(22));

        //CASE 32
        listeCases.get(32).getListeCasesVoisines().add(listeCases.get(31));
        listeCases.get(32).getListeCasesVoisines().add(listeCases.get(23));
        listeCases.get(32).getListeCasesVoisines().add(listeCases.get(33));
        listeCases.get(32).getListeCasesVoisines().add(listeCases.get(39));

        //CASE 33
        listeCases.get(33).getListeCasesVoisines().add(listeCases.get(32));
        listeCases.get(33).getListeCasesVoisines().add(listeCases.get(34));
        listeCases.get(33).getListeCasesVoisines().add(listeCases.get(24));
        listeCases.get(33).getListeCasesVoisines().add(listeCases.get(39));

        //CASE 34
        listeCases.get(34).getListeCasesVoisines().add(listeCases.get(33));
        listeCases.get(34).getListeCasesVoisines().add(listeCases.get(35));
        listeCases.get(34).getListeCasesVoisines().add(listeCases.get(25));

        //CASE 35
        listeCases.get(35).getListeCasesVoisines().add(listeCases.get(27));
        listeCases.get(35).getListeCasesVoisines().add(listeCases.get(47));

        //CASE 36
        listeCases.get(36).getListeCasesVoisines().add(listeCases.get(30));
        listeCases.get(36).getListeCasesVoisines().add(listeCases.get(39));
        listeCases.get(36).getListeCasesVoisines().add(listeCases.get(38));

        //CASE 37
        listeCases.get(37).getListeCasesVoisines().add(listeCases.get(34));
        listeCases.get(37).getListeCasesVoisines().add(listeCases.get(39));
        listeCases.get(37).getListeCasesVoisines().add(listeCases.get(40));

        //CASE 38
        listeCases.get(38).getListeCasesVoisines().add(listeCases.get(39));
        listeCases.get(38).getListeCasesVoisines().add(listeCases.get(41));

        //CASE 39
        listeCases.get(39).getListeCasesVoisines().add(listeCases.get(32));
        listeCases.get(39).getListeCasesVoisines().add(listeCases.get(33));
        listeCases.get(39).getListeCasesVoisines().add(listeCases.get(36));
        listeCases.get(39).getListeCasesVoisines().add(listeCases.get(37));
        listeCases.get(39).getListeCasesVoisines().add(listeCases.get(38));
        listeCases.get(39).getListeCasesVoisines().add(listeCases.get(40));
        listeCases.get(39).getListeCasesVoisines().add(listeCases.get(43));
        listeCases.get(39).getListeCasesVoisines().add(listeCases.get(42));

        //CASE 40
        listeCases.get(40).getListeCasesVoisines().add(listeCases.get(39));
        listeCases.get(40).getListeCasesVoisines().add(listeCases.get(37));
        listeCases.get(40).getListeCasesVoisines().add(listeCases.get(44));

        //CASE 41
        listeCases.get(41).getListeCasesVoisines().add(listeCases.get(42));
        listeCases.get(41).getListeCasesVoisines().add(listeCases.get(38));
        listeCases.get(41).getListeCasesVoisines().add(listeCases.get(53));

        //CASE 42
        listeCases.get(42).getListeCasesVoisines().add(listeCases.get(41));
        listeCases.get(42).getListeCasesVoisines().add(listeCases.get(39));
        listeCases.get(42).getListeCasesVoisines().add(listeCases.get(43));
        listeCases.get(42).getListeCasesVoisines().add(listeCases.get(54));

        //CASE 43
        listeCases.get(43).getListeCasesVoisines().add(listeCases.get(39));
        listeCases.get(43).getListeCasesVoisines().add(listeCases.get(55));
        listeCases.get(43).getListeCasesVoisines().add(listeCases.get(42));
        listeCases.get(43).getListeCasesVoisines().add(listeCases.get(44));

        //CASE 44
        listeCases.get(44).getListeCasesVoisines().add(listeCases.get(43));
        listeCases.get(44).getListeCasesVoisines().add(listeCases.get(56));
        listeCases.get(44).getListeCasesVoisines().add(listeCases.get(40));
        listeCases.get(44).getListeCasesVoisines().add(listeCases.get(45));

        //CASE 45
        listeCases.get(45).getListeCasesVoisines().add(listeCases.get(44));
        listeCases.get(45).getListeCasesVoisines().add(listeCases.get(46));
        listeCases.get(45).getListeCasesVoisines().add(listeCases.get(46));

        //CASE 46
        listeCases.get(46).getListeCasesVoisines().add(listeCases.get(45));
        listeCases.get(46).getListeCasesVoisines().add(listeCases.get(47));

        //CASE 47
        listeCases.get(47).getListeCasesVoisines().add(listeCases.get(35));
        listeCases.get(47).getListeCasesVoisines().add(listeCases.get(48));
        listeCases.get(47).getListeCasesVoisines().add(listeCases.get(46));

        //CASE 48
        listeCases.get(48).getListeCasesVoisines().add(listeCases.get(47));

        //CASE 49
        listeCases.get(49).getListeCasesVoisines().add(listeCases.get(30));
        listeCases.get(49).getListeCasesVoisines().add(listeCases.get(50));

        //CASE 50
        listeCases.get(50).getListeCasesVoisines().add(listeCases.get(49));
        listeCases.get(50).getListeCasesVoisines().add(listeCases.get(51));

        //CASE 51
        listeCases.get(51).getListeCasesVoisines().add(listeCases.get(50));
        listeCases.get(51).getListeCasesVoisines().add(listeCases.get(52));

        //CASE 52
        listeCases.get(52).getListeCasesVoisines().add(listeCases.get(51));
        listeCases.get(52).getListeCasesVoisines().add(listeCases.get(53));

        //CASE 53
        listeCases.get(53).getListeCasesVoisines().add(listeCases.get(52));
        listeCases.get(53).getListeCasesVoisines().add(listeCases.get(54));
        listeCases.get(53).getListeCasesVoisines().add(listeCases.get(59));
        listeCases.get(53).getListeCasesVoisines().add(listeCases.get(41));

        //CASE 54
        listeCases.get(54).getListeCasesVoisines().add(listeCases.get(53));
        listeCases.get(54).getListeCasesVoisines().add(listeCases.get(55));
        listeCases.get(54).getListeCasesVoisines().add(listeCases.get(42));
        listeCases.get(54).getListeCasesVoisines().add(listeCases.get(60));

        //CASE 55
        listeCases.get(55).getListeCasesVoisines().add(listeCases.get(54));
        listeCases.get(55).getListeCasesVoisines().add(listeCases.get(56));
        listeCases.get(55).getListeCasesVoisines().add(listeCases.get(43));
        listeCases.get(55).getListeCasesVoisines().add(listeCases.get(61));

        //CASE 56
        listeCases.get(56).getListeCasesVoisines().add(listeCases.get(55));
        listeCases.get(56).getListeCasesVoisines().add(listeCases.get(44));
        listeCases.get(56).getListeCasesVoisines().add(listeCases.get(62));

        //CASE 57
        listeCases.get(57).getListeCasesVoisines().add(listeCases.get(62));

        //CASE 58
        listeCases.get(58).getListeCasesVoisines().add(listeCases.get(63));

        //CASE 59
        listeCases.get(59).getListeCasesVoisines().add(listeCases.get(63));
        listeCases.get(59).getListeCasesVoisines().add(listeCases.get(53));
        listeCases.get(59).getListeCasesVoisines().add(listeCases.get(60));

        //CASE 60
        listeCases.get(60).getListeCasesVoisines().add(listeCases.get(59));
        listeCases.get(60).getListeCasesVoisines().add(listeCases.get(54));
        listeCases.get(60).getListeCasesVoisines().add(listeCases.get(61));
        listeCases.get(60).getListeCasesVoisines().add(listeCases.get(64));

        //CASE 61
        listeCases.get(61).getListeCasesVoisines().add(listeCases.get(60));
        listeCases.get(61).getListeCasesVoisines().add(listeCases.get(62));
        listeCases.get(61).getListeCasesVoisines().add(listeCases.get(55));
        listeCases.get(61).getListeCasesVoisines().add(listeCases.get(65));

        //CASE 62
        listeCases.get(62).getListeCasesVoisines().add(listeCases.get(61));
        listeCases.get(62).getListeCasesVoisines().add(listeCases.get(57));
        listeCases.get(62).getListeCasesVoisines().add(listeCases.get(56));
        listeCases.get(62).getListeCasesVoisines().add(listeCases.get(66));

        //CASE 63
        listeCases.get(63).getListeCasesVoisines().add(listeCases.get(58));
        listeCases.get(63).getListeCasesVoisines().add(listeCases.get(59));
        listeCases.get(63).getListeCasesVoisines().add(listeCases.get(64));
        listeCases.get(63).getListeCasesVoisines().add(listeCases.get(67));

        //CASE 64
        listeCases.get(64).getListeCasesVoisines().add(listeCases.get(63));
        listeCases.get(64).getListeCasesVoisines().add(listeCases.get(65));
        listeCases.get(64).getListeCasesVoisines().add(listeCases.get(60));
        listeCases.get(64).getListeCasesVoisines().add(listeCases.get(68));

        //CASE 65
        listeCases.get(65).getListeCasesVoisines().add(listeCases.get(64));
        listeCases.get(65).getListeCasesVoisines().add(listeCases.get(66));
        listeCases.get(65).getListeCasesVoisines().add(listeCases.get(61));
        listeCases.get(65).getListeCasesVoisines().add(listeCases.get(69));

        //CASE 66
        listeCases.get(66).getListeCasesVoisines().add(listeCases.get(65));
        listeCases.get(66).getListeCasesVoisines().add(listeCases.get(62));
        listeCases.get(66).getListeCasesVoisines().add(listeCases.get(70));

        //CASE 67
        listeCases.get(67).getListeCasesVoisines().add(listeCases.get(63));
        listeCases.get(67).getListeCasesVoisines().add(listeCases.get(68));

        //CASE 68
        listeCases.get(68).getListeCasesVoisines().add(listeCases.get(67));
        listeCases.get(68).getListeCasesVoisines().add(listeCases.get(69));
        listeCases.get(68).getListeCasesVoisines().add(listeCases.get(64));

        //CASE 69
        listeCases.get(69).getListeCasesVoisines().add(listeCases.get(68));
        listeCases.get(69).getListeCasesVoisines().add(listeCases.get(70));
        listeCases.get(69).getListeCasesVoisines().add(listeCases.get(65));

        //CASE 70
        listeCases.get(70).getListeCasesVoisines().add(listeCases.get(69));
        listeCases.get(70).getListeCasesVoisines().add(listeCases.get(66));

    }

    public void creationCartes()
    {
        //CARTES ARMES
        this.listeDesCartes.add(new Poignard(Type_Cartes.Carte_Arme));
        this.listeDesCartes.add(new Corde(Type_Cartes.Carte_Arme));
        this.listeDesCartes.add(new Chandelier(Type_Cartes.Carte_Arme));
        this.listeDesCartes.add(new Revolver(Type_Cartes.Carte_Arme));
        this.listeDesCartes.add(new CleAnglaise(Type_Cartes.Carte_Arme));
        this.listeDesCartes.add(new Matraque(Type_Cartes.Carte_Arme));

        //CARTES SUSPECTS
        this.listeDesCartes.add(new Rose(Type_Cartes.Carte_Suspect));
        this.listeDesCartes.add(new Moutarde(Type_Cartes.Carte_Suspect));
        this.listeDesCartes.add(new Violet(Type_Cartes.Carte_Suspect));
        this.listeDesCartes.add(new Leblanc(Type_Cartes.Carte_Suspect));
        this.listeDesCartes.add(new Olive(Type_Cartes.Carte_Suspect));
        this.listeDesCartes.add(new Pervenche(Type_Cartes.Carte_Suspect));

        //CARTES LIEUX
        this.listeDesCartes.add(new Hall(Type_Cartes.Carte_Lieu));
        this.listeDesCartes.add(new SalleAManger(Type_Cartes.Carte_Lieu));
        this.listeDesCartes.add(new Salon(Type_Cartes.Carte_Lieu));
        this.listeDesCartes.add(new Cuisine(Type_Cartes.Carte_Lieu));
        this.listeDesCartes.add(new Chambre(Type_Cartes.Carte_Lieu));
        this.listeDesCartes.add(new Bureau(Type_Cartes.Carte_Lieu));
        this.listeDesCartes.add(new Bibliotheque(Type_Cartes.Carte_Lieu));

    }

    public void creationDesJoueur(int nombre)
    {
        ArrayList<Color> liste_couleur = new ArrayList<>();
        liste_couleur.add(Color.PINK);
        liste_couleur.add(Color.CYAN);
        liste_couleur.add(Color.GREEN);
        liste_couleur.add(Color.YELLOW);
        liste_couleur.add(Color.PURPLE);
        liste_couleur.add(Color.GREY);


        for(int i=0 ; i<nombre ; i++){
            listeJoueurs.add(new Joueur(this.listeCases, "Joueur "+ (i+1), this.listeDeListesCartesJoueur.get(i), liste_couleur.get(i)));
        }
        this.initialisationPlacementPion(nombre);
        for(int i=0 ; i<nombre ; i++){
            listeJoueurs.get(i).setListeJoueurs(this.listeJoueurs);
        }



    }

    public void initialisationPlacementPion(int nombre)
    {
        this.listeJoueurs.get(0).setPion(new Pion(this.listeJoueurs.get(0),listeCases.get(2)));
        this.listeJoueurs.get(1).setPion(new Pion(this.listeJoueurs.get(1),listeCases.get(69)));
        if(nombre==3)
        {
            this.listeJoueurs.get(2).setPion(new Pion(this.listeJoueurs.get(2),listeCases.get(18)));
        }
        else if (nombre==4)
        {
            this.listeJoueurs.get(2).setPion(new Pion(this.listeJoueurs.get(2),listeCases.get(18)));
            this.listeJoueurs.get(3).setPion(new Pion(this.listeJoueurs.get(3),listeCases.get(48)));;
        }
        else if (nombre==5)
        {
            this.listeJoueurs.get(2).setPion(new Pion(this.listeJoueurs.get(2),listeCases.get(18)));;
            this.listeJoueurs.get(3).setPion(new Pion(this.listeJoueurs.get(3),listeCases.get(48)));;
            this.listeJoueurs.get(4).setPion(new Pion(this.listeJoueurs.get(4),listeCases.get(29)));;

        }
        else if (nombre==6)
        {
            this.listeJoueurs.get(2).setPion(new Pion(this.listeJoueurs.get(2),listeCases.get(18)));
            this.listeJoueurs.get(3).setPion(new Pion(this.listeJoueurs.get(3),listeCases.get(48)));
            this.listeJoueurs.get(4).setPion(new Pion(this.listeJoueurs.get(4),listeCases.get(29)));
            this.listeJoueurs.get(5).setPion(new Pion(this.listeJoueurs.get(5),listeCases.get(49)));
        }

    }

    ///////////////////////////////////GETTER ET SETTER
    public ArrayList<Case> getListeCases() {
        return listeCases;
    }

    public void setListeCases(ArrayList<Case> listeCases) {
        this.listeCases = listeCases;
    }

    public ArrayList<Joueur> getListeJoueurs() {
        return listeJoueurs;
    }

    public void setListeJoueurs(ArrayList<Joueur> listeJoueurs) {
        this.listeJoueurs = listeJoueurs;
    }

    public ArrayList<Carte> getListeDesCartes() {
        return listeDesCartes;
    }

    public void setListeDesCartes(ArrayList<Carte> listeDesCartes) {
        this.listeDesCartes = listeDesCartes;
    }

    public Automate getAutomate() {
        return automate;
    }




}
