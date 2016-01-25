package application.modules.users.utils.lib_files;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
import application.modules.users.models.admin;
import application.modules.users.models.singleton;

@SuppressWarnings("deprecation")
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
            xstream.toXML(singleton.admins.getAdmins(), osw);
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
	public static void createxml_auto(){
		String PATH = null;

        try {
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/application/modules/users/files/admin_files/admins.xml";
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            OutputStream os = new ByteArrayOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            XStream xstream = new XStream();

            Annotations.configureAliases(xstream, admin.class);
            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING
                    + "\"?>\n";
            xstream.toXML(singleton.admins.getAdmins(), osw);
            StringBuffer xml = new StringBuffer();
            xml.append(header);
            xml.append(os.toString());

            FileWriter fileXml = new FileWriter(PATH);
            fileXml.write(xml.toString());
            fileXml.close();
            osw.close();
            os.close();
        } catch (IOException e) {
            // JOptionPane.showMessageDialog(null, "Error al grabar el XML",
            // "Error", JOptionPane.ERROR_
        }
	}
	@SuppressWarnings("unchecked")
	public static void load_xml() {
    	String PATH=null;
    	try {
            XStream xstream = new XStream();;
            Annotations.configureAliases(xstream, admin.class);
 
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));
            int seleccion = fileChooser.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
            	File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                singleton.admins.setAdmins((ArrayList <admin>)xstream.fromXML(new FileReader(PATH)));
            }
        } catch (Exception E) {
        	JOptionPane.showMessageDialog(null, "The program couldn't load the xml", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	@SuppressWarnings("unchecked")
	public static void load_xml_auto(){
		String PATH;

        try {
            XStream xstream = new XStream();
            Annotations.configureAliases(xstream, admin.class);

            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/application/modules/users/files/admin_files/admins.xml";

            File path = new File(PATH);

            if (path.exists()) {
            	singleton.admins.setAdmins((ArrayList <admin>)xstream.fromXML(new FileReader(PATH)));
            }

        } catch (IOException e) {
            // JOptionPane.showMessageDialog(null, "The program couldn't load the xml",
        }
	}
}
