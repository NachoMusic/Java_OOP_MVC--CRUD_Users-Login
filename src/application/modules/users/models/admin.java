package application.modules.users.models;

import application.models.Config;
import application.models.Dates;
import application.utils.Format;

public class admin extends users{
	private String hirin_date;
	private float salary;
	private int years_of_service, activity;

	//Constructors
	public admin(String dni, String name, String subname, String phone_number, String email, String user, String pass,
			String avatar, String state, String date_birthday, String hirin_date, float salary,
			int activity) {
		super(dni, name, subname, phone_number, email, user, pass, avatar, state, date_birthday);
		this.hirin_date = hirin_date;
		this.salary = salary;
		this.activity = activity;
		super.setIncentives((int)calculate_advantages());
		this.years_of_service=calculate_years_of_service(hirin_date);
		
	}
	public admin() {
		super();
	}
	
	public admin(String dni) {
		super(dni);
	}
	//Constructor a petición de usuario
	public admin(int i, Object option){
		switch(i){
		case 0:
			this.hirin_date=(String)option;
			break;
		case 1:
			this.salary=(float)option;
			break;
		case 2:
			this.years_of_service=(int)option;
			break;
		case 3:
			this.activity=(int)option;
			break;
		}
	}
	//Getters & Setters
	public String getHirin_date() {
		return hirin_date;
	}
	public void setHirin_date(String hirin_date) {
		this.hirin_date = hirin_date;
		this.years_of_service=calculate_years_of_service(hirin_date);
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public int getYears_of_service() {
		return years_of_service;
	}

	public int getActivity() {
		return activity;
	}
	public void setActivity(int activity) {
		this.activity = activity;
		super.setIncentives(((int)this.calculate_advantages()));
	}
	
	//to string
	public String toString(Config arg){
		String cad="";
		
		cad+=super.toString()+"\n";
		cad+="Hirin date: "+this.getHirin_date()+"\n";
		switch(arg.getCurrency_config()){
		case '€':
			cad+="Salary: "+Format.formatEuro(this.getSalary(),arg.getDecimals_config())+"\n";
			break;
		case '$':
			cad+="Salary: "+Format.formatDollar(this.getSalary(),arg.getDecimals_config())+"\n";
			break;
		case '£':
			cad+="Salary: "+Format.formatLibra(this.getSalary(),arg.getDecimals_config())+"\n";
			break;
		}
		cad+="Years of service: "+this.getYears_of_service()+"\n";
		cad+="Incentives: "+this.getIncentives()+"\n";
		cad+="Activity: "+this.getActivity()+"\n";
		return cad;
	}
	//to string clave primaria
	
	public String toString(String dni) {
		return super.toString(dni);
	}
	//to string peticion usuario
	
	public String toString(int i){
		String cad="";
		
		switch(i){
		case 0:
			cad+=this.getHirin_date()+"\n";
			break;
		case 1:
			cad+=this.getSalary()+"\n";
			break;
		case 2:
			cad+=this.getYears_of_service()+"\n";
			break;
		case 3:
			cad+=this.getIncentives()+"\n";
			break;
		case 4:
			cad+=this.getActivity()+"\n";
			break;
		}
		return cad;
	}
	
	@Override
	public float calculate_advantages(){
		return (float) (getActivity()*0.4);
	}
	public int calculate_years_of_service(String date){
		Dates date1 = new Dates(date);
		return date1.timeBetweetDates(date1.DateToCalendar(), date1.SystemDate(), 1);
	}
	public void changeCurrency(Config arg, char monedaAnterior){
		float test;
		//1€ = 1,09321$ = 0,726888£
		
		// € -> $ *1,09321 
		//€ -> £ * 0,726888
		//1$ -> € / 1,09321
		//£ -> € /0,726888
		//£ -> $ /0,664970
		//$ -> £ *0,664970
		if(arg.getCurrency_config()=='$'&&monedaAnterior=='€'){
			test=(float) (this.salary*1.09321);
			this.salary=test;
		}
		if(arg.getCurrency_config()=='€'&&monedaAnterior=='$'){
			test=(float) (this.salary/1.09321);
			this.salary=test;
		}
		if(arg.getCurrency_config()=='£'&&monedaAnterior=='€'){
			test=(float) (this.salary*0.726888);
			this.salary=test;
		}
		if(arg.getCurrency_config()=='€'&&monedaAnterior=='£'){
			test=(float) (this.salary/0.726888);
			this.salary=test;
		}
		if(arg.getCurrency_config()=='$'&&monedaAnterior=='£'){
			test=(float) (this.salary/0.664970);
			this.salary=test;
		}
		if(arg.getCurrency_config()=='£'&&monedaAnterior=='$'){
			test=(float) (this.salary*0.664970);
			this.salary=test;
		}
	}
}
