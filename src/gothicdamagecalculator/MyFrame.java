/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gothicdamagecalculator;

import java.awt.Frame;

/**
 *
 * @author Milten Plescott
 */
public class MyFrame extends Frame {
	
	MyFrame(String name) {
		super(name);
		this.setVisible(true);
		// TODO: dynamic resizing here
		this.setSize(500, 500);
		this.setBackground(Colors.GRAY);
	}
}