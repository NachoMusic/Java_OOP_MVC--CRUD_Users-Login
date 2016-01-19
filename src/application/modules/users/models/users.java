package application.modules.users.models;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import application.models.Dates;
@SuppressWarnings("serial")
@XStreamAlias("users")
public abstract class users implements Comparable <users>, Serializable {
	//Atributes
	@XStreamAlias("dni")
	private String dni;
	@XStreamAlias("name")
	private String name;
	@XStreamAlias("subname")
	private String subname;
	@XStreamAlias("phone_number")
	private String phone_number;
	@XStreamAlias("email")
	private String email;
	@XStreamAlias("user")
	private String user;
	@XStreamAlias("pass")
	private String pass;
	@XStreamAlias("avatar")
	private String avatar;
	@XStreamAlias("state")
	private String state;
	@XStreamAlias("date_birthday")
	private String date_birthday;
	@XStreamAlias("age")
	private int age;
	@XStreamAlias("points")
	private int points;
	@XStreamAlias("discount")
	private int discount;
	@XStreamAlias("incentives")
	private int incentives;
	@XStreamAlias("advantages")
	private float advantages;
	//Constructors
	//dni name subname mobile birthday age login password email avatar status
	public users(String dni, String name, String subname, String phone_number, String email, String user, String pass,
			String avatar, String state, String date_birthday) {
		this.dni = dni;
		this.name = name;
		this.subname = subname;
		this.phone_number = phone_number;
		this.email = email;
		this.user = user;
		this.pass = pass;
		this.avatar = avatar;
		this.state = state;
		this.date_birthday = date_birthday;
		this.age=(calculate_age());
	}
	public users() {
	}
	public users(String dni) {
		this.dni = dni;
	}
	//constructor a petici�n del usuario
	public users(int i, String s, int age){
		switch(i){
		case 0:
			this.dni=s;
			break;
		case 1:
			this.name=s;
			break;
		case 2:
			this.subname=s;
			break;
		case 3:
			this.phone_number=s;
			break;
		case 4:
			this.email=s;
			break;
		case 5:
			this.user=s;
			break;
		case 6:
			this.pass=s;
			break;
		case 7:
			this.avatar=s;
			break;
		case 8:
			this.state=s;
			break;
		case 9:
			this.date_birthday=s;
			break;
		case 10:
			this.age=age;
			break;
		}
	}
	//Getters & setters
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDate_birthday() {
		return date_birthday;
	}
	public void setDate_birthday(String date_birthday) {
		this.date_birthday = date_birthday;
		this.age=(calculate_age());
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getAdvantages() {
		return advantages;
	}
	public void setAdvantages(int advantages) {
		this.advantages = advantages;
	}
	
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getIncentives() {
		return incentives;
	}
	public void setIncentives(int incentives) {
		this.incentives = incentives;
	}
	//Compares if two users are equals, I still have to test it
	public boolean equals(users user, int type){
		switch(type){
		case 0:
			return ((this.dni.toUpperCase()).equals(user.getDni().toUpperCase()));
		case 1:
			return ((this.name.toUpperCase()).equals(user.getName().toUpperCase()));
		}
		return false;
	}
	public int compareTo(users user){
		if(this.dni.compareTo(user.getDni())>0)
			return 1;
		if(this.dni.compareTo(user.getDni())<0)
			return -1;
		return 0;
	  }
	@Override
	public String toString() {
		String cad="";
		cad+="DNI: "+this.getDni()+"\n";
		cad+="Name: "+this.getName()+"\n";
		cad+="Subname: "+this.getSubname()+"\n";
		cad+="Phone Number: "+this.getPhone_number()+"\n";
		cad+="Email: "+this.getEmail()+"\n";
		cad+="User: "+this.getUser()+"\n";
		//cad+=this.getPass()+"\n";
		cad+="Avatar: "+this.getAvatar()+"\n";
		cad+="The user is(state): "+this.getState()+"\n";
		cad+="Date Birthday: "+this.getDate_birthday()+"\n";
		cad+="Age: "+this.getAge()+"\n";
		return cad;
	}
	//to string clave primaria
	public String toString(String dni){
		return this.getDni()+"\n";
	}
	//to string peticion usuario
	public String toString(int i){
		String cad="";
		
		switch(i){
		case 0:
			cad+=this.getDni()+"\n";
			break;
		case 1:
			cad+=this.getName()+"\n";
			break;
		case 2:
			cad+=this.getSubname()+"\n";
			break;
		case 3:
			cad+=this.getPhone_number()+"\n";
			break;
		case 4:
			cad+=this.getEmail()+"\n";
			break;
		case 5:
			cad+=this.getUser()+"\n";
			break;
		case 6:
			cad+=this.getPass()+"\n";
			break;
		case 7:
			cad+=this.getAvatar()+"\n";
			break;
		case 8:
			cad+=this.getState()+"\n";
			break;
		case 9:
			cad+=this.getDate_birthday()+"\n";
			break;
		case 10:
			cad+=this.getAge()+"\n";
			break;
		}
		return cad;
	}
	public abstract float calculate_advantages();
	//incentivos puntos y ___ fuera de las hijas y estaran en la madre con sus geters/setters en la madre y no en las hijas
	public int calculate_age(){
		Dates date1 = new Dates(this.date_birthday);
		return date1.timeBetweetDates(date1.SystemDate(), date1.DateToCalendar(),1);
	}
}
