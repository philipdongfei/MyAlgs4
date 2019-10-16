import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.math.BigInteger;
import java.util.Random;

// Based on https://www.geeksforgeeks.org/online-algorithm-for-checking-palindrome-in-a-stream/
//

public class Ex5_3_23 {
    public class PalindromeStreamChecker {
        // pattern
        private StringBuilder currentString;

        private long largePrimeNumber;  //prime number used to evaluate Rabin-Karp's rolling hash
        private int alphabetSize;

        private long hash;

        // Hash of the left half of the pattern reversed
        private long leftHalfReversedHash;
        // Hash of the right half of the pattern
        private long rightHalfHash;

        PalindromeStreamChecker(){
            currentString = new StringBuilder();

            alphabetSize = 256;
            hash = 1;

            largePrimeNumber = longRandomPrime();
        }

        // A random 31-bit prime
        private long longRandomPrime(){
            BigInteger prime = BigInteger.probablePrime(31, new Random());
            return prime.longValue();
        }

        public boolean checkPalindromeOnline(char character){
            currentString.append(character);
            int patternLength = currentString.length();

            // Base cases: strings of lengths 1 and 2
            if (patternLength == 1){
                leftHalfReversedHash = character % largePrimeNumber;

                return true;
            } else if (patternLength == 2){
                rightHalfHash = character % largePrimeNumber;
                return currentString.charAt(0) == currentString.charAt(1);
            }

            if (patternLength % 2 == 0){
                // left string -> add trailing character in left half
                // right string -> add trailing character in right half
                char characterToBeAddedInLeftString = currentString.charAt((patternLength - 1) / 2);
                hash = (hash * alphabetSize) % largePrimeNumber;

                leftHalfReversedHash = (leftHalfReversedHash + hash * characterToBeAddedInLeftString) % largePrimeNumber;
                rightHalfHash = (rightHalfHash * alphabetSize + character) % largePrimeNumber;
            } else {
                // Left string -> no changes
                // Right string -> remove leading character and add trailing character
                char characterToRemove = currentString.charAt(patternLength / 2);
                rightHalfHash = (alphabetSize * (rightHalfHash + largePrimeNumber - characterToRemove * hash) % largePrimeNumber
                + character ) % largePrimeNumber;
            }
            // Monte Carlo version - If hashes match, a palindrome was found.
            /*
               if (leftHalfReversedHash == rightHalfHash){
               return true;
               }
            */
            // Las Vaga version - If hashes match, compare characters.
            if (leftHalfReversedHash == rightHalfHash){
                boolean isPalindrome = true;

                for (int index = 0; index < currentString.length() / 2; index++) 
                {
                    if (currentString.charAt(index) != currentString.charAt(currentString.length() - 1 - index)){
                        isPalindrome = false;
                        break;
                    }
                }
                return isPalindrome;
            }
            return false;
        }
    }
    public static void main(String[] args){
        Ex5_3_23 ex23 = new Ex5_3_23();
        StdOut.println("Test 1: ");
        PalindromeStreamChecker check = ex23.new PalindromeStreamChecker();
        StdOut.println("Check r: " + check.checkPalindromeOnline('r') + "Expected: true");
        StdOut.println("Check re: " + check.checkPalindromeOnline('e') + "Expected: false");
        StdOut.println("Check ree: " + check.checkPalindromeOnline('e') + "Expected: false");
        StdOut.println("Check reer: " + check.checkPalindromeOnline('r') + "Expected: true");
    }
}
