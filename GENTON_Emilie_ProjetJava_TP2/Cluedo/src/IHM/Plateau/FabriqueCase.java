package IHM.Plateau;

import IHM.Plateau.ToutesLesCases.*;
import Metier.Automate;
import Metier.Cases.Case;

public class FabriqueCase {

    public FabriqueCase(){}

    public VueCase FabriqueCaseDuJeu(Case caseMetier, Automate automate)
    {
        VueCase c=null;
        switch(caseMetier.getNumero())
        {
            case 0: c= new Hall0(caseMetier, automate); break;
            case 1 : c = new Classique1(caseMetier, automate);break;
            case 2 : c = new Classique2(caseMetier, automate);break;
            case 3 : c = new Classique3(caseMetier, automate);break;
            case 4 : c = new Classique4(caseMetier, automate);break;
            case 5 : c = new Bureau5(caseMetier, automate);break;
            case 6 : c = new Classique6(caseMetier, automate);break;
            case 7 : c = new Classique7(caseMetier, automate);break;
            case 8 : c = new Classique8(caseMetier, automate);break;
            case 9 : c = new Classique9(caseMetier, automate);break;
            case 10 : c = new Classique10(caseMetier, automate);break;
            case 11: c = new Classique11(caseMetier, automate);break;
            case 12: c = new Classique12(caseMetier, automate);break;
            case 13: c = new Classique13(caseMetier, automate);break;
            case 14: c = new Classique14(caseMetier, automate);break;
            case 15: c = new Classique15(caseMetier, automate);break;
            case 16: c = new Classique16(caseMetier, automate);break;
            case 17: c = new Classique17(caseMetier, automate);break;
            case 18: c = new Classique18(caseMetier, automate);break;
            case 19: c = new Classique19(caseMetier, automate);break;
            case 20: c = new Classique20(caseMetier, automate);break;
            case 21: c = new Classique21(caseMetier, automate);break;
            case 22: c = new Classique22(caseMetier, automate);break;
            case 23: c = new Classique23(caseMetier, automate);break;
            case 24: c = new Classique24(caseMetier, automate);break;
            case 25: c = new Classique25(caseMetier, automate);break;
            case 26: c = new Classique26(caseMetier, automate);break;
            case 27: c = new Classique27(caseMetier, automate);break;
            case 28: c = new Classique28(caseMetier, automate);break;
            case 29: c = new Classique29(caseMetier, automate);break;
            case 30: c = new Cuisine30(caseMetier, automate);break;
            case 31: c = new Classique31(caseMetier, automate);break;
            case 32: c = new Classique32(caseMetier, automate);break;
            case 33: c = new Classique33(caseMetier, automate);break;
            case 34: c = new Classique34(caseMetier, automate);break;
            case 35: c = new Chambre35(caseMetier, automate);break;
            case 36: c = new Classique36(caseMetier, automate);break;
            case 37: c = new Classique37(caseMetier, automate);break;
            case 38: c = new Classique38(caseMetier, automate);break;
            case 39: c = new Bibilotheque39(caseMetier, automate);break;
            case 40: c = new Classique40(caseMetier, automate);break;
            case 41: c = new Classique41(caseMetier, automate);break;
            case 42: c = new Classique42(caseMetier, automate);break;
            case 43: c = new Classique43(caseMetier, automate);break;
            case 44: c = new Classique44(caseMetier, automate);break;
            case 45: c = new Classique45(caseMetier, automate);break;
            case 46: c = new Classique46(caseMetier, automate);break;
            case 47: c = new Classique47(caseMetier, automate);break;
            case 48: c = new Classique48(caseMetier, automate);break;
            case 49: c = new Classique49(caseMetier, automate);break;
            case 50: c = new Classique50(caseMetier, automate);break;
            case 51: c = new Classique51(caseMetier, automate);break;
            case 52: c = new Classique52(caseMetier, automate);break;
            case 53: c = new Classique53(caseMetier, automate);break;
            case 54: c = new Classique54(caseMetier, automate);break;
            case 55: c = new Classique55(caseMetier, automate);break;
            case 56: c = new Classique56(caseMetier, automate);break;
            case 57: c = new Salon57(caseMetier, automate);break;
            case 58: c = new SalleAManger58(caseMetier, automate);break;
            case 59: c = new Classique59(caseMetier, automate);break;
            case 60: c = new Classique60(caseMetier, automate);break;
            case 61: c = new Classique61(caseMetier, automate);break;
            case 62: c = new Classique62(caseMetier, automate);break;
            case 63: c = new Classique63(caseMetier, automate);break;
            case 64: c = new Classique64(caseMetier, automate);break;
            case 65: c = new Classique65(caseMetier, automate);break;
            case 66: c = new Classique66(caseMetier, automate);break;
            case 67: c = new Classique67(caseMetier, automate);break;
            case 68: c = new Classique68(caseMetier, automate);break;
            case 69: c = new Classique69(caseMetier, automate);break;
            case 70: c = new Classique70(caseMetier, automate);break;

        }
        return c;
    }

}
