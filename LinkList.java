public class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

    /*
     * public LinkList() {
     * after = null;
     * }
     */

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(double dd) {
        Link newLink = new Link(dd);
        newLink.setNext(first);
        first = newLink;
        /* System.out.println("DONE"); */
    }

    public void insertLast(double dd) {
        Link current = first; // current (actual) es una variable temporal de tipo link
        if (isEmpty()) {
            insertFirst(dd);
        } else {
            while (current != null) {
                if (current.getNext() == null) {
                    Link newLink = new Link(dd);
                    newLink.setNext(null);
                    current.setNext(newLink); // enlazo la lista
                    current = null;
                } else {
                    current = current.getNext();
                    /* current.setNext(current.getNext()); */
                }
            }
        }
    }

    public Link deleteFirst() {
        Link temp = null;
        if (!isEmpty()) {
            temp = first;

            first.setNext(first.getNext());
            // first = first.getNext();
        }
        return temp;
    }

    public Link deleteLast() {
        Link temp = null;
        Link current = first;
        while (current != null) {
            if (current.getNext().getNext() == null) {
                temp = current.getNext(); // guardo la variable que voy a borrar
                current.setNext(null);
                ; // despues de current estará null (el final)
                current = null; // es como borrar mi variable
            } else {
                current = current.getNext();
            }
        }

        return temp;
    }

    // borrar un elemento dado un valor y dado una posición,
    // queremos saber el numero de elementos de una lista

    public void displayList() {
        System.out.print("List (first--> ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
            // current.setNext(current.getNext());
        }
        System.out.println("<--last)");
    }

    public Link find(double value) {
        Link current = first;
        while (current.getDData() != value) {
            if (current.getNext() == null) {
                return null;
            } else {
                current = current.getNext();
            }
        }
        return current;

    }

    public int findPosition(double value) {
        Link current = first;
        int cont = 0;
        if (isEmpty()) {
            return -1;
        } else {
            while (current != null) {
                if (current.getDData() == value) {
                    return cont;
                } else {
                    cont++;
                    current = current.getNext();
                }
            }

        }
        return -1;

    }

    public int size() {

        Link current = first;
        int cont = 0;
        while (current != null) {
            cont++;
            current = current.getNext();
        }
        return cont;

    }

    public double getElementAt(int index) {
        Link current = first;
        int cont = 0;
        while (current != null) {
            if (cont == index) {
                return current.getDData();
            } else {
                cont++;
                current = current.getNext();
            }
        }
        return -1;
    }

    public void deleteAt(int index) {
        Link current = first;
        if (isEmpty()) {
            return;
        }
        // caso cuando se el primer elemento de la lista en eliminar
        if (index == 0) {
            first = current.getNext();
        }
        // se almacena el elemento previo a eliminar
        for (int i = 0; current != null && i < index - 1; i++) {
            current = current.getNext();

        }
        // el indice es mayor al numero de elementos
        if (current == null || current.getClass() == null) {
            return;
        }
        // current.getNext es el elemento a eliminar
        // almacenamos en una variable temporal el elemento anterior
        Link temp = current.getNext().getNext();
        current.setNext(temp);

    }
}
