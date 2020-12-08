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
public class Queue {

	String item;
	Queue next;

	Queue front;
	Queue rear;

	int n = 0;

	public Queue() {
		super();
	}

	public Queue(String item, Queue next) {
		super();
		this.item = item;
		this.next = next;
	}

	void enqueue(String item) {
		Queue newNode = new Queue(item, null);
		if (isEmpty()) {
			front = newNode;
			rear = newNode;
		} else {
			newNode.next = front;
			front = newNode;
		}
		n++;
	}

	String dequeue() {
		if (isEmpty())
			throw new NoSuchElementException("Queue underflow");
		Queue pointer = front;
		while (pointer.next.next != null) {
			pointer = pointer.next;
		}
		String removed = pointer.next.item;
		pointer.next = null;
		rear = pointer;
		n--;
		return removed;
	}

	boolean isEmpty() {
		return (front == null);
	}

	int size() {
		return n;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue queue = new Queue();
		char choice = 'n';
		do {
			System.out.println("MENU\n1.Enqueue\n2.Dequeue\n3.isEmpty\n4.Size\nPlease enter your choice(1/2/3/4) : ");
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				System.out.println("Enter the element to be added : ");
				queue.enqueue(sc.next());
				break;
			case 2:
				System.out.println(queue.dequeue());
				break;
			case 3:
				System.out.println(queue.isEmpty());
				break;
			case 4:
				System.out.println(queue.size());
				break;

			default:System.out.println("Wrong input!!");
				break;
			}
			System.out.println("Do you want to perform any other operations? (y/n) : ");
			choice = sc.next().charAt(0);
		} while (choice == 'y');
	}

}
