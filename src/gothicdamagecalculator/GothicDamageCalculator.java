/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gothicdamagecalculator;

import javax.swing.JPanel;

/**
 *
 * @author Milten Plescott
 */
public class GothicDamageCalculator {
	MyFrame frame;
	JPanel jpNameless;
	JPanel jpWeapon;
	JPanel jpTarget;
	JPanel jpResult;
	
	GothicDamageCalculator() {
		frame = new MyFrame("Gothic Damage Calculator");
		//frame.setLayout(TBD);
		frame.addWindowListener(new CloseWindow());
		jpNameless = new JPanel();
		jpWeapon = new JPanel();
		jpTarget = new JPanel();
		jpResult = new JPanel();
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		GothicDamageCalculator gdc = new GothicDamageCalculator();
	}
	
}
