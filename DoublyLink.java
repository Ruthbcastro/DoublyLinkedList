public class DoublyLink<T> {
    private T dData;
    private DoublyLink next;
    private DoublyLink previous;

    // para cuando no hay nodos
    public DoublyLink(T dd) {
        this(dd, null, null);
    }

    public DoublyLink(T dd, DoublyLink next, DoublyLink previous) {
        this.dData = dd;
        this.next = next;
        this.previous = previous;
    }
    /*
     * public DoublyLink(T dd) {
     * }
     */

    public T getDData() {
        return this.dData;
    }

    public void setDData(T dData) {
        this.dData = dData;
    }

    public DoublyLink getNext() {
        return this.next;
    }

    public void setNext(DoublyLink next) {
        this.next = next;
    }

    public DoublyLink getPrevious() {
        return this.previous;
    }

    public void setPrevious(DoublyLink previous) {
        this.previous = previous;
    }

    public void displayLink() {
        System.out.print(dData + ",");
    }

}
