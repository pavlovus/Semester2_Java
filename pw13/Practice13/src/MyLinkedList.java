public class MyLinkedList<T> {
    private Node<T> head;

    public void addFirst(T data) {
        head = new Node<>(data, head);
    }

    public void addLast(T data) {
        if (head == null) {
            addFirst(data);
            return;
        }
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node<>(data, null);
    }

    public void add(int position, T data) {
        if (position < 0) {
            throw new IllegalArgumentException("Позиція не може бути від'ємною!!!");
        }
        if (position == 0) {
            addFirst(data);
            return;
        }
        Node<T> current = head;
        int currentPosition = 0;
        while (current != null && currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Позиція " + position + " виходить за межі!!");
        }
        Node<T> newNode = new Node<>(data, current.next);
        current.next = newNode;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Список пустий!!!");
        }
        T data = head.data;
        head = head.next;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Список пустий!!!");
        }
        if (head.next == null) {
            removeFirst();
        }
        Node<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        T data = current.next.data;
        current.next = null;
    }

    public void remove(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("Позиція не може бути від'ємною!!!");
        }
        if (isEmpty()) {
            throw new NoSuchElementException("Список пустий!!!");
        }
        if (position == 0) {
            removeFirst();
        }
        Node<T> current = head;
        int currentPosition = 0;
        while (current != null && currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }
        if (current == null || current.next == null) {
            throw new IndexOutOfBoundsException("Позиція " + position + " виходить за межі!!");
        }
        T data = current.next.data;
        current.next = current.next.next;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Список пустий!!!");
        }
        return head.data;
    }

    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Список пустий!!!");
        }
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    public T get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Індекс не може бути від'ємний!!!");
        }
        Node<T> current = head;
        int currentIndex = 0;
        while (current != null) {
            if (currentIndex == index) {
                return current.data;
            }
            current = current.next;
            currentIndex++;
        }
        throw new IndexOutOfBoundsException("Індекс виходить за межі!!!");
    }

    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public String toString() {
        String s = "";
        for(Node temp = head; temp != null; temp = temp.next){
            s = temp + "\n" + s;
        }
        return s;
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
