public class MyLinkedListUse {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        System.out.println(list);

        list.removeFirst();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);

        list.addFirst(4);
        list.addFirst(5);
        list.addFirst(6);
        System.out.println(list.get(2));

        list.add(2, 7);
        System.out.println(list);

        list.remove(2);
        System.out.println(list);
    }
}
