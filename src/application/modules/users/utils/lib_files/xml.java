package application.modules.users.utils.lib_files;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;

import application.modules.users.models.admin;
import application.modules.users.models.singleton;
import application.modules.users.models.users;

public class xml {
	private static final String ENCODING = "UTF-8";
	public static void createxml(){
		String PATH=null;
		try{
			OutputStream os = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, admin.class);
			
			String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
            xstream.toXML(singleton.admins, osw);
            StringBuffer xml = new StringBuffer();
            xml.append(header);
            xml.append(os.toString());
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showSaveDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION){
            	File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                PATH = PATH+".xml";
                
                FileWriter fileXml = new FileWriter(PATH);
                fileXml.write(xml.toString());
                fileXml.close();
                osw.close();
                os.close();
                JOptionPane.showMessageDialog(null, "XML file saved properly", "XML file", JOptionPane.INFORMATION_MESSAGE);
            }
		}catch (Exception E){
	    	JOptionPane.showMessageDialog(null, "The program couldn't make the xml", "Error", JOptionPane.ERROR_MESSAGE);
	    } 
	}
	public static void load_xml() {
    	String PATH=null;
    	try {
            XStream xstream = new XStream();;
            Annotations.configureAliases(xstream, admin.class);
 
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
            	File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                System.out.print(6);
                singleton.admins.setAdmins((ArrayList <admin>)xstream.fromXML(new FileReader(PATH)));
                System.out.print(7);
            }
            
        } catch (Exception E) {
        	JOptionPane.showMessageDialog(null, "The program couldn't load the xml", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
