package application.modules.users.model.kernel;

import application.modules.users.model.models.admin;
import application.modules.users.model.models.singleton;
import application.utils.Functions;

public class Dummies {
	public static final String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";
	public static String letraDNI(int dni){
	    return String.valueOf(dni) + NIF_STRING_ASOCIATION.charAt(dni % 23);
	}
	public static void generatedummies(){
		char lettercalc=' ';
		String e="";
		
		int a = Functions.validateint("How many dummies do you want to add?", "Add Dummies");
		for(int i=0; i<a;i++){
			int azar=(int)(Math.random()*100000000);
			e=letraDNI(azar);
			System.out.print(lettercalc);
			admin dummy1 = new admin(e, "dummy", "dummy", "987654321", "asdf@asdf.asdf", "Usuario", "Pass",
					"Avatar", "Online", "10/10/1990", "14/12/2014",1234.1234f, 1234);
			singleton.admins.addData(dummy1);
		}
	}
}
