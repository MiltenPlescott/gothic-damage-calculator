/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gothicdamagecalculator;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Milten Plescott
 */
public class GothicDamageCalculator {
	MyJFrame frame;
	
	ButtonGroup rbGroup;
	
	JRadioButton rbG1;
	JRadioButton rbG2;
	
	JPanel pGrid;
	JPanel pRadioButton;
	JPanel pNameless;
	JPanel pWeapon;
	JPanel pTarget;
	JPanel pResult;
	
	GothicDamageCalculator() {
		frame = new MyJFrame("Gothic Damage Calculator");
		frame.addWindowListener(new CloseWindow());
		frame.setLayout(new BorderLayout(0, 20));	// hgap, vgap
		
		rbG1 = new JRadioButton("Gothic 1", false);	// false - initially unselected
		rbG2 = new JRadioButton("Gothic 2", true);	// true - initially selected
		
		pRadioButton = new JPanel();
		pRadioButton.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));	// align, hgap, vgap
		frame.add(pRadioButton, BorderLayout.NORTH);
		
		pRadioButton.add(rbG1);
		pRadioButton.add(rbG2);
		
		rbGroup = new ButtonGroup();
		rbGroup.add(rbG1);
		rbGroup.add(rbG2);
		
		pGrid = new JPanel();
		frame.add(pGrid, BorderLayout.CENTER);
		
		
		pNameless = new JPanel();
		pWeapon = new JPanel();
		pTarget = new JPanel();
		pResult = new JPanel();
		
		pGrid.setLayout(new GridLayout(2, 2, 20, 20));	// rows, cols, hgap, vgap
		pGrid.add(pNameless);
		pGrid.add(pTarget);
		pGrid.add(pWeapon);
		pGrid.add(pResult);
		
		
		/*
		COLOR CODING
		*/
		colorCoding();
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		GothicDamageCalculator gdc = new GothicDamageCalculator();
	}
	
	
	private void colorCoding() {
		frame.setBackground(Colors.GRAY);
		rbG1.setBackground(Colors.CYAN);
		rbG2.setBackground(Colors.YELLOW);
		pGrid.setBackground(Colors.PINK);
		pRadioButton.setBackground(Colors.BLUE);
		pNameless.setBackground(Colors.BROWN);
		pWeapon.setBackground(Colors.RED);
		pTarget.setBackground(Colors.GREEN);
		pResult.setBackground(Colors.ORANGE);
	}
}
