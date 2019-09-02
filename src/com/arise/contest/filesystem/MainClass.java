package com.arise.contest.filesystem;

public class MainClass {

	public static void main(String[] args) {
		FileSystem f = new FileSystem();
		System.out.println(f.create("/leet", 1));
		System.out.println(f.create("/leet/code/hmm", 2));
		System.out.println(f.get("/leet/code"));
		System.out.println(f.create("/c/d", 1));
		System.out.println(f.get("/c"));
	}

}
