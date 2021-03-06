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
public class Calculator implements ActionListener {
	public MyFrame frame;
	
	public Calculator(MyFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		CalculationInput calcInput = new CalculationInput(frame);
		
		if (calcInput.gameG1 == true) {
			gameG1(calcInput);
		}
		else {
			gameG2(calcInput);
		}
	}
	
	public void gameG1(CalculationInput calcInput) {
		if (calcInput.weaponType.equals("1H") || calcInput.weaponType.equals("2H")) {
			g1Melee(calcInput);
		}
		else {
			g1Ranged(calcInput);
		}
	}
	
	private void gameG2(CalculationInput calcInput) {
		if (calcInput.weaponType.equals("1H") || calcInput.weaponType.equals("2H")) {
			g2Melee(calcInput);
		}
		else {
			g2Ranged(calcInput);
		}
	}
	
	private void g1Melee(CalculationInput calcInput) {
		int skill = calcInput.skillBonus;
		int singleNormalDmg;
		int singleCritDmg;
		
		if (calcInput.weaponType.equals("1H")) {
			skill += calcInput.skill1H;
		}
		else {
			skill += calcInput.skill2H;
		}
		
		singleNormalDmg = calcInput.weaponDamage + calcInput.strength - calcInput.meleeArmor;
		singleCritDmg = (2 * calcInput.weaponDamage) + calcInput.strength - calcInput.meleeArmor;
		
		g1Total(calcInput, singleNormalDmg, singleCritDmg, skill);
	}
	
	private void g1Ranged(CalculationInput calcInput) {
		int skill = calcInput.skillBonus;
		int singleNormalDmg;
		int singleCritDmg;
		
		if (calcInput.weaponType.equals("Bow")) {
			skill += calcInput.skillBow;
		}
		else {
			skill += calcInput.skillCrossbow;
		}
		
		singleNormalDmg = calcInput.weaponDamage - calcInput.rangedArmor;
		singleCritDmg = (2 * calcInput.weaponDamage) - calcInput.rangedArmor;
		
		g1Total(calcInput, singleNormalDmg, singleCritDmg, skill);
	}
	
	private void g1Total(CalculationInput calcInput, int singleNormalDmg, int singleCritDmg, int skill) {
		int noNormals;
		int noCrits;
		int normalDmg;
		int critDmg;
		int noLightnings = 0;
		int lightningDmg = 0;
		int totalDmg;
		int hitpoints;
		
		noCrits = calcInput.hits * skill / 100;
		noNormals = calcInput.hits - noCrits;
		
		normalDmg = noNormals * ((singleNormalDmg < 0) ? 0 : singleNormalDmg);
		critDmg = noCrits * ((singleCritDmg < 0) ? 0 : singleCritDmg);
		
		if (calcInput.beliar == true) {
			noLightnings = calcInput.hits * calcInput.lightningChance / 100;
			lightningDmg = noLightnings * calcInput.lightningDamage;
		}
		
		totalDmg = normalDmg + critDmg + lightningDmg;
		hitpoints = calcInput.hitpoints - totalDmg;
		
		setResults(noNormals, normalDmg, noCrits, critDmg, noLightnings, lightningDmg, hitpoints, totalDmg);
	}
	
	private void g2Melee(CalculationInput calcInput) {
		int skill = calcInput.skillBonus;
		int singleNormalDmg;
		int singleCritDmg;
		int noNormals;
		int noCrits;
		int normalDmg;
		int critDmg;
		int noLightnings = 0;
		int lightningDmg = 0;
		int totalDmg;
		int hitpoints;
		
		if (calcInput.weaponType.equals("1H")) {
			skill += calcInput.skill1H;
		}
		else {
			skill += calcInput.skill2H;
		}
		
		singleNormalDmg = (calcInput.weaponDamage + calcInput.strength - calcInput.meleeArmor - 1) / 10;
		singleNormalDmg = (singleNormalDmg < 5) ? 5 : singleNormalDmg;
		
		singleCritDmg = calcInput.weaponDamage + calcInput.strength - calcInput.meleeArmor;
		singleCritDmg = (singleCritDmg < 5) ? 5 : singleCritDmg;
		
		noCrits = calcInput.hits * skill / 100;
		noNormals = calcInput.hits - noCrits;
		
		normalDmg = noNormals * singleNormalDmg;
		critDmg = noCrits * singleCritDmg;
		
		if (calcInput.beliar == true) {
			noLightnings = calcInput.hits * calcInput.lightningChance / 100;
			lightningDmg = noLightnings * calcInput.lightningDamage;
		}
		
		totalDmg = normalDmg + critDmg + lightningDmg;
		hitpoints = calcInput.hitpoints - totalDmg;
		
		setResults(noNormals, normalDmg, noCrits, critDmg, noLightnings, lightningDmg, hitpoints, totalDmg);
	}
		
	private void g2Ranged(CalculationInput calcInput) {
		int singleNormalDmg;
		int noNormals;
		int normalDmg;
		int noLightnings = 0;
		int lightningDmg = 0;
		int totalDmg;
		int hitpoints;
		
		singleNormalDmg = calcInput.weaponDamage + calcInput.dexterity - calcInput.rangedArmor;
		singleNormalDmg = (singleNormalDmg < 5) ? 5 : singleNormalDmg;
		
		noNormals = calcInput.hits;
		normalDmg = noNormals * singleNormalDmg;
		
		if (calcInput.beliar == true) {
			noLightnings = calcInput.hits * calcInput.lightningChance / 100;
			lightningDmg = noLightnings * calcInput.lightningDamage;
		}
		
		totalDmg = normalDmg + lightningDmg;
		hitpoints = calcInput.hitpoints - totalDmg;
		
		setResults(noNormals, normalDmg, 0, 0, noLightnings, lightningDmg, hitpoints, totalDmg);
	}
	
	private void setResults(int noNormals, int normalDmg, int noCrits, int critDmg, int noLightnings, int lightningDmg, int hitpoints, int totalDmg) {
		frame.gui.result.jlNoNormals.setText("" + noNormals);
		frame.gui.result.jlNormalDmg.setText("" + normalDmg);
		frame.gui.result.jlNoCrits.setText("" + noCrits);
		frame.gui.result.jlCritDmg.setText("" + critDmg);
		frame.gui.result.jlNoLightnings.setText("" + noLightnings);
		frame.gui.result.jlLightningDmg.setText("" + lightningDmg);
		frame.gui.result.jlStatus.setText("" + ((hitpoints < 0) ? 0 : hitpoints));
		frame.gui.result.jlTotalDmg.setText("" + totalDmg);
	}
}
