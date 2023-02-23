/**
 * @author Julian Chan Palomo
 * @author Ruth Castro Acosta
 */
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

    /**
     * * Insert an element at the beginning of the list
     * @param dd
     */
    public void insertFirst(T dd) {
        DoublyLink<T> newLink = new DoublyLink<T>(dd);
        if (isEmpty())
            last = newLink;
        else
            first.setPrevious(newLink);
        newLink.setNext(first);
        first = newLink;
    }

    /**
     * Insert an element at the end of the list
     * @param dd
     */
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

    /**
     * Delete the first element of the list
     */
    public void deleteFirst(){
        if (first.getNext() == null)
            last = null;
        else
            first.getNext().setPrevious(null);
        first = first.getNext();
    }

    /**
     * Delete the last element of the list
     */
    public void deleteLast() {
        if (first.getNext() == null)
            first = null;
        else
            last.getPrevious().setNext(null);
        last = last.getPrevious();
    }

    /**
     * Insert an element after a given key
     * @param key
     * @param dd
     * @return boolean
     */
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

    /**
     * Display the list from the first element to the last
     */
    public void displayForward() {
        System.out.print("List (first-->last): ");
        DoublyLink<T> current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println("");
    }

    /**
     * Display the list from the last element to the first
     */
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
    /**
     * Method to get the first element of the list
     */
    public T getFirst() {
        return first.getDData();
    }

    // 1
    /**
     * Method to get the last element of the list
     */
    public T getLast() {
        return last.getDData();
    }

    // 2
    /**
     * Method to get the size of the list
     * @return cont
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
    /**
     * Method to insert an element in order
     * @param dd
     */
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
    /**
     * Method to update an element, givin the old value and the new value
     * @param oldValue
     * @param newValue
     */
    public void updateOldtoNew(T oldValue, T newValue) {
        DoublyLink<T> current = first;
        while (current != null) {
            if (current.getDData().equals(oldValue)) {
                current.setDData(newValue);
                return;
            }
            current = current.getNext();
        }
        System.out.println("Valor no encontrado");
    }

    // 5
    /**
     * Method to update an element, givin the new value and the index
     * @param key
     * @param index
     */
    public void updatedDataIndex(T dd, int index) {
        
        DoublyLink<T> current = first;
        int cont = 0;
        while (current != null) {
            if (cont == index) {
                current.setDData(dd);
            }
            current = current.getNext();
            cont++;
        }
    }

    // 6
    /**
     * Method to delete an element, givin it
     * @param key
     */
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
    /**
     * Method to delete an element, givin the index
     * @param index
     */
    public void deleteAt(int index) {
        try{
        DoublyLink<T> current = first;
        
        // caso cuando se el primer elemento de la lista en eliminar
            if (index == 0) {
                first = current.getNext();
            }
        // se almacena el elemento previo a eliminar
            for (int i = 0; current != null && i < index - 1; i++) {
                current = current.getNext();
            }

            // current.getNext es el elemento a eliminar
            // almacenamos en una variable temporal el elemento a eliminar
            /* DoublyLink<T> temp = current.getNext().getNext(); */
            current.setNext(current.getNext().getNext());
        }catch(NullPointerException | IndexOutOfBoundsException e){
            System.out.println("No existe ese indice");
        }
    }

    // 8
    /**
     * Method to delete all the elements of the list
     */
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
    /**
     * Method to find an element, givin it
     * @param value
     * @return -1 if the element is not found, or the position of the element
     * @return cont
     */
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
