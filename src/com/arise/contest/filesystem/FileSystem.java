package com.arise.contest.filesystem;

import java.util.HashMap;
import java.util.Map;

public class FileSystem {
	Map<String, Integer> map = null;

	public FileSystem() {
		map = new HashMap<>();
	}

	public boolean create(String path, int value) {
		if (path == null || path.equals("") || path.equals("/"))
			return false;
		if (map.containsKey(path))
			return false;
		String[] split = path.split("/");
		if (split.length == 2) {
			map.put(path, value);
			return true;
		} else {
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i < split.length - 1; i++) {
				String key = "/" + split[i];
				sb.append(key);
				if (!map.containsKey(sb.toString())) {
					return false;
				}
			}
			map.put(path, value);
			return true;
		}
	}

	public int get(String path) {
		if (path == null || path.equals(""))
			return -1;
		if (map.containsKey(path)) {
			return map.get(path);
		} else {
			return -1;
		}
	}
}
