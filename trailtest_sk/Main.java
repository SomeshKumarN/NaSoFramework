package trailtest_sk;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
	public static ArrayList<Integer> temp = new ArrayList<>();
	public static void main(String[] args) {

		int maxSize = 0;
		ArrayList<Integer> storeInt = new ArrayList<>();
		System.out.println(storeInt.size());
		Integer[] inputArray = { -2, 9, 0,3,4 ,-6,2,3, 3,2,4, -1, 0};
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] < 0) {
				if (storeInt.size() > maxSize) {
					temp = new ArrayList<Integer>(storeInt);
					System.out.println(temp);
					maxSize = storeInt.size();
					}
				storeInt.clear();				
			} else {
				storeInt.add(inputArray[i]);
			}
			
		}
		System.out.println("Max positive sequence" + temp);
	}

	public void postiveSequence() {

		// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
		// int numberArray[] = { -2, -3, -5, -6, -7, -7, -8, 9, 0, -6, 3, -1,
		// -2, 0, -9, -12 };
		int numberArray[] = { 1, 20000, 3, -1, -2, 1, 2 };

		/*
		 * TEST DATA int numberArray[] = {-2, -3, -5, -6, -7}; //DATA WITH ALL
		 * NEGATIVE NUMBERS. EXPECTED OUTPUT is SIZE : 0 int numberArray[] = {};
		 * //DATA WITH ALL NO VALUES. EXPECTED OUTPUT is SIZE : 0 int
		 * numberArray[] = {-2, -3, 7, -6, -7}; //DATA WITH ONE POSITIVE DATA.
		 * EXPECTED OUTPUT is SIZE : 1 int numberArray[] = {-2, 3, 5, 6, -7, 23,
		 * 4, 4, 1}; //DATA WITH VALID VALUES. EXPECTED OUTPUT is SIZE : 4
		 */

		// Initializing all values. At Start, Start And End Index Points to
		// First Location i.e., Index=0;
		int startIndex = 0;
		int endIndex = 0;

		// Stores the Length of Sequence and Its Start Index
		int validSequenceSize = 0;
		int validSequenceStartIndex = 0;

		for (int index = 0; index < numberArray.length; index++) {

			// If series started with Positive Number and StartIndex is '0',
			// Move EndIndex to Next Location.
			// This make sure the StartIndex and End Index are always different.

			if (numberArray[index] > 0 && startIndex == 0) {
				endIndex = endIndex + 1;
			}

			// Setting the Value of End Index. if value is Negative or reached
			// the end of Series, Set the end Index
			if (numberArray[index] < 0 || numberArray.length - 1 == index) {

				if (startIndex != endIndex) {
					endIndex = index;
					int difference = endIndex - startIndex;

					// Check the difference between Start and End Index of Valid
					// Positive Number Sequence
					if (difference >= validSequenceSize && difference != 0) {
						validSequenceSize = difference;

						// if the Last Digit is Positive Number, Increase the
						// valid Sequence size by 1
						if (numberArray[numberArray.length - 1] > 0 && numberArray.length - 1 == index) {
							validSequenceSize = validSequenceSize + 1;
						}
						validSequenceStartIndex = startIndex;

					}
				}

				// Setting value of Start Index after One Set of Calculation is
				// Completed.
				if (endIndex != numberArray.length - 1 && numberArray[index] < 0) {
					startIndex = endIndex + 1;
				}

			}
		}

		// RESULT
		System.out.println("Size of Sequence : " + validSequenceSize);

		if (validSequenceSize > 0) {
			System.out.println("Valid Sequence Starts at Index[" + validSequenceStartIndex + "]");
			for (int index = validSequenceStartIndex; index < validSequenceStartIndex + validSequenceSize; index++) {
				System.out.println(
						"Values of Biggest Positive Sequence in Index[" + index + "] -- " + numberArray[index]);
			}
		}
	}
}