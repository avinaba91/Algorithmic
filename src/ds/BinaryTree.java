package ds;

class Node {
	int data;
	Node left, right;
	Node(int item) {
		data = item;
		left = right = null;
	}
}

class BinaryTree {
	Node root;

	void showLeaves(Node node) {
		if (node != null) {
			showLeaves(node.left);
			if (node.left == null && node.right == null) {
				System.out.print(node.data + " ");
			}
			showLeaves(node.right);
		}
	}

	void showLeftBoundary(Node node) {
		if (node != null) {
			if (node.left != null) {
				System.out.print(node.data + " ");
				showLeftBoundary(node.left);
			} else if (node.right != null) {
				System.out.print(node.data + " ");
				showLeftBoundary(node.right);
			}
		}
	}

	void showRightBoundary(Node node) {
		if (node != null) {
			if (node.right != null) {
				showRightBoundary(node.right);
				System.out.print(node.data + " ");
			} else if (node.left != null) {
				showRightBoundary(node.left);
				System.out.print(node.data + " ");
			}
		}
	}

	void printBoundary(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");
			showLeftBoundary(node.left);
			showLeaves(node.left);
			showLeaves(node.right);
			showRightBoundary(node.right);
		}
	}

	public static void main(String args[]) {
		/**
		 *          0
		 *         / \
		 *        1   2
		 *       / \  / \
		 *      3   4 5  6
		 *           / \
		 *          7   8
		 */
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(0);
		tree.root.left = new Node(1);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.right = new Node(2);
		tree.root.right.left = new Node(5);
		tree.root.right.left.left = new Node(7);
		tree.root.right.left.right = new Node(8);
		tree.root.right.right = new Node(6);
		tree.printBoundary(tree.root);

	}
}
