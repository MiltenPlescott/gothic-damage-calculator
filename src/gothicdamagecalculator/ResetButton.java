/*
 * GothicDamageCalculator
 * 
 * Copyright (c) 2017, Milten Plescott. All rights reserved.
 * 
 * SPDX-License-Identifier:    BSD-3-Clause
 */

package gothicdamagecalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Milten Plescott
 */
public class ResetButton implements ActionListener {
	public MyFrame frame;
	
	public ResetButton(MyFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		reset();
	}
	
	private void reset() {
		frame.gui.namelessHero.jsStrength.setValue(10);
		frame.gui.namelessHero.jsDexterity.setValue(10);
		frame.gui.namelessHero.js1HSkill.setValue(10);
		frame.gui.namelessHero.js2HSkill.setValue(10);
		frame.gui.namelessHero.jsBow.setValue(10);
		frame.gui.namelessHero.jsCrossbow.setValue(10);
		
		frame.gui.weapon.jsDamage.setValue(10);
		frame.gui.weapon.jcomboWeaponType.setSelectedItem("1H");
		frame.gui.weapon.jcheckBeliar.setSelected(false);
		frame.gui.weapon.jsBonusSkill.setValue(0);
		frame.gui.weapon.jsLightningDmg.setValue(100);
		frame.gui.weapon.jsLightningChance.setValue(12);
		
		frame.gui.target.jsHitpoints.setValue(1000);
		frame.gui.target.jsHits.setValue(20);
		frame.gui.target.jsMelee.setValue(10);
		frame.gui.target.jsRanged.setValue(10);
		
		frame.gui.result.jlNoNormals.setText("");
		frame.gui.result.jlNormalDmg.setText("");
		frame.gui.result.jlNoCrits.setText("");
		frame.gui.result.jlCritDmg.setText("");
		frame.gui.result.jlNoLightnings.setText("");
		frame.gui.result.jlLightningDmg.setText("");
		frame.gui.result.jlStatus.setText("");
		frame.gui.result.jlTotalDmg.setText("");
	}
}
