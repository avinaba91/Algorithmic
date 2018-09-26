package utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SampleFileReading {

	public static void readFile() {
		String fileName = "C://Users/AVINABA/Desktop/build.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		readFile();
	}

}
