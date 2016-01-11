package application.modules.users.utils;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import application.models.Config;
import application.modules.users.kernel.GenericKernel;
import application.modules.users.models.admin;
import application.utils.Functions;

public class Arraylist {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private ArrayList<admin> admins = new ArrayList();
	
	public Arraylist(){
		//constructor
	}
	public void addData(admin a){
		admins.add(a);
	}
	public admin getData(int num){
		return admins.get(num);
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
	public void sortData(){

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
