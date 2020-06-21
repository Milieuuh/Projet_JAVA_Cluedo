package Metier.Cartes;

public abstract class Carte
{
    //////////////////////ATTRIBUTS
    private Type_Cartes type;

    ///////////////////////CONSTRUCTEUR
    public Carte(Type_Cartes type)
    {
        this.type = type;
    }



    ////////////////////////////////////GETTER SETTER
    public Type_Cartes getType() {
        return type;
    }

    public void setType(Type_Cartes type) {
        this.type = type;
    }

    public String toString()
    {
        return "Cartes ";
    }

}
