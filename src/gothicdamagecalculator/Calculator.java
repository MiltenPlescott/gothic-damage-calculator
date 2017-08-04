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


// this class/file is no longer needed

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
		System.out.println("running G1");	
		
		if (calcInput.weaponType.equals("1H") || calcInput.weaponType.equals("2H")) {
			g1Melee(calcInput);
		}
		else {
			g1Ranged(calcInput);
		}
	}
		
		//foo(weaponDamage, skill);
	
		/*
		int rangedArmor = (Integer) frame.gui.target.jsRanged.getValue();
		System.out.println("ranged");
		
		int singleNormalDmg;
		*/
	
	private void gameG2(CalculationInput calcInput) {
		System.out.println("running G2");
		
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
		// if singleNormalDmd < 0 ??????
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
		// if singleNormalDmd < 0 ??????
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
		int health;
		
		noCrits = ((skill) / 100) * calcInput.hits;
		noNormals = calcInput.hits - noCrits;
		
		normalDmg = noNormals * singleNormalDmg;
		critDmg = noCrits * singleCritDmg;
		
		if (calcInput.beliar == true) {
			noLightnings = ((calcInput.lightningChance)/ 100) * calcInput.hits;
			lightningDmg = noLightnings * calcInput.lightningDamage;
		}
		
		totalDmg = normalDmg + critDmg + lightningDmg;
		health = calcInput.health - totalDmg;
		
		setResults(noNormals, normalDmg, noCrits, critDmg, noLightnings, lightningDmg, health, totalDmg);
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
		int health;
		
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
		
		noCrits = ((skill) / 100) * calcInput.hits;
		//noCrits = calcInput.hits * skill / 100;
		noNormals = calcInput.hits - noCrits;
		
		normalDmg = noNormals * singleNormalDmg;
		critDmg = noCrits * singleCritDmg;
		
		if (calcInput.beliar == true) {
			noLightnings = ((calcInput.lightningChance)/ 100) * calcInput.hits;
			lightningDmg = noLightnings * calcInput.lightningDamage;
		}
		
		totalDmg = normalDmg + critDmg + lightningDmg;
		health = calcInput.health - totalDmg;
		
		setResults(noNormals, normalDmg, noCrits, critDmg, noLightnings, lightningDmg, health, totalDmg);
	}
		
	private void g2Ranged(CalculationInput calcInput) {
		int singleNormalDmg;
		int noNormals;
		int normalDmg;
		int noLightnings = 0;
		int lightningDmg = 0;
		int totalDmg;
		int health;
		
		singleNormalDmg = calcInput.weaponDamage + calcInput.dexterity - calcInput.rangedArmor;
		singleNormalDmg = (singleNormalDmg < 5) ? 5 : singleNormalDmg;
		// if singleNormalDmd < 0 ??????
		
		noNormals = calcInput.hits;
		normalDmg = noNormals * singleNormalDmg;
		
		if (calcInput.beliar == true) {
			noLightnings = ((calcInput.lightningChance)/ 100) * calcInput.hits;
			lightningDmg = noLightnings * calcInput.lightningDamage;
		}
		
		totalDmg = normalDmg + lightningDmg;
		health = calcInput.health - totalDmg;
		
		setResults(noNormals, normalDmg, 0, 0, noLightnings, lightningDmg, health, totalDmg);
	}
	

	
	private void setResults(int noNormals, int normalDmg, int noCrits, int critDmg, int noLightnings, int lightningDmg, int health, int totalDmg) {
		frame.gui.result.jlNoNormals.setText("" + noNormals);
		frame.gui.result.jlNormalDmg.setText("" + normalDmg);
		frame.gui.result.jlNoCrits.setText("" + noCrits);
		frame.gui.result.jlCritDmg.setText("" + critDmg);
		frame.gui.result.jlNoLightnings.setText("" + noLightnings);
		frame.gui.result.jlLightningDmg.setText("" + lightningDmg);
		frame.gui.result.jlStatus.setText("" + health);
		frame.gui.result.jlTotalDmg.setText("" + totalDmg);
		
	}
	
	
}
