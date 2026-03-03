package ADT;

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


    }
}
