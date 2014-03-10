import java.util.ArrayList;

public class UniqueBSTs {
	
	public class TreeNode {
		
		int data;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			data = x;
			left = null;
			right = null;
		}
		
		@Override
		public String toString() {
			return "TreeNode [data=" + data + ", left=" + left + ", right=" + right + "]";
		}
		
	}
	
	public ArrayList<TreeNode> enumerate(int n) {
		return enumerate(1, n);
	}
	
	private ArrayList<TreeNode> enumerate(int start, int end) {
		ArrayList<TreeNode> trees = new ArrayList<TreeNode>();
		
		if (start > end) {
			trees.add(null);
			return trees;
		}
		
		for (int i = start; i <= end; i++) {
			ArrayList<TreeNode> left = enumerate(start, i - 1);
			ArrayList<TreeNode> right = enumerate(i + 1, end);
			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					trees.add(root);
				}
			}
		}
		
		return trees;
	}
	
	public static void main(String[] args) {
		System.out.println(new UniqueBSTs().enumerate(5));
	}
}
