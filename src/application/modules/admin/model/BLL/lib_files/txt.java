package application.modules.admin.model.BLL.lib_files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import application.models.SingletonF;
import application.modules.admin.model.models.admin;
import application.modules.admin.model.models.singleton;

public class txt {
	public static void createtxt() {
        String PATH = null;
        try {
            File f;
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showSaveDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                PATH=PATH+ ".txt";
                f = new File(PATH);
                
                FileOutputStream fo=new FileOutputStream(f);
				ObjectOutputStream o=new ObjectOutputStream(fo);
				o.writeObject(singleton.admins.getAdmins());
				o.close();
                JOptionPane.showMessageDialog(null, "TXT file saved successfully", "TXT file", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Error creating the TXT", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	public static void createtxt_auto() {
        String PATH = null,pathin="";
        try {
        	if(SingletonF.configApp.getDummiesmode())
	        	  pathin="/src/application/modules/users/model/files/dummies/admin_files/admins";
	          else
	        	  pathin="/src/application/modules/users/model/files/admin_files/admins";
        	try {
	              PATH = new java.io.File(".").getCanonicalPath()
	                      + pathin;
	          } catch (IOException e) {
	              e.printStackTrace();
	          }
            File f;
                PATH=PATH+ ".txt";
                f = new File(PATH);
                FileOutputStream fo=new FileOutputStream(f);
				ObjectOutputStream o=new ObjectOutputStream(fo);
				o.writeObject(singleton.admins.getAdmins());
				o.close();
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Error creating the TXT", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	@SuppressWarnings("unchecked")
	public static void load_txt() {
    	String PATH = null;
        try {
            File f;
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Text (*.txt)", "txt"));
            int seleccion = fileChooser.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                f = new File(PATH);
                FileInputStream fi=new FileInputStream(f);
    			ObjectInputStream oi=new ObjectInputStream(fi);
    			singleton.admins.setAdmins((ArrayList<admin>)oi.readObject());
    			oi.close();
            }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "The program couldn't load the txt", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	@SuppressWarnings("unchecked")
	public static void load_txt_auto() {
    	String PATH = null;
        try {
        	try {
	              PATH = new java.io.File(".").getCanonicalPath()
	                      + "/src/application/modules/admin/model/files/admin_files/admins.txt";
	          } catch (IOException e) {
	              e.printStackTrace();
	          }
            File f;
            File path = new File(PATH);
            if (path.exists()) {
                f = new File(PATH);
                FileInputStream fi=new FileInputStream(f);
    			ObjectInputStream oi=new ObjectInputStream(fi);
    			singleton.admins.setAdmins((ArrayList<admin>)oi.readObject());
    			oi.close();
            }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "The program couldn't load the txt", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
