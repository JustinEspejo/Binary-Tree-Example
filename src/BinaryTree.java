/**
 * This is the Binary Search Tree class, the data will be stored in the binary tree.
 * It takes the first data and makes it the root, then where the next data will be stored will
 * depend on its value, whether it is greater than or less than the root and the other existing 
 * data already plotted in the tree.
 * @author justinespejo
 *
 */
public class BinaryTree {
	
	Node root;
	static int size = 0;
	static String charArray[][];
	static int row = 10;
	static int col = 64;
	static int col2 = col / 2;
	// row col and col2 are used for printing the tree. 
	
	/**
	 * This method adds the data to the tree.
	 * @param data is the data that is to be stored
	 */
	public void add (int data) {
		Node nodeToAdd = new Node (data);
		size++;
		if (root == null)
			root = nodeToAdd;
		// if data < node traverse left child, else traverse right
		// until we get to an empty node, insert our new node.
		
			traverse(root, nodeToAdd);

		
	}
	/**
	 * This recursive method traverses the tree and adds the node to be added to its
	 * appropriate place
	 * @param node points to the current node that we are on.
	 * @param nodeToAdd is the node that we are going to be adding 
	 */
	private void traverse (Node node, Node nodeToAdd){
		if (nodeToAdd.data < node.data) // if data is less than data of the root then move to the left
		{
			if (node.leftChild==null) // if there is no node on the left place the node to be added on the left
			{
				node.leftChild = nodeToAdd;
			}
			else
			{
				traverse ( node.leftChild, nodeToAdd);
			}
		}
		else if (nodeToAdd.data > node.data){ //if data is larger than the data of the root move to the right
			if (node.rightChild==null) //if there is no node on the left place the node to be added on the left
			{
				node.rightChild = nodeToAdd;
			}
			traverse ( node.rightChild, nodeToAdd);
			}
	}
	
	
	public int visit(){
		return root.getData();
	}
	
	/**
	 * This is a preorder traversal of the Binary tree done recursively starting with the root
	 * then going to the left side of the tree, then the right side. As the pointer goes down the tree
	 * it designates the node to the appropriate array to be used for printing. 
	 * @param root is the current node that we are in
	 * @param i is used for the row of the two dimensional array
	 * @param j is used for the offset of the column of the two dimensional array
	 */
	
	public static void  printTraversal(Node root, int i, int j) {
		if (root==null) return;
		charArray[i][j] = Integer.toString(root.getData());
		int d = col2/(i+2);
		int l = j - (d/2);
		int r = j + (d/2);
		// offsets of each data we go deeper in the tree
		printTraversal (root.leftChild, i+2, l); //move to the left side of the tree recursively
		if(root.leftChild != null) charArray[i+1][j - (d/4)] = "/"; // used to illustrate the branch in the the plot
		printTraversal (root.rightChild, i+2, r);
		if(root.rightChild != null) charArray[i+1][j + (d/4)]  = " \\"; // used to illustrate the branch in the the plot
		if(root.leftChild != null) charArray[i+1][j - (d/4)] = "/";

	
	}
	
}