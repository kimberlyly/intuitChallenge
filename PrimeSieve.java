/* Class name: PrimeSieve
 * Description: This class uses the Sieve of Eratosthenes to
 * determine the nth prime number.
 * Usage: java PrimeSieve n, where n is the nth prime number
 *			the user wishes to find.
 *		  java PrimeSieve test, to run the test cases.
 */

import java.lang.Math;

public class PrimeSieve {

	// Constants
	public static final int NUM_PRIME_BEFORE_SIX = 3;
	public static final int DEFAULT_ARRAY_SIZE = 5;

	/* Method name: main
	 * Description: Main driver of the program. Parses
	 *				the argument, calls the sieve methods.
	 * Parameters: n - n being the nth prime number
	 * Returns: void
	 */
	public static void main(String[] args) {
		int nthPrime = Integer.parseInt(args[0]);
		int upperBound = getUpperBound(nthPrime);
		System.out.println(runSieve(upperBound, nthPrime));
	}

	/* Method name: runSieve
	 * Description: Method that runs the Sieve of Eratosthenes.
	 *				The algorithm works as follows:
	 *				1. Create a boolean array from 2 to upper bound,
	 *					which is determined by helper method below.
	 *				2. Assume all numbers are prime
	 *				3. From 2 to the square root of the upper bound,
	 *					loop through and for each i, set its multiples
	 *					to false in the prime array.
	 *				4. Then count the number of primes up until n and
	 *					return.
	 *				5. If the number is negative or invalid, return -1.
	 *
	 * Parameters: int upper - the upper bound of the sieve;
	 *             int n - the nth prime number to find
	 * Returns: int, the nth prime number
	 */
	public static int runSieve(int upper, int n) {
		
		// declare a boolean array to encompass 2 to n.
		boolean[] isPrime = new boolean[upper + 1];
		
		// initialize all values to true (ignoring 0 and 1), since
		// we will not be accessing these values at all.
		for (int i = 2; i <= upper; i++) {
			isPrime[i] = true;
		}

		// Loop from 2 to the square root of upper bound.
		// We use square root because all numbers after the
		// square root will be repeated.
		for (int i = 2; i <= Math.sqrt(upper); i++) {
			
			// if number is prime, set its multiples to false
			if (isPrime[i]) {
				for (int j = i; i*j <= upper; j++) {
					isPrime[i*j] = false;
				}
			}
		}

		// count the prime numbers
		int primeNumbers = 0;
		for (int i = 2; i <= upper; i++) {
			if (isPrime[i]) {
				primeNumbers++; // if it is prime, increase the count
				if (primeNumbers == n) return i; // return the nth prime number
			}
		}
		return -1; // error, invalid input.
	}

	/* Method name: getUpperBound
	 * Description: This method finds the minimum number of values
	 *				to calculate to find the nth prime.
	 *				It is based on this algorithm: 
	 *				https://en.wikipedia.org/wiki/Prime_number_theorem
	 *
	 * Parameters: int n - the nth prime number
	 * Returns: The minimum array size needed to find the nth prime number
	 */
	public static int getUpperBound(int n) {
		if (n > NUM_PRIME_BEFORE_SIX) { // This algorithm only works on n >= 6
			return (int) (n * (Math.log(n) + Math.log(Math.log(n))));
		} else {
			// 5 will be the maximum array size to calculate 1st, 
			// 2nd, and 3rd primes
			return DEFAULT_ARRAY_SIZE;
		}
	}
}