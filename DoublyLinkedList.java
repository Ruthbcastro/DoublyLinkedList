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

    //1
    public T getFirst() {
        return first.getDData();
    }

    //1
    public T getLast() {
        return last.getDData();
    }

    //2
    public int getSize() {
        int cont = 0;
        DoublyLink<T> current = first;
        while (current != null) {
            current = current.getNext();
            cont++;
        }
        return cont;
    }

    //3
    //4

    
    //5

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
    
    //6
    public DoublyLink<T> deleteKey(T key) {
        DoublyLink<T> current = first;
        while (current.getDData() != key) {
            current = current.getNext();
            if (current == null)
                return null;
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
        return current;
    }
    //7
    //8
    //9
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

    public DoublyLink<T> deleteLast(){
        DoublyLink<T> temp = last;
        if(first.getNext() == null)
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

    
}