/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gothicdamagecalculator;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Milten Plescott
 */
public class Target {
	
	/*
	ALIGNMENT of number insdie JSpinner -- probably not gonna use it since the arrows of spinner are on the right
	and far away from the number (it would not look any better so there is no point in doing extra work)

	JComponent jc = jsMelee.getEditor();
	JSpinner.DefaultEditor foo = (JSpinner.DefaultEditor)jc;
	foo.getTextField().setHorizontalAlignment(JTextField.LEFT);
	*/
	
	public JLabel jlHealth;
	public JLabel jlHits;
	public JLabel jlMelee;
	public JLabel jlRanged;
	
	public JSpinner jsHealth;
	public JSpinner jsHits;
	public JSpinner jsMelee;
	public JSpinner jsRanged;
	
	public Target(JPanel pTarget) {
		pTarget.setLayout(new GridBagLayout());
		createJLabels();
		createJSpinners();
		addComponentsToPanel(pTarget);
	}
	
	private void createJLabels() {
		jlHealth = new JLabel("Health:");
		jlHits = new JLabel("Number of hits:");
		jlMelee = new JLabel("Melee armor:");
		jlRanged = new JLabel("Ranged armor:");
	}
	
	private void createJSpinners() {
		jsHealth = new JSpinner(new SpinnerNumberModel(1000, 1, 1000000, 1));
		jsHits = new JSpinner(new SpinnerNumberModel(20, 1, 5000, 1));
		jsMelee = new JSpinner(new SpinnerNumberModel(10, 0, 5000, 1));
		jsRanged = new JSpinner(new SpinnerNumberModel(10, 0, 5000, 1));
	}

	private void addComponentsToPanel(JPanel pTarget) {
		Insets i = new Insets(0, 0, 0, 0);
		
		double a = 1.0;
		double b = 1.0;
		int c = GridBagConstraints.EAST;
		int d = GridBagConstraints.WEST;
		int e = GridBagConstraints.NONE;
		
		GridBagConstraints g1 = new GridBagConstraints(0, 0, 1, 1, a, b, c, e, i, 10, 0);
		GridBagConstraints g2 = new GridBagConstraints(1, 0, 1, 1, a, b, d, e, i, 0, 0);
		GridBagConstraints g3 = new GridBagConstraints(2, 0, 1, 1, a, b, c, e, i, 10, 0);
		GridBagConstraints g4 = new GridBagConstraints(3, 0, 1, 1, a, b, d, e, i, 0, 0);
		
		GridBagConstraints g5 = new GridBagConstraints(0, 1, 1, 1, a, b, c, e, i, 10, 0);
		GridBagConstraints g6 = new GridBagConstraints(1, 1, 1, 1, a, b, d, e, i, 0, 0);
		GridBagConstraints g7 = new GridBagConstraints(2, 1, 1, 1, a, b, c, e, i, 10, 0);
		GridBagConstraints g8 = new GridBagConstraints(3, 1, 1, 1, a, b, d, e, i, 0, 0);
		
		pTarget.add(jlHealth, g1);
		pTarget.add(jsHealth, g2);
		pTarget.add(jlMelee,   g3);
		pTarget.add(jsMelee,   g4);
		
		pTarget.add(jlHits,  g5);
		pTarget.add(jsHits,  g6);
		pTarget.add(jlRanged, g7);
		pTarget.add(jsRanged, g8);
		
		
		/*
		pTarget.add(jlHealth, GridBag.setGBC(0, 0, GridBagConstraints.EAST, 10));
		pTarget.add(jsHealth, GridBag.setGBC(1, 0, GridBagConstraints.WEST));
		pTarget.add(jlHits,   GridBag.setGBC(2, 0, GridBagConstraints.EAST, 10));
		pTarget.add(jsHits,   GridBag.setGBC(3, 0, GridBagConstraints.WEST));
		
		pTarget.add(jlMelee,  GridBag.setGBC(0, 1, GridBagConstraints.EAST, 10));
		pTarget.add(jsMelee,  GridBag.setGBC(1, 1, GridBagConstraints.WEST));
		pTarget.add(jlRanged, GridBag.setGBC(2, 1, GridBagConstraints.EAST, 10));
		pTarget.add(jsRanged, GridBag.setGBC(3, 1, GridBagConstraints.WEST));
		*/
	}
}


