package application.modules.users.utils;

import java.util.ArrayList;
import application.modules.users.models.admin;

public class Arraylist {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	ArrayList<admin> admins = new ArrayList();

	public Arraylist(){
		//constructor
	}
	public void addData(admin a){
		admins.add(a);
	}
	public admin getData(int num){
		return admins.get(num);
	}
	public admin[] printArraylist(){
		admin[] vec = new admin[admins.size()];
		for (int i = 0; i<admins.size();i++){
			vec[i] = admins.get(i);
		}
		return vec;
	}
	public void deleteData(int index){
		admins.remove(index);
	}
	/*
	public static void main(String[] args){
		Arraylist a = new Arraylist();
		Config configApp = new Config();
		admin[] adminsvec=null;
		a.addData(new admin("12345678A", "Nacho", "Valera", "987654321", "asdf@asdf.asdf", "Usuario", "Pass",
				"Avatar", "Online", "16/10/1996", "14/12/2014",1234.1234f, 1234));
		a.addData(new admin("12345678Z", "Dummy", "Dummy", "123456789", "dummy@gmail.com", "DummyUser", "Pass",
				"Avatar.jpg", "Offline", "30/11/1994", "10/11/2012",1234.1234f, 123));
		
		adminsvec = a.printArraylist(); 
		for(int i = 0;i<adminsvec.length;i++){
			JOptionPane.showMessageDialog(null,adminsvec[i].toString(configApp));
		}
		a.deleteData(0);
		adminsvec = a.printArraylist(); 
		for(int i = 0;i<adminsvec.length;i++){
			JOptionPane.showMessageDialog(null,adminsvec[i].toString(configApp));
		}
	}
	*/
}
