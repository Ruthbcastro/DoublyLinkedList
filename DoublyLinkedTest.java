public class DoublyLinkedTest {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> theList = new DoublyLinkedList<Integer>();
        theList.insertLast(22);
        theList.insertLast(44);
        theList.insertLast(66);
        theList.insertLast(77);
        theList.insertLast(88);
        theList.insertLast(99);
        
        theList.updateOldtoNew(23, 66);

        theList.displayForward();
        

    }
}