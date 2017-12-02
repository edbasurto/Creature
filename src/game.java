
public class game {
	
	public static void printLine(String in) {
		System.out.println(in);
	}
	
	public static void printGreater(int n1, int n2) {
		printLine("Battle start");
		int atck1 = 0;
		int atck2 = 0;
		while(n1 > 0 && n2 > 0) {
			atck1 = (int)(Math.random() * 5);
			atck2 = (int)(Math.random() * 5);
			n2 -= atck1;
			n1 -= atck2;
			if(n1 < 1 && n2 < 1) {
				printLine("Tie");
			}
			if(n2 < 1) {
				printLine("First number is winner");
			}
			if(n1 < 1) {
				printLine("Second number is winner");
			}
			if(n1 > 0 && n2 > 0) {
				printLine("The battle continues...");
			}
		}
	}

	public static void main(String[] args) {
		printGreater(7, 7);
	}
}
