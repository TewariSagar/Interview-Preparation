/*
Given a singly linked list, devise a time- and space-efficient algorithm
to find the mth-to-last element of the list. Implement your algorithm, taking care
to handle relevant error conditions. Define mth to last such that when m = 0 the
last element of the list is returned.
 */
/*
We can't use the temporary stack approach for this problem because as the size of the 
list increases so does the size of the stack increases and that can be space inefficient.
 */

class MthToLast
{
	Node head;
	Node reference;
	public MthToLast()
	{
		head = null;
	}

	void last(int m)
	{
		reference = head;
		int count = 0;
		//Node temp = reference;
		while(count != m)
		{
			reference = reference.next;
			count++;
		}
		//System.out.println("reference: "+reference.data);
		while(reference.next != null)
		{
			reference = reference.next;
			head = head.next;

		}
		System.out.println("Mth to last element in the list is: " + head.data);
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

	public static void main(String args[])
	{
		MthToLast m = new MthToLast();
		m.insertEnd(1);
		m.insertEnd(2);
		m.insertEnd(3);
		m.insertEnd(4);
		m.insertEnd(5);
		m.insertEnd(6);
		m.insertEnd(7);
		m.insertEnd(8);
		m.displayList();
		m.last(3);
	}
}