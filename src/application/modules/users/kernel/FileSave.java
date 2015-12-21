package application.modules.users.kernel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import application.modules.users.models.admin;

public class FileSave {

	public static void saveadmin(admin admin) {
		
		try {
			File f = new File("admins.txt");
			FileWriter fw;
			BufferedWriter bw;
			if(f.exists()){
				fw = new FileWriter(f,true);
				bw = new BufferedWriter(fw);
				bw.newLine();
				bw.write(admin.getDni()+"&"+admin.getName()+"&"+admin.getSubname()+"&"+
						admin.getPhone_number()+"&"+admin.getEmail()+"&"+admin.getUser()+
						"&"+admin.getPass()+"&"+admin.getAvatar()+"&"+admin.getState()+"&"+admin.getDate_birthday()+
						"&"+admin.getHirin_date()+"&"+admin.getSalary()+"&"+admin.getActivity());
			}else{
				fw = new FileWriter(f);
				bw = new BufferedWriter(fw);
				bw.write(admin.getDni()+"&"+admin.getName()+"&"+admin.getSubname()+"&"+
				admin.getPhone_number()+"&"+admin.getEmail()+"&"+admin.getUser()+
				"&"+admin.getPass()+"&"+admin.getAvatar()+"&"+admin.getState()+"&"+admin.getDate_birthday()+
				"&"+admin.getHirin_date()+"&"+admin.getSalary()+"&"+admin.getActivity());
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void readadmin(){
		try{
			File f = new File("admins.txt");
			FileReader fr;
			BufferedReader br;
			if(f.exists()){
				fr = new FileReader(f);
				br = new BufferedReader(fr);
				String linea;
				while((linea = br.readLine()) != null){
					String[] usersA = linea.split("&");
					admin admin1=new admin();
					admin1.setDni(usersA[0]);
					admin1.setName(usersA[1]);
					admin1.setSubname(usersA[2]);
					admin1.setPhone_number(usersA[3]);
					admin1.setEmail(usersA[4]);
					admin1.setUser(usersA[5]);
					admin1.setPass(usersA[6]);
					admin1.setPass(usersA[6]);
					admin1.setAvatar(usersA[7]);
					admin1.setState(usersA[8]);
					admin1.setDate_birthday(usersA[9]);
					admin1.setHirin_date(usersA[10]);
					admin1.setSalary(Float.parseFloat(usersA[11]));
					admin1.setActivity(Integer.parseInt(usersA[12]));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
