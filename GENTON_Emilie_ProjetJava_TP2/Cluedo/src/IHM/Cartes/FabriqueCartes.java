package IHM.Cartes;

import IHM.Cartes.Armes.*;
import IHM.Cartes.Lieux.*;
import IHM.Cartes.Suspects.*;
import IHM.Plateau.VueCase;
import Metier.Cartes.Armes.Arme;
import Metier.Cartes.Armes.Type_Arme;
import Metier.Cartes.Carte;
import Metier.Cartes.Lieux.Lieu;
import Metier.Cartes.Lieux.Type_Lieux;
import Metier.Cartes.Suspects.Suspect;
import Metier.Cartes.Suspects.Type_Suspects;

public class FabriqueCartes
{
    public FabriqueCartes(){}

    /**
     * Permet de fabriquer la carte en fonction de la carte métier correspondante
     * @param carteMetier : carte du métier
     * @return
     */
    public VueCarte FabriqueCartesDuJeu(Carte carteMetier) {
        VueCarte c = null;
        switch (carteMetier.getType()) {
            case Carte_Arme:
                if(((Arme)carteMetier).getTypeArme()== Type_Arme.Poignard)
                {
                    c = new Poignard(carteMetier);

                }
                else if(((Arme)carteMetier).getTypeArme()== Type_Arme.Corde)
                {
                    c = new Corde(carteMetier);
                }
                else if(((Arme)carteMetier).getTypeArme()== Type_Arme.Chandelier)
                {
                    c = new Chandelier(carteMetier);
                }
                else if(((Arme)carteMetier).getTypeArme()== Type_Arme.CleAnglaise)
                {
                    c = new CleAnglaise(carteMetier);
                }
                else if(((Arme)carteMetier).getTypeArme()== Type_Arme.Matraque)
                {
                    c = new Matraque(carteMetier);
                }
                else if(((Arme)carteMetier).getTypeArme()== Type_Arme.Revolver)
                {
                    c = new Revolver(carteMetier);
                };
                break;

            case Carte_Suspect:
                if(((Suspect)carteMetier).getTypeSuspect()== Type_Suspects.Leblanc)
                {
                    c = new Leblanc(carteMetier);
                }
                else if(((Suspect)carteMetier).getTypeSuspect()== Type_Suspects.Moutarde)
                {
                    c = new Moutarde(carteMetier);
                }else if(((Suspect)carteMetier).getTypeSuspect()== Type_Suspects.Pervenche)
                {
                    c = new Pervenche(carteMetier);
                }
                else if(((Suspect)carteMetier).getTypeSuspect()== Type_Suspects.Olive)
                {
                    c = new Olive(carteMetier);
                }
                else if(((Suspect)carteMetier).getTypeSuspect()== Type_Suspects.Rose)
                {
                    c = new Rose(carteMetier);
                }
                else if(((Suspect)carteMetier).getTypeSuspect()== Type_Suspects.Violet)
                {
                    c = new Violet(carteMetier);
                };

                break;
            case Carte_Lieu:
                if(((Lieu)carteMetier).getTypeLieux()== Type_Lieux.Bibliotheque)
                {
                    c = new Bibliotheque(carteMetier);
                }
                else if(((Lieu)carteMetier).getTypeLieux()== Type_Lieux.Bureau)
                {
                    c = new Bureau(carteMetier);
                }
                else if(((Lieu)carteMetier).getTypeLieux()== Type_Lieux.Hall)
                {
                    c = new Hall(carteMetier);
                }
                else if(((Lieu)carteMetier).getTypeLieux()== Type_Lieux.Chambre)
                {
                    c = new Chambre(carteMetier);
                }
                else if(((Lieu)carteMetier).getTypeLieux()== Type_Lieux.Cuisine)
                {
                    c = new Cuisine(carteMetier);
                }
                else if(((Lieu)carteMetier).getTypeLieux()== Type_Lieux.Salle_a_manger)
                {
                    c = new SalleAManger(carteMetier);
                }
                else if(((Lieu)carteMetier).getTypeLieux()== Type_Lieux.Salon)
                {
                    c = new Salon(carteMetier);
                };
                break;

        }

        return c;
    }

}
