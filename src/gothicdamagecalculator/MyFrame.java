/*
 * GothicDamageCalculator
 * 
 * Copyright (c) 2017, Milten Plescott. All rights reserved.
 * 
 * SPDX-License-Identifier:    BSD-3-Clause
 */

package gothicdamagecalculator;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

/**
 *
 * @author Milten Plescott
 */
public class MyFrame extends JFrame {
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
		frame.setMinimumSize(new Dimension(810, 350));
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
