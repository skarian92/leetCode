package serialize.deserialize.binary.tree;

public class CodecImproved {
	public String serialize(TreeNode root) {
		return root == null ? ",null" : "," + root.val + serialize(root.left) + serialize(root.right);
	}

	public TreeNode deserialize(String data) {
		return helper(data.substring(1).split(","), new int[] { 0 });
	}

	private TreeNode helper(String[] in, int[] state) {
		if (in[state[0]].equals("null")) {
			state[0]++;
			return null;
		}
		TreeNode newNode = new TreeNode(Integer.valueOf(in[state[0]++]));
		newNode.left = helper(in, state);
		newNode.right = helper(in, state);
		return newNode;
	}
}
