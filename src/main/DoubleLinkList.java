package main;

class Node {
    int data;
    Node next;
    Node previous;
}

public class DoubleLinkList {
    Node head;
    int size;

    public static void main(String[] args) {
        DoubleLinkList obj = new DoubleLinkList();
        for (int i = 0; i < 5; i++) {
            Node node = new Node();
            node.data = (i + 1) * 100;
            obj.insert(node);
        }
        obj.display();
        obj.delete();
    }

    void insert(Node node) {
        System.out.println("inserting node" + node.data + "at last");
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            node.previous = temp;
            temp.next = node;
        }
    }

    void display() {
        System.out.println("Doubly LinkedList");
        Node temp = head;
        System.out.println("null<-->");
        while (temp != null) {
            System.out.println(temp.data + "<--->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    void delete() {
        if (head == null) {
            System.out.println("empty list");
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            System.out.println("deleting node" + temp.data + "from last");
            temp = temp.previous;
            temp.next = null;
        }
    }

    boolean search(Node node) {
        boolean response = false;
        Node temp = head;
        while (temp != null) {
            if (temp.data == node.data) {
                response = true;
                break;
            }
            temp = temp.next;
        }
        return response;
    }

    void insertAtBeginning(Node node) {
        System.out.println("inserting node" + node.data + "at beginning");
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head.previous = node;
            head = node;
        }
        size++;
    }

    void deletingFromBeginning() {
        System.out.println("deleting node" + head.data + "from beginning");
        head = head.next;
        head.previous = null;
    }
}
