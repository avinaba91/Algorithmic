package ds;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Build {
	private static final String END_LINE = "Files Extraction Completed From PVCS With Current version Label";
	private static final String START_LINE = "Get Files From PVCS With Current version Label";
	private static String SUCCESS = "success";
	private static String WARNING = "warning";

	public static Map<String, List<String>> getDecisionMap (String filePath) {
		Map<String, List<String>> decisionMap = new HashMap<>();
		if (filePath != null && filePath.length() > 0) {
			BufferedReader br = null;
			File file = null;
			try {
				List<String> warningList = new ArrayList<String>();
				List<String> successList = new ArrayList<String>();
				file = new File(filePath);
				br = new BufferedReader(new FileReader(file));
				System.out.println("Started reading file using Buffered Reader ...");
				String readLine = null;
				while ((readLine = br.readLine()) != null) {
					String logLine = readLine;
					if (logLine.contains(START_LINE)) {
						br.readLine();
						continue;
					} else if (logLine.contains(END_LINE)) {
						break;
					}
					if (logLine.startsWith("Warning")) {
						warningList.add(logLine);
					} else {
						if (logLine != null && logLine.length() > 0 && !logLine.trim().equals("")) {
							successList.add(logLine);
						}
					}
				}
				decisionMap.put(WARNING, warningList);
				decisionMap.put(SUCCESS, successList);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (br != null) {
						br.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return decisionMap;
	}

	public static void printSuccessMap(List<String> successList) {
		if (successList != null && successList.size() > 0) {
			System.out.println("Started printing successful logs ...");
			for (String s : successList) {
				int startIndex = 0;
				int endIndex = 0;
				if (s.indexOf("<-") != -1) {
					startIndex = s.indexOf("<-");
				}
				if (s.indexOf("Fetched") != -1) {
					endIndex = s.indexOf("Fetched");
				}
				if (startIndex > 0 && endIndex > 0) {
					String filePath = s.substring(startIndex + 3, endIndex);
					String version = s.substring(endIndex + 17);
					System.out.println("Successful file path : " + filePath + " having Version :: " + version);
				}
			}
		}
	}

	public static void printWarningMap(List<String> warningList) {
		if (warningList != null && warningList.size() > 0) {
			System.out.println("Started printing warnings ...");
			for (String warn : warningList) {
				System.out.println(warn);
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String filePath = "C://Users/AVINABA/Desktop/build.txt";
		Map<String, List<String>> decisionMap = getDecisionMap(filePath);
		List<String> warningList = decisionMap.get(WARNING);
		List<String> successList = decisionMap.get(SUCCESS);
		printWarningMap(warningList);
		printSuccessMap(successList);
	}
}
