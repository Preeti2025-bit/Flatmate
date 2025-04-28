package com.example.flat.com;


import java.util.List;

public class MyCustomLogger {
	public enum LineDiff {
		SAME_LINE, DIFF_LINE
	}

	public enum LogType {
		Header, Subheading, Error, Function, Success
	}

	public enum Divider {
		equal, percentage, cross,
	}

	private final static boolean isPrintQueryAllowed = true, isPrint = true;
	private final static String dividerEqual = "=================";
	private final static String dividerPercentage = "  %%%%%%%%%%%%%%%  ";
	private final static String dividerError = "=X=X=X=X=X=X=X=X=";
	private final static String dividerHeadingF = " ------------------------>>>>>>>   ";
	private final static String dividerHeadingL = "    <<<<<<<----------------------  ";
	private final static String dividerHeader = ": : : : : : : : : : : : : : : : : : :  ";
	private final static String dividerFunctionRightSide = " -------->>>>>>> [[[[[[  ";
	private final static String dividerFunctionLeftSide = " ]]]]]]   <<<<<<<--------------  ";

	public static void log(String message) {
		if (isPrint)
			System.out.println(message);

	}

	public static void log(String key, String value) {
		log(dividerHeadingF + key + "----- is here:  -----" + value + dividerHeadingL);
	}

	public static void log(String key, boolean value) {
		log(dividerHeadingF + key + "----- is here:  -----" + value + dividerHeadingL);
	}

	public static void log(boolean key, String value) {
		log(dividerHeadingF + key + "----- is here:  -----" + value + dividerHeadingL);
	}

	public static void log(int key, String value) {
		log(dividerHeadingF + key + "----- is here:  -----" + value + dividerHeadingL);
	}

	public static void log(long key, String value) {
		log(dividerHeadingF + key + "----- is here:  -----" + value + dividerHeadingL);
	}

	public static void log(double key, String value) {
		log(dividerHeadingF + key + "----- is here:  -----" + value + dividerHeadingL);
	}

	public static void log(String message, Divider divider, LineDiff lineCode) {
		process(message, divider, lineCode);
	}

	public static void log(String message, LogType typeCode) {

		message = "  " + message + "  ";
		switch (typeCode) {
		case Header:
			log(dividerHeader + (message) + dividerHeader);
			break;
		case Subheading:
			log(dividerHeadingF + (message) + dividerHeadingL);
			break;
		case Error:
			log((dividerError + message + dividerError));
			break;
		case Function:
			log(dividerFunctionRightSide + (message) + dividerFunctionLeftSide);
			break;
		case Success:
			log((dividerFunctionRightSide + message + dividerFunctionLeftSide));
			break;

		default:
			log("Type Code undefined" + message);
		}

	}

	public static void log(String key, String value, LogType typeCode) {
		log(dividerHeadingF + key + "----- is here:  -----" + value + dividerHeadingL, typeCode);
	}

	public static void log(int message) {
		mlog(message + " ");
	}

	public static void log(long message) {
		mlog(message + " ");
	}

	public static void log(double message) {
		mlog(message + " ");
	}

	public static void log(boolean message) {
		mlog(message + " ");
	}

	public static void log(float message) {
		mlog(message + " ");
	}

	public static void log(String[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			try {
				log(arr[i][0], arr[i][1]);
			} catch (Exception e) {
				log("index " + i, LogType.Error);
			}
		}
	}

	public static void printQuery(String query) {
		if (isPrintQueryAllowed)
			process(query, Divider.percentage, LineDiff.DIFF_LINE);
	}

	public static void printQuery(String query, Divider divider, LineDiff lineCode) {
		if (isPrintQueryAllowed)
			process(query, divider, lineCode);
	}

	private static void process(String message, Divider divider, LineDiff lineCode) {
		String divide = getDivider(divider);
		String lineDiv = getSameLineOrNot(lineCode);
		mlog(divide + lineDiv + message + lineDiv + divide);
	}

	private static String getDivider(Divider divider) {
		switch (divider) {
		case equal:
			return dividerEqual;
		case percentage:
			return dividerPercentage;
		case cross:
			return dividerError;
		default:
			return dividerEqual;
		}
	}

	private static String getSameLineOrNot(LineDiff lineCode) {
		switch (lineCode) {
		case DIFF_LINE:
			return "\n";
		case SAME_LINE:
			return "\t";
		default:
			return "\n";
		}
	}

	private static void mlog(String message) {
		log((message));
	}


}
