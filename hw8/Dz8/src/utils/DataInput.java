package utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class DataInput {

	public static void main(String[] args) {
		System.out.println("Hello world!");
	}

	public static long getLong(String s) {
		String str = "";
		str = getString(s);
		if (str.isEmpty()) return 0;
		return Long.parseLong(str);
	}

	public static double getDouble(String s) {
		String str = "";
		boolean done = false;
		while (!done)
			try {
				str = getString(s);
				Double.parseDouble(str);
				done = true;
			} catch (NumberFormatException _) {
			}
		return Double.parseDouble(str);
	}
	public static char getChar(String s) {
		String str = "";
		str = getString(s);
		if (str.isEmpty()) return 0;
		return str.charAt(0);
	}

	public static int getInt(String s) {
		String str = "";
		boolean done = false;
		while (!done)
			try {
				str = getString(s);
				Integer.parseInt(str);
				done = true;
			} catch (NumberFormatException _) {
			}
		return Integer.parseInt(str);
	}

	public static String getString(String str) {
		writeText(str);
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			return br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static void writeText(String str) {
		if (str == null) System.out.print("Enter data: ");
		else System.out.print(str);
	}
}