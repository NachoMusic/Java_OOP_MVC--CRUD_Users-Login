package application.modules.admin.model.BLL.lib_files;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import application.models.SingletonF;
import application.modules.admin.model.models.admin;
import application.modules.admin.model.models.singleton;

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
                PATH = PATH + ".json";

                Gson gson = new Gson();
                String json = gson.toJson(singleton.admins.getAdmins());
                FileWriter fileXml = new FileWriter(PATH);
                fileXml.write(json.toString());
                fileXml.close();
                JOptionPane.showMessageDialog(null, "JSON file saved successfully", "JSON file", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "Error creating the JSON", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void createjson_auto() {
        String PATH = null, pathin = "";

        try {
            XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
            xstreamjson.setMode(XStream.NO_REFERENCES);
            xstreamjson.alias("admin", admin.class);
            if (SingletonF.configApp.getDummiesmode()) {
                pathin = "/src/application/modules/users/model/files/dummies/admin_files/admins";
            } else {
                pathin = "/src/application/modules/users/model/files/admin_files/admins";
            }
            try {
                PATH = new java.io.File(".").getCanonicalPath()
                        + pathin;
            } catch (IOException e) {
                e.printStackTrace();
            }
            PATH = PATH + ".json";
            Gson gson = new Gson();
            String json = gson.toJson(singleton.admins.getAdmins());
            FileWriter fileXml = new FileWriter(PATH);
            fileXml.write(json.toString());
            fileXml.close();
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "Error creating the JSON", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void load_json() {
        String PATH = null;
        admin admin1 = new admin();

        try {
            XStream xstream = new XStream(new JettisonMappedXmlDriver());
            xstream.setMode(XStream.NO_REFERENCES);
            xstream.alias("admin", admin.class);
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
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

    public static void load_json_auto() {
        String PATH = null, pathin = "";
        admin admin1 = new admin();

        try {
            XStream xstream = new XStream(new JettisonMappedXmlDriver());
            xstream.setMode(XStream.NO_REFERENCES);
            xstream.alias("admin", admin.class);
            if (SingletonF.configApp.getDummiesmode()) {
                pathin = "/src/application/modules/admin/model/files/dummies/admin_files/admins.json";
            } else {
                pathin = "/src/application/modules/admin/model/files/admin_files/admins.json";
            }
            PATH = new java.io.File(".").getCanonicalPath()
                    + pathin;
            File path = new File(PATH);
            if (path.exists()) {
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
