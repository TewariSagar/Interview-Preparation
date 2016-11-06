/*
	The stack has 2 main operations push and pop. The push operation needs the head of the list and
	data to be inserted as the argument. The pop operation needs only the pointer to the list as the 
	argument and extracts the data.
 */
class Stack
{
	Node head;
	//the constructor is the create stack function
	public Stack()
	{
		head = null;
	}
	//the push function inserts in front of the linklist
	boolean push(int data)
	{
		Node temp = new Node(data);
		if(head == null)
		{
			head = temp;
			return true;
		}
		temp.next = head;
		head = temp;
		return true;
	}
	
	Node pop()
	{
		if(head == null)
		{
			System.out.println("Stack is empty");
			return null;
		}
		//System.out.println("HEAD: "+head.data);
		Node remove = head;
		Node tempNext = head.next;
		head = tempNext;
		return remove;
	}
	void displayList()
	{
		Node curr = head;
		System.out.println("Current stack is: ");
		while(curr != null)
		{
			System.out.println(curr.data);
			curr = curr.next;
		}
	}
	void displayPop(Node t)
	{
		System.out.println("Element popped is: "+t.data);
	}
	public static void main(String args[])
	{
		Stack s = new Stack();
		boolean ret;
		Node l = s.pop();
		ret = s.push(1);
		ret = s.push(2);
		ret = s.push(3);
		ret = s.push(4);
		s.displayList();
		Node x = s.pop();
		s.displayPop(x);
		Node y = s.pop();
		s.displayPop(y);
		s.displayList();
	}
}