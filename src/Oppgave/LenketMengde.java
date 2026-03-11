import ADT.MengdeADT;


public class LenketMengde <T> implements MengdeADT<T> {

    private Node<T> head;
    private int size;

    //Indre node klasse
    private static class Node<T> {
        T data;
        Node<T> next;


        Node(T data) {
            this.data = data;
            this.next = null;
        }

    }

    //konstruktør
    public LenketMengde() {
        head = null;
        size = 0;
    }

    @Override
    public boolean erTom() {
        return head == null;
    }

    @Override
    public boolean inneholder(T element) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(element))
                return true;
            current = current.next;
        }
        return false;
    }


    @Override
    public boolean erDelmengdeAv(MengdeADT<T> element) {

        Node<T> current = head;

        while (current != null) {
            if (!element.inneholder(current.data)) {
                return false;
            }

            current = current.next;
        }

        return true;

    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        if (antallElementer() != annenMengde.antallElementer())
            return false;
        return erDelmengdeAv(annenMengde);
    }


    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        Node<T> current = head;

        while (current != null) {
            if (annenMengde.inneholder(current.data)) {
                return false;
            }
            current = current.next;

        }
        return true;

    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {

        MengdeADT<T> resultat = new LenketMengde<>();

        Node<T> current = head;

        while (current != null) {

            if (annenMengde.inneholder(current.data)) {
                resultat.leggTil(current.data);
            }

            current = current.next;


        }

        return resultat;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {

        MengdeADT<T> resultat = new LenketMengde<T>();

        Node<T> current = head;

        while (current != null) {
            resultat.leggTil(current.data);
            current = current.next;
        }

        resultat.leggTilAlleFra(annenMengde);
        return resultat;
    }






    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {

        MengdeADT<T> resultat = new LenketMengde<>();

        Node<T> current = head;

        while (current != null) {
            if (!annenMengde.inneholder(current.data)) {
                resultat.leggTil(current.data);
            }
            current = current.next;
        }

        return resultat;

    }

    @Override
    public void leggTil(T element) {
        if (!inneholder(element)) {

            Node<T> newNode = new Node<>(element);

            if (head == null) {
                head = newNode;
            } else {

                Node <T> current = head;
                while (current.next !=null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            size++;

        }
    }

    @Override
    public void leggTilAlleFra(MengdeADT <T> annenMengde) {

        T [] elements = annenMengde.toTabell();
        for (T element : elements) {
            leggTil(element);
        }
    }

    @Override
    public T fjern(T element) {
        if (head == null) {
            return null;
        }


        if (head.data.equals(element)) {
            T removed = head.data;
            head = head.next;
            size--;

            return removed;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.equals(element)) {
                T removed = current.next.data;
                current.next = current.next.next;
                size--;
                return removed;
            }
            current = current.next;

        }

        return null;

    }

    @SuppressWarnings("unchecked")
    public T[] toTabell() {
        T[] tabell = (T[]) new Object[size];

        Node<T> current = head;
        int index = 0;

        while (current != null) {
            tabell[index] = current.data;
            index++;
            current = current.next;
        }
        return tabell;
    }

    public int antallElementer() {
        return size;
    }


}