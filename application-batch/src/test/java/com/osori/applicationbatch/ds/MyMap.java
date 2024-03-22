package com.osori.applicationbatch.ds;

public class MyMap<K, V> {

    transient MapNode<K, V>[] table;

    static final int hash(Object key) {
        if (key == null) {
            return 0;
        }
        int hash = key.hashCode();
        return hash ^ (hash >>> 16); //균형있는 hash 값을 가지기 위한 상위 bit 하위 bit xor 연산
    }

    public V get(Object key) {
        MapNode<K, V> e = getNode(hash(key), key);
        return e == null ? null : e.value;
    }

    final MapNode<K, V> getNode(int hashKey, Object originalKey) {
        MapNode<K, V>[] tab = table;
        int n = tab.length;
        MapNode<K, V> first = tab[(n - 1) & hashKey];

        if (tab != null && n > 0 && first != null) {
            K k = first.key;
            //맨앞에꺼 그냥 체크해봄 얻어걸릴수도있으니까?
            if (first.hash == hashKey && (k == originalKey || (originalKey != null && originalKey.equals(k)))){
                return first;
            }

            MapNode<K, V> nextNode = first.next;
            if (nextNode != null) {
                do {
                    if (nextNode.hash == hashKey){
                        k = nextNode.key;
                        if (k == originalKey || (originalKey != null && originalKey.equals(k)))
                            return nextNode;
                    }

                } while ((nextNode = nextNode.next) != null);
            }
        }
        return null;
    }
}
