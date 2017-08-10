/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gothicdamagecalculator;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Milten Plescott
 */
public class MyFrame extends JFrame {
	
	public MyFrame frame;
	
	public static final int SCREEN_WIDTH = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
	public static final int SCREEN_HEIGHT = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
	public static final int DEFAULT_WIDTH = 1300;
	public static final int DEFAULT_HEIGHT = 550;
	
	public GUI gui;
	
	public MyFrame() {
		super();
		prepareFrame();
	}
	
	private void prepareFrame() {
		this.setName("Gothic Damage Calculator");
		this.setBackground(Colors.GREY);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.gui = new GUI(this);
		
		this.pack();
		this.setVisible(true);
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frameSize(frame);
		addBordersToWidgets(frame);
		changeTextStyleOnResize(frame);
	}
	
	public static void frameSize(MyFrame frame) {
		frame.setMinimumSize(new Dimension(600, 300));
		frame.setBounds((SCREEN_WIDTH - DEFAULT_WIDTH)/2, (SCREEN_HEIGHT - DEFAULT_HEIGHT)/2, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	public static void addBordersToWidgets(MyFrame frame) {
		CustomBorder border = new CustomBorder(frame);
		frame.gui.rbG1.addActionListener(border);
		frame.gui.rbG2.addActionListener(border);
		frame.gui.weapon.jcomboWeaponType.addActionListener(border);
		border.addBorders();
	}
	
	public static void changeTextStyleOnResize(MyFrame frame) {
		frame.addComponentListener(new TextStyle(frame));
	}
}
