/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gothicdamagecalculator;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 *
 * @author Milten Plescott
 */
public class Menu {
	
	public MyFrame frame;
	
	public Menu(MyFrame frame) {
		this.frame = frame;
		menu();
	}
	
	private void menu() {
		JMenuBar jmb = new JMenuBar();
		JMenu jm = new JMenu("Help");
		JMenuItem jmiDisclaimer = new JMenuItem("Disclaimer");
		JMenuItem jmiFormulas = new JMenuItem("Used formulas");
		JMenuItem jmiHowTo = new JMenuItem("How to use Gothic Damage Calculator");
		JMenuItem jmiAbout = new JMenuItem("About");
		
		jmb.add(jm);
		jm.add(jmiDisclaimer);
		jm.add(jmiFormulas);
		jm.add(jmiHowTo);
		jm.add(jmiAbout);
		
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 15);
		
		jmb.setFont(font);
		jm.setFont(font);
		jmiDisclaimer.setFont(font);
		jmiFormulas.setFont(font);
		jmiHowTo.setFont(font);
		jmiAbout.setFont(font);
		
		frame.setJMenuBar(jmb);
		
		jmiDisclaimer.addActionListener((ActionEvent e) -> {
			dialog(frame, e);
		});
		
		jmiFormulas.addActionListener((ActionEvent e) -> {
			dialog(frame, e);
		});
		
		jmiHowTo.addActionListener((ActionEvent e) -> {
			dialog(frame, e);
		});
		
		jmiAbout.addActionListener((ActionEvent e) -> {
			dialog(frame, e);
		});
		
	}
	
	private void dialog(MyFrame frame, ActionEvent e) {
		String origin = e.getActionCommand();
		
		switch (origin) {
			case "Disclaimer": 
				break;
			case "Used formulas": 
				break;
			case "How to use Gothic Damage Calculator": 
				break;
			case "About": 
				break;
		}
		
		JTextArea jta = new JTextArea("adsaadsaadsaadsaadsaadsaadsaadsaadsa");
		jta.setEditable(false);
		//jta.setHighlighter(null);
		jta.setBackground(Colors.GREY);
		jta.setLineWrap(true);
		
		JTextPane jtp = new JTextPane();
		jtp.setEditable(false);
		jtp.setBackground(Colors.GREY);
		
		
		JDialog jd = new JDialog(frame, "Dia=adaj", true);
		jd.add(jta);
		jd.setSize(300, 300);
		jd.setVisible(true);
		
		// http://forum.worldofplayers.de/forum/threads/127320-Damage-System?p=2198181#post2198181
		
	}
}
