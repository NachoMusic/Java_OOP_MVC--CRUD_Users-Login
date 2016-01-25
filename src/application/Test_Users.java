package application;
//nombre dni fechanac edad puntos
import javax.swing.JOptionPane;
import application.models.Config;
import application.models.Language;
import application.modules.users.model.models.admin;
import application.modules.users.model.models.singleton;
import application.modules.users.model.utils.Arraylist_admin;
import application.modules.users.model.utils.Arraylist_client;
import application.modules.users.model.utils.Arraylist_registered_user;
import application.modules.users.model.utils.functions_users;
import application.modules.users.model.utils.lib_files.json;
import application.modules.users.model.utils.lib_files.txt;
import application.modules.users.model.utils.lib_files.xml;
import application.utils.LookAndFeel;
import application.utils.Menus;

public class Test_Users {

	public static void main(String[] args){
		Language language =new Language("English");
		int option,continuar=0;
		char monedaAnterior='€';
		boolean continuar2=true;
		@SuppressWarnings("unused")
		admin dummy1 = new admin("12345678A", "Nacho", "Valera", "987654321", "asdf@asdf.asdf", "Usuario", "Pass",
				"Avatar", "Online", "16/10/1996", "14/12/2014",1234.1234f, 1234);
		@SuppressWarnings("unused")
		admin dummy2 = new admin("12345678Z", "Dummy", "Dummy", "123456789", "dummy@gmail.com", "DummyUser", "Pass",
				"Avatar.jpg", "Offline", "30/11/1994", "10/11/2012",1234.1234f, 123);
		singleton.configApp = new Config();
		singleton.admins = new Arraylist_admin();
		singleton.clients = new Arraylist_client();
		singleton.registered_users = new Arraylist_registered_user();
		
		switch(singleton.configApp.getSavingextension()){
		case "json"://json
			//json.load_json();
			json.load_json_auto();;
			break;
		case "xml"://xml
			xml.load_xml_auto();
			break;
		case "txt": //txt
			txt.load_txt_auto();
			break;
		}
		
		while(continuar!=4){
			String[] vec = {language.getProperty("admin"),language.getProperty("client"),
					language.getProperty("registered_user"),language.getProperty("config"),
					language.getProperty("exit")};
			String[] vec1 = {language.getProperty("create"), language.getProperty("change_data"), language.getProperty("print_data"),
					"Delete","Find","Sort by","Export","Import",language.getProperty("go_back"), language.getProperty("exit")};
			String[] find = {"By DNI","By name",language.getProperty("go_back")};
			String[] sortBy = {"By DNI","By name","By birthday",language.getProperty("go_back")};
			String[] config = {language.getProperty("date"),language.getProperty("currency"),language.getProperty("decimals"),
					language.getProperty("lang"),"Saving extension","Look and Feel","Reestablecer conf",language.getProperty("go_back"), language.getProperty("exit")};
			String[] dateconfig = {"dd/mm/yyyy","dd-mm-yyyy","yyyy/mm/dd","yyyy-mm-dd",language.getProperty("go_back"), language.getProperty("exit")};
			String[] currencyconfig = {"Euro \u20ac", "Dollar $", "Libra �",language.getProperty("go_back"),language.getProperty("exit")};
			String[] languageconfig = {language.getProperty("english"), language.getProperty("spanish"),language.getProperty("go_back"),
					language.getProperty("exit")};
			String[] decimalsconfig = {language.getProperty("1decimal"),language.getProperty("2decimal"),language.getProperty("3decimal"),
					language.getProperty("go_back"), language.getProperty("exit")};
			String[] save = {"Save on JSON","Save on XML","Save on TXT",language.getProperty("go_back")};
			String[] looknfeel = {"Metal","GTK Windows","CDE/Motif","Nimbus",language.getProperty("go_back")};
			LookAndFeel.selectTheme(singleton.configApp.getLookandfeel());

			option=Menus.menu(vec, language.getProperty("choose_an_option"),language.getProperty("application_users"));
			switch(option){
			case 0://Admins
				do{
					continuar2=true;
					option=Menus.menu(vec1, language.getProperty("admin"), language.getProperty("application_users"));
					switch(option){
					case 0:
						singleton.admins.addData(functions_users.newadmin(language));
						//FileSave.saveadmin(admin1); for saving on files, will come eventually
						break;
					case 1:
						singleton.admins.changeData(language);
						break;
					case 2://Print
						singleton.admins.printArraylist();
						break;
					case 3://Delete
						singleton.admins.deleteData();
						break;
					case 4://Find
						option=Menus.menu(find, "Searh admins", "Search");
						switch(option){
						case 0://By dni
							singleton.admins.find(0);
							break;
						case 1://By name
							singleton.admins.find(1);
							break;
						case 2://Go back
						}
						break;
					case 5://Sort by
						
						option=Menus.menu(sortBy, "Sort admins", "Sort");
						switch(option){
						case 0://By dni
							singleton.admins.sortData(0);
							break;
						case 1://By name
							singleton.admins.sortData(1);
							break;
						case 2://By date birthday
							singleton.admins.sortData(2);
							break;
						case 3://Go back
						}
						break;
					case 6://Save
						//option=Menus.menu(save, "Save admins", "Save");
						switch(singleton.configApp.getSavingextension()){
						case "json"://json
							json.createjson();
							break;
						case "xml"://xml
							xml.createxml();
							break;
						case "txt"://txt
							txt.createtxt();
							break;
						}
						break;
					case 7://Load
						//option=Menus.menu(load, "Save admins", "Save");
						switch(singleton.configApp.getSavingextension()){
						case "json"://json
							json.load_json();
							break;
						case "xml"://xml
							xml.load_xml();
							break;
						case "txt": //txt
							txt.load_txt();
							break;
						}
						break;
					case 8:
						continuar2=false;
						break;
					case 9:
						continuar2=false;
						continuar=4;
						break;
					}				
				}while(continuar2);
				break;
			case 1://Clients
				do{
					continuar2=true;
					option=Menus.menu(vec1, "Client", "Application Users");
					switch(option){
					case 0:
						singleton.clients.addData(functions_users.newclient());
						break;
					case 1:
						singleton.clients.changeData(language);
						break;
					case 2:
						singleton.clients.printArraylist();
						break;
					case 3://Delete
						singleton.clients.deleteData();
						break;
					case 4://Find
						option=Menus.menu(find, "Searh clients", "Search");
						switch(option){
						case 0://By dni
							singleton.clients.find(0);
							break;
						case 1://By name
							singleton.clients.find(1);
							break;
						case 2://Go back
						}
						break;
					case 5://Sort by
						option=Menus.menu(sortBy, "Sort admins", "Sort");
						switch(option){
						case 0://By dni
							singleton.clients.sortData(0);
							break;
						case 1://By name
							singleton.clients.sortData(1);
							break;
						case 2://By date birthday
							singleton.clients.sortData(2);
							break;
						case 3://Go back
						}
						break;
					case 6://Save
						break;
					case 7://Load
						break;
					case 8:
						continuar2=false;
						break;
					case 9:
						continuar2=false;
						continuar=4;
						break;
					}
				}while(continuar2);
				break;
			case 2://Registered_users
				do{
					continuar2=true;
					option=Menus.menu(vec1, "Registered user", "Application Users");
					switch(option){
					case 0://Add data
						singleton.registered_users.addData(functions_users.newregistered_user());
						break;
					case 1:
						singleton.registered_users.changeData(language);	
						break;
					case 2:
						singleton.registered_users.printArraylist();
						break;
					case 3://Delete
						singleton.registered_users.deleteData();
						break;
					case 4://Find
						option=Menus.menu(find, "Searh registered users", "Search");
						switch(option){
						case 0://By dni
							singleton.registered_users.find(0);
							break;
						case 1://By name
							singleton.registered_users.find(1);
							break;
						case 2://Go back
						}
						break;
					case 5://Sort by
						option=Menus.menu(sortBy, "Sort admins", "Sort");
						switch(option){
						case 0://By dni
							singleton.registered_users.sortData(0);
							break;
						case 1://By name
							singleton.registered_users.sortData(1);
							break;
						case 2://By date birthday
							singleton.registered_users.sortData(2);
							break;
						case 3://Go back
						}
						break;
					case 6://Save
						break;
					case 7://Load
						break;
					case 8:
						continuar2=false;
						break;
					case 9:
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
							singleton.configApp.getDate_config()+"     "+language.getProperty("currency2")+singleton.configApp.getCurrency_config()+
					"     "+language.getProperty("decimals2")+singleton.configApp.getDecimals_config()+"     "+language.getProperty("language")+singleton.configApp.getLanguage_config(),
					language.getProperty("config"));
					switch(option){
					case 0://date format
						option=Menus.menu(dateconfig,language.getProperty("dateconf2"), language.getProperty("dateconf"));
						switch(option){
						case 0:// dd/mm/yyyy
							singleton.configApp.setDate_config(0);
							break;
						case 1:
							singleton.configApp.setDate_config(1);
							break;
						case 2:
							singleton.configApp.setDate_config(2);
							break;
						case 3:
							singleton.configApp.setDate_config(3);
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
							monedaAnterior=singleton.configApp.getCurrency_config();
							singleton.configApp.setCurrency_config('€');
							singleton.admins.changeFormatCurrency(monedaAnterior);
							break;
						case 1:
							monedaAnterior=singleton.configApp.getCurrency_config();
							singleton.configApp.setCurrency_config('$');
							singleton.admins.changeFormatCurrency(monedaAnterior);
							break;
						case 2:
							monedaAnterior=singleton.configApp.getCurrency_config();
							singleton.configApp.setCurrency_config('£');
							singleton.admins.changeFormatCurrency(monedaAnterior);
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
							singleton.configApp.setDecimals_config(1);
							break;
						case 1:
							singleton.configApp.setDecimals_config(2);
							break;
						case 2:
							singleton.configApp.setDecimals_config(3);
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
							singleton.configApp.setLanguage_config("English");
							language.setIdioma(singleton.configApp.getLanguage_config());
							continuar2=false;
							break;
						case 1:
							singleton.configApp.setLanguage_config("Spanish");
							language.setIdioma(singleton.configApp.getLanguage_config());
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
					case 4://Saving extension
						option=Menus.menu(save, "Save admins", "Save");
						switch(option){
						case 0://json
							singleton.configApp.setSavingextension("json");
							break;
						case 1://xml
							singleton.configApp.setSavingextension("xml");
							break;
						case 2://txt
							singleton.configApp.setSavingextension("txt");
							break;
						case 3://Go back
						}
						break;
					case 5://Look and feel
						option=Menus.menu(looknfeel, "Look and Feel", "Themes");
						switch(option){
						case 0://Metal
							singleton.configApp.setLookandfeel(0);
							break;
						case 1:// GTK - WINDOWS
							singleton.configApp.setLookandfeel(1);
							break;
						case 2:// CDE/Moti
							singleton.configApp.setLookandfeel(2);
							break;
						case 3:// Nimbus
							singleton.configApp.setLookandfeel(3);
							break;
						case 4:
						}
						continuar2=false;
						break;
					case 6://Resets the default configuration
						monedaAnterior=singleton.configApp.getCurrency_config();
						singleton.configApp = new Config();
						language.setIdioma(singleton.configApp.getLanguage_config());
						for(int i = 0;i<singleton.admins.getAdmins().size();i++){
							singleton.admins.getData(i).changeCurrency(monedaAnterior);
						}
						break;
					case 7:
						continuar2=false;
						break;
					case 8:
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
		json.createjson_auto();
		xml.createxml_auto();
		txt.createtxt_auto();
		language.getProperty("Spanish");
		JOptionPane.showMessageDialog(null, language.getProperty("goodbye"));
	}
}
