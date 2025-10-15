public class LinkedList {
    private static class Node {
        String value = null;
        Node next = null;
    }

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void prepend(String value) {
        Node node = new Node();
        node.value = value;

        if (this.head == null) this.head = node;
        else {
            node.next = this.head;
            this.head = node;
        }
    }

    public void append(String value) {
        Node node = new Node();
        node.value = value;

        if (this.head == null) this.head = node;
        else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }

    public String print() {
        Node current = this.head;
        String printedList = "[HEAD] ";
        while (current != null) {
            printedList += current.value + " -> ";
            current = current.next;
        }
        printedList += "[NULL]";
        return printedList;
    }

    static void main() {
        LinkedList list = new LinkedList();
        list.append("test2");
        list.append("test3");
        list.prepend("test1");
        list.prepend("test0");
        list.append("test4");
        list.append("test5");

        System.out.println(list.print());
    }

}
