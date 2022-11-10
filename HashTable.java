package hash;


/**
 * Hash Table implementation. Uses linear probing to resolve collisions.
 * @author Mark Floryan
 *
 * @param <K>
 * @param <V>
 */
public class HashTable<K,V> implements Map<K,V>{

	private static final int INITIAL_CAP = 100000;

	/* The array of objects and related things */
	private HashNode<K,V>[] table;
	
	/* YOU WILL LIKELY WANT MORE PRIVATE VARIABLES HERE */
	private int capacity;
	private int numFilled;
	private double loadFactor = 0.75;
	int collisions;
	private HashNode<K,V>sentinal = new HashNode<K, V>(null, null);
	
	public HashTable() {
		this(INITIAL_CAP);
	}
	
	
	
	public HashTable(int initialCapacity) {
		/* TODO: IMPLEMENT THIS METHOD */
		table =  (HashNode<K,V>[])new HashNode[initialCapacity];
		capacity = initialCapacity;
		numFilled = 0;
	}

	
	public int Collisions() {
		return collisions;
	}
	
	@Override
	public void insert(K key, V value) {
		/* TODO: IMPLEMENT THIS METHOD */
		HashNode <K,V>newNode = new HashNode<K,V>(key, value);
		int hashIndex = (Math.abs(key.hashCode())) % capacity;
		int probe = 0;
		
		while(table[(hashIndex + probe*probe)%capacity] != null) {
			if(table[(hashIndex + probe*probe)%capacity].equals(newNode)) break;
			collisions++;
			probe++;
		}
		
		table[(hashIndex + probe*probe)%capacity]= newNode;
		numFilled++;
		
		if( (double)numFilled/capacity > loadFactor) {
			rehash();
		}
		
		
		
	}

	@Override
	public V retrieve(K key) {
		/* TODO: IMPLEMENT THIS METHOD */
		int hashIndex = (Math.abs(key.hashCode())) % capacity;
		int secondHash = 69 - (Math.abs(key.hashCode()) % capacity);
		int probe = 0;
		while(table[(hashIndex + probe*probe)%capacity] != null) {
			if(table[(hashIndex + probe*probe)%capacity].getKey() != null) {
				if(table[(hashIndex + probe*probe)%capacity].getKey().equals(key)) {
					return table[(hashIndex + probe*probe)%capacity].getValue();
				}
			}
			collisions++;
			probe++;
		}
		return null;
	}

	@Override
	public boolean contains(K key) {
		/* TODO: IMPLEMENT THIS METHOD */
		V hold = retrieve(key);
		if(hold == (null)) {
			return false;
		}
		return true;
	}

	@Override
	public void remove(K key) {
		/* TODO: IMPLEMENT THIS METHOD */
		int probing;
		int a = 0;
		
		if(contains(key) == false) {
			return;
		}
		
		probing = (Math.abs(key.hashCode()) + 17*a) % capacity;
		
		while(table[probing] != null && !table[probing].getKey().equals(key)) {
			a++;
			probing = (probing + 17*a) % capacity;
		}
		
		table[probing] = sentinal;
		numFilled--;
	}
	
	public void rehash() {
		HashNode<K,V>[] newtable = this.table;
		table  = new HashNode[capacity*2];
		numFilled = 0;
		for(int i = 0; i < newtable.length; i++) {
			if(newtable[i] != null && newtable[i]!= sentinal) {
				insert(newtable[i].getKey(), newtable[i].getValue());
			}
		}
		
	}
	
}
