package application.modules.users.utils;

import application.models.Config;
import application.models.Language;
import application.modules.users.kernel.GenericKernel;
import application.modules.users.models.admin;
import application.modules.users.models.client;
import application.modules.users.models.registered_user;
import application.modules.users.models.users;
import application.utils.Functions;
import application.utils.Menus;

public class functions_users {
	
	public static admin newadmin(Config arg, Language language){
		String dni, name, subname, phone_number, email, user, pass,
		avatar, state, date_birthday, hiring_date;
		float salary;
		int activity;
		String dateFormat="";
		
		switch(arg.getDate_config()){
		case 0:
			dateFormat="dd/mm/yyyy";
			break;
		case 1:
			dateFormat="dd-mm-yyyy";
			break;
		case 2:
			dateFormat="yyyy/mm/dd";
			break;
		case 3:
			dateFormat="yyyy-mm-dd";
			break;
		}
		dni=GenericKernel.insertDni(language.getProperty("typedni"), "DNI");
		name=GenericKernel.insertText(language.getProperty("name"), language.getProperty("name2"));
		subname=GenericKernel.insertText(language.getProperty("subname"), language.getProperty("subname2"));
		phone_number=GenericKernel.insertPhone(language.getProperty("insertphone"), language.getProperty("insertphone2"));
		email=GenericKernel.insertEmail(language.getProperty("email"), "Email");
		user=Functions.validatestring(language.getProperty("user"), language.getProperty("user2"));
		pass=Functions.validatestring(language.getProperty("pass"),language.getProperty("pass2"));
		avatar=Functions.validatestring(language.getProperty("avatar"), language.getProperty("avatar2"));
		state=Functions.validatestring(language.getProperty("state"), language.getProperty("state2"));
		date_birthday=GenericKernel.insertDateBirthday(language.getProperty("date_birthday")+dateFormat, language.getProperty("date_birthday2"),arg);
		hiring_date=GenericKernel.insertUpDate(language.getProperty("hiring_date")+dateFormat, language.getProperty("hiring_date2"),date_birthday,arg);
		salary=Functions.validatefloat(language.getProperty("salary"),language.getProperty("salary2"));
		activity=Functions.validateint(language.getProperty("activity"), language.getProperty("activity2"));
		return new admin(dni,name,subname,phone_number,email,user,pass,avatar,state,
				date_birthday,hiring_date,salary,activity);
	}
	public static client newclient(Config arg){
		String dni, name, subname, phone_number, email, user, pass,
		avatar, state, date_birthday, discharge_date, client_type;
		float shopping;
		boolean premium;
		String dateFormat="";
		
		switch(arg.getDate_config()){
		case 0:
			dateFormat="dd/mm/yyyy";
			break;
		case 1:
			dateFormat="dd-mm-yyyy";
			break;
		case 2:
			dateFormat="yyyy/mm/dd";
			break;
		case 3:
			dateFormat="yyyy-mm-dd";
			break;
		}
		dni=GenericKernel.insertDni("Type your DNI  \n XXXXXXXXA", "Dni");
		name=GenericKernel.insertText("Type your name", "Name");
		subname=GenericKernel.insertText("Type your subname", "Subname");
		phone_number=GenericKernel.insertPhone("Type your Phone Number", "Phone number");
		email=GenericKernel.insertEmail("Type your email \n ejemplo@ejemplo.ejemplo", "Email");
		user=Functions.validatestring("Type your username", "Username");
		pass=Functions.validatestring("Type your password", "Password");
		avatar=Functions.validatestring("Type the link to the avatar", "Avatar");
		state=Functions.validatestring("Type your state", "State");
		date_birthday=GenericKernel.insertDateBirthday("Type your date birthday \n"+dateFormat, "Date birthday",arg);
		discharge_date=GenericKernel.insertUpDate("Type your discgarge date \n"+dateFormat, "Discgarge Date",date_birthday,arg);
		client_type=Functions.validatestring("Type your client type", "Client Type");
		shopping=Functions.validatefloat("Type your shopping", "Shopping");
		premium=Functions.validateboolean("Type if you are premium or not","Premium");
		return new client(dni,name,subname,phone_number,email,user,pass,avatar,state,
				date_birthday,discharge_date,client_type,shopping,premium);
	}
	public static registered_user newregistered_user(Config arg){
		String dni, name, subname, phone_number, email, user, pass,
		avatar, state, date_birthday, karma="";
		int activity;
		String dateFormat="";
		
		switch(arg.getDate_config()){
		case 0:
			dateFormat="dd/mm/yyyy";
			break;
		case 1:
			dateFormat="dd-mm-yyyy";
			break;
		case 2:
			dateFormat="yyyy/mm/dd";
			break;
		case 3:
			dateFormat="yyyy-mm-dd";
			break;
		}
		
		dni=GenericKernel.insertDni("Type your DNI  \n XXXXXXXXA", "Dni");
		name=GenericKernel.insertText("Type your name", "Name");
		subname=GenericKernel.insertText("Type your subname", "Subname");
		phone_number=GenericKernel.insertPhone("Type your Phone Number", "Phone number");
		email=GenericKernel.insertEmail("Type your email \n ejemplo@ejemplo.ejemplo", "Email");
		user=Functions.validatestring("Type your username", "Username");
		pass=Functions.validatestring("Type your password", "Password");
		avatar=Functions.validatestring("Type the link to the avatar", "Avatar");
		state=Functions.validatestring("Type your state", "State");
		date_birthday=GenericKernel.insertDateBirthday("Type your date birthday \n"+dateFormat, "Date birthday",arg);
		String[] vec = {"Alto","Medio","Bajo"};
		switch(Menus.menu(vec, "Choose the Karma", "Karma")){
		case 0:
			karma="High";
			break;
		case 1:
			karma="Medium";
			break;
		case 2:
			karma="Low";
			break;
		}
		activity=Functions.validateint("Type your activity", "Activity");
		
		return new registered_user(dni,name,subname,phone_number,email,user,pass,avatar,state,
				date_birthday,karma,activity);
	}
	public static void getuser(users param, int a, Config arg, Language language){
		int edit=14;
		String dateFormat="";
		switch(arg.getDate_config()){
		case 0:
			dateFormat="dd/mm/yyyy";
			break;
		case 1:
			dateFormat="dd-mm-yyyy";
			break;
		case 2:
			dateFormat="yyyy/mm/dd";
			break;
		case 3:
			dateFormat="yyyy-mm-dd";
			break;
		}
		
		switch(a){
		case 0:
			edit=Functions.validateint("Type a number for editing:\n"
					+ " 1 -> DNI\n 2 -> Name\n 3 -> Subname\n 4 -> Phone number\n 5 -> Email"
					+" \n 6 -> Username\n 7 -> Pass\n 8 -> Avatar\n 9 -> State\n"
					+ " 10 -> Date Birthday\n 11 -> Hirin Date\n 12 -> Salary"
					+ " \n 13 -> Activity", "EDIT");
			
			switch(edit){
			case 11:
				((admin) param).setHirin_date(GenericKernel.insertUpDate("Type your hiring date \n"+dateFormat, "Hiring Date",param.getDate_birthday(),arg));
				break;
			case 12:
				((admin) param).setSalary(Functions.validatefloat(language.getProperty("salary"), language.getProperty("salary2")));
				break;
			case 13:
				((admin) param).setActivity(Functions.validateint(language.getProperty("activity"), language.getProperty("activity2")));
				break;
			}
			break;
		case 1:
			edit=Functions.validateint("Type a number for editing:\n"
					+ " 1 -> DNI\n 2 -> Name\n 3 -> Subname\n 4 -> Phone number\n 5 -> Email"
					+" 6 -> Username\n 7 -> Pass\n 8 -> Avatar\n 9 -> State\n"
					+ " 10 -> Date Birthday\n 11 -> Discharge date\n"
					+ " 12 -> Client type\n 13 Shopping\n 14-> Premium", "EDIT");
			switch(edit){
			case 11:
				((client) param).setDischarge_date(GenericKernel.insertUpDate("Introduce el nuevo discharge date "+dateFormat, "discharge date", param.getDate_birthday(),arg));
				break;
			case 12:
				((client) param).setClient_type(Functions.validatestring("Introduce el nuevo client type", "client type"));
				break;
			case 13:
				((client) param).setShopping(Functions.validateint("Introduce el nuevo Shopping", "Shopping"));
				break;
			case 14:
				((client) param).setPremium(Functions.validateboolean("Introduce si es Premium", "Premium"));
			}
			break;
		case 2:
			edit=Functions.validateint("Type a number for editing:\n"
					+ " 0 -> DNI\n 1 -> Name\n 2 -> Subname\n 3 -> Phone number\n 4 -> Email"
					+" 5 -> Username\n 6 -> Pass\n 7 -> Avatar\n 8 -> State\n"
					+ " 9 -> Date Birthday\n 10 -> Karma\n 11 -> Activity\n"
					, "EDIT");
			switch(edit){
			case 10:
				String[] vec = {"Alto","Medio","Bajo"};
				String karma = null;
				switch(Menus.menu(vec, "Choose the Karma", "Karma")){
				case 0:
					karma="High";
					break;
				case 1:
					karma="Medium";
					break;
				case 2:
					karma="Low";
					break;
				}
				((registered_user) param).setKarma(karma);
				break;
			case 11:
				((registered_user) param).setActivity(Functions.validateint("Introduce el nuevo activity", "activity"));
				break;
			}
			break;
		}
		switch(edit){
		case 1:
			param.setDni(GenericKernel.insertDni(language.getProperty("typedni"), "DNI"));
			break;
		case 2:
			param.setName(GenericKernel.insertText(language.getProperty("name"), language.getProperty("name2")));
			break;
		case 3:
			param.setSubname(GenericKernel.insertText(language.getProperty("subname"), language.getProperty("subname2")));
			break;
		case 4:
			param.setPhone_number(GenericKernel.insertPhone(language.getProperty("insertphone"), language.getProperty("insertphone2")));
			break;
		case 5:
			param.setEmail(GenericKernel.insertEmail(language.getProperty("email"), "Email"));
			break;
		case 6:
			param.setUser(Functions.validatestring(language.getProperty("user"), language.getProperty("user2")));
			break;
		case 7:
			param.setPass(Functions.validatestring(language.getProperty("pass"), language.getProperty("pass2")));
			break;
		case 8:
			param.setAvatar(Functions.validatestring(language.getProperty("avatar"),language.getProperty("avatar2")));
			break;
		case 9:
			param.setState(Functions.validatestring(language.getProperty("state"), language.getProperty("state2")));
			break;
		case 10:
			param.setDate_birthday(GenericKernel.insertDateBirthday(language.getProperty("date_birthday")+dateFormat, language.getProperty("date_birthday2"),arg));
			break;
		}
	}
}
