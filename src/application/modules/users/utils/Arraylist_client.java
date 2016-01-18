package application.modules.users.utils;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

import application.models.Config;
import application.models.Language;
import application.modules.users.kernel.GenericKernel;
import application.modules.users.models.admin;
import application.modules.users.models.client;
import application.utils.Functions;

public class Arraylist_client {
private ArrayList<client> clients = new ArrayList<client>();
	
	public Arraylist_client(){
		//constructor
	}
	
	public void addData(client a){
		client client1 = a;
		boolean action=true;
		
		for(int i = 0;i<clients.size();i++){
			if(clients.get(i).equals(client1,0)){
				action=false;
			}
		}
		if(action)
			clients.add(a);
		else
			JOptionPane.showMessageDialog(null, "There is already a user with the same DNI");
	}
	public client getData(int num){
		return clients.get(num);
	}
	public void changeData(Config configApp, Language language){
		try{
			int action=0;
			String dni;
			int num = Functions.validateint("Type the number of"
					+ " the admin to change", "Change users");
			
			dni=clients.get(num-1).getDni();
			functions_users.getuser(clients.get(num-1), 0, configApp, language);
			for(int i=0;i<clients.size();i++){
				if(clients.get(num-1).equals(clients.get(i),0)){
					if(i!=num-1)
						action++;
				}
			}
			if(action!=0){
				clients.get(num-1).setDni(dni);
				JOptionPane.showMessageDialog(null, "There is already a user with that DNI");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"The admin does not exist");
		}
	}
	public void printArraylist(Config configApp){
		int times=0;
		
		for (int i = 0; i<clients.size();i++){
			JOptionPane.showMessageDialog(null, (i+1)+":\n"+clients.get(i).toString(configApp));
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
			for(int i = 0;i<clients.size();i++){
				if(clients.get(i).equals(admin1,0)){
					JOptionPane.showMessageDialog(null,clients.get(i).toString(config));
					times++;
				}
			}
			if(times==0)
				JOptionPane.showMessageDialog(null, "No admins found");
			break;
		case 1://By name
			admin1.setName(Functions.validatestring("Type the Name of the user you are looking for", "Search by Name"));
			for(int i = 0;i<clients.size();i++){
				if(clients.get(i).equals(admin1,1)){
					JOptionPane.showMessageDialog(null,clients.get(i).toString(config));
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
			Collections.sort(clients);
			break;
		case 1:
			//Collections.sort(clients, new sortbyName());
			break;
		case 2:
			//Collections.sort(clients, new sortbyAge());
			break;
		}
		
	}
	/*public void changeFormatCurrency(Config configApp, char monedaAnterior){
		try{
			for(int i = 0;i<clients.size();i++){
				clients.get(i).changeCurrency(configApp, monedaAnterior);
			}
		}catch(Exception e){};
	}*/
	public void deleteData(){
		try{
			clients.remove(Functions.validateint("Type the number of the user to delete", "Delete entries")-1);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"The client does not exist");
		}
	}
}
