public class MyQueue<T extends Comparable<T>> {
    MyLinkedList<T> list = new MyLinkedList<T>();

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int size(){
        return list.size();
    }

    public T peek(){
        return list.get(0);
    }

    public T enqueue(T data){
        list.add(data);
        return data;
    }

    public T dequeue(){
        T firstElem = peek();
        list.remove(0);
        return firstElem;
    }
}
