/**
 * 
 * @author bentaherghassen
 *
 */

public class SubnetCalculator {
	public static InterFace interFace = new InterFace();
	public static void main(String[] args) {
		//interFace.initialize();
	}

	@SuppressWarnings("unused")
	private static void createOctalPrint(String label, int a, int b, int c,
			int d) {
		System.out.println(label + ": " + a + "." + b + "." + c + "." + d);

	}

	@SuppressWarnings("unused")
	private static void createOctalBinaryPrint(String label, int a, int b,
			int c, int d) {
		System.out.println(label + ": " + Integer.toBinaryString(a) + "."
				+ Integer.toBinaryString(b) + "." + Integer.toBinaryString(c)
				+ "." + Integer.toBinaryString(d));
	}

}