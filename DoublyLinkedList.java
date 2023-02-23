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

    public T getFirst() {
        return first.getDData();
    }

    public T getLast() {
        return last.getDData();
    }

    public int getSize() {
        int cont = 0;
        DoublyLink current = first;
        while (current != null) {
            current = current.getNext();
            cont++;
        }
        return cont;
    }

    

    public <T> void insertFirst(T dd) {
        DoublyLink<T> newLink = new DoublyLink(dd);
        if (isEmpty())
            last = newLink;
        else
            first.setPrevious(newLink);
        newLink.setNext(first);
        first = newLink;
    }

    public <T> void insertLast(T dd) {
        DoublyLink newLink = new DoublyLink(dd);
        if (isEmpty())
            first = newLink;
        else {
            last.setNext(newLink);
            newLink.setPrevious(last);
        }
        last = newLink;
    }

    public <T> DoublyLink<T> deleteFirst() {
        DoublyLink<T> temp = first;
        if (first.getNext() == null)
            last = null;
        else
            /* first.next.previous = null; */
            first.getNext().setPrevious(null);
        first = first.getNext();
        return temp;
    }

    public <T> DoublyLink<T> deleteLast() {
        DoublyLink<T> temp = last;
        if (first.getNext() == null)
            first = null;
        else
            last.getPrevious().setNext(null);
        last = last.getPrevious();
        return temp;
    }

    public <T> boolean insertAfter(T key, T dd) {
        DoublyLink current = first;
        while (current.getDData() != key) {
            current = current.getNext();
            if (current == null)
                return false;
        }
        DoublyLink newLink = new DoublyLink(dd);
        if (current == last) {
            newLink.setNext(null);
            ;
            last = newLink;
        } else {
            newLink.setNext(current.getNext());
            /* current.next.previous = newLink; */
            current.getNext().setPrevious(newLink);
        }
        /* newLink.previous = current; */
        newLink.setPrevious(current);
        ;
        current.setNext(newLink);
        return true;
    }

    public <T> DoublyLink deleteKey(T key) {
        DoublyLink current = first;
        while (current.getDData() != key) {
            current = current.getNext();
            if (current == null)
                return null;
        }
        if (current == first)
            first = current.getNext();
        else
            /* current.previous.next = current.getNext(); */
            current.getPrevious().setNext(current.getNext());
        if (current == last)
            last = current.getPrevious();
        else
            /* current.next.previous = current.getPrevious(); */
            current.getNext().setPrevious(current.getPrevious());
        return current;
    }

    public void displayForward() {
        System.out.print("List (first-->last): ");
        DoublyLink current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println("");
    }

    public void displayBackward() {
        System.out.print("List (last-->first): ");
        DoublyLink current = last;
        while (current != null) {
            current.displayLink();
            current = current.getPrevious();
        }
        System.out.println("");
    }

    public <T> void updatedData(T key, int index) {
        DoublyLink current = first;
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
}