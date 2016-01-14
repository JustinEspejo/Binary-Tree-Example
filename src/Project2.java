
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * Project 2
 * Binary Search Tree 
 * CSC313
 * @author Justin Espejo
 *
 */
public class Project2 {

	public BinaryTree t = new BinaryTree();
	public static int TreeCounter = 0;
/**
 * This is the main of the project, It reads the file, if there is not file given
 * or the file name is wrong it will print out an error. If the file is able to be read
 * it will read the file, store its data in a binary search tree and prints it out
 * accordingly.
 * @param args
 */
	public static void main(String[] args) {
		if(args == null || args.length == 0) System.out.println("You did not enter the name of the file.");
		else {
			try {
				readFile(args[0]);
			} catch (IOException e) {
				System.out.println("That File Does NOT Exist!!!");
			}
		}

	}
	
	
	
/**
 * This reads the fileinput, store the data to the binary tree until there are 
 * no more lines then prints it out.
 * @param fileName is name of the file to be read 
 * @throws IOException
 */
	public static void readFile(String fileName) throws IOException {
	
		BinaryTree t = new BinaryTree();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();
		while (line != null) {
			if (line.equals("")) {
				System.out.println();
				line = br.readLine();
				continue;
			}
			TreeCounter++;
			System.out.println("Binary tree " + TreeCounter );
			t = new BinaryTree();
			String[] input = line.split(" ", -1);
			for (int i = 0; i < input.length; i++) { // insert the line in the
														// node
				t.add(Integer.parseInt(input[i]));
			}

			t.charArray = new String[t.row][t.col];
			for (int i = 0; i < t.row; i++) {
				for (int j = 0; j < t.col; j++) {
					t.charArray[i][j] = " ";
				}
			}
			try {
				t.printTraversal(t.root, 0, (t.col / 2) -1);
			} catch (Exception e) {
				e.printStackTrace();
			}

			for (int i = 0; i < t.row; i++) {
				for (int j = 0; j < t.col; j++) {
					System.out.print(t.charArray[i][j] + " ");
				}
				System.out.println();
			}
			line = br.readLine();
		}
		br.close();
	}

}
