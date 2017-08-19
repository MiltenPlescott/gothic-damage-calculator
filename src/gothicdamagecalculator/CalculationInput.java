/*
 * GothicDamageCalculator
 * 
 * Copyright (c) 2017, Milten Plescott. All rights reserved.
 * 
 * SPDX-License-Identifier:    BSD-3-Clause
 */

package gothicdamagecalculator;

import java.text.ParseException;

import javax.swing.JSpinner;

/**
 *
 * @author Milten Plescott
 */
public class CalculationInput {
	public boolean gameG1;
	
	public int strength;
	public int dexterity;
	public int skill1H;
	public int skill2H;
	public int skillBow;
	public int skillCrossbow;
	
	public String weaponType;
	public boolean beliar;
	public int weaponDamage;
	public int skillBonus;
	public int lightningDamage;
	public int lightningChance;
	
	public int hitpoints;
	public int hits;
	public int meleeArmor;
	public int rangedArmor;
	
	public CalculationInput(MyFrame frame) {
		readData(frame);
	}
	
	private void readData(MyFrame frame) {
		gameG1 = frame.gui.rbG1.isSelected();
		
		commitSpinner(frame.gui.namelessHero.jsStrength);
		commitSpinner(frame.gui.namelessHero.jsDexterity);
		commitSpinner(frame.gui.namelessHero.js1HSkill);
		commitSpinner(frame.gui.namelessHero.js2HSkill);
		commitSpinner(frame.gui.namelessHero.jsBow);
		commitSpinner(frame.gui.namelessHero.jsCrossbow);

		strength = (Integer) frame.gui.namelessHero.jsStrength.getValue();
		dexterity = (Integer) frame.gui.namelessHero.jsDexterity.getValue();
		skill1H = (Integer) frame.gui.namelessHero.js1HSkill.getValue();
		skill2H = (Integer) frame.gui.namelessHero.js2HSkill.getValue();
		skillBow = (Integer) frame.gui.namelessHero.jsBow.getValue();
		skillCrossbow = (Integer) frame.gui.namelessHero.jsCrossbow.getValue();
		
		weaponType = frame.gui.weapon.jcomboWeaponType.getSelectedItem().toString();
		beliar = frame.gui.weapon.jcheckBeliar.isSelected();

		commitSpinner(frame.gui.weapon.jsDamage);
		commitSpinner(frame.gui.weapon.jsBonusSkill);
		commitSpinner(frame.gui.weapon.jsLightningDmg);
		commitSpinner(frame.gui.weapon.jsLightningChance);

		weaponDamage = (Integer) frame.gui.weapon.jsDamage.getValue();
		skillBonus = (Integer) frame.gui.weapon.jsBonusSkill.getValue();
		lightningDamage = (Integer) frame.gui.weapon.jsLightningDmg.getValue();
		lightningChance = (Integer) frame.gui.weapon.jsLightningChance.getValue();

		commitSpinner(frame.gui.target.jsHitpoints);
		commitSpinner(frame.gui.target.jsHits);
		commitSpinner(frame.gui.target.jsMelee);
		commitSpinner(frame.gui.target.jsRanged);

		hitpoints = (Integer) frame.gui.target.jsHitpoints.getValue();
		hits = (Integer) frame.gui.target.jsHits.getValue();
		meleeArmor = (Integer) frame.gui.target.jsMelee.getValue();
		rangedArmor = (Integer) frame.gui.target.jsRanged.getValue();
	}
	
	private void commitSpinner(JSpinner spinner) {
		try {
			spinner.commitEdit();
		}
		catch (ParseException e) {
		}
	}
}
