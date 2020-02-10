public class Stack {
	
	static public class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static Node top;
	
	public static void push(int item) {
		Node n = new Node(item);
		n.next = top;
		top = n;
	}
	
	public void display() {
		if(top == null) {
			System.out.println("Stack is Empty");
		}
		Node temp = top;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	
	public static int pop() throws Exception {
		if(top == null) {
			throw new Exception("Stack is Empty");
		}
		int poppedData = top.data;
		top = top.next;
		return poppedData;
	}
	
	public static int search(int element) {
		int pos = 0;
		Node temp = top;
		while(temp.data != element) {
			pos++;
			temp = temp.next;
			if(temp == null) {
				System.out.println("Element " + element +" Not found");
				return -1;
			}
		}
		return pos;
	}
	public static int peek() throws Exception{
		if(top == null) {
			throw new Exception ("Stack is Empty.");
		}
		else {
		return top.data;
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.display();
		System.out.println();
		System.out.println(stack.pop());
		stack.display();
		System.out.println();
		System.out.println(stack.peek());
		stack.pop();
		stack.pop();
		stack.display();
		stack.pop();
		stack.display();
		stack.push(20);
		stack.display();
		System.out.println(stack.search(2));
		
	}
		
}
