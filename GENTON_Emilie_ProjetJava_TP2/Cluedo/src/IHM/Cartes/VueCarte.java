package IHM.Cartes;

import Metier.Cartes.Carte;
import Metier.Cases.Case;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;

//PERMET D'AVOIR UNE VUE SUR UNE CARTE DU METIER
public class VueCarte extends Pane {

    private Carte carteMetier;
    private ImageView image;
    public VueCarte(Carte carte)
    {
        this.carteMetier=carte;
    }

    //GETTER POUR MANIPULER LES CARTES ET LEURS IMAGES
    public Carte getCarte(){
        return carteMetier;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public String toString()
    {
        return "null";
    }
}
