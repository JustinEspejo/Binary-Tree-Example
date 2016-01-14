/**
 * this is the node class of the binary tree. It contains the data
 * to be stored and also a pointer to the left and right nodes of the tree.
 * @author justinespejo
 *
 */
public class Node {

	int data;
	Node leftChild;
	Node rightChild;
	
	public Node(){
		
	}
	
	public Node (int data){
		this.data=data;
	}

	public int getData() {
		return data;
	}


	
}
