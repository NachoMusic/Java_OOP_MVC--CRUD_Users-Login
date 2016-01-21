package application.utils;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class LookAndFeel {
	public static void selectTheme(int theme){
		try {
			switch (theme){
			case 0:// Metal
				UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
				break;

			case 1:// GTK - WINDOWS
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				break;

			case 2:// CDE/Motif
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
				break;

			case 3:// Nimbus
				/*
				 * LookAndFeelInfo[] lafs =
				 * UIManager.getInstalledLookAndFeels();
				 * 
				 * for (LookAndFeelInfo laf : lafs) { if
				 * ("Nimbus".equals(laf.getName()))
				 * UIManager.setLookAndFeel(laf.getClassName()); }
				 */
				UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
				break;
			/* For Mac OS
			case 4: //Get list look&feel available on the OS
					//http://www.codigofantasma.com/blog/java-look-feel-parte-1/
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.mac.MacLookAndFeel");
				break;
				*/
			}
		}catch (Exception e){
			JOptionPane.showMessageDialog(null,"No pudo cargarse la apariencia deseada", 
														"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}
