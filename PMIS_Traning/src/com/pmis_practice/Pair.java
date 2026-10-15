package genericexample.com;
// Multi type parameters
class gen1<K, V> {
    private K key;
    private V value;

    public gen1(K key, V value) {
       this.key = key;
        this.value = value;
   }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
   }
}

class Pair{
    public static void main(String[] args){
        gen1<String, Integer> p = new gen1<>("Age", 25);

        String k = p.getKey();
        Integer v = p.getValue();

        System.err.println(k + ":" + v);
    }
}