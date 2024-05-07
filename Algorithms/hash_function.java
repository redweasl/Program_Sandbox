import java.util.Scanner;

/** Quick program for computing a hash table for a sentence.
Date: May 7th, 2024
Suppose that a hash function h on a string x of letters is defined as the sum of the numerical values
of the letters mod 7.
For example: 
h(komodo) = (11 + 15 + 13 + 15 + 4 + 15) % 7 = 3
The sentence I was asked to process was this:
"Everybody, try laughing. Then whatever scares you will go away!"
*/

public class hash_function {

    public static void main(String[] args) {
        Scanner uinput = new Scanner(System.in);
        String input = "";
        String word = "";
        int mod_val = 7;

        while (true) {
            System.out.println("Welcome to hash function. Please input a sentence: ");
            input = uinput.nextLine();
            if (input.equals("q")) {
                uinput.close();
                System.exit(0);
            }
            input = input.toLowerCase();
            Scanner sentenceScan = new Scanner(input);
            int hash_val = 0;
            while (sentenceScan.hasNext()) {
                word = sentenceScan.next();
                hash_val = 0;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    // Get the number of the letter
                    int letter_val = (int)c - 96;
                    if (letter_val >= 1 && letter_val <= 26) {
                        hash_val += letter_val;
                    }
                }
                hash_val = hash_val % mod_val;
                System.out.printf("Word %s has hash value %d\n", word, hash_val);
            }
            sentenceScan.close();
        }
    }
}