import java.util.Arrays;

public class Main {

	public enum Roll {
		one23, one, two, three, four, five, six, ones, twos, threes, fours, fives, sixes, four56
	}

	public static int[] log = new int[14];
	public static int loops = 2000000000;

	public static void main(String[] args) {
		
		
		int count = 0;
		
		while (count != loops) {
			Roll roll = checkRoll(getRoll());
			if (roll != null) {
				logRoll(roll);
				count++;
			}
		}
//		for (int i = 0; i < log.length; i++) {
//			System.out.print(log[i] + " ");
//		}
//		System.out.println();
		showData();
	}

	public static int[] getRoll() {
		int[] arr = new int[3];
		for (int i = 0; i < 3; i++) {
			arr[i] = (int) Math.floor(Math.random() * 6) + 1;
			//System.out.print(arr[i] + "\t");
		}
		return arr;
	}

	public static Roll checkRoll(int[] arr) {

		Arrays.sort(arr);

		if (arr[0] == 1 && arr[1] == 2 && arr[2] == 3) {
			return Roll.one23;
		} else

		if (arr[0] == 4 && arr[1] == 5 && arr[2] == 6) {
			return Roll.four56;
		} else

		if (arr[0] == arr[1] && arr[1] == arr[2]) {
			switch (arr[0]) {
			case 1:
				return Roll.ones;
			case 2:
				return Roll.twos;
			case 3:
				return Roll.threes;
			case 4:
				return Roll.fours;
			case 5:
				return Roll.fives;
			case 6:
				return Roll.sixes;
			}
		}
		int matchingNum = 0;
		boolean match = false;
		for (int i = 0; i < 3; i++) {
			int num = arr[i];
			for (int j = 0; j < 3; j++) {
				if (i != j && num == arr[j]) {
					match = true;
					matchingNum = num;
				}
			}
		}

		int otherNum = -1;
		for (int i = 0; i < 3; i++) {
			if (arr[i] != matchingNum) {
				otherNum = arr[i];
			}
		}
		if (match) {
			// System.out.println(match + "\t" + matchingNum + "\t" + otherNum);
			switch (otherNum) {
			case 1:
				return Roll.one;
			case 2:
				return Roll.two;
			case 3:
				return Roll.three;
			case 4:
				return Roll.four;
			case 5:
				return Roll.five;
			case 6:
				return Roll.six;
			}
		}
		// System.out.println("invalid roll");
		return null;
	}

	public static void logRoll(Roll r) {
		log[r.ordinal()]++;
	}
	
	public static void showData() {
		System.out.println("Roll\tcount\t\t%");
		System.out.println("123\t" + log[0] + "\t" + log[0] / ((double) loops) * 100.0);
		System.out.println("1\t" + log[1] + "\t" + log[1] / ((double) loops) * 100.0);
		System.out.println("2\t" + log[2] + "\t" + log[2] / ((double) loops) * 100.0);
		System.out.println("3\t" + log[3] + "\t" + log[3] / ((double) loops) * 100.0);
		System.out.println("4\t" + log[4] + "\t" + log[4] / ((double) loops) * 100.0);
		System.out.println("5\t" + log[5] + "\t" + log[5] / ((double) loops) * 100.0);
		System.out.println("6\t" + log[6] + "\t" + log[6] / ((double) loops) * 100.0);
		System.out.println("111\t" + log[7] + "\t" + log[7] / ((double) loops) * 100.0);
		System.out.println("222\t" + log[8] + "\t" + log[8] / ((double) loops) * 100.0);
		System.out.println("333\t" + log[9] + "\t" + log[9] / ((double) loops) * 100.0);
		System.out.println("444\t" + log[10] + "\t" + log[10] / ((double) loops) * 100.0);
		System.out.println("555\t" + log[11] + "\t" + log[11] / ((double) loops) * 100.0);
		System.out.println("666\t" + log[12] + "\t" + log[12] / ((double) loops) * 100.0);
		System.out.println("456\t" + log[13] + "\t" + log[13] / ((double) loops) * 100.0);

	}
}
