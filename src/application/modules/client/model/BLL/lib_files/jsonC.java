package application.modules.client.model.BLL.lib_files;

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
import application.modules.admin.model.models.singleton;
import application.modules.client.model.models.client;

public class jsonC {

    public static void createjson() {
        String PATH = null;

        try {
            XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
            xstreamjson.setMode(XStream.NO_REFERENCES);
            xstreamjson.alias("client", client.class);
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showSaveDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                PATH = PATH + ".json";
                Gson gson = new Gson();
                String json = gson.toJson(singleton.clients.getClients());
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
            xstreamjson.alias("client", client.class);
            pathin = "/src/application/modules/client/files/client_files/client_files";
            try {
                PATH = new java.io.File(".").getCanonicalPath()
                        + pathin;
            } catch (IOException e) {
                e.printStackTrace();
            }
            PATH = PATH + ".json";
            Gson gson = new Gson();
            String json = gson.toJson(singleton.clients.getClients());
            FileWriter fileXml = new FileWriter(PATH);
            fileXml.write(json.toString());
            fileXml.close();
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "Error creating the JSON", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void load_json() {
        String PATH = null;
        client client1 = new client();

        try {
            XStream xstream = new XStream(new JettisonMappedXmlDriver());
            xstream.setMode(XStream.NO_REFERENCES);
            xstream.alias("client", client.class);
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
            int seleccion = fileChooser.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();

                singleton.clients.getClients().clear();
                JsonReader lector = new JsonReader(new FileReader(PATH));
                JsonParser parseador = new JsonParser();
                JsonElement raiz = parseador.parse(lector);

                Gson json = new Gson();
                JsonArray lista = raiz.getAsJsonArray();
                for (JsonElement elemento : lista) {
                    client1 = json.fromJson(elemento, client.class);
                    singleton.clients.getClients().add(client1);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The program couldn't load the json", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void load_json_auto() {
        String PATH = null, pathin = "";
        client client1 = new client();

        try {
            XStream xstream = new XStream(new JettisonMappedXmlDriver());
            xstream.setMode(XStream.NO_REFERENCES);
            xstream.alias("client", client.class);
            pathin = "/src/application/modules/client/files/client_files/client_files.json";
            PATH = new java.io.File(".").getCanonicalPath()
                    + pathin;
            File path = new File(PATH);
            if (path.exists()) {
                singleton.clients.getClients().clear();
                JsonReader lector = new JsonReader(new FileReader(PATH));
                JsonParser parseador = new JsonParser();
                JsonElement raiz = parseador.parse(lector);

                Gson json = new Gson();
                JsonArray lista = raiz.getAsJsonArray();
                for (JsonElement elemento : lista) {
                    client1 = json.fromJson(elemento, client.class);
                    singleton.clients.getClients().add(client1);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The program couldn't load the json", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
