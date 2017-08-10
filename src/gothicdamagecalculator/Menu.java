/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gothicdamagecalculator;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;

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
			dialog(e);
		});
		
		jmiFormulas.addActionListener((ActionEvent e) -> {
			dialog(e);
		});
		
		jmiHowTo.addActionListener((ActionEvent e) -> {
			dialog(e);
		});
		
		jmiAbout.addActionListener((ActionEvent e) -> {
			dialog(e);
		});
	}
	
	private void dialog(ActionEvent e) {
		String title = e.getActionCommand();
		String pathHtml = "file:///" + getPath();
		int dialogWidth = 900;
		int dialogHeight = 700;
		int xPos = (MyFrame.SCREEN_WIDTH - dialogWidth) / 2;
		int yPos = (MyFrame.SCREEN_HEIGHT - MyFrame.DEFAULT_HEIGHT) / 4;
		
		switch (title) {
			case "Disclaimer":
				pathHtml += "disclaimer.html";
				System.out.println(getPath());
				break;
			case "Used formulas":
				pathHtml += "used formulas.html";
				break;
			case "How to use Gothic Damage Calculator":
				pathHtml += "how to use gothic damage calculator.html";
				break;
			default:
			case "About":
				pathHtml += "about.html";
				break;
		}
		
		JDialog jd = new JDialog(frame, title, true);
		jd.setSize(dialogWidth, dialogHeight);
		
		try {
			JEditorPane editor = new JEditorPane(pathHtml);
			editor.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
			editor.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, true);
			editor.setEditable(false);
			editor.setHighlighter(null);
			editor.setBackground(Colors.GREY);
			
			jd.add(new JScrollPane(editor));
			
			editor.addHyperlinkListener(
				(HyperlinkEvent hyperE) -> {
					if (hyperE.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
						openLicense();
					}
				}
			);
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		
		jd.setLocationRelativeTo(frame);
		jd.setLocation(xPos, yPos);
		jd.setVisible(true);		
	}
	
	private String getPath() {
		String dir = System.getProperty("user.dir");
		return dir + File.separator;
	}
	
	private void openLicense() {
		if (Desktop.isDesktopSupported() == true) {
			Desktop desktop = Desktop.getDesktop();
			if (desktop.isSupported(Desktop.Action.OPEN) == true) {
				try {
					desktop.open(new File(getPath() + "license.txt"));
				}
				catch (IOException ioex) {
					ioex.printStackTrace();
				}
			}
		}
	}
}
