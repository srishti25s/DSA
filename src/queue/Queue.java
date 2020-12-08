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
public class Queue<Item> implements QueueInterface<Item>{

	class Node{
		Item item;
		Node next;
	}

	Node first, last;
	int size;
	

	public Queue() {
		this.size = 0;
	}


	@Override
	public void enqueue(Item item) {
		Node prevLast = last;
		last.item = item;
		last.next = null;
		if(prevLast == null) {
			first = last;
		}else {
			prevLast.next = last;
		}
		size++;
	}

	@Override
	public Item dequeue() {
		if(isEmpty()) throw new NoSuchElementException("Queue underflow");
		Node prevFirst = first;
		first = first.next;
		size--;
		if(isEmpty()) last = null;
		return prevFirst.item;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
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
