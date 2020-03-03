package java;

// https://www.swarthmore.edu/NatSci/echeeve1/Ref/BinaryMath/BinaryMath.html
// http://www.java2s.com/Tutorial/Java/0040__Data-Type/Hexadecimalintegerliteral.htm
// https://docs.oracle.com/javase/8/docs/technotes/guides/language/binary-literals.html
// https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
// https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
// https://en.wikipedia.org/wiki/Bitwise_operation

public class BitStuff {

	public static void main(String[] args) {
		// hex literal
		int twoHundredFiftySix = 0x100;
		int negativeTwoHundredFiftySix = -0x100;

		// bit literals
		byte two = 0b00000010;
		// for some reason, get an error on negative 'bytes'
		// if don't cast it
		byte negativeTwo = (byte) 0b11111110;
		// AND
		int twoANDnegativeTwo = two & negativeTwo; // == 2
		// OR
		int twoORnegativeTwo = two | negativeTwo; // == -2
		// XOR
		int twoXORnegativeTwo = two ^ negativeTwo; // == -4
		// NOT
		int notNegativeTwo = ~negativeTwo; // == 1
		// Left Shift (Arithmetic)
		int leftShiftNegativeTwo = negativeTwo <<2; // == -8
		// Right Shift (Arithmetic)
		int rightShiftNegativeTwo = negativeTwo >>2; // == -1
		// Right Shift (Logicial)
		int logicalRightShiftNegativeTwo = negativeTwo >>>2; // == 
		System.out.println("2 & -2: " + twoANDnegativeTwo);
		System.out.println("2 | -2: " + twoORnegativeTwo);
		System.out.println("2 ^ 2: " + twoXORnegativeTwo);
		System.out.println("~-2: " + notNegativeTwo);
		System.out.println("-2 <<2: " + leftShiftNegativeTwo);
		System.out.println("-2 >>2: " + rightShiftNegativeTwo);
		System.out.println("-2 >>>2: " + logicalRightShiftNegativeTwo);


		System.out.println("two: " + two);
		System.out.println("negativeTwo: " + negativeTwo);
		System.out.println("twoHundredFiftySix: " + twoHundredFiftySix);
		System.out.println("negativeTwoHundredFiftySix: " + negativeTwoHundredFiftySix);

		// TODO
		// - NOT, AND, OR, XOR
		// - logical right/left shift
		// - arithmatic right/left shift
		// - overflow
	}

}