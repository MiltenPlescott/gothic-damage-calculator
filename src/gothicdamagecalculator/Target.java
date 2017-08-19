/*
 * GothicDamageCalculator
 * 
 * Copyright (c) 2017, Milten Plescott. All rights reserved.
 * 
 * SPDX-License-Identifier:    BSD-3-Clause
 */

package gothicdamagecalculator;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Milten Plescott
 */
public class Target {
	public JLabel jlHitpoints;
	public JLabel jlHits;
	public JLabel jlMelee;
	public JLabel jlRanged;
	
	public JSpinner jsHitpoints;
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
		jlHitpoints = new JLabel("Hitpoints:");
		jlHits = new JLabel("Number of hits:");
		jlMelee = new JLabel("Melee armor:");
		jlRanged = new JLabel("Ranged armor:");
	}
	
	private void createJSpinners() {
		jsHitpoints = new JSpinner(new SpinnerNumberModel(1000, 1, 1000000, 1));
		jsHits = new JSpinner(new SpinnerNumberModel(20, 1, 5000, 1));
		jsMelee = new JSpinner(new SpinnerNumberModel(10, 0, 5000, 1));
		jsRanged = new JSpinner(new SpinnerNumberModel(10, 0, 5000, 1));
	}

	private void addComponentsToPanel(JPanel pTarget) {
		pTarget.add(jlHitpoints, GridBag.setGBC(0, 0, GridBagConstraints.EAST, 10));
		pTarget.add(jsHitpoints, GridBag.setGBC(1, 0, GridBagConstraints.WEST));
		pTarget.add(jlMelee,  GridBag.setGBC(2, 0, GridBagConstraints.EAST, 10));
		pTarget.add(jsMelee,  GridBag.setGBC(3, 0, GridBagConstraints.WEST));
		
		pTarget.add(jlHits,   GridBag.setGBC(0, 1, GridBagConstraints.EAST, 10));
		pTarget.add(jsHits,   GridBag.setGBC(1, 1, GridBagConstraints.WEST));
		pTarget.add(jlRanged, GridBag.setGBC(2, 1, GridBagConstraints.EAST, 10));
		pTarget.add(jsRanged, GridBag.setGBC(3, 1, GridBagConstraints.WEST));
	}
}
