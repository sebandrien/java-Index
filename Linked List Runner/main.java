public class LinkedListRunner {

    public static void main(String[] args) {
        LinkedList<String> lst = new LinkedList<>();

        lst.insert("A");
        lst.insert("B");
        lst.insert("C");
        lst.insert("D");

        System.out.println(lst.toString());

        lst.remove("A");
        System.out.println(lst.toString());

        lst.clear();
        System.out.println(lst.toString());

        System.out.println("Creating a new list...");

        LinkedList<Integer> lst2 = new LinkedList<>();

        lst2.insert(0);
        lst2.insert(1);
        lst2.insert(7, 99); 
        lst2.insert(5);
        lst2.insert(4, 1); 
        lst2.insert(8, 3); 
        System.out.println(lst2.toString());
    }
}

class Node<T> {
    Node<T> next;
    T data;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList<T> {

    private int length;
    private Node<T> head;

    LinkedList() {
        this.head = null;
        this.length = 0;
    }

    void insert(T data) {
        Node<T> n = new Node<>(data);
        if (head == null) {
            head = n;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
        }
        this.length++;
    }

    void insert(int position, T data) { 
        if (position < 1 || position > this.length + 1) {
            System.out.println("Insert out of range!");
            return;
        }

        Node<T> n = new Node<>(data);
        if (position == 1) {
            n.next = head;
            head = n;
        } else {
            Node<T> temp = head;
            for (int i = 2; i < position; i++) {
                temp = temp.next;
            }
            n.next = temp.next;
            temp.next = n;
        }
        this.length++;
    }

    void remove(T data) {
        if (head == null) return;
        if (head.data.equals(data)) {
            head = head.next;
            this.length--; 
        } else {
            Node<T> temp = head;
            while (temp.next != null && !temp.next.data.equals(data)) {
                temp = temp.next;
            }
            if (temp.next != null) {
                temp.next = temp.next.next;
                this.length--; 
            }
        }
    }

    void clear() {
        this.head = null;
        this.length = 0;
    }

    int length() {
        return this.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<T> temp = head;
        while (temp != null) {
            result.append(temp.data);
            if (temp.next != null) {
                result.append(" ---> ");
            }
            temp = temp.next;
        }
        return result.toString();
    }
}
