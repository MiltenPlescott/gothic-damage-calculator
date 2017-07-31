/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gothicdamagecalculator;

import java.awt.Panel;

/**
 *
 * @author Milten Plescott
 */
public class GothicDamageCalculator {
	MyFrame frame;
	Panel pNameless;
	Panel pWeapon;
	Panel pTarget;
	
	GothicDamageCalculator() {
		frame = new MyFrame("Gothic Damage Calculator");
		//frame.setLayout(TBD);
		frame.addWindowListener(new CloseWindow());
		pNameless = new Panel();
		pWeapon = new Panel();
		pTarget = new Panel();
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		GothicDamageCalculator gdc = new GothicDamageCalculator();
	}
	
}
