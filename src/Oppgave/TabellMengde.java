package Oppgave;
import ADT.MengdeADT;

public class TabellMengde<T> implements MengdeADT<T> {
 private static final int DEFAULT_KAPASITET = 100;
 private T[] tabell;
 private int antall;

 public TabellMengde(){this(DEFAULT_KAPASITET);}

 public TabellMengde(int kapasitet){
     antall = 0;
     tabell = (T[]) new Object[kapasitet];

 }
   @Override
    public boolean erTom() {
        return antall == 0;
    }

    @Override
    public boolean inneholder(T element) {

      for(int i = 0; i < antall; i++){
          if(element.equals(tabell[i])){return true;}
      }
      return false;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {

     for(int i = 0; i < antall;i++){
         if(!annenMengde.inneholder(tabell[i])) return false;
     }
     return true;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {

     return this.erDelmengdeAv(annenMengde) && annenMengde.erDelmengdeAv(this);

    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        for(int i = 0; i < antall;i++){
            if(annenMengde.inneholder(tabell[i])) return false;
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
     MengdeADT<T> nyTabell = new TabellMengde<>();

     for(int i = 0; i < antall; i++){
         if(annenMengde.inneholder(tabell[i])){
             nyTabell.leggTil(tabell[i]);
         }
     }
  return nyTabell;
 }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
     MengdeADT<T> nyTabell = new TabellMengde<>();

     nyTabell.leggTilAlleFra(this);
     nyTabell.leggTilAlleFra(annenMengde);

     return nyTabell;
  }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        MengdeADT<T> nyMengde = new TabellMengde<>();

        for(int i = 0; i < antall; i++){

            if(!annenMengde.inneholder(tabell[i])){
                nyMengde.leggTil(tabell[i]);

            }


        }
        return nyMengde;

    }

    @Override
    public void leggTil(T element) {

         if(!inneholder(element)){
             tabell[antall]=element;
             antall++;
         }
     }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {

     T[] nyTabell = annenMengde.tilTabell();

     for(int i = 0; i < nyTabell.length; i++){
         leggTil(nyTabell[i]);

     }

    }

    @Override
    public T fjern(T element) {
        T skalFjernes = null;

        int funnetIndeks = -1;
        int i = 0;
        while (i < antall && funnetIndeks == -1) {
            if (element.equals(tabell[i])) {
                funnetIndeks = i;
            }
            i++;

        }
        if (funnetIndeks == -1) {return null;}

        skalFjernes = tabell[funnetIndeks];
        tabell[funnetIndeks] = tabell[antall - 1];
        tabell[antall - 1] = null;
        antall--;


        return skalFjernes;


 }

    @Override
    public T[] tilTabell() {
     T[] nyTabell = (T[])new Object[antall];

     for (int i = 0; i < antall; i++){
         nyTabell[i] = tabell[i];
     }
     return nyTabell;

    }

    @Override
    public int antallElementer() {
        return antall;
    }
}
