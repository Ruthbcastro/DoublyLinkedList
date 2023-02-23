
/**
 * @author Julian Chan Palomo
 * @author Ruth Castro Acosta
 */
public class DoublyLink<T> {
    private T dData;
    private DoublyLink<T> next;
    private DoublyLink<T> previous;

    // para cuando no hay nodos
    public DoublyLink() {
        this(null, null, null);
    }

    public DoublyLink(T dd) {
        this(dd, null, null);
    }

    public DoublyLink(T dd, DoublyLink<T> next, DoublyLink<T> previous) {
        this.dData = dd;
        this.next = next;
        this.previous = previous;
    }

    public T getDData() {
        return this.dData;
    }

    public void setDData(T dData) {
        this.dData = dData;
    }

    public DoublyLink<T> getNext() {
        return this.next;
    }

    public void setNext(DoublyLink<T> next) {
        this.next = next;
    }

    public DoublyLink<T> getPrevious() {
        return this.previous;
    }

    public void setPrevious(DoublyLink<T> previous) {
        this.previous = previous;
    }

    public void displayLink() {
        System.out.print(dData + ",");
    }

}
