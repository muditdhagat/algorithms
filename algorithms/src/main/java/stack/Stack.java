package stack;

public class Stack {
	
	int top;
	
	int capacity;
	
	String[] items;
	
	public Stack(int cap) {
		this.capacity = cap;
		items = new String[capacity];
	}
	
	public void push(String item) {
		
		if(top == capacity - 1) return;
		items[top++] = item;
		
	}
	
	public String pop() {
		
		if(top == 0) return null;
		return items[--top];
		
	}

	public static void main(String[] args) {
		
		stack.Stack stack = new Stack(10);
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.push("D");
		stack.push("E");
		stack.push("F");
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		stack.push("C");
		stack.push("D");
		stack.push("E");
		stack.push("F");
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		
		
	}

}
