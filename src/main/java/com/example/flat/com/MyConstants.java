package com.example.flat.com;

public class MyConstants {

	public static class ResponseCode {
		public final static int OK = 200;
		public final static int PARTIAL_CONTENT = 206;
		public final static int INTERNAL_SERVER_ERROR = 500;
		public final static int SERVICE_UNAVAILABLE = 503;
		public final static int UNPROCESSABLE_ENTITY = 422;
		public final static int UNSUPPORTED_MEDIA_TYPE = 415;
	}

	/**
	 * 
	 * @author sanchit created on 30 aug 2023 this class denotes StringResources
	 *         short form is used as StringRes
	 */
	public static class StringRes {

		public final static String DESC_MSG = "Error Undefined Contact System Administrator";
		public final static String FHTTF_NOT_VALID = "Error Fhttf is not valid";
		public final static String SOMETHING_WENT_WRONG = "Something went wrong";
		public final static String TRY_AFTER_SOME_TIME = "Try After Sometime";
		public final static String SUCCESS_DATA_SAVED = "Successfully Data is Saved";
		public final static String OTP_SENT = "Otp has been sent to the registered email id/mobile";
		public final static String STATUS = "status";
		public final static String MSG = "msg";
		public final static String MSGDESC = "msgDesc";
		public final static String DATA = "data";
		public final static String OTPTimeOutMinutes = "5";
		public final static int OTPLength = 6;

		public final static String NPPARegardsOTP = " \r\n\r\nRegards\r\nNational Pharmaceutical Pricing Authority.";
		public final static String[][] urlReplacements = { { "/", "" }, { ":", "" }, { "^", "" }, { ".", "" },
				{ "%5E", "" }, { "%5e", "" } };
		public final static String OTP_SEND_SOURCE_NAME_FORGOT_PASSWORD = "forget_password";
		public final static String OTP_SEND_SOURCE_NAME_CHANGE_PASSWORD = "change_password";
		public final static String OTP_SEND_SOURCE_NAME_LOGIN = "login";
		public final static String OTP_SEND_SOURCE_NAME_FIRST_LOGIN = "first_login";
		public final static String OTP_SEND_SOURCE_NAME_MOBILE_LOGIN = "mobile_login";

		// public final static OtpSendSource getSourceName(String source) {

		// 	OtpSendSource mOtpSendSource = new OtpSendSource();
		// 	switch (source) {
		// 	case "FGP":ß
		// 		mOtpSendSource.setDbName(OTP_SEND_SOURCE_NAME_FORGOT_PASSWORD);
		// 		break;
		// 	case "CHP":
		// 		mOtpSendSource.setDbName(OTP_SEND_SOURCE_NAME_FORGOT_PASSWORD);
		// 		break;
		// 	case "Login":
		// 		mOtpSendSource.setDbName(OTP_SEND_SOURCE_NAME_LOGIN);
		// 		break;
		// 	case "FLGN":
		// 		mOtpSendSource.setDbName(OTP_SEND_SOURCE_NAME_FIRST_LOGIN);
		// 		break;
		// 	case "MOLO":
		// 		mOtpSendSource.setDbName(OTP_SEND_SOURCE_NAME_MOBILE_LOGIN);
		// 		break;

		// 	default:
		// 		mOtpSendSource.setEmailName("undefined");
		// 		mOtpSendSource.setDbName("undefined");
		// 	}
		// 	return mOtpSendSource;
		// }

		/***
		 * 
		 * @param name   of the paramaeter
		 * @param isNull if true then return with null else with blank;
		 * @return
		 */
		public final static String getValueError(String name, boolean isNull) {
			return name + " can't be " + (isNull ? " null" : "blank");
		}

		/**
		 * 
		 * @param name   of the parameter
		 * @param length of the parameter
		 * @return
		 */
		public final static String getLengthError(String name, int length) {
			return name + "doesn't have length of " + length;

		}
	}

	public static class MyUtils {
		public final static String LOGGER_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	}

	public static class ConsoleTextColors {
		public static final String ANSI_RESET = "\u001B[0m";
		public static final String ANSI_BLACK = "\u001B[30m";
		public static final String ANSI_RED = "\u001B[31m";
		public static final String ANSI_GREEN = "\u001B[32m";
		public static final String ANSI_YELLOW = "\u001B[33m";
		public static final String ANSI_BLUE = "\u001B[34m";
		public static final String ANSI_PURPLE = "\u001B[35m";
		public static final String ANSI_CYAN = "\u001B[36m";
		public static final String ANSI_WHITE = "\u001B[37m";
	}

	public static class ConsoleTextBackGroundColors {
		public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
		public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
		public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
		public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
		public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
		public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
		public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
		public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	}

	/**
	 * @author Sanchit Verma created on 4 september 2023;
	 * 
	 */
	public static class GenerateOtpMessage {

		public static String sms(String templateid, String otp, String name) {
			String message;
			switch (templateid) {
			case OtpTemplateId.AccountValidationTemplateId:
				message = "OTP for IPDMS account verification is : " + otp + StringRes.NPPARegardsOTP;
				break;

			case OtpTemplateId.FormTemplateId:
				message = "OTP for " + name + " Submission is: " + otp + StringRes.NPPARegardsOTP;
				break;

			default:
				message = "Your Otp is here " + otp + StringRes.NPPARegardsOTP;
			}
			return message;
		}
	}

	public static class OtpTemplateId {
		private final static String AccountValidationToken = "ACCV";
		private final static String FormToken = "FORM";
		private final static String AccountValidationTemplateId = "1007987461281637799";
		private final static String FormTemplateId = "1007009837907233209";

		public final static String getTemplateId(String tempId) throws Exception {
			switch (tempId) {
			case AccountValidationToken:
				return AccountValidationTemplateId;
			case FormToken:
				return FormTemplateId;
			default:
				throw new Exception("Template Id not Found");
			}

		}
	}

	public static class RestAuthStrings {

		public static final String NAME = "/auth";

		/**
		 * This @param [validateOtp] is acronym for validdateOTP
		 */
		public static final String validateOtp = "/v1/vdateOTP";
		public static final String generateOtp = "/v1/generateOTP";
		public static final String generateCaptcha = "/v1/generateCaptcha";
	}

	public static enum mUserType {
		Student, Faculty, Unknown
	}

	public static class UploadFolderConstants {
		private final static String PersonalDocumentToken = "DOCPERSNL";
		private final static String PersonalDocumentPathId = "PersonalDocs";
		private final static String ThesisDocumentToken = "ThesisDocs";
		private final static String CommitteeActionDocumentToken = "COMMACT";
		private final static String CommitteeActionDocumentPathId = "CommitteeActionAttachement";
		private final static String ThesisPathActionDocumentPathId = "thesisDeskAttachment - ";
		private final static String FormQtrStock = "1007237326942905492";

		public final static String getTemplateId(String tempId) throws Exception {
			switch (tempId) {
			case PersonalDocumentToken:
				return PersonalDocumentPathId;
			case CommitteeActionDocumentToken:
				return CommitteeActionDocumentPathId;
			case ThesisDocumentToken:
				return ThesisPathActionDocumentPathId;
			default:
				throw new Exception("Template Id not Found");
			}

		}
	}
}
