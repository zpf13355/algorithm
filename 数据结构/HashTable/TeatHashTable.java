package HashTable;

public class TeatHashTable {
    public static void main(String[] args) {
        HashTable hashTable=new HashTable();
        hashTable.put(2);
        hashTable.put(10);
        hashTable.put(12);
        hashTable.put(43);
        hashTable.put(5);
        hashTable.put(6);
        hashTable.put(8);

        System.out.println(hashTable.contains(12));

        System.out.println(hashTable.get(10));
    }
}
