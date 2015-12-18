package application.modules.users.kernel;

import javax.swing.JOptionPane;
import application.models.Config;
import application.models.Dates;
import application.utils.Functions;
import application.utils.Validate;

public class GenericKernel {
	public static String insertDni(String arg1, String arg2){
		String DNIletters="TRWAGMYFPDXBNJZSQVHLCKET";
		String number="";
		int numberint;
		char lettercalc=' ',lettergiven=' ';
		boolean validate=false;
		String dni="";
		
		do{
			do{
				validate=Validate.validateDni(dni=Functions.validatestring(arg1,arg2));
				if(!validate)
					JOptionPane.showMessageDialog(null, "You have not introduced a valid argument");
			}while(!validate);
			int[] vec = new int[dni.length()-1];
			for(int i = 0;i<dni.length()-1;i++){
				vec[i]=dni.charAt(i)- '0';
			}
			for(int i=0;i<dni.length()-1;i++){
				number+=vec[i];
			}
			numberint=Integer.parseInt(number);
			lettercalc=DNIletters.charAt(numberint%23);

			lettergiven=(dni.toUpperCase()).charAt(8);
			
			if(lettercalc!=lettergiven){
				JOptionPane.showMessageDialog(null, "The DNI is not correct, the letter does not match the numbers.");
				validate=false;
				lettergiven=' ';
				numberint=0;
				lettercalc=' ';
				number="";
				dni="";
				vec=null;
			}
		}while(!validate);
		return dni;
	}
	public static String insertText(String arg1, String arg2){
		boolean validate=false;
		String text="";
		
		while(!validate){
			validate=Validate.validateText(text=Functions.validatestring(arg1,arg2));
			if(!validate)
				JOptionPane.showMessageDialog(null, "You have not introduced a valid argument");
		}
		return text;
	}
	public static String insertPhone(String arg1, String arg2){
		boolean validate=false;
		String phone="";
		
		while(!validate){
			validate=Validate.validatePhone(phone=Functions.validatestring(arg1,arg2));
			if(!validate)
				JOptionPane.showMessageDialog(null, "You have not introduced a valid argument");
		}
		return phone;
	}
	public static String insertEmail(String arg1, String arg2){
		boolean validate=false;
		String email="";
		
		while(!validate){
			validate=Validate.validateEmail(email=Functions.validatestring(arg1,arg2));
			if(!validate)
				JOptionPane.showMessageDialog(null, "You have not introduced a valid argument");
		}
		return email;
	}
	/**
	 * Insert Date
	 * @param arg1 Message
	 * @param arg2 Title
	 * @return the date in a String
	 * This function is used by insertDateBirthday() and insertUpDate()
	 */
	public static String insertDate(String arg1, String arg2, Config arg){
		boolean validate=false;
		String date="",month="",day="",year="";
		int daynum=0,yearnum=0;
		
		while(!validate){
			month="";
			day="";
			year="";
			switch(arg.getDate_config()){
			case 0: 
				validate=Validate.validateDate1(date=Functions.validatestring(arg1,arg2));
				break;
			case 1:
				validate=Validate.validateDate2(date=Functions.validatestring(arg1,arg2));
				break;
			case 2:
				validate=Validate.validateDate3(date=Functions.validatestring(arg1,arg2));
				break;
			case 3:
				validate=Validate.validateDate4(date=Functions.validatestring(arg1,arg2));
				break;
				
			}
			
			try{
				if(arg.getDate_config()<2){
				day+=date.charAt(0);
				day+=date.charAt(1);
				month+=date.charAt(3);
				month+=date.charAt(4);
				year+=date.charAt(6);
				year+=date.charAt(7);
				year+=date.charAt(8);
				year+=date.charAt(9);
				}
				else{
				day+=date.charAt(8);
				day+=date.charAt(9);
				month+=date.charAt(5);
				month+=date.charAt(6);
				year+=date.charAt(0);
				year+=date.charAt(1);
				year+=date.charAt(2);
				year+=date.charAt(3);
				}
				daynum=Integer.parseInt(day);
				yearnum=Integer.parseInt(year);
			}catch(Exception e){}
			switch(month){
			case "02"://February
				if(daynum>29){
					validate=false;
				}
				if(daynum==29&&yearnum%4!=0){
					validate=false;
				}
				break;
			case "04"://April
				if(daynum>30){
					validate=false;
				}
				break;
			case "06"://June
				if(daynum>30){
					validate=false;
				}
				break;
			case "09"://September
				if(daynum>30){
					validate=false;
				}
				break;
			case "11"://November
				if(daynum>30){
					validate=false;
				}
			}
			if(!validate)
				JOptionPane.showMessageDialog(null, "You have not introduced a valid argument");
		}
		return date;
	}
	/**
	 *  InsertDateBirthday
	 * @param arg1	Message
	 * @param arg2	Title
	 * @return	The date in a String
	 */
	public static String insertDateBirthday(String arg1, String arg2, Config arg){
		boolean valid=true;
		Dates date1 = new Dates(insertDate(arg1,arg2, arg));
		
		do{
			valid=true;
			if(date1.compareWith(date1.DateToCalendar(), date1.SystemDate())!=1){
				valid=false;
				JOptionPane.showMessageDialog(null, "You have not introduced a valid argument");
				date1 = new Dates(insertDate(arg1,arg2, arg));
			}
			if(date1.timeBetweetDates(date1.DateToCalendar(), date1.SystemDate(), 1)<18){
				JOptionPane.showMessageDialog(null, "You can't register until you're 18 years old");
				valid=false;
				date1 = new Dates(insertDate(arg1,arg2, arg));
			}
		}while(!valid);
		return date1.getDate();
	}
	/**
	 * 	Insert hiring date and discharge date
	 * @param arg1 Message
	 * @param arg2 Title
	 * @param date_birthday 
	 * @return The date in a String
	 */
	public static String insertUpDate (String arg1, String arg2, String date_birthday, Config arg){
		boolean valid=true;
		int yearsDif=0;
		Dates date1 = new Dates(insertDate(arg1,arg2, arg));
		Dates date2= new Dates(date_birthday);
		
		do{
			valid=true;
			if(date1.compareWith(date1.DateToCalendar(), date1.SystemDate())!=1){
				valid=false;
				JOptionPane.showMessageDialog(null, "You have not introduced a valid argument");
				date1 = new Dates(insertDate(arg1,arg2, arg));
			}
			yearsDif=date1.timeBetweetDates(date1.DateToCalendar(), date2.DateToCalendar(), 1);
			if(yearsDif<18){
				valid=false;
				JOptionPane.showMessageDialog(null, "You could not be hired until you were 18");
				date1 = new Dates(insertDate(arg1,arg2, arg));
			}
			
			if(date1.compareWith(date1.DateToCalendar(), date2.DateToCalendar())==1){
				valid=false;
				JOptionPane.showMessageDialog(null, "The date can not be before your date birthday");
				date1 = new Dates(insertDate(arg1,arg2,arg));
			}
		}while(!valid);
		return date1.getDate();
	}
}
