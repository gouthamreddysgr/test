import java.util.LinkedList;

class Node { 
	int data; 
	Node left_node, right_node; 

	Node(int item) 
	{ 
		data = item; 
		left_node =  null;
		right_node = null; 
	} 
} 

class Tree { 
	Node root; 

	LinkedList<Integer> Morris(Node root) 
	{ 
		Node curr, prev; 
        LinkedList<Integer> lis = new LinkedList<>();
		if (root == null) 
			return lis; 

		curr = root; 
		while (curr != null) { 
			if (curr.right_node == null) { 
                lis.addFirst(curr.data);
				System.out.print(curr.data + " "); 
				curr = curr.left_node; 
			} 
			else { 
				/* Find the previous (prev) of curr */
                //System.out.print(curr.data+" ");
				prev = curr.right_node; 
				while (prev.left_node != null && prev.left_node != curr) 
					prev = prev.left_node; 
                //System.out.print(curr.data+" ");

				/* Make curr as right child of its prev */
				if (prev.left_node == curr) { 
					prev.left_node = null; 
                    //lis.addFirst(curr.data);
                    //System.out.print(curr.data+" ");
					curr = curr.left_node; 
				} 

				/* fix the right child of prev*/

				else { 
					prev.left_node = curr; 
                    lis.addFirst(curr.data);
					System.out.print(curr.data + " "); 
					curr = curr.right_node; 
				} 
                //System.out.print(curr.data+" ");

			} 
		}
        return lis;
	} 

	public static void main(String args[]) 
	{ 
		
		Tree tree = new Tree(); 
		tree.root = new Node(4); 
		tree.root.left_node = new Node(2); 
		tree.root.right_node = new Node(5); 
		tree.root.left_node.left_node = new Node(1); 
		tree.root.left_node.right_node = new Node(3); 

		LinkedList<Integer> list = tree.Morris(tree.root); 
        System.out.println(list);
	} 
} 