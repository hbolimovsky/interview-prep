public class BaseConversion {

	public static void main(String[] args) {
		int example = 1523;
		System.out.println("example: " + example);

		// base 2
		String base2 = intToBaseN(example, 2);
		System.out.println("base2: " + base2);

		// base 8
		String base8 = intToBaseN(example, 8);
		System.out.println("base8: " + base8);

		// base 16
		String base16 = intToBaseN(example, 16);
		System.out.println("base16: " + base16);
	}

	// TODO: do recursive
	public static String intToBaseN(int num, int base) {

		// TODO: make sure only handles base 2-9, 16
		if (base <= 0) {
			throw new IllegalArgumentException();
		}

		StringBuilder baseN = new StringBuilder();
		int quotient = num;
		int remainder;

		while (quotient != 0) {

			remainder = quotient % base;
			quotient = quotient / base;
			// baseN.append(remainder);
			safeAppend(baseN, remainder);
		}

		return baseN.reverse().toString();
	}

	private static void safeAppend(StringBuilder sb, int remainder) {
		// TOOD: cleanpu
		if (remainder < 10 || remainder > 16) {
			sb.append(remainder);
		} else {
			switch (remainder) {
				case 10:
					sb.append('a');
				case 11:
					sb.append('b');
				case 12:
					sb.append('c');
				case 13:
					sb.append('d');
				case 14:
					sb.append('e');
				case 15:
					sb.append('f');
			}
		}
	}

}