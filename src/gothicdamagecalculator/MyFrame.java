/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gothicdamagecalculator;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Milten Plescott
 */
public class MyFrame extends JFrame {
	
	public MyFrame frame;
	
	public GUI gui;
	
	public MyFrame() {
		super();
		prepareFrame();
	}
	
	private void prepareFrame() {
		// TODO: dynamic resizing here
		this.setName("Gothic Damage Calculator");
		//this.setSize(500, 500);
		//this.setMinimumSize(new Dimension(100, 100));
		this.setBackground(Colors.GRAY);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.gui = new GUI(this);
		
		this.pack();
		this.setVisible(true);
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// look and feel testing
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}
		catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		

		UIManager.LookAndFeelInfo[] lafInfo = UIManager.getInstalledLookAndFeels();
		
		
		for (UIManager.LookAndFeelInfo i : lafInfo) {
			System.out.println(i.getName());
		}
		
		
		// use menu->menu item to put in all available L&F and let the user to choose ???
		
		
		
		
		
		/*
		UIManager.setLookAndFeel(lookAndFeel);

			// If L&F = "Metal", set the theme

			if (LOOKANDFEEL.equals("Metal")) {
				if (THEME.equals("DefaultMetal"))
					MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
				else if (THEME.equals("Ocean"))
					MetalLookAndFeel.setCurrentTheme(new OceanTheme());
				else
					MetalLookAndFeel.setCurrentTheme(new TestTheme());
				UIManager.setLookAndFeel(new MetalLookAndFeel()); 
			}	


		
		// Set cross-platform Java L&F (also called "Metal")
		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

		// Set System L&F
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		// Set cross-platform Java L&F (also called "Metal")
		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		UIManager.setLookAndFeel("javax.swing.plaf.windows.WindowsLookAndFeel");
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		UIManager.setLookAndFeel("javax.swing.plaf.motif.MotifLookAndFeel");
		*/
		
		
		
		//GothicDamageCalculator gdc = new GUI();
		MyFrame frame = new MyFrame();
	}
}
