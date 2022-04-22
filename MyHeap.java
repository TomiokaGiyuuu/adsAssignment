public class MyHeap<T extends Comparable<T>> {
    MyArrayList<T> list = new MyArrayList<T>();

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int size(){
        return list.size();
    }

    public T getMax(){
        return list.get(0);
    }

    public void add(T data){
        list.add(data);
        if(list.size() > 1) {
            traverseUp(parentOf(list.size() - 1));
        }
    }

    public T removeRoot(){
        swap(0, list.size() - 1);
        list.remove(list.size() - 1);

        hiddenHeapify(0);
        return list.get(list.size() - 1);
    }

    public boolean remove(int index){
        if (index >= list.size() || index < 0)
            throw new IndexOutOfBoundsException("index should be positive and less than size");

        swap(index, 0);
        removeRoot();
        return true;
    }


    //Class methods
    private void hiddenHeapify(int index){
        if (index >= list.size() || index < 0)
            throw new IndexOutOfBoundsException("index should be positive and less than size");

        //Parent and children data
        int largest = largestOfChilds(index);

        if (largest != index){
            swap(index, largest);
            if(leftChildOf(index) >= list.size()){
                return;
            }
            hiddenHeapify(largest);
        }
    }

    private void traverseUp(int index){
        if (index >= list.size() || index < 0)
            throw new IndexOutOfBoundsException("index should be positive and less than size");

        //Parent and children data
        int largest = largestOfChilds(index);

        if (largest != index){
            swap(index, largest);
            if(parentOf(index) < 0){
                return;
            }
            traverseUp(parentOf(index));
        }
    }

    private int leftChildOf(int index){
        return index * 2 + 1;
    }

    private int rightChildOf(int index){
        return index * 2 + 2;
    }

    private int parentOf(int index){
        double result = (double)index / 2;
        return (int) (Math.ceil(result) - 1);
    }

    private void swap(int index1, int index2){
        T temp = list.get(index1);
        list.changeDataByIndex(index1, list.get(index2));
        list.changeDataByIndex(index2, temp);
    }

    //Methods for my own use
    public void displayHeap()  {
        System.out.println("PARENT LEFT  RIGHT");
        for (int k = 0; k < list.size() / 2; k++) {
            System.out.print(" " + list.get(k) + "\t\t" + list.get(leftChildOf(k)) + "\t\t" + list.get(rightChildOf(k)));
            System.out.println();
        }
    }
    private int largestOfChilds(int index){
        T parent = list.get(index);
        T leftChild = null;
        T rightChild = null;
        int largest = index;
        /////////
        if (leftChildOf(index) < list.size()){
            leftChild = list.get(leftChildOf(index));
            if((leftChild.compareTo(parent) > 0)) {
                largest = leftChildOf(index);
            }
        }
        if (rightChildOf(index) < list.size()){
            rightChild = list.get(rightChildOf(index));
            if((rightChild.compareTo(list.get(largest)) > 0)) {
                largest = rightChildOf(index);
            }
        }
        return largest;
    }

    private int hasChilds(int index){
        if (leftChildOf(index) < list.size()){
            return 1;
        }
        return 0;
    }
}