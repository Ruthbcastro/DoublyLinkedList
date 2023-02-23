

public class DoublyLinkedTest {
/**
 * @param args
 * Main method to test the DoublyLinkedList class
 */
    public static void main(String[] args) {
        DoublyLinkedList<Integer> theList = new DoublyLinkedList<Integer>();
        theList.insertLast(22);
        theList.insertLast(33);
        theList.insertInOrder(30);
        
        theList.displayForward();

    }
}