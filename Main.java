import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String needle = input.next(); // s
		String haystack = input.next(); // s2

		int count = 0;

		Set<String> boo = findPermutation(needle);
		String[] boo2 = boo.toArray(new String[0]);
		for (int i = 0; i < boo2.length; i++) {
			if (haystack.contains(boo2[i]))
				count++;

		}
		System.out.println(count);

	}

	public static Set<String> findPermutation(String str) {

		Set<String> result = new HashSet<String>();
		if (str == null)
			return null;
		else if (str.length() == 0) {
			result.add("");
			return result;
		}

		char charFirst = str.charAt(0);
		String tes = str.substring(1);
		Set<String> totalWords = findPermutation(tes);
		for (String str2 : totalWords) {
			for (int i = 0; i <= str2.length(); i++) {
				result.add(addCharacter(str2, charFirst, i));
			}
		}
		return result;
	}

	public static String addCharacter(String strp, char j, int p) {
		String first = strp.substring(0, p);
		String last = strp.substring(p);
		return first + j + last;
	}

}