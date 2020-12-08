/**
 * 
 */
package stack;

import java.util.Scanner;

/**
 * @author Srishti Srivastava
 *
 */
public class StackUsingLinkedList {

	private int node;
	private StackUsingLinkedList next;

	public StackUsingLinkedList() {

	}

	/**
	 * @param node
	 * @param next
	 */
	public StackUsingLinkedList(int node, StackUsingLinkedList next) {
		super();
		this.node = node;
		this.next = next;
	}

	private StackUsingLinkedList top;

	/**
	 * @param item
	 */
	void push(int item) {
		if (top == null) {
			top = new StackUsingLinkedList(item, null);
		} else {
			StackUsingLinkedList newNode = new StackUsingLinkedList(item, top);
			top = newNode;
		}
		System.out.println(item + " added to the stack");
	}

	/**
	 * @return last element after removing it
	 */
	int pop() {
		int popedElement = -1;
		if (isEmpty()) {
			System.out.println("Stack underflow");

		} else {
			popedElement = top.node;
			top = top.next;

		}
		return popedElement;
	}

	/**
	 * @return last element
	 */
	int peek() {
		if (isEmpty()) {
			System.out.println("Stack underflow");
			return -1;
		} else {
			return top.node;
		}
	}

	/**
	 * @return if stack is empty
	 */
	boolean isEmpty() {
		return (top == null);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackUsingLinkedList stack = new StackUsingLinkedList();
		Scanner sc = new Scanner(System.in);
		String choice = "n";
		do {
			System.out.println(
					"STACK Operations : \n 1. Push \n 2. Pop \n 3. Peek \n 4. isEmpty \n Enter your choice(1/2/3/4) :  ");
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				System.out.println("Enter the element to be pushed");
				int item = sc.nextInt();
				stack.push(item);
				break;
			case 2:
				System.out.println(stack.pop() + " popped");
				break;
			case 3:
				System.out.println(stack.peek());
				break;
			case 4:
				System.out.println(stack.isEmpty());
				break;
			default:
				System.out.println("WRONG INPUT!");

			}
			System.out.println("Do you want to perform any other operation? (y/n)");
			choice = sc.next();
		} while (choice.equals("y"));
	}

}
