package Metier.Cases;

public class CaseClassique extends Case{
    Type_Case type;

    public CaseClassique(int numero) {
        super(numero);
        this.type= Type_Case.Classique;
    }

    @Override
    public String toString() {
        return "Classique";
    }
}
