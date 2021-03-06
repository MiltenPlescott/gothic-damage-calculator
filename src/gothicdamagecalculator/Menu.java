/*
 * GothicDamageCalculator
 * 
 * Copyright (c) 2017, Milten Plescott. All rights reserved.
 * 
 * SPDX-License-Identifier:    BSD-3-Clause
 */

package gothicdamagecalculator;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

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
		String pathHtml = "file:///" + getPath() + "menu" + File.separator;
		int dialogWidth = 900;
		int dialogHeight = 700;
		int xPos = (MyFrame.SCREEN_WIDTH - dialogWidth) / 2;
		int yPos = (MyFrame.SCREEN_HEIGHT - MyFrame.DEFAULT_HEIGHT) / 4;
		
		switch (title) {
			case "Disclaimer":
				pathHtml += "disclaimer.html";
				break;
			case "Used formulas":
				pathHtml += "formulas.html";
				break;
			case "How to use Gothic Damage Calculator":
				pathHtml += "howto.html";
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
			editor.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, true);
			editor.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
			editor.setEditable(false);
			editor.setBackground(Colors.GREY);
			
			jd.add(new JScrollPane(editor));
			
			editor.addHyperlinkListener(
				(HyperlinkEvent hyperE) -> {
					if (hyperE.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
						if (hyperE.getDescription().equals("LICENSE.txt")) {
							openLicense();
						}
						else {
							try {
								openBrowser(new URI(hyperE.getDescription()));
							}
							catch (URISyntaxException uriEx) {
								uriEx.printStackTrace();
							}
						}
					}
				}
			);
		}
		catch (IOException ioEx) {
			ioEx.printStackTrace();
		}
		
		jd.setLocationRelativeTo(frame);
		jd.setLocation(xPos, yPos);
		jd.setVisible(true);		
	}
	
	private void openLicense() {
		if (Desktop.isDesktopSupported() == true) {
			Desktop desktop = Desktop.getDesktop();
			if (desktop.isSupported(Desktop.Action.OPEN) == true) {
				try {
					desktop.open(new File(getPath() + "LICENSE.txt"));
				}
				catch (IOException ioEx) {
					ioEx.printStackTrace();
				}
			}
		}
	}
	
	private void openBrowser(URI uri) {
		if (Desktop.isDesktopSupported() == true) {
			Desktop desktop = Desktop.getDesktop();
			if (desktop.isSupported(Desktop.Action.BROWSE) == true) {
				try {
					desktop.browse(uri);
				}
				catch (IOException ioEx) {
					ioEx.printStackTrace();
				}
			}
		}
	}
	
	private String getPath() {
		return System.getProperty("user.dir") + File.separator;
	}
}
