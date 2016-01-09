package application;

import javax.swing.JOptionPane;
import application.models.Config;
import application.models.Language;
import application.modules.users.kernel.GenericKernel;
import application.modules.users.models.admin;
import application.modules.users.models.client;
import application.modules.users.models.registered_user;
import application.modules.users.utils.Arraylist;
import application.modules.users.utils.functions_users;
import application.utils.Functions;
import application.utils.Menus;

public class Test_Users {

	public static void main(String[] args){
		Language language =new Language("English");
		int option,continuar=0;
		char monedaAnterior='€';
		boolean continuar2=true;
		admin admin1 = new admin();
		client client1 = new client();
		registered_user registered_user1 = new registered_user();
		@SuppressWarnings("unused")
		admin dummy1 = new admin("12345678A", "Nacho", "Valera", "987654321", "asdf@asdf.asdf", "Usuario", "Pass",
				"Avatar", "Online", "16/10/1996", "14/12/2014",1234.1234f, 1234);
		@SuppressWarnings("unused")
		admin dummy2 = new admin("12345678Z", "Dummy", "Dummy", "123456789", "dummy@gmail.com", "DummyUser", "Pass",
				"Avatar.jpg", "Offline", "30/11/1994", "10/11/2012",1234.1234f, 123);
		Config configApp = new Config();
		Arraylist admins = new Arraylist();
		admin[] adminsvec=null;
		
		while(continuar!=4){
			String[] vec = {language.getProperty("admin"),language.getProperty("client"),
					language.getProperty("registered_user"),language.getProperty("config"),
					language.getProperty("exit")};
			String[] vec1 = {language.getProperty("create"), language.getProperty("change_data"), language.getProperty("print_data"),
					"Delete","Find","Sort by",language.getProperty("go_back"), language.getProperty("exit")};
			String[] find = {"By DNI","By name",language.getProperty("go_back")};
			String[] config = {language.getProperty("date"),language.getProperty("currency"),language.getProperty("decimals"),
					language.getProperty("lang"),"Reestablecer conf",language.getProperty("go_back"), language.getProperty("exit")};
			String[] dateconfig = {"dd/mm/yyyy","dd-mm-yyyy","yyyy/mm/dd","yyyy-mm-dd",language.getProperty("go_back"), language.getProperty("exit")};
			String[] currencyconfig = {"Euro €", "Dollar $", "Libra £",language.getProperty("go_back"),language.getProperty("exit")};
			String[] languageconfig = {language.getProperty("english"), language.getProperty("spanish"),language.getProperty("go_back"),
					language.getProperty("exit")};
			String[] decimalsconfig = {language.getProperty("1decimal"),language.getProperty("2decimal"),language.getProperty("3decimal"),
					language.getProperty("go_back"), language.getProperty("exit")};
			
			option=Menus.menu(vec, language.getProperty("choose_an_option"),language.getProperty("application_users"));
			switch(option){
			case 0:
				do{
					continuar2=true;
					option=Menus.menu(vec1, language.getProperty("admin"), language.getProperty("application_users"));
					switch(option){
					case 0:
						//admin1=functions_users.newadmin(configApp, language);
						admins.addData(functions_users.newadmin(configApp, language));
						//FileSave.saveadmin(admin1); for saving on files, will come eventually
						adminsvec = admins.printArraylist(); 
						break;
					case 1:
						try{
							functions_users.getuser(admins.getData(Functions.validateint("Type the number of"
									+ " the admin to change", "Change users")-1),0,configApp,language);
						}catch(Exception e){
							JOptionPane.showMessageDialog(null,"The admin does not exist");
						}
						adminsvec = admins.printArraylist();
						break;
					case 2:
						//JOptionPane.showMessageDialog(null,admin1.toString(configApp));
						try{
							for(int i = 0;i<adminsvec.length;i++){
								JOptionPane.showMessageDialog(null,(i+1)+":\n"+adminsvec[i].toString(configApp));
							}
						}catch(Exception e){
							JOptionPane.showMessageDialog(null,"You have to create an admin first");
						};
						break;
					case 3://Delete
						try{
							admins.deleteData(Functions.validateint("Type the number of the user to delete", "Delete entries")-1);
						}catch(Exception e){
							JOptionPane.showMessageDialog(null,"You have to create an admin first");
						}
						adminsvec = admins.printArraylist(); 
						break;
					case 4://Find
						option=Menus.menu(find, "Searh admins", "Search");
						switch(option){
						case 0://By dni
							admin1.setDni(GenericKernel.insertDni("Type the DNI of the user you are looking for", "Search by DNI"));
							for(int i = 0;i<adminsvec.length;i++){
								if(adminsvec[i].equals(admin1,0)){
									JOptionPane.showMessageDialog(null,adminsvec[i].toString());
								}
							}
							break;
						case 1://By name
							admin1.setName(Functions.validatestring("Type the DNI of the user you are looking for", "Search by DNI"));
							for(int i = 0;i<adminsvec.length;i++){
								if(adminsvec[i].equals(admin1,1)){
									JOptionPane.showMessageDialog(null,adminsvec[i].toString());
								}
							}
							break;
						case 2://Go back
						}
						break;
					case 5://Sort by
						break;
					case 6:
						continuar2=false;
						break;
					case 7:
						continuar2=false;
						continuar=4;
						break;
					}				
				}while(continuar2);
				break;
			case 1:
				do{
					continuar2=true;
					option=Menus.menu(vec1, "Client", "Application Users");
					switch(option){
					case 0:
						client1=functions_users.newclient(configApp);
						break;
					case 1:
						functions_users.getuser(client1,1,configApp,language);
						break;
					case 2:
						JOptionPane.showMessageDialog(null,client1.toString());
						break;
					case 3://Delete
						break;
					case 4://Find
						break;
					case 5://Sort by
						break;
					case 6:
						continuar2=false;
						break;
					case 7:
						continuar2=false;
						continuar=4;
						break;
					}
				}while(continuar2);
				break;
			case 2:
				do{
					continuar2=true;
					option=Menus.menu(vec1, "Registered user", "Application Users");
					switch(option){
					case 0:
						registered_user1=functions_users.newregistered_user(configApp);
						break;
					case 1:
						functions_users.getuser(registered_user1,2,configApp,language);		
						break;
					case 2:
						JOptionPane.showMessageDialog(null,registered_user1.toString());
						break;
					case 3://Delete
						break;
					case 4://Find
						break;
					case 5://Sort by
						break;
					case 6:
						continuar2=false;
						break;
					case 7:
						continuar2=false;
						continuar=4;
						break;
					}					
				}while(continuar2);
				break;
			case 3:
				do{
					continuar2=true;
					option=Menus.menu(config, language.getProperty("config2")+"\n"+language.getProperty("date2")+
					configApp.getDate_config()+"     "+language.getProperty("currency2")+configApp.getCurrency_config()+
					"     "+language.getProperty("decimals2")+configApp.getDecimals_config()+"     "+language.getProperty("language")+configApp.getLanguage_config(),
					language.getProperty("config"));
					switch(option){
					case 0://date format
						option=Menus.menu(dateconfig,language.getProperty("dateconf2"), language.getProperty("dateconf"));
						switch(option){
						case 0:// dd/mm/yyyy
							configApp.setDate_config(0);
							
							break;
						case 1:
							configApp.setDate_config(1);
							
							break;
						case 2:
							configApp.setDate_config(2);
							
							break;
						case 3:
							configApp.setDate_config(3);
							break;
						case 4:
							continuar2=false;
							break;
						case 5:
							continuar2=false;
							continuar=4;
							break;
						}				
						break;
					case 1://Currency format
						option=Menus.menu(currencyconfig, "Currency config", "Configuration about the currency");
						switch(option){
						case 0:
							monedaAnterior=configApp.getCurrency_config();
							configApp.setCurrency_config('€');
							try{
								for(int i = 0;i<adminsvec.length;i++){
									adminsvec[i].changeCurrency(configApp, monedaAnterior);
								}
							}catch(Exception e){};
							
						
							break;
						case 1:
							monedaAnterior=configApp.getCurrency_config();
							configApp.setCurrency_config('$');
							//admin1.changeCurrency(configApp, monedaAnterior);
							try{
								for(int i = 0;i<adminsvec.length;i++){
									adminsvec[i].changeCurrency(configApp, monedaAnterior);
								}
							}catch(Exception e){};
							break;
						case 2:
							monedaAnterior=configApp.getCurrency_config();
							configApp.setCurrency_config('£');
							//admin1.changeCurrency(configApp, monedaAnterior);
							try{
								for(int i = 0;i<adminsvec.length;i++){
									adminsvec[i].changeCurrency(configApp, monedaAnterior);
								}
							}catch(Exception e){};
							break;
						case 3:
							continuar2=false;
							break;
						case 4:
							continuar2=false;
							continuar=4;
							break;
						}				
						break;
					case 2://Decimals
						option=Menus.menu(decimalsconfig, language.getProperty("decimalsconf2"), language.getProperty("decimalsconf"));
						switch(option){
						case 0:
							configApp.setDecimals_config(1);
							break;
						case 1:
							configApp.setDecimals_config(2);
							break;
						case 2:
							configApp.setDecimals_config(3);
							break;
						case 3:
							continuar2=false;
							break;
						case 4:
							continuar2=false;
							continuar=4;
							break;
						}				
						break;
					case 3://Language
						option=Menus.menu(languageconfig, language.getProperty("dateconf"), language.getProperty("dateconf2"));
						switch(option){
						case 0:
							configApp.setLanguage_config("English");
							language.setIdioma(configApp.getLanguage_config());
							continuar2=false;
							break;
						case 1:
							configApp.setLanguage_config("Spanish");
							language.setIdioma(configApp.getLanguage_config());
							continuar2=false;
							break;
						case 2:
							continuar2=false;
							break;
						case 3:
							continuar2=false;
							continuar=4;
							break;
						}				
						break;
					case 4://Reestablece la configuración por defecto
						monedaAnterior=configApp.getCurrency_config();
						configApp = new Config();
						language.setIdioma(configApp.getLanguage_config());
						admin1.changeCurrency(configApp, monedaAnterior);
						break;
					case 5:
						continuar2=false;
						break;
					case 6:
						continuar2=false;
						continuar=4;
						break;
					}		
				}while(continuar2);
				break;
			case 4:
				continuar=4;
				}
		}
		language.getProperty("Spanish");
		JOptionPane.showMessageDialog(null, language.getProperty("goodbye"));
	}
}
