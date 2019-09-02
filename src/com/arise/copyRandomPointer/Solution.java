package com.arise.copyRandomPointer;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	Map<Node, Node> map = new HashMap<>();

	public Node copyRandomList(Node head) {

		if (head == null)
			return null;
		Node h = head;
		while (h != null) {
			Node n = new Node(h.val, null, null);
			map.put(h, n);
			h = h.next;
		}

		h = head;
		while (h != null) {
			Node n = map.get(h);
			n.next = map.get(h.next);
			n.random = map.get(h.random);
			h = h.next;
		}

		return map.get(head);
	}
}
