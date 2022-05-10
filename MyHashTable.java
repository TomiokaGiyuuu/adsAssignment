public class MyHashTable<K, V> {

    /////////////////////////////
    private class HashNode<K, V>{
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }
    /////////////////////////////

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size = 0;

    public MyHashTable(){
        chainArray = new HashNode[M];
    }

    public MyHashTable(int M){
        this.M = M;
        chainArray = new HashNode[M];
    }

    public int getSize(){
        return size;
    }

    private int hash(K key){
        int result = 18;

        result = (31 * result + key.hashCode());

        return result;
    }

    public void put(K key, V value){
        int index = getIndex(key);
        int hashCodeOfKey = hash(key);

        HashNode<K, V> temp = new HashNode<K, V>(key, value);

        if(chainArray[index] == null){
            chainArray[index] = temp;
            size++;
            return;
        }

        HashNode<K, V> head = chainArray[index];

        while (head != null){
            if(hash(head.key) == hashCodeOfKey){
                head.value = value;
                return;
            }
            head = head.next;
        }

        head = chainArray[index];
        temp.next = head;
        chainArray[index] = temp;
        size++;
    }

    public K getKey(V value){

        for(int i = 0; i < M; i++){
            HashNode<K, V> head = chainArray[i];
            while (head != null){
                if(head.value == value){
                    return head.key;
                }
                head = head.next;
            }
        }

        return null;
    }

    public V get(K key){
        int index = getIndex(key);
        int hashCodeOfKey = hash(key);

        HashNode<K, V> head = chainArray[index];

        while (head != null){
            if(hash(head.key) == hashCodeOfKey){
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    public V remove(K key){
        int index = getIndex(key);
        int hashCodeOfKey = hash(key);

        HashNode<K, V> head = chainArray[index];
        HashNode<K, V> prev = null;

        while(head != null){
            if(hash(head.key) == hashCodeOfKey){
                break;
            }
            prev = head;
            head = head.next;
        }

        if(head == null){
            return null;
        }
        if(prev != null){
            prev.next = head.next;
        } else {
            chainArray[index] = head.next;
        }

        size--;
        return head.value;
    }

    public boolean contains(V value){

        for(int i = 0; i < M; i++){
            HashNode<K, V> head = chainArray[i];

            while(head != null){
                if(head.value.equals(value)){
                    return true;
                }
                head = head.next;
            }
        }

        return false;
    }


    //CUSTOM METHODS
    private int getIndex(K key){
        int index = hash(key) % M;
        if(index < 0){
            index = index * -1;
        }
        return index;
    }
}
