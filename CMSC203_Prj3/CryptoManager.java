package cipherprj;

/**
 * This is a utility class that encrypts and decrypts a phrase using three
 * different approaches.
 * 
 * The first approach is called the Vigenere Cipher.Vigenere encryption is a
 * method of encrypting alphabetic text based on the letters of a keyword.
 * 
 * The second approach is Playfair Cipher. It encrypts two letters (a digraph)
 * at a time instead of just one.
 * 
 * The third approach is Caesar Cipher. It is a simple replacement cypher.
 * 
 * @author Huseyin Aygun
 * @version 8/3/2025
 */

public class CryptoManager {

	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
	// Use 64-character matrix (8X8) for Playfair cipher
	private static final String ALPHABET64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_";

	public static boolean isStringInBounds(String plainText) {
		for (int i = 0; i < plainText.length(); i++) {
			if (!(plainText.charAt(i) >= LOWER_RANGE && plainText.charAt(i) <= UPPER_RANGE)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Vigenere Cipher is a method of encrypting alphabetic text based on the
	 * letters of a keyword. It works as below: Choose a keyword (e.g., KEY). Repeat
	 * the keyword to match the length of the plaintext. Each letter in the
	 * plaintext is shifted by the position of the corresponding letter in the
	 * keyword (A = 0, B = 1, ..., Z = 25).
	 */

	public static String vigenereEncryption(String plainText, String key) {
		if (!isStringInBounds(plainText) || !isStringInBounds(key)) {
			return "Out of bounds";
		}
		String encrypted = "";
		String fullKey = key;

		// Create key length
		while (fullKey.length() < plainText.length()) {
			fullKey += key;
		}
		// Checks if bigger than plain then cuts required length
		if (fullKey.length() > plainText.length()) {
			fullKey = fullKey.substring(0, plainText.length());
		}

		// Loops through
		for (int i = 0; i < plainText.length(); i++) {
			char plainChar = plainText.charAt(i);
			char keyChar = fullKey.charAt(i);

			// Shifts by ASCII of key
			int shifted = plainChar + keyChar;

			// Makes sure the added values are in range
			while (shifted > UPPER_RANGE) {
				shifted -= RANGE;
			}
			while (shifted < LOWER_RANGE) {
				shifted += RANGE;
			}

			char encryptedChar = (char) shifted;

			encrypted += encryptedChar;
		}
		return encrypted;
	}

	// Vigenere Decryption
	public static String vigenereDecryption(String encryptedText, String key) {
		String decrypted = "";
		String fullKey = key;

		// Create full key
		while (fullKey.length() < encryptedText.length()) {
			fullKey += key;
		}

		// Checks if bigger than plain then cuts required length
		if (fullKey.length() > encryptedText.length()) {
			fullKey = fullKey.substring(0, encryptedText.length());
		}

		// Loops through
		for (int i = 0; i < encryptedText.length(); i++) {
			char encryptedChar = encryptedText.charAt(i);
			char keyChar = fullKey.charAt(i);

			// Unshifts by ASCII
			int shifted = encryptedChar - keyChar;

			// Make sure values are in range
			while (shifted > UPPER_RANGE) {
				shifted -= RANGE;
			}
			while (shifted < LOWER_RANGE) {
				shifted += RANGE;
			}

			char decryptedChar = (char) shifted;
			decrypted += decryptedChar;
		}

		return decrypted;
	}

	/**
	 * Playfair Cipher encrypts two letters at a time instead of just one. It works
	 * as follows: A matrix (8X8 in our case) is built using a keyword Plaintext is
	 * split into letter pairs (e.g., ME ET YO UR). Encryption rules depend on the
	 * positions of the letters in the matrix: Same row: replace each letter with
	 * the one to its right. Same column: replace each with the one below.
	 * Rectangle: replace each letter with the one in its own row but in the column
	 * of the other letter in the pair.
	 */

	public static String playfairEncryption(String plainText, String key) {
		if (!isStringInBounds(plainText) || !isStringInBounds(key)) {
			return "Out of bounds";
		}
		// Create matrix
		char[][] matrix = new char[8][8];
		boolean[] used = new boolean[128];
		int index = 0;

		// Fill matrix with key
		for (int i = 0; i < key.length(); i++) {
			char c = key.charAt(i);

			// Check if used and is in alphabet
			if (!used[c] && ALPHABET64.indexOf(c) != -1) {
				matrix[index / 8][index % 8] = c;
				used[c] = true;
				index++;
			}

		}

		// Fill remaining with alphabet
		for (int i = 0; i < ALPHABET64.length(); i++) {
			char c = ALPHABET64.charAt(i);
			if (!used[c]) {
				matrix[index / 8][index % 8] = c;
				used[c] = true;
				index++;
			}
		}

		// Create pairs
		String pairs = "";
		for (int i = 0; i < plainText.length(); i += 2) {
			char a = plainText.charAt(i);
			char b;

			if (i + 1 < plainText.length()) {
				b = plainText.charAt(i + 1);
				if (a == b) {
					b = 'P';
					i--;
				}
			} else {
				b = 'P';
			}

			pairs += a;
			pairs += b;
		}

		String encrypted = "";
		for (int i = 0; i < pairs.length(); i += 2) {
			char a = pairs.charAt(i);
			char b = pairs.charAt(i + 1);

			// Find a in matrix
			int[] posA = null;
			for (int j = 0; j < 8; j++) {
				for (int k = 0; k < 8; k++) {
					if (matrix[j][k] == a) {
						posA = new int[] { j, k };
					}
				}
			}
			// Find B in matrix
			int[] posB = null;
			for (int j = 0; j < 8; j++) {
				for (int k = 0; k < 8; k++) {
					if (matrix[j][k] == b) {
						posB = new int[] { j, k };
					}
				}
			}

			// Mod 8 so it wraps around (no 7+1)
			if (posA[0] == posB[0]) {
				// Same row
				encrypted += matrix[posA[0]][(posA[1] + 1) % 8];
				encrypted += matrix[posB[0]][(posB[1] + 1) % 8];
			} else if (posA[1] == posB[1]) {
				// Same column
				encrypted += matrix[(posA[0] + 1) % 8][posA[1]];
				encrypted += matrix[(posB[0] + 1) % 8][posB[1]];
			} else {
				// Rectangle
				encrypted += matrix[posA[0]][posB[1]];
				encrypted += matrix[posB[0]][posA[1]];
			}

		}

		return encrypted;
	}

	public static String playfairDecryption(String encryptedText, String key) {

		// Create matrix
		char[][] matrix = new char[8][8];
		boolean[] used = new boolean[128];
		int index = 0;

		// Fill matrix with key
		for (int i = 0; i < key.length(); i++) {
			char c = key.charAt(i);

			// Check if used and is in alphabet
			if (!used[c] && ALPHABET64.indexOf(c) != -1) {
				matrix[index / 8][index % 8] = c;
				used[c] = true;
				index++;
			}
		}

		// Fill remaining with alphabet
		for (int i = 0; i < ALPHABET64.length(); i++) {
			char c = ALPHABET64.charAt(i);
			if (!used[c]) {
				matrix[index / 8][index % 8] = c;
				used[c] = true;
				index++;
			}
		}

		String decrypted = "";
		for (int i = 0; i < encryptedText.length(); i += 2) {
			char a = encryptedText.charAt(i);
			char b = encryptedText.charAt(i+1);
			
			// Find a in matrix
			int[] posA = null;
			for (int j = 0; j < 8; j++) {
				for (int k = 0; k < 8; k++) {
					if (matrix[j][k] == a) {
						posA = new int[] { j, k };
					}
				}
			}
			// Find B in matrix
			int[] posB = null;
			for (int j = 0; j < 8; j++) {
				for (int k = 0; k < 8; k++) {
					if (matrix[j][k] == b) {
						posB = new int[] { j, k };
					}
				}
			}

			// Add 7 to get back to original pos (8 would be the same pos)
			if (posA[0] == posB[0]) {
				// Same row
				decrypted += matrix[posA[0]][(posA[1] + 7) % 8];
				decrypted += matrix[posB[0]][(posB[1] + 7) % 8];
			} else if (posA[1] == posB[1]) {
				// Same column
				decrypted += matrix[(posA[0] + 7) % 8][posA[1]];
				decrypted += matrix[(posB[0] + 7) % 8][posB[1]];
			} else {
				// Rectangle
				decrypted += matrix[posA[0]][posB[1]];
				decrypted += matrix[posB[0]][posA[1]];
			}

		}
		//Remove placeholder P
		String result = "";
		for (int i = 0; i < decrypted.length(); i++) {
		    char c = decrypted.charAt(i);
		    if (c != 'P') {
		        result += c;
		    }
		}
		decrypted = result;
		
		return decrypted;
	}

	/**
	 * Caesar Cipher is a simple substitution cipher that replaces each letter in a
	 * message with a letter some fixed number of positions down the alphabet. For
	 * example, with a shift of 3, 'A' would become 'D', 'B' would become 'E', and
	 * so on.
	 */

	public static String caesarEncryption(String plainText, int key) {
		if (!isStringInBounds(plainText)) {
			return "Out of bounds";
		}
		String encrypted = "";

		for (int i = 0; i < plainText.length(); i++) {
			char c = plainText.charAt(i);

			int shifted = c + key;

			while (shifted > UPPER_RANGE) {
				shifted -= RANGE;
			}
			while (shifted < LOWER_RANGE) {
				shifted += RANGE;
			}

			encrypted += (char) shifted;
		}

		return encrypted;
	}

	// Caesar Decryption
	public static String caesarDecryption(String encryptedText, int key) {
		String decrypted = "";

		for (int i = 0; i < encryptedText.length(); i++) {
			char c = encryptedText.charAt(i);

			int shifted = c - key;

			while (shifted < LOWER_RANGE) {
				shifted += RANGE;
			}
			while (shifted > UPPER_RANGE) {
				shifted -= RANGE;
			}

			decrypted += (char) shifted;
		}

		return decrypted;
	}

}
