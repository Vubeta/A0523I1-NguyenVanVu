package ss10_list;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    public MyLinkedList() {
    }

    public void add(int index, E element) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Invalid value");
        }

        if (index == 0) {
            addFirst(element);
            return;
        }

        Node temp = head;
        Node holder;

        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(E e) {
        Node temp = head;
        head = new Node(e);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E e) {
        Node temp = head;
        for (int i = 0; i < numNodes - 1; i++) {
            temp = temp.next;
        }
        temp.next = new Node(e);
        numNodes++;
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Invalid value");
        }

        Node temp = head;
        Node holder;

        if (index == 0) {
            head = head.next;
            numNodes--;
            return (E) temp.getData();
        }

        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        holder = temp.next;
        temp.next = temp.next.next;
        numNodes--;
        return (E) holder.getData();
    }

    public boolean remove(Object e) {
        Node temp = head;

        //use temp.data to specify object which variable 'temp' saved
        if (e.equals(temp.getData())) {
            head = temp.next;
            numNodes--;
            return true;
        }

        for (int i = 0; i < numNodes - 1; i++) {
            if (e.equals(temp.next.getData())) {
                temp.next = temp.next.next;
                numNodes--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int size() {
        return numNodes;
    }

    public MyLinkedList<E> clone() {
        MyLinkedList<E> newElements = new MyLinkedList<>();
        newElements.numNodes = this.numNodes;

        if (this.head != null) {
            Node current = this.head;
            Node newCurrent = new Node(current.getData());
            newElements.head = newCurrent;

            while (current.next != null) {
                current = current.next;
                Node newNode = new Node(current.getData());
                newCurrent.next = newNode;
                newCurrent = newNode;
            }
        }

        return newElements;
    }

    public boolean contains(E o) {
        Node temp = head;

        for (int i = 0; i < numNodes; i++) {
            if (o.equals(temp.getData())) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    public int indexOf(E o) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (o.equals(temp.getData())) {
                return 1;
            }
            temp = temp.next;
        }
        return -1;
    }

    public boolean add(E e) {
        add(numNodes, e);
        return true;
    }

    public E get(int i) {
        if (i < 0 || i >= numNodes) {
            throw new IndexOutOfBoundsException("Invalid value");
        }

        Node temp = head;
        for (int j = 0; j < i; j++) {
            temp = temp.next;
        }
        return (E) temp.getData();
    }

    public E getFirst() {
        if (numNodes == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        return get(0);
    }

    public E getLast() {
        if (numNodes == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        return get(numNodes - 1);
    }

    public void clear() {
        head = null;
        numNodes = 0;
    }

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }
}

class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> newList = new MyLinkedList<>();
        newList.add(0, 3);
        newList.add(1, 7);
        newList.add(2, 11);
        newList.add(3, 17);

        System.out.println(newList.contains(11));
        System.out.println(newList.contains(13));

        System.out.println(newList.remove((Integer) 11));

        for (int i = 0; i < newList.size(); i++) {
            System.out.println("newList[" + i + "] is " + newList.get(i));
        }
    }
}