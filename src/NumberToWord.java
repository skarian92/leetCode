import java.util.HashMap;
import java.util.Map;

public class NumberToWord {

	Map<Integer, String> ones = new HashMap<>();
	Map<Integer, String> tens = new HashMap<>();
	Map<Integer, String> teens = new HashMap<>();
	Map<Integer, String> places = new HashMap<>();

	public NumberToWord() {
		ones.put(0, "");
		ones.put(1, "One");
		ones.put(2, "Two");
		ones.put(3, "Three");
		ones.put(4, "Four");
		ones.put(5, "Five");
		ones.put(6, "Six");
		ones.put(7, "Seven");
		ones.put(8, "Eight");
		ones.put(9, "Nine");

		tens.put(2, "Twenty");
		tens.put(3, "Thirty");
		tens.put(4, "Forty");
		tens.put(5, "Fifty");
		tens.put(6, "Sixty");
		tens.put(7, "Seventy");
		tens.put(8, "Eighty");
		tens.put(9, "Ninety");

		teens.put(10, "Ten");
		teens.put(11, "Eleven");
		teens.put(12, "Twelve");
		teens.put(13, "Thirteen");
		teens.put(14, "Fourteen");
		teens.put(15, "Fifteen");
		teens.put(16, "Sixteen");
		teens.put(17, "Seventeen");
		teens.put(18, "Eighteen");
		teens.put(19, "Nineteen");

		places.put(1, "Thousand");
		places.put(2, "Million");
		places.put(3, "Billion");

	}

	public String numberToWords(int num) {
		if (num == 0) {
			return "Zero";
		}
		String s = String.valueOf(num);
		StringBuilder sb = new StringBuilder();
		int i = (s.length() - 1) / 3;
		int x = 0, y = 0;
		if (s.length() % 3 == 0) {
			y = 3;
		} else {
			y = s.length() % 3;
		}

		while (i >= 0) {

			String hun = getHun(Integer.parseInt(s.substring(x, y)));
			if (!hun.equals("")) {
				sb.append(" " + hun);

				if (i != 0) {
					sb.append(" " + places.get(i));
				}
			}
			x = y;
			y = y + 3;
			i--;
		}

		System.out.println(sb.toString());
		return sb.toString().substring(1);
	}

	private String getHun(int num) {
		StringBuilder sb = new StringBuilder();
		int hunDigit = num / 100;
		if (hunDigit != 0) {
			sb.append(ones.get(hunDigit) + " Hundred");
			if (num % 10 != 0 || num % 100 != 0) {
				sb.append(" ");
			}
		}

		sb.append(getTens(num % 100));

		return sb.toString();

	}

	private String getTens(int num) {
		StringBuilder sb = new StringBuilder();
		int tensDigit = num / 10;
		int onesDigit = num % 10;

		if (tensDigit == 0) {
			sb.append(ones.get(onesDigit));
		} else if (tensDigit == 1) {
			sb.append(teens.get(num));
		} else {
			sb.append(tens.get(tensDigit));
			if (onesDigit != 0) {
				sb.append(" ");
				sb.append(ones.get(onesDigit));
			}

		}
		return sb.toString();
	}

	public static void main(String[] args) {

		NumberToWord n = new NumberToWord();
		/*
		 * n.numberToWords(02); n.numberToWords(10); n.numberToWords(13);
		 * n.numberToWords(23);
		 * 
		 * n.numberToWords(102); n.numberToWords(210); n.numberToWords(313);
		 * n.numberToWords(423);
		 */
		n.numberToWords(12423);
		n.numberToWords(222423);
		n.numberToWords(987222423);

	}
}
