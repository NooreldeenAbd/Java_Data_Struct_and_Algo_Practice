import java.util.NoSuchElementException;

public class LinkedList {

    private class Node {
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    private boolean isEmpty(){
        return first == null;
    }

    private Node getPrevious(Node node){
        var current = first;
        while (current != null){
            if (current.next == node)
                return current;
            current = current. next;
        }
        return null;
    }



    public void  addFirst (int item){
        var node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }


    public  void  addLast (int item){
        var node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }


    public int  indexOf (int item){
        int index = 0;

        if (isEmpty())
            return -1;

        var current = first;

        while (current != null){
            if (current.value == item)
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }



    public void  deleteFirst () {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last){
            first = last = null;
            size =0;
            return;
        }

       var second = first.next;
       first.next = null;
       first = second;

        size--;
    }


    public void  deleteLast (){
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last){
            first = last = null;
            size =0;
            return;
        }

        var pre = getPrevious(last);
        last = pre;
        last.next = null;
        size--;
    }


    public boolean  contains (int item){
        return indexOf(item) != -1;
    }

    public int  size (){
        return size;
    }

}
