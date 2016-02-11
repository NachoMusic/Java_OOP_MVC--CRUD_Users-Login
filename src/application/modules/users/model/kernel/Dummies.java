package application.modules.users.model.kernel;

import javax.swing.JOptionPane;
import application.models.SingletonF;
import application.modules.users.model.BLL.Arraylist_admin;
import application.modules.users.model.models.admin;
import application.modules.users.model.models.singleton;
import application.utils.Functions;

public class Dummies {
	public static final String DNI_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";
	public static String letraDNI(int dni){
	    return String.valueOf(dni) + DNI_ASOCIATION.charAt(dni % 23);
	}
	public static void generatedummies(int a){
		String e="";
		
		
		for(int i=0; i<a;i++){
			int random=(int)(Math.random()*100000000);
			int phone=(int)(Math.random()*1000000000);
			e=letraDNI(random);
			admin dummy1 = new admin(e, "dummy", "dummy", Integer.toString(phone), "asdf@asdf.asdf", "Usuario", "Pass",
					"Avatar", "Online", "10/10/1990", "14/12/2014",1234.1234f, 1234);
			singleton.admins.addData(dummy1);
		}
	}
	public static void deletealldummies(){
		if(SingletonF.configApp.getDummiesmode())
			singleton.admins = new Arraylist_admin();
		else{
			JOptionPane.showMessageDialog(null, SingletonF.language.getProperty("dummiesdelerror"));
		}
	}
}
