/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.bbdd;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Raul
 */
public class ConexionBD {

    /**
     * abrimos conexion en la base de datos
     *
     * @return
     */
    public Connection AbrirConexion() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String urlOdbc = "jdbc:mysql://127.0.0.1:3306/application";
            con = (java.sql.DriverManager.getConnection(urlOdbc, "root", "1234"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha sido imposible establecer la conexion!");
        }
        return con;
    }

    /**
     * cerramos la conexion en la bd
     *
     * @param con
     */
    public void CerrarConexion(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha sido imposible cerrar la conexion!");
        }
    }
}
