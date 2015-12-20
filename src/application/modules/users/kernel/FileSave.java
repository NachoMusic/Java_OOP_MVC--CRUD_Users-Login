package application.modules.users.kernel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import application.modules.users.models.admin;

public class FileSave {

	public static void saveadmin(admin admin) {
		
		try {
			File f = new File("users.txt");
			FileWriter fw;
			BufferedWriter bw;
			if(f.exists()){
				fw = new FileWriter(f,true);
				bw = new BufferedWriter(fw);
				bw.newLine();
				bw.write(admin.getDni()+"&"+admin.getName()+"&"+admin.getSubname()+"&"+
				admin.getPhone_number()+"&"+admin.getEmail()+"&"+admin.getSubname()+"&"+admin.getUser()+
				"&"+admin.getPass()+"&"+admin.getAvatar()+"&"+admin.getState()+"&"+admin.getDate_birthday()+
				"&"+admin.getHirin_date()+"&"+admin.getSalary()+"&"+admin.getSubname()+"&"+admin.getActivity()+
				"&"+admin.getIncentives()+"&"+admin.getYears_of_service());
			}else{
				fw = new FileWriter(f);
				bw = new BufferedWriter(fw);
				bw.write(admin.getDni()+"&"+admin.getName()+"&"+admin.getSubname()+"&"+
				admin.getPhone_number()+"&"+admin.getEmail()+"&"+admin.getSubname()+"&"+admin.getUser()+
				"&"+admin.getPass()+"&"+admin.getAvatar()+"&"+admin.getState()+"&"+admin.getDate_birthday()+
				"&"+admin.getHirin_date()+"&"+admin.getSalary()+"&"+admin.getSubname()+"&"+admin.getActivity()+
				"&"+admin.getIncentives()+"&"+admin.getYears_of_service());
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
