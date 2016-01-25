package application.modules.users.model.utils;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import application.models.Language;
import application.modules.users.model.kernel.GenericKernel;
import application.modules.users.model.models.admin;
import application.modules.users.model.models.sortbyAge;
import application.modules.users.model.models.sortbyName;
import application.utils.Functions;

public class Arraylist_admin {
	private ArrayList<admin> admins = new ArrayList<admin>();
	
	public Arraylist_admin(){
		//constructor
	}
	public ArrayList<admin> getAdmins() {
		return admins;
	}
	public void setAdmins(ArrayList<admin> admins) {
		this.admins = admins;
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
	public void changeData(Language language){
		try{
			int action=0;
			String dni;
			int num = Functions.validateint("Type the number of"
					+ " the admin to change", "Change users");
			
			dni=admins.get(num-1).getDni();
			functions_users.getuser(admins.get(num-1), 0, language);
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
	public void printArraylist(){
		int times=0;
		
		for (int i = 0; i<admins.size();i++){
			JOptionPane.showMessageDialog(null, (i+1)+":\n"+admins.get(i).toString());
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
			for(int i = 0;i<admins.size();i++){
				if(admins.get(i).equals(admin1,0)){
					JOptionPane.showMessageDialog(null,admins.get(i).toString());
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
					JOptionPane.showMessageDialog(null,admins.get(i).toString());
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
	public void changeFormatCurrency(char monedaAnterior){
		try{
			for(int i = 0;i<admins.size();i++){
				admins.get(i).changeCurrency(monedaAnterior);
			}
		}catch(Exception e){};
	}
	public void deleteData(){
		try{
			admins.remove(Functions.validateint("Type the number of the user to delete", "Delete entries")-1);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"The admin does not exist");
		}
	}
}
