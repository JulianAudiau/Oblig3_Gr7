import ADT.MengdeADT;
import Oppgave.TabellMengde;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TabellMengdeTest {

    MengdeADT<Integer> testTabell1 = new TabellMengde<>();
    MengdeADT<Integer> testTabell2 = new TabellMengde<>();
    MengdeADT<Integer> testTabell3 = new TabellMengde<>();
    MengdeADT<Integer> testTabell4 = new TabellMengde<>();
    MengdeADT<Integer> testTabell5 = new TabellMengde<>();



    @BeforeEach
    void nullstill(){
        testTabell1.leggTil(1);
        testTabell1.leggTil(2);
        testTabell1.leggTil(3);
        testTabell1.leggTil(4);
        testTabell1.leggTil(5);

        testTabell2.leggTil(6);
        testTabell2.leggTil(8);
        testTabell2.leggTil(10);
        testTabell2.leggTil(12);
        testTabell2.leggTil(14);

        testTabell4.leggTil(1);
        testTabell4.leggTil(2);
        testTabell4.leggTil(3);

        testTabell5.leggTil(1);
        testTabell5.leggTil(2);
        testTabell5.leggTil(3);


    }
@Test
    void erTomATest(){
  assertTrue(testTabell3.erTom());
  assertFalse(testTabell2.erTom());
    }

    @Test
    void inneholderTest(){
        assertTrue(testTabell1.inneholder(1));
        assertTrue(testTabell1.inneholder(3));
        assertFalse(testTabell1.inneholder(6));
    }

    @Test
    void erDelMengdeAvTest(){
        assertTrue(testTabell4.erDelmengdeAv(testTabell1));
        assertFalse(testTabell4.erDelmengdeAv(testTabell2));
    }
    @Test
    void erLikTest(){
        assertTrue(testTabell4.erLik(testTabell5));
        assertFalse(testTabell4.erLik(testTabell1));
    }
    @Test
    void erDisjunktTest(){
        assertTrue(testTabell1.erDisjunkt(testTabell2));
        assertFalse(testTabell1.erDisjunkt(testTabell4));
    }

    @Test
    void snittTest(){

        assertTrue(testTabell1.snitt(testTabell2).erTom());
        assertTrue(testTabell1.snitt(testTabell4).erLik(testTabell4));
    }

    @Test
    void unionTest(){
        MengdeADT <Integer> resultat = testTabell1.union(testTabell2);
        assertTrue(testTabell1.erDelmengdeAv(resultat));
        assertTrue(testTabell2.erDelmengdeAv(resultat));
    }

    @Test
    void minusTest(){
        MengdeADT <Integer> resultat = testTabell1.minus(testTabell4);
        assertFalse(testTabell4.erDelmengdeAv(resultat));
    }
    @Test
    void leggTilAlleFraTest(){
        testTabell3.leggTilAlleFra(testTabell2);
        assertTrue(testTabell2.erLik(testTabell3));
    }
    @Test
    void fjernTest(){
         testTabell1.fjern(1);
        assertFalse(testTabell1.inneholder(1));
    }
    @Test
    void tilTabellTest(){
        
    }







}
