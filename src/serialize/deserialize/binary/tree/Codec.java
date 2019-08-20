package serialize.deserialize.binary.tree;

import java.util.LinkedList;

public class Codec {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		boolean isLast = true;
		if (root == null)
			return null;

		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);

		while (!q.isEmpty()) {
			isLast = true;
			int size = q.size();
			while (size > 0) {
				TreeNode node = q.remove();
				if (node != null) {
					sb.append("," + node.val);
					if (!isLast || node.left != null || node.right != null) {
						isLast = false;
					}
					q.add(node.left);
					q.add(node.right);
				} else {
					sb.append(",null");
				}
				size--;
			}
			if (isLast)
				break;
		}
		String[] arr = sb.toString().substring(1).split(",");
		int j = arr.length - 1;
		while (arr[j].equals("null")) {
			j--;
		}

		StringBuilder sb1 = new StringBuilder();
		for (int i = 0; i <= j; i++) {
			sb1.append("," + arr[i]);
		}

		return sb1.toString().substring(1);
	}

	// Decodes your encoded data to tree.
	/*
	 * public TreeNode deserialize(String data) { if (data == null ||
	 * data.equals("")) return null; String[] arr = data.split(","); if
	 * (arr.length == 0) { arr = new String[] { data }; } TreeNode root = new
	 * TreeNode(Integer.parseInt(arr[0])); LinkedList<TreeNode> q = new
	 * LinkedList<>(); q.add(root); TreeNode par = null; for (int i = 1; i <
	 * arr.length;) { par = q.poll(); TreeNode left = null; if (arr[i] !=
	 * "null") { left = new TreeNode(Integer.parseInt(arr[i])); q.add(left);
	 * 
	 * } TreeNode right = null; if (i < arr.length) { if (arr[i + 1] != "null")
	 * { right = new TreeNode(Integer.parseInt(arr[i])); q.add(right); } }
	 * 
	 * par.left = left; par.right = right; } return root; }
	 */

	public TreeNode deserialize(String data) {
		if (data == null || data.equals("") || data.length() == 0)
			return null;
		return des(data.split(","));
	}

	public TreeNode des(String[] data) {
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode root = null;

		TreeNode n = new TreeNode(Integer.parseInt(data[0]));
		q.add(n);
		root = n;

		for (int i = 1; i < data.length; i++) {
			TreeNode node = q.remove();
			node.left = getNode(data[i], q);
			if (i < data.length - 1) {
				i++;
				node.right = getNode(data[i], q);
			}

		}

		return root;
	}

	private TreeNode getNode(String d, LinkedList<TreeNode> q) {
		if (d.equals("null"))
			return null;

		TreeNode n = new TreeNode(Integer.parseInt(d));
		q.add(n);
		return n;
	}
}
