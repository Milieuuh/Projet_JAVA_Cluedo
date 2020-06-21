package IHM.Fenetre;

import IHM.ComposantJeu.*;
import IHM.Element.Pion;
import IHM.Fenetre.Erreur.FenetreErreurDeplacement;
import Metier.Automate;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

//FENETRE PRINCIPALE DU JEU
public class FenetreJeu extends Parent {

    private Canvas canvas = new Canvas(1500,900);
    private Stage fenetreDuJeu ;
    private Automate automate;
    private ZoneHaut zoneHaut;
    private ZoneListe zoneListe;
    private ZonePlateau zonePlateau;
    private ZoneCartes zoneBas;
    private ZoneBoutonBas zoneBoutonBas;
    private Pion pions;

    public FenetreJeu(Stage fenetre, Automate automate)
    {
        this.automate = automate;
        this.fenetreDuJeu = fenetre;

        //ZONE HAUT
        zoneHaut = new ZoneHaut(automate, this);
        zoneHaut.genererZoneHaut();


        //ZONE CARTE
        this.zoneBas = new ZoneCartes(automate);

        //ZONE BAS BOUTON
        this.zoneBoutonBas = new ZoneBoutonBas(automate, this);
        zoneBas.genererToutesLesCartes();
        zoneBas.genererCartesDuJoueur(automate.getListeJoueurs().get(0));

        //ZONE PLATEAU
        zonePlateau = new ZonePlateau(automate);
        pions = new Pion(automate, zonePlateau);

        //ZONE LISTE
        zoneListe = new ZoneListe(automate);
        zoneListe.genererZoneListe();


        ///////////////////////////AJOUT
        this.getChildren().add(zoneBas);
        this.getChildren().add(zoneBoutonBas);
        this.getChildren().add(zoneListe);
        this.getChildren().add(zoneHaut);
        this.getChildren().add(zonePlateau);
    }

    public void fenetreNoire()
    {

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        canvas.setOpacity(0.5);
        gc.fillRect(0,0, 1600,1600);
        this.getChildren().add(canvas);
    }

    public void deplacement()
    {

        final int[] compteur = {0};
        for(int i=0; i<automate.getListeDesCases().size(); i++)
        {
            final int index = i;
            FenetreJeu jeu = this;
            zonePlateau.getListeCases().get(i).setOnMouseClicked(
                    new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            compteur[0]++;
                            if(compteur[0] ==1 || (automate.getListeJoueurs().get(0).isSestDeplace()==false && automate.getListeJoueurs().get(0).getaLanceLesDes()==true))
                            {
                                zonePlateau.getListeCases().get(index).setEstCliquee(true);
                                automate.getListeJoueurs().get(0).setCaseVoulue(zonePlateau.getListeCases().get(index).getCase());
                                automate.evoluer("Deplacement");


                                //GESTION DU PION
                                if(automate.getListeJoueurs().get(0).isSestDeplace()==true)
                                {
                                    pions.entrerDansCase();
                                }
                                else if (automate.getListeJoueurs().get(0).isSestDeplace()==false || automate.getListeJoueurs().get(0).getaLanceLesDes()==true)
                                {
                                    Stage nouvelle_fenetre_erreur_deplacement = new Stage();
                                    FenetreErreurDeplacement fenetreErreurDeplacements = new FenetreErreurDeplacement(automate, nouvelle_fenetre_erreur_deplacement, jeu );

                                    Scene nouvelle_scene = new  Scene(fenetreErreurDeplacements,500,250);

                                    //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
                                    nouvelle_fenetre_erreur_deplacement.initModality(Modality.WINDOW_MODAL);
                                    nouvelle_fenetre_erreur_deplacement.initOwner(fenetreDuJeu);

                                    nouvelle_fenetre_erreur_deplacement.setScene(nouvelle_scene);
                                    //POSITION DE LA FENETRE
                                    nouvelle_fenetre_erreur_deplacement.show();
                                }

                            }
                        }
                    }
            );
        }

    }

    public void validerProposition(String arme, String suspect)
    {

       this.automate.getListeJoueurs().get(0).getListeCartesProposition().add(this.automate.rechercherArme(arme));
       this.automate.getListeJoueurs().get(0).getListeCartesProposition().add(this.automate.rechercherSuspect(suspect) );

       String lieu = this.automate.getListeJoueurs().get(0).getPion().getSaCase().toString();

       switch(lieu)
       {
           case "Hall" : lieu = "le hall"; break;
           case "Cuisine" : lieu = "la cuisine"; break;
           case "Salon" : lieu = "le salon"; break;
           case "Bibliotheque" : lieu = "la bibliotheque"; break;
           case "Salle a manger" : lieu = "la salle à manger"; break;
           case "Chambre" : lieu = "la chambre"; break;
           case "Bureau" : lieu = "le bureau"; break;
       }
        this.automate.getListeJoueurs().get(0).getListeCartesProposition().add(this.automate.rechercherLieu(lieu) );

       automate.evoluer("Proposition");
       this.ChoixCarteMontree();

    }

    public void validerAccusation(String arme, String suspect)
    {

        this.automate.getListeJoueurs().get(0).getListeCartesProposition().add(this.automate.rechercherArme(arme));
        this.automate.getListeJoueurs().get(0).getListeCartesProposition().add(this.automate.rechercherSuspect(suspect) );

        String lieu = this.automate.getListeJoueurs().get(0).getPion().getSaCase().toString();

        switch(lieu)
        {
            case "Hall" : lieu = "le hall"; break;
            case "Cuisine" : lieu = "la cuisine"; break;
            case "Salon" : lieu = "le salon"; break;
            case "Bibliotheque" : lieu = "la bibliotheque"; break;
            case "Salle a manger" : lieu = "la salle à manger"; break;
            case "Chambre" : lieu = "la chambre"; break;
            case "Bureau" : lieu = "le bureau"; break;
        }
        this.automate.getListeJoueurs().get(0).getListeCartesProposition().add(this.automate.rechercherLieu(lieu) );

        pions.sortirDeCase();
        automate.evoluer("Accusation");
        if(automate.getListeJoueurs().get(0).getBonneAccusation()==true)
        {
            Stage nouvelle_fenetre_gagnee = new Stage();
            FenetreGagnee fenetreGagnee = new FenetreGagnee(automate,nouvelle_fenetre_gagnee, this);

            Scene nouvelle_scene = new  Scene(fenetreGagnee,600,350);

            //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
            nouvelle_fenetre_gagnee.initModality(Modality.WINDOW_MODAL);
            nouvelle_fenetre_gagnee.initOwner(fenetreDuJeu);

            nouvelle_fenetre_gagnee.setScene(nouvelle_scene);
            //POSITION DE LA FENETRE
            nouvelle_fenetre_gagnee.show();
        }
        else
        {
            Stage nouvelle_fenetre_perdue = new Stage();
            FenetrePerdu fenetrePerdu = new FenetrePerdu(automate,nouvelle_fenetre_perdue, this);

            Scene nouvelle_scene = new  Scene(fenetrePerdu,500,250);

            //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
            nouvelle_fenetre_perdue.initModality(Modality.WINDOW_MODAL);
            nouvelle_fenetre_perdue.initOwner(fenetreDuJeu);

            nouvelle_fenetre_perdue.setScene(nouvelle_scene);
            //POSITION DE LA FENETRE
            nouvelle_fenetre_perdue.show();
        }

    }

    public void ChoixCarteMontree()
    {
        Stage nouvelle_fenetre_peutMontrerCarte = new Stage();
        FenetreVaMontrerCarteOUaucuneCarteAMontrer fenetreErreurDeplacements = new FenetreVaMontrerCarteOUaucuneCarteAMontrer(automate, nouvelle_fenetre_peutMontrerCarte, this );

        Scene nouvelle_scene = new  Scene(fenetreErreurDeplacements,650,250);

        //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
        nouvelle_fenetre_peutMontrerCarte.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_peutMontrerCarte.initOwner(fenetreDuJeu);

        nouvelle_fenetre_peutMontrerCarte.setScene(nouvelle_scene);
        //POSITION DE LA FENETRE
        nouvelle_fenetre_peutMontrerCarte.show();


    }


    public Stage getFenetreDuJeu() {
        return fenetreDuJeu;
    }

    public Canvas getCanvas() {
        return canvas;
    }


    public ZoneHaut getZoneHaut() {
        return zoneHaut;
    }

    public ZoneListe getZoneListe() {
        return zoneListe;
    }

    public ZonePlateau getZonePlateau() {
        return zonePlateau;
    }

    public ZoneCartes getZoneBas() {
        return zoneBas;
    }

    public ZoneBoutonBas getZoneBoutonBas() {
        return zoneBoutonBas;
    }

    public Pion getPions() {
        return pions;
    }

}
