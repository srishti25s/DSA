/**
 * 
 */
package stack;

import java.util.Scanner;

/**
 * @author Srishti Srivastava
 *
 */
public class StackUsingArray {

	private static final int MAX = 100;
	int top = -1;
	int stack[] = new int[MAX];

	public StackUsingArray() {
		top = -1;
	}

	boolean push(int item) {
		if (top == MAX) {
			System.out.println("Stack Overflow");
			return false;
		} else {
			stack[++top] = item;
			System.out.println(item+" added to the Stack.");
			return true;
		}
	}

	int pop() {
		if (top == -1) {
			System.out.println("Stack underflow");
			return top;
		} else {
			return stack[top--];
		}
	}

	boolean isEmpty() {
		return (top < 0);
	}

	int peek() {
		return stack[top];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		StackUsingArray stack = new StackUsingArray();
		do {
			System.out.println(
					"STACK Operations : \n 1. Push \n 2. Pop \n 3. Peek \n 4. isEmpty \n Enter your choice(1/2/3/4) :  ");
			int menu = sc.nextInt();
			switch (menu) {
			case 1: System.out.println("Enter the element to be pushed");
			        int item = sc.nextInt();
			        stack.push(item);  
				break;
			case 2: System.out.println(stack.pop());
				break;
			case 3: System.out.println(stack.peek());
				break;
			case 4: System.out.println(stack.isEmpty());
				break;
			default : 
				System.out.println("WRONG INPUT!");
			}
			System.out.println("Do you want to perform any other operation? (y/n)");
			choice = sc.next();
		} while (choice.equals("y"));

	}

}
