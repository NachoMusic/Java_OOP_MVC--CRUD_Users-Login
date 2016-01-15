package application.modules.users.utils;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import application.models.Config;
import application.models.Language;
import application.modules.users.kernel.GenericKernel;
import application.modules.users.models.admin;
import application.modules.users.models.sortbyAge;
import application.modules.users.models.sortbyName;
import application.utils.Functions;

public class Arraylist_admin {
	private ArrayList<admin> admins = new ArrayList<admin>();
	
	public Arraylist_admin(){
		//constructor
	}
	
	public void addData(admin a){
		admin admin1 = a;
		boolean action=true;
		
		for(int i = 0;i<admins.size();i++){
			if(admins.get(i).equals(admin1,0)){
				action=false;
			}
		}
		if(action)
			admins.add(a);
		else
			JOptionPane.showMessageDialog(null, "There is already a user with the same DNI");
	}
	public admin getData(int num){
		return admins.get(num);
	}
	public void changeData(Config configApp, Language language){
		try{
			int action=0;
			String dni;
			int num = Functions.validateint("Type the number of"
					+ " the admin to change", "Change users");
			
			dni=admins.get(num-1).getDni();
			functions_users.getuser(admins.get(num-1), 0, configApp, language);
			for(int i=0;i<admins.size();i++){
				if(admins.get(num-1).equals(admins.get(i),0)){
					if(i!=num-1)
						action++;
				}
			}
			if(action!=0){
				admins.get(num-1).setDni(dni);
				JOptionPane.showMessageDialog(null, "There is already a user with that DNI");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"The admin does not exist");
		}
	}
	public void printArraylist(Config configApp){
		int times=0;
		
		for (int i = 0; i<admins.size();i++){
			JOptionPane.showMessageDialog(null, (i+1)+":\n"+admins.get(i).toString(configApp));
			times++;
		}
		if(times==0)
			JOptionPane.showMessageDialog(null, "No admins found");
	}
	public void find(int option, Config config){
		admin admin1 = new admin();
		int times=0;
		
		switch(option){
		case 0://By dni
			admin1.setDni(GenericKernel.insertDni("Type the DNI of the user you are looking for", "Search by DNI"));
			for(int i = 0;i<admins.size();i++){
				if(admins.get(i).equals(admin1,0)){
					JOptionPane.showMessageDialog(null,admins.get(i).toString(config));
					times++;
				}
			}
			if(times==0)
				JOptionPane.showMessageDialog(null, "No admins found");
			break;
		case 1://By name
			admin1.setName(Functions.validatestring("Type the Name of the user you are looking for", "Search by Name"));
			for(int i = 0;i<admins.size();i++){
				if(admins.get(i).equals(admin1,1)){
					JOptionPane.showMessageDialog(null,admins.get(i).toString(config));
					times++;
				}
			}
			if(times==0)
				JOptionPane.showMessageDialog(null, "No admins found");
			break;
		}
	}
	public void sortData(int type){
		switch(type){
		case 0:
			Collections.sort(admins);
			break;
		case 1:
			Collections.sort(admins, new sortbyName());
			break;
		case 2:
			Collections.sort(admins, new sortbyAge());
			break;
		}
		
	}
	public void changeFormatCurrency(Config configApp, char monedaAnterior){
		try{
			for(int i = 0;i<admins.size();i++){
				admins.get(i).changeCurrency(configApp, monedaAnterior);
			}
		}catch(Exception e){};
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
