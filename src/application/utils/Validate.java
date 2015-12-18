package application.utils;
/*
 * classes(models) ->admin user regisuser client
 * utils -> funciones, format, menu, validate
 * modules -> users(carpeta) ->clases admin user gegisuser client ,, utils funciones_users, core_users(kernel)
 */

public class Validate {
	private static final String dniFormat = "^([0-9]{8})[A-Za-z]{1}$";
	private static final String textFormat = "[a-zA-ZÒ—\\s]+([ ]?)+([a-zA-Z]*)+([ ]?)+([a-zA-Z]*)";
	private static final String phoneFormat = "^([+]|[0-9]+)*$";
	private static final String emailFormat = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String dateFormat1="(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/]((175[7-9])|(17[6-9][0-9])|(1[8-9][0-9][0-9])|([2-9][0-9][0-9][0-9]))";
	private static final String dateFormat2="(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-]((175[7-9])|(17[6-9][0-9])|(1[8-9][0-9][0-9])|([2-9][0-9][0-9][0-9]))";
	private static final String dateFormat3="((175[7-9])|(17[6-9][0-9])|(1[8-9][0-9][0-9])|([2-9][0-9][0-9][0-9]))[/](0[1-9]|1[012])[/](0[1-9]|[12][0-9]|3[01])";
	private static final String dateFormat4="((175[7-9])|(17[6-9][0-9])|(1[8-9][0-9][0-9])|([2-9][0-9][0-9][0-9]))[-](0[1-9]|1[012])[-](0[1-9]|[12][0-9]|3[01])";
	
	public static boolean validateDni(String dni){
		return dni.matches(dniFormat);
	}
	public static boolean validateText(String name){
		return name.matches(textFormat);
	}
	public static boolean validatePhone(String phone){
		return phone.matches(phoneFormat);
	}
	public static boolean validateEmail(String email){
		return email.matches(emailFormat);
	}
	public static boolean validateDate1(String date){
		return date.matches(dateFormat1);
	}
	public static boolean validateDate2(String date){
		return date.matches(dateFormat2);
	}
	public static boolean validateDate3(String date){
		return date.matches(dateFormat3);
	}
	public static boolean validateDate4(String date){
		return date.matches(dateFormat4);
	}
	/*
	public static void main(String[] args){
		System.out.print(validateDate4("2010-02-15"));
	}
	*/
}
