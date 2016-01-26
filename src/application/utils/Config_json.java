package application.utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import application.models.Config;
import application.models.SingletonF;

public class Config_json {
	public static void create_conf_json(){
		String PATH = null;
        
	      try {
	          XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
	          xstreamjson.setMode(XStream.NO_REFERENCES);
	          xstreamjson.alias("Config", Config.class);
	          try {
	              PATH = new java.io.File(".").getCanonicalPath()
	                      + "/src/application/config.json";
	          } catch (IOException e) {
	              e.printStackTrace();
	          }
	          Gson gson = new Gson();
		      String json = gson.toJson(SingletonF.configApp);
		      FileWriter fileXml = new FileWriter(PATH);
	          fileXml.write(json.toString());
	          fileXml.close();
	      }catch (Exception E) {
	        	JOptionPane.showMessageDialog(null, "Error creating the config JSON", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	}
	public static void load_conf_json(){
		 String PATH = null;
		 Config C=new Config();
		 
		 try {
      	  XStream xstream = new XStream(new JettisonMappedXmlDriver());
	          xstream.setMode(XStream.NO_REFERENCES);
			  xstream.alias("Config", Config.class);
			  PATH = new java.io.File(".").getCanonicalPath()
	                    + "/src/application/config.json";
			  File path = new File(PATH);
	          if (path.exists()) {             
	                JsonReader lector = new JsonReader(new FileReader(PATH));
	                JsonParser parseador = new JsonParser();
	                JsonElement raiz = parseador.parse(lector);
	            	Gson json = new Gson();
	            	C = json.fromJson(raiz, Config.class);
	            	SingletonF.configApp =C;
	          } 
      } catch (Exception e) {
      	JOptionPane.showMessageDialog(null, "The program couldn't load the config", "Error", JOptionPane.ERROR_MESSAGE);
      }
		 
	 }
}
