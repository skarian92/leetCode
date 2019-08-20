import java.util.HashMap;

class LRUCache {

	int capacity = 0;
	private HashMap<Integer, ListNode> map;
	ListNode head = null;
	ListNode tail = null;

	class ListNode {
		int key;
		int value;
		ListNode pre;
		ListNode next;

		ListNode(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
	}

	public int get(int key) {
		ListNode node = map.get(key);
		if (node == null) {
			return -1;
		}

		if (node.pre != null) {
			if (tail == node && node.pre != null) {
				tail = node.pre;
			}
			node.pre.next = node.next;

			if (node.next != null) {
				node.next.pre = node.pre;
			}

			node.pre = null;
			node.next = head;
			head.pre = node;
			head = node;
		}

		return node.value;
	}

	public void put(int key, int value) {
		ListNode node = map.get(key);
		if (node == null) {
			if (capacity == map.size()) {
				int x = delete();
				map.remove(x);
			}
			node = new ListNode(key, value);
			map.put(key, node);
			addToHead(node);
		} else {
			node.value = value;
			if (node.pre != null) {
				if (tail == node && node.pre != null) {
					tail = node.pre;
				}
				node.pre.next = node.next;

				if (node.next != null) {
					node.next.pre = node.pre;
				}

				node.pre = null;
				node.next = head;
				head.pre = node;
				head = node;
			}
		}

	}

	private void addToHead(ListNode node) {

		if (head == null) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			head.pre = node;
			head = node;
		}

	}

	private int delete() {
		int value = tail.key;
		if (tail == head) {
			tail = null;
			head = null;
		} else {
			ListNode prev = tail.pre;
			prev.next = null;
			tail.pre = null;
			tail = prev;
		}
		return value;
	}
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */