package leetcode;

/*
* Входящие параметры: Node1 -> Node2 -> Node3 -> null;
* null <- Node1 <- Node2
*
* Результат: Node3 -> Node2 -> Node1 -> null;
* */
class OtpMain {

    public static void main(String[] args) {
        Node node1 = new Node("node1");
        Node node2 = new Node("node2");
        Node node3 = new Node("node3");

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        Node invertedList = invert(node1);

        while (invertedList != null) {
            System.out.println(invertedList.getName());
            invertedList = invertedList.next;
        }
    }

    public static Node invert(Node list) {
        Node previous = null;
        Node current = list;
        Node next;

        while (current != null) {
            next = current.next; // Node2
            current.next = previous; // null <- Node1
            previous = current;
            current = next;
        }

        return previous;
    }

    public static class Node {
        public Node next;

        public String getName() {
            return name;
        }

        private final String name;

        public Node(String name) {
            this.name = name;
        }
    }
}
