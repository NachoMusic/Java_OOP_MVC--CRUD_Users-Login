package application.utils;

import javax.swing.JOptionPane;

public class Menus {
	//Menu
	public static int menu(String []v, String message, String title){
		int op=0;
		//String[] vec = { "suma","resta","producto","división" };
		op = JOptionPane.showOptionDialog(null,
						message,title,0,
						JOptionPane.QUESTION_MESSAGE,null,v,v[0]);
		return op;
	}
	//Confirm Dialog
	public static int confirmdialog(String message){
		int confirmated = JOptionPane.showConfirmDialog(
				   null,
				   message);
		return confirmated;
	}
	//Combobox
	public static String combobox(String []v, String mensaje, String titulo){
		Object selection = JOptionPane.showInputDialog(
				   null,
				   mensaje,
				   titulo,
				   JOptionPane.QUESTION_MESSAGE,
				   null,  // null for the default icon
				   v,
				   v[0]);
		String i = (String) selection; //cast the object into a string
		return i;
	}
}
