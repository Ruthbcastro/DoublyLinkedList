public class DoublyLinkedTest {
    public static void main(String[] args) {
        DoublyLinkedList theList = new DoublyLinkedList();
        theList.insertLast(22);
        theList.insertLast(44);
        theList.insertLast(66);
        theList.insertLast(77);
        theList.insertLast(88);
        theList.insertLast(99);
        /*
         * theList.insertLast(11);
         * theList.insertLast(33);
         * theList.insertLast(55);
         * theList.displayForward();
         * theList.displayBackward();
         * 
         * theList.deleteFirst();
         * theList.deleteLast();
         * theList.deleteKey(11);
         * 
         * theList.displayForward();
         * theList.insertAfter(22, 77);
         * theList.insertAfter(33, 88);
         */
        System.out.println(theList.getFirst());
        System.out.println(theList.getLast());
        System.out.println(theList.getSize());
        /*theList.displayForward();
        theList.updatedData(111, 5);
        theList.displayForward();*/

    }
}