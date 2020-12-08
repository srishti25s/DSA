package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class GenericStack<T>{
	
	private List<T> stack = new ArrayList<>();
	int top = 0;
	
	boolean isEmpty() {
		return (stack.size() == 0);
	}
	
	T pop() {
		return stack.remove(--top);
	}
	
	T peek() {
		return stack.get(top);
	} 
	
	void push(T item) {
		if(top == 0) {
			stack.add(top++, item);
		}
		stack.add(top++, item);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		final String OPENING_BRACKETS = "{[(";
		final String CLOSING_BRACKETS = "}])";
		boolean balanced = true;
		GenericStack<Character> stack = new GenericStack<>();
		for(int i = 0; i < input.length() && balanced; i++) {
			int index_of_input_in_o_b = OPENING_BRACKETS.indexOf(input.charAt(i));
			if(index_of_input_in_o_b != -1) {
				stack.push(input.charAt(i));
			}else {
				char poped = stack.pop();
				int index_of_inp_in_c_b = CLOSING_BRACKETS.indexOf(input.charAt(i));
				if(index_of_inp_in_c_b != OPENING_BRACKETS.indexOf(poped)) {
					balanced = false;
				}
			}
		}
		System.out.println(balanced ? "Balanced" : "Unbalanced");
	}
	
}