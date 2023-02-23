public class Link {
    private double dData;
    private Link next;

    public Link(double dd) {
        dData = dd;
    }

    public void displayLink() {
        System.out.print("{" + dData + "} ");
    }


    public double getDData() {
        return this.dData;
    }

    public void setDData(double dData) {
        this.dData = dData;
    }

    public Link getNext() {
        return this.next;
    }

    public void setNext(Link next) {
        this.next = next;
    }

}
