/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gothicdamagecalculator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		frame.gui.target.jsHealth.setValue(1000);
		frame.gui.target.jsHits.setValue(20);
		frame.gui.target.jsMelee.setValue(10);
		frame.gui.target.jsRanged.setValue(10);
	}
}
