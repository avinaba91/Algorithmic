package ds;

import java.util.HashMap;
import java.util.Map;

public class HuffManDecoder {

	/*
	 * Complete the function below.
	 */
	static String decode(String[] codes, String encoded) {
		StringBuilder decodedStrBuilder = null;
		String decodedStr = "";
		Map<String, String> codeMap = getCodeMap(codes);
		if (codeMap != null && codeMap.size() > 0 && encoded != null) {
			decodedStrBuilder = new StringBuilder();
			StringBuilder codeBuilder = new StringBuilder();
			for (int i = 0; i < encoded.length(); i++) {
				char c = encoded.charAt(i);
				codeBuilder.append(c);
				if (codeMap.containsKey(codeBuilder.toString())) {
					String character = codeMap.get(codeBuilder.toString());
					if ("[newline]".equals(character)) {
						character = "\n";
					}
					decodedStrBuilder.append(character);
					codeBuilder = new StringBuilder();
				}
			}
			decodedStr = decodedStrBuilder.toString();
		}
		return decodedStr;
	}

	static Map<String, String> getCodeMap(String[] codes) {
		Map<String, String> codeMap = new HashMap<>();
		if (codes != null && codes.length > 0) {
			for (int i = 0; i < codes.length; i++) {
				String inputLines = codes[i];
				System.out.print(inputLines + " : ");
				String inputs[] = inputLines.split("");
				System.out.println(inputs.length);
				if (inputs != null && inputs.length == 2) {
					String character = inputs[0];
					String code = inputs[1];
					codeMap.put(code, character);
				}
			}
		}
		return codeMap;
	}

	public static void main(String[] args) {
		try {
			
			String codes[] = { "a	100100", "b		100101", "c		110001", "d		100000", "[newline]		111111",
					"p		111110", "q		000001" };
			String encoded = "111110000001100100111111100101110001111110";
			System.out.println(decode(codes, encoded));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}
}
