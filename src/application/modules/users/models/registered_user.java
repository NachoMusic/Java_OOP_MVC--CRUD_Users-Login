package application.modules.users.models;

public class registered_user extends users{
	private String karma;
	private int activity;
	
	//Constructors
	public registered_user(String dni, String name, String subname, String phone_number, String email, String user,
			String pass, String avatar, String state, String date_birthday, String karma, int activity) {
		super(dni, name, subname, phone_number, email, user, pass, avatar, state, date_birthday);
		this.karma = karma;
		this.activity = activity;
		super.setPoints((int)calculate_advantages());
	}
	public registered_user() {
		super();
	}
	//Constructor a peticion de usuario
	public registered_user(int i, Object option){
		switch(i){
		case 0:
			this.karma=(String)option;
			break;
		case 1:
			this.activity=(int)option;
			break;
		}
	}
	//Getters & Setters
	public String getKarma() {
		return karma;
	}
	public void setKarma(String karma) {
		this.karma = karma;
		super.setPoints((int)this.calculate_advantages());
	}
	public int getActivity() {
		return activity;
	}
	public void setActivity(int activity) {
		this.activity = activity;
		super.setPoints((int)this.calculate_advantages());
	}

	//To String
	
	public String toString(){
		String cad="";
		
		cad+=super.toString()+"\n";
		cad+="Karma: "+this.getKarma()+"\n";
		cad+="Activity: "+this.getActivity()+"\n";
		cad+="Points: "+this.getPoints()+"\n";
		return cad;
	}
	//to string clave primaria
	public String toString(String dni) {	
		return super.toString(dni);
	}
	//to String a petición de usuario
	public String toString(int i){
		String cad="";
		switch(i){
		case 0:
			cad+=this.getKarma()+"\n";
			break;
		case 1:
			cad+=this.getActivity()+"\n";
			break;
		case 2:
			cad+=this.getPoints()+"\n";
			break;
		}
		return cad;
	}
	@Override
	public float calculate_advantages(){
		int plus=0;
		if(getKarma()=="High"){
			plus+=0.2*getActivity();
		}else if(getKarma()=="Medium"){
			plus+=0.1*getActivity();
		}
		return plus;
	}
}
