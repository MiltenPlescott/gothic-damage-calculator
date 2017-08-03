/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gothicdamagecalculator;

import java.awt.Dimension;

import javax.swing.JFrame;

/**
 *
 * @author Milten Plescott
 */
public class MyJFrame extends JFrame {
	
	MyJFrame(String name) {
		super(name);
		prepareFrame();
	}
	
	private void prepareFrame() {
		this.setVisible(true);
		// TODO: dynamic resizing here
		this.setSize(500, 500);
		this.setMinimumSize(new Dimension(100, 100));
		this.setBackground(Colors.GRAY);
	}
}
