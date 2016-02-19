package application.utils;

import javax.swing.JOptionPane;
import application.utils.Menus;

public class Functions {
    //Validate an integer

    public static int validateint(String mensaje, String titulo) {
        int a = 0;
        String s;
        boolean correcto = true;

        do {
            try {
                s = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
                if (s == null) {
                    //JOptionPane.showMessageDialog(null, "Saliendo de la aplicaci�n","Saliendo",JOptionPane.INFORMATION_MESSAGE);
                    //System.exit(0);//al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la ejecuci�n
                } else {
                    a = Integer.parseInt(s);
                    correcto = true;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "You have not inserted an int number", "Error", JOptionPane.ERROR_MESSAGE);
                correcto = false;
            }
        } while (correcto == false);
        return a;
    }

    public static int validateInt(String s) {
        int a = 0;

        boolean correcto = true;

        do {
            try {
                if (s == null) {
                    //JOptionPane.showMessageDialog(null, "Saliendo de la aplicaci�n","Saliendo",JOptionPane.INFORMATION_MESSAGE);
                    //System.exit(0);//al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la ejecuci�n
                } else {
                    a = Integer.parseInt(s);
                    correcto = true;
                }
            } catch (Exception e) {
                correcto = false;
            }
        } while (correcto == false);
        return a;
    }
    //Validate an integer different from 0

    public static int validateintdif0(String mensaje, String titulo) {
        /**
         * Valida un int diferente de 0
         */
        //Se pone javadoc Antes del codigo de una clase, en los m�todos antes de cada metodo y delante de cada atributo
        int a = 0;
        String s;
        boolean correcto = true;

        do {
            try {
                s = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
                if (s == null) {
                    //JOptionPane.showMessageDialog(null, "Saliendo de la aplicaci�n","Saliendo",JOptionPane.INFORMATION_MESSAGE);
                    //System.exit(0);//al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la ejecuci�n
                } else {
                    a = Integer.parseInt(s);
                    if (a != 0) {
                        correcto = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "It can't be 0");
                        correcto = false;
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "You have not inserted an int", "Error", JOptionPane.ERROR_MESSAGE);
                correcto = false;
            }
        } while (correcto == false);
        return a;
    }
    //Validate a float

    public static float validatefloat(String mensaje, String titulo) {
        float b = 0.0f;
        String t;
        boolean correcto2 = true;

        do {
            try {
                t = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
                if (t == null) {
                    //JOptionPane.showMessageDialog(null, "Saliendo de la aplicaci�n","Saliendo",JOptionPane.INFORMATION_MESSAGE);
                    //System.exit(0);//al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la ejecuci�n
                } else {
                    b = Float.parseFloat(t);
                    correcto2 = true;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "You have not inserted a float", "Error", JOptionPane.ERROR_MESSAGE);
                correcto2 = false;
            }
        } while (correcto2 == false);
        return b;

    }
    //Validate a String

    public static String validatestring(String mensaje, String titulo) {
        String u = "";
        boolean correcto3 = true;

        do {
            try {
                u = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
                correcto3 = true;
                if (u == null) {
                    //JOptionPane.showMessageDialog(null, "Saliendo de la aplicaci�n","Saliendo",JOptionPane.INFORMATION_MESSAGE);
                    //System.exit(0);//al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la ejecuci�n
                }
                if (u.equals("")) {
                    JOptionPane.showMessageDialog(null, "Data entry error", "Error", JOptionPane.ERROR_MESSAGE);
                    correcto3 = false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "You have not inserted a string", "Error", JOptionPane.ERROR_MESSAGE);
                correcto3 = false;
            }
        } while (correcto3 == false);
        return u;
    }
    //Validate a char

    public static char validatechar(String mensaje, String titulo) {
        char c = 0;
        String s;
        boolean correcto = true;

        do {
            try {
                s = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
                if (s == null) {
                    //JOptionPane.showMessageDialog(null, "Saliendo de la aplicaci�n","Saliendo",JOptionPane.INFORMATION_MESSAGE);
                    //System.exit(0);//al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la ejecuci�n
                } else {
                    c = s.charAt(0);
                    correcto = true;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "You have not inserted a char", "Error", JOptionPane.ERROR_MESSAGE);
                correcto = false;
            }
        } while (correcto == false);
        return c;
    }
    //Validate boolean

    public static boolean validateboolean(String message, String title) {
        int option;
        boolean a = true;
        String[] vec = {"Yes", "No"};

        option = Menus.menu(vec, message, title);
        if (option == 0) {
            a = true;
        } else {
            a = false;
        }
        return a;
    }
}
