
public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String[] dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		int index = 0;
		while (!in.isEmpty() && index < dictionary.length) {
			String line = in.readLine(); // reads a lkine from the file
			if (line != null && !line.isEmpty()) {
				dictionary[index] = line; // store line in array
				index++;
			}

		}

		return dictionary;
	}

	public static boolean existInDictionary(String word, String[] dictionary) {
		int length = dictionary.length;
		for (int i = 0; i < length; i++) {
			if (word.equals(dictionary[i])){
				return true;
			}
		}
		return false;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {

		hashtag = hashtag.toLowerCase(); // pre-processing. turns hashtag String into lower case
		// Base case: do nothing (return) if hashtag is an empty string.
		if (hashtag.isEmpty()) {
			return;
		}

		boolean wordFound = false;
		int N = hashtag.length();

		for (int i = 1; i <= N; i++) {
			String innerWord = hashtag.substring(0, i);

			if (existInDictionary(innerWord, dictionary)) { // IF inner word is valid word in dictionary it prints it

				System.out.println(innerWord);

				// initiates the recursive case for the rest of the hashtag, starting at the end
				// of the current "inner word"
				// checks if the current index i (which also represents the length of the
				// current innerWord that has been found to match a word in the dictionary) is less than the total length N
				if (i < N) {
					breakHashTag(hashtag.substring(i), dictionary);
				}
				wordFound = true;
				break;
			}

		}
	}

}
