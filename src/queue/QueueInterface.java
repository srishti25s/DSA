package queue;

public interface QueueInterface<Item> {
	
	void enqueue(Item item) throws Exception;
	Item dequeue();
	boolean isEmpty();
	int size();

}
