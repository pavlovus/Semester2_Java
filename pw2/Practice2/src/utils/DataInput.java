package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class DataInput {

	private static void writeText(String wr){
		if (wr == null)
			System.out.print("Введіть дані: ");
		else 
			System.out.print(wr);
	}
	
	public static Long getLong(String wr) throws IOException{
		String s = getString(wr);
		Long value = Long.valueOf(s);
		return value;
	}

	public static char getChar(String wr) {
		while (true) {
			try {
				String s = getString(wr);
				if(s.length() >1){
					System.out.println("Вам потрібно ввести ЛИШЕ ОДИН символ!");
				} else if (!s.isEmpty()) {
					return s.charAt(0);
				}
				System.out.println("Помилка! Введіть хоча б один символ.");
			} catch (IOException e) {
				System.out.println("Помилка введення. Спробуйте ще раз.");
			}
		}
	}

	public static Integer getInt(String wr) {
		while (true) {
			try {
				String s = getString(wr);
				return Integer.valueOf(s);
			} catch (NumberFormatException | IOException e) {
				System.out.println("Ой, схоже, що вам потрібно ввести ціле число");
			}
		}
	}

	public static Double getDouble(String wr) {
		while (true) {
			try {
				String s = getString(wr);
				return Double.valueOf(s);
			} catch (NumberFormatException | IOException e) {
				System.out.println("Ой, схоже, що вам потрібно ввести дійсне число");
			}
		}
	}

	public static String getString(String wr) throws IOException {
		writeText(wr);
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		return br.readLine();
	}
	
}
