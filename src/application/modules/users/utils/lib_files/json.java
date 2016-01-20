package application.modules.users.utils.lib_files;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import application.modules.users.models.admin;
import application.modules.users.models.singleton;

public class json {
	public static void createjson() {
        String PATH = null;
	      try {
	          XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
	          xstreamjson.setMode(XStream.NO_REFERENCES);
	          xstreamjson.alias("admin", admin.class);
	          
	          JFileChooser fileChooser = new JFileChooser();
	          int seleccion = fileChooser.showSaveDialog(null);
	          if (seleccion == JFileChooser.APPROVE_OPTION) {
	                File JFC = fileChooser.getSelectedFile();
	                PATH = JFC.getAbsolutePath();
	                PATH=PATH+ ".json";
	                
	                Gson gson = new Gson();
		            String json = gson.toJson(singleton.admins.getAdmins());
		            FileWriter fileXml = new FileWriter(PATH);
	                fileXml.write(json.toString());
	                fileXml.close();
	                JOptionPane.showMessageDialog(null, "JSON file saved successfully", "JSON file", JOptionPane.INFORMATION_MESSAGE);    
	         }
	      }catch (Exception E) {
	        	JOptionPane.showMessageDialog(null, "Error creating the JSON", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	}
	 public static void load_json(){
		 String PATH = null;
		 admin admin1=new admin();
		 
		 try {
       	  XStream xstream = new XStream(new JettisonMappedXmlDriver());
	          xstream.setMode(XStream.NO_REFERENCES);
			  xstream.alias("admin", admin.class);
			  
			  JFileChooser fileChooser = new JFileChooser();
	          int seleccion = fileChooser.showOpenDialog(null);
	          if (seleccion == JFileChooser.APPROVE_OPTION) {
	                File JFC = fileChooser.getSelectedFile();
	                PATH = JFC.getAbsolutePath();
	               
	                singleton.admins.getAdmins().clear();	              
	                JsonReader lector = new JsonReader(new FileReader(PATH));
	                JsonParser parseador = new JsonParser();
	                JsonElement raiz = parseador.parse(lector);
	            		  
	            	Gson json = new Gson();
	            	JsonArray lista = raiz.getAsJsonArray();
	            	for (JsonElement elemento : lista) {
	            		admin1 = json.fromJson(elemento, admin.class);
	            		singleton.admins.getAdmins().add(admin1);
	            	}
	          } 
       } catch (Exception e) {
       	JOptionPane.showMessageDialog(null, "The program couldn't load the json", "Error", JOptionPane.ERROR_MESSAGE);
       }
		 
	 }
}
