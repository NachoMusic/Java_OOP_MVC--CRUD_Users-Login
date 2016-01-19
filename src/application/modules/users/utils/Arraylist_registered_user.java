package application.modules.users.utils;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import application.models.Language;
import application.modules.users.kernel.GenericKernel;
import application.modules.users.models.admin;
import application.modules.users.models.registered_user;
import application.modules.users.models.sortbyAge;
import application.modules.users.models.sortbyName;
import application.utils.Functions;

public class Arraylist_registered_user {
private ArrayList<registered_user> registered_users = new ArrayList<registered_user>();
	
	public Arraylist_registered_user(){
		//constructor
	}
	
	public void addData(registered_user a){
		registered_user registered_user1 = a;
		boolean action=true;
		
		for(int i = 0;i<registered_users.size();i++){
			if(registered_users.get(i).equals(registered_user1,0)){
				action=false;
			}
		}
		if(action)
			registered_users.add(a);
		else
			JOptionPane.showMessageDialog(null, "There is already a user with the same DNI");
	}
	public registered_user getData(int num){
		return registered_users.get(num);
	}
	public void changeData(Language language){
		try{
			int action=0;
			String dni;
			int num = Functions.validateint("Type the number of"
					+ " the admin to change", "Change users");
			
			dni=registered_users.get(num-1).getDni();
			functions_users.getuser(registered_users.get(num-1),0,language);
			for(int i=0;i<registered_users.size();i++){
				if(registered_users.get(num-1).equals(registered_users.get(i),0)){
					if(i!=num-1)
						action++;
				}
			}
			if(action!=0){
				registered_users.get(num-1).setDni(dni);
				JOptionPane.showMessageDialog(null, "There is already a user with that DNI");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"The admin does not exist");
		}
	}
	public void printArraylist(){
		int times=0;
		
		for (int i = 0; i<registered_users.size();i++){
			JOptionPane.showMessageDialog(null, (i+1)+":\n"+registered_users.get(i).toString());//I removed config from it
			times++;
		}
		if(times==0)
			JOptionPane.showMessageDialog(null, "No admins found");
	}
	public void find(int option){
		admin admin1 = new admin();
		int times=0;
		
		switch(option){
		case 0://By dni
			admin1.setDni(GenericKernel.insertDni("Type the DNI of the user you are looking for", "Search by DNI"));
			for(int i = 0;i<registered_users.size();i++){
				if(registered_users.get(i).equals(admin1,0)){
					JOptionPane.showMessageDialog(null,registered_users.get(i).toString());// I removed config from it
					times++;
				}
			}
			if(times==0)
				JOptionPane.showMessageDialog(null, "No admins found");
			break;
		case 1://By name
			admin1.setName(Functions.validatestring("Type the Name of the user you are looking for", "Search by Name"));
			for(int i = 0;i<registered_users.size();i++){
				if(registered_users.get(i).equals(admin1,1)){
					JOptionPane.showMessageDialog(null,registered_users.get(i).toString());//I removed config from it
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
			Collections.sort(registered_users);
			break;
		case 1:
			Collections.sort(registered_users, new sortbyName());
			break;
		case 2:
			Collections.sort(registered_users, new sortbyAge());
			break;
		}
		
	}
	/*
	public void changeFormatCurrency(Config configApp, char monedaAnterior){
		try{
			for(int i = 0;i<registered_users.size();i++){
				registered_users.get(i).changeCurrency(configApp, monedaAnterior);
			}
		}catch(Exception e){};
	}
	*/
	public void deleteData(){
		try{
			registered_users.remove(Functions.validateint("Type the number of the user to delete", "Delete entries")-1);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"The registered user does not exist");
		}
	}
}
