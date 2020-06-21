package Metier.Cases;

public class CaseSalle extends Case {

    private Type_Case lieu;

    public CaseSalle(int num, Type_Case l)
    {
        super(num);
        this.lieu = l;
    }

    @Override
    public String toString() {
        String s= "";
        switch (lieu){
            case Hall: s="Hall"; break;
            case Chambre: s="Chambre"; break;
            case Cuisine: s="Cuisine"; break;
            case Salle_a_manger: s="Salle a manger"; break;
            case Salon:s="Salon"; break;
            case Bureau: s="Bureau"; break;
            case Bibliotheque: s="Bibliotheque"; break;
            case Classique: s="Classique";
            default:s="error";
        }
        if(s.equals("Classique"))
        {
            System.out.println("Le lieu n'est pas une salle mais une case lambda !");
        }

        return s;
    }
}
