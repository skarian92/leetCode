import java.io.IOException;

public class MainClass {

	public static void main(String[] args) throws IOException {
		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(System.in));
		// String line;
		// while ((line = in.readLine()) != null) {
		String s = "bbbb";

		int ret = new Solution().lengthOfLongestSubstring(s);

		String out = String.valueOf(ret);

		System.out.print(out);
		// }
	}
}