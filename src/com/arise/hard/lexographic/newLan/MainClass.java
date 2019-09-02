package com.arise.hard.lexographic.newLan;

public class MainClass {
	public static void main(String[] args) {

		String[] arr = { "wef", "efg" };

		// List<String> orders = new Solution().getOrders(arr);
		// orders.forEach(or -> {
		// System.out.println(or);
		// });

		// List<String> orders = new ArrayList<>();
		// orders.add("wef");
		// orders.add("egf");
		// orders.add("zxz");

		String alienOrder = new Solution2().alienOrder(arr);
		System.out.println(alienOrder);
	}
}
