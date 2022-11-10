package queue;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A Linked-List based Queue
 * Is concurrent (i.e., can modify front and back in parallel)
 *
 * @param <T>
 */
public class ConcurrentQueue<T> implements IQueue<T>{

	
	/**
	 * Constructor: Initialize the inner list
	 */
	private LinkedList<T> cqueue;
	private Lock lock;
	private Condition condition;
	
	public ConcurrentQueue(){
		//TODO: Write this method
		cqueue = new LinkedList<T>();
		lock = new ReentrantLock();
		condition = lock.newCondition();
	}
	
	/**
	 * Return the size by invoking the size of the list
	 */
	public int size() { 
		//TODO: Write this method
		return cqueue.size();
	}
	

	/**
	 * Simply add the data to the tail of the linked list
	 */
	public void enqueue(T data) {
		//TODO: Write this method\
		lock.lock();
		try
		{
			cqueue.add(data);
			condition.signalAll();
		}
		finally {
			lock.unlock();
		}
	}
	
	/**
	 * Simply remove data from the head of the list
	 */
	public T dequeue(){	
		
		//TODO: Write this method
		T hold = null;
		lock.lock();
		try
		{
			while(size() <= 0 || cqueue.peek() == null) {
				condition.await();
			}
			hold = cqueue.poll();
		}
		catch(Exception e) {
			System.out.println("Nothing in List");;
		}
		finally
		{
			lock.unlock();
		}
		
		return hold;
		
	}
	
	
}
