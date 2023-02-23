public class DoublyLinkedList<T> {
    private DoublyLink<T> first;
    private DoublyLink<T> last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(T dd) {
        DoublyLink<T> newLink = new DoublyLink<T>(dd);
        if (isEmpty())
            last = newLink;
        else
            first.setPrevious(newLink);
        newLink.setNext(first);
        first = newLink;
    }

    public void insertLast(T dd) {
        DoublyLink<T> newLink = new DoublyLink<T>(dd);
        if (isEmpty())
            first = newLink;
        else {
            last.setNext(newLink);
            newLink.setPrevious(last);
        }
        last = newLink;
    }

    public DoublyLink<T> deleteFirst() {
        DoublyLink<T> temp = first;
        if (first.getNext() == null)
            last = null;
        else
            /* first.next.previous = null; */
            first.getNext().setPrevious(null);
        first = first.getNext();
        return temp;
    }

    public DoublyLink<T> deleteLast() {
        DoublyLink<T> temp = last;
        if (first.getNext() == null)
            first = null;
        else
            /* last.previous.next = null; */
            last.getPrevious().setNext(null);
        last = last.getPrevious();
        return temp;
    }

    public boolean insertAfter(T key, T dd) {
        DoublyLink<T> current = first;
        while (current.getDData() != key) {
            current = current.getNext();
            if (current == null)
                return false;
        }
        DoublyLink<T> newLink = new DoublyLink<T>(dd);
        if (current == last) {
            newLink.setNext(null);
            last = newLink;
        } else {
            /* newLink.next = current.next; */
            newLink.setNext(current.getNext());
            /* current.next.previous = newLink; */
            current.getNext().setPrevious(newLink);
        }
        /* newLink.previous = current; */
        newLink.setPrevious(current);
        /* current.next = newLink; */
        current.setNext(newLink);
        return true;
    }

    public void displayForward() {
        System.out.print("List (first-->last): ");
        DoublyLink<T> current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println("");
    }

    public void displayBackward() {
        System.out.print("List (last-->first): ");
        DoublyLink<T> current = last;
        while (current != null) {
            current.displayLink();
            current = current.getPrevious();
        }
        System.out.println("");
    }

    // 1
    public T getFirst() {
        return first.getDData();
    }

    // 1
    public T getLast() {
        return last.getDData();
    }

    // 2
    /**
     * @return
     */
    public int getSize() {
        int cont = 0;
        DoublyLink<T> current = first;
        while (current != null) {
            current = current.getNext();
            cont++;
        }
        return cont;
    }

    // 3
    public void insertInOrder(T dd) {
        DoublyLink<T> newLink = new DoublyLink<T>(dd);
        DoublyLink<T> current = first;
        DoublyLink<T> previous = null;

        // Find the correct position for the new element
        while (current != null && ((Comparable) dd).compareTo((Comparable) current.getDData()) > 0) {
            previous = current;
            current = current.getNext();
        }

        // Insert the new element
        if (previous == null) {
            // The new element is the first one in the list
            first = newLink;
        } else {
            // The new element is inserted after the previous element
            previous.setNext(newLink);
            newLink.setPrevious(previous);
        }
        if (current == null) {
            // The new element is the last one in the list
            last = newLink;
        } else {
            // The new element is inserted before the current element
            current.setPrevious(newLink);
            newLink.setNext(current);
        }
    }

    // 4
    public void updateOldtoNew(T oldValue, T newValue) {
        DoublyLink<T> current = first;
        while (current != null) {
            if (current.getDData().equals(oldValue)) {
                current.setDData(newValue);
                return;
            }
            current = current.getNext();
        }
        System.out.println("Value not found.");
    }

    // 5
    public void updatedData(T key, int index) {
        DoublyLink<T> current = first;
        int cont = 0;
        if (isEmpty()) {
            return;
        }
        while (current != null) {
            if (cont == index) {
                current.setDData(key);
            }
            current = current.getNext();
            cont++;
        }
    }

    // 6
    
    public void deleteKey(T key) {
        DoublyLink<T> current = first;
        while (current.getDData() != key) {
            current = current.getNext();
        }
        if (current == first)
            first = current.getNext();
        else
            /* current.previous.next = current.next; */
            current.getPrevious().setNext(current.getNext());
        if (current == last)
            last = current.getPrevious();
        else
            /* current.next.previous = current.previous; */
            current.getNext().setPrevious(current.getPrevious());
    }

    // 7
    public void deleteAt(int index) {
        DoublyLink<T> current = first;
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
        if (current == null || current.getNext() == null) {
            return;
        } // current.getNext es el elemento a eliminar
          // almacenamos en una variable temporal el elemento a eliminar
        /* DoublyLink<T> temp = current.getNext().getNext(); */
        current.setNext(current.getNext().getNext());
    }

    // 8
    public void deleteAll() {
        DoublyLink<T> current = first;
        if (isEmpty()) {
            return;
        } else {
            while (current != null) {
                current = current.getNext();
                current.setPrevious(null);
            }
        }
    }

    // 9
    public int findPosition(T value) {
        DoublyLink<T> current = first;
        int cont = 0;
        if (isEmpty()) {
            return -1;
        } else {
            while (current != null) {
                if (current.getDData().equals(value)) {
                    return cont;
                } else {
                    cont++;
                    current = current.getNext();
                }
            }

        }
        return -1;

    }
}
