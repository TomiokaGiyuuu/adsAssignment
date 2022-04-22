public class MyStack<T extends Comparable<T>> {
    MyLinkedList<T> list = new MyLinkedList<T>();

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int size(){
        return list.size();
    }

    public T peek(){
        return list.getLast();
    }

    public T push(T data){
        list.add(data);
        return data;
    }

    public T pop(){
        return list.removeLast();
    }
}
