/*
Write a function that takes a pointer to the head of a list and determines whether
the list is cyclic or acyclic. Your function should return false if the list is acyclic
and true if it is cyclic. You may not modify the list in any way.
 */
/*
Start slow pointer at the head of the list
Start fast pointer at second node
Loop infinitely
If the fast pointer reaches a null pointer
Return that the list is null terminated
If the fast pointer moves onto or over the slow pointer
Return that there is a cycle
Advance the slow pointer one node
Advance the fast pointer two nodes
 In the worst case we traverse 3n nodes, so this approach is O(n).
 */
 
class Cycle
{
	Node head;
	//Node fast;
	//Node slow;
	public Cycle()
	{
		head = null;
	}
	void insertEnd(int data)
	{
		Node temp = new Node(data);
		Node curr = head;
		if(head == null)
		{
			head = temp;
			return;
		}
		while(curr.next != null)
		{
			curr = curr.next;
		}
		//System.out.println(curr.data);
		curr.next = temp;
	}	
	void displayList()
	{
		Node curr = head;
		while(curr != null)
		{
			System.out.println(curr.data);
			curr = curr.next;
		}

	}

	boolean detectCycle(Node slow)
	{
		if(slow == null)
			return false;
		Node fast = slow;
		while(true)
		{
			slow = slow.next;
			if(fast != null)
				fast = fast.next.next;
			else
				return false;
			if(slow == null || fast == null)
				return false;
			if(slow == fast)
				return true;
		}
	}
	public static void main(String args[])
	{
		Cycle m = new Cycle();
		m.insertEnd(1);
		m.insertEnd(2);
		m.insertEnd(3);
		m.insertEnd(4);
		m.insertEnd(5);
		m.insertEnd(6);
		m.insertEnd(7);
		m.insertEnd(8);
		m.displayList();
		boolean ret = m.detectCycle(m.head);
		System.out.println(ret);
	}
}
