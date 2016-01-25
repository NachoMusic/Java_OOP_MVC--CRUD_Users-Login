package application.models;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import application.modules.users.model.models.singleton;
import application.utils.Functions;
import application.utils.Validate;

public class Dates {
	private String date;
	//constructor
	public Dates(String date) {
		this.date = date;
	}
	//getters setters
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return this.date;
	}
	
	public Calendar DateToCalendar(){
		Calendar cal = new GregorianCalendar();
		String day ="",month="",year="";
		if(this.date.charAt(2)=='/'||this.date.charAt(2)=='-'){
			day+=this.date.charAt(0);
			day+=this.date.charAt(1);
			month+=this.date.charAt(3);
			month+=this.date.charAt(4);
			year+=this.date.charAt(6);
			year+=this.date.charAt(7);
			year+=this.date.charAt(8);
			year+=this.date.charAt(9);
		}
		else{
			day+=this.date.charAt(8);
			day+=this.date.charAt(9);
			month+=this.date.charAt(5);
			month+=this.date.charAt(6);
			year+=this.date.charAt(0);
			year+=this.date.charAt(1);
			year+=this.date.charAt(2);
			year+=this.date.charAt(3);
		}
		cal.set(Calendar.DAY_OF_MONTH,Integer.parseInt(day));
		cal.set(Calendar.MONTH,Integer.parseInt(month)-1);
		cal.set(Calendar.YEAR,Integer.parseInt(year));
		return cal;
	}
	
	public String DateToString (Calendar c1, int dateconf) {
		String date = "";
		
		switch(dateconf){
		case 0:
			date+=Integer.toString(c1.get(Calendar.DATE));
			date+="/"+Integer.toString(c1.get(Calendar.MONTH)+1)+"/"+Integer.toString(c1.get(Calendar.YEAR));
			break;
		case 1:
			date+=Integer.toString(c1.get(Calendar.DATE));
			date+="-"+Integer.toString(c1.get(Calendar.MONTH)+1)+"-"+Integer.toString(c1.get(Calendar.YEAR));
			break;
		case 2:
			date+=Integer.toString(c1.get(Calendar.YEAR))+"/"+Integer.toString(c1.get(Calendar.MONTH)+1)+"/"+Integer.toString(c1.get(Calendar.DATE));
			break;
		case 3:
			date+=Integer.toString(c1.get(Calendar.YEAR))+"-"+Integer.toString(c1.get(Calendar.MONTH)+1)+"-"+Integer.toString(c1.get(Calendar.DATE));
			break;
		}
		return date;
	}
	
	public Calendar SystemDate(){
		Calendar cal = Calendar.getInstance();
		return cal;
	}
	/**
	 * Time between dates.
	 * @param date2compare
	 * @param date2compare2
	 * @param Option 1 returns difference in years and 2 in days
	 * @return the time between two dates in an integer.
	 */
	public int timeBetweetDates(Calendar date2compare, Calendar date2compare2, int Option){ 
		long resoult=0;
		long introducedData = date2compare.getTimeInMillis();
		long introducedData2 = date2compare2.getTimeInMillis();
		
		switch(Option){
		case 1:
			if(introducedData>introducedData2){
				resoult=((introducedData - introducedData2)/(24 * 60 * 60 * 1000)/365);
			}
			else{
				resoult=((introducedData2 - introducedData)/(24 * 60 * 60 * 1000)/365);
			}
			break;
		case 2:
			if(introducedData>introducedData2){
				resoult=((introducedData - introducedData2)/(24 * 60 * 60 * 1000));
			}
			else{
				resoult=((introducedData2 - introducedData)/(24 * 60 * 60 * 1000));
			}
			break;
		}
		return (int)resoult;
	}
	
	public int compareWith(Calendar date2compare, Calendar date2compare2){
		int resoult=0;
		long introducedData2 = date2compare2.getTimeInMillis();
		long introducedData = date2compare.getTimeInMillis();
		
		if(introducedData2>introducedData){
			resoult=1;
		}
		else if(introducedData2<introducedData){
			resoult=2;
		}
		else{
			resoult=3;
		}
		return resoult;
	}
	public String insertDate(String arg1, String arg2){
		boolean validate=false;
		String date="",month="",day="",year="";
		int daynum=0,yearnum=0;
		
		while(!validate){
			month="";
			day="";
			year="";
			switch(singleton.configApp.getDate_config()){
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
				if(singleton.configApp.getDate_config()<2){
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
}
