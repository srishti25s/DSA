/**
 * 
 */
package queue;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Srishti Srivastava
 *
 */
public class CircularQueue<Item> implements QueueInterface<Item> {

	private final static int MAX = 10;
	@SuppressWarnings("unchecked")
	Item[] queue = (Item[]) new Object[MAX];
	int first = 0, last = 0, size = 0;

	@Override
	public void enqueue(Item item) throws Exception {
		if(size() == MAX) throw new Exception("Queue Overflow");
		if(last == MAX) last = 0;
		if(queue[last] == null) queue[last++] = item;
		size++;
	}

	@Override
	public Item dequeue() {
		if (isEmpty())
			throw new NoSuchElementException("Queue underflow");
		Item removed = queue[first];
		queue[first] = null;
		first++;
		if (first == last) {
			Item item = queue[first];
			queue[first] = null;
			first = 0;
			last = 0;
			queue[first] = item;
		}
		size--;
		return removed;
	}

	@Override
	public boolean isEmpty() {
		return (queue[first] == null);
	}

	@Override
	public int size() {
		return size;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CircularQueue<Integer> queue = new CircularQueue<>();
		while (true) {
			System.out.println("MENU\n1.Enqueue\n2.Dequeue\n3.isEmpty\n4.Size\nEnter your choice(1/2/3/4) : ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the value to be inserted : ");
				int a = sc.nextInt();
				try {
					queue.enqueue(a);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println(queue.dequeue() + " removed!");
				break;
			case 3:
				System.out.println(queue.isEmpty());
				break;
			case 4:
				System.out.println(queue.size());
				break;
			default:
				break;
			}
		}
	}

}
