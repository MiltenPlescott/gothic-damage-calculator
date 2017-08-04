/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gothicdamagecalculator;

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
	
	public int health;
	public int hits;
	public int meleeArmor;
	public int rangedArmor;
	
	public CalculationInput(MyFrame frame) {
		// read all the data into fields (radio button included)
		readData(frame);
	}
	
	private void readData(MyFrame frame) {
		gameG1 = frame.gui.rbG1.isSelected();
		
		strength = (Integer) frame.gui.namelessHero.jsStrength.getValue();
		dexterity = (Integer) frame.gui.namelessHero.jsDexterity.getValue();
		skill1H = (Integer) frame.gui.namelessHero.js1HSkill.getValue();
		skill2H = (Integer) frame.gui.namelessHero.js2HSkill.getValue();
		skillBow = (Integer) frame.gui.namelessHero.jsBow.getValue();
		skillCrossbow = (Integer) frame.gui.namelessHero.jsCrossbow.getValue();

		weaponType = frame.gui.weapon.jcomboWeaponType.getSelectedItem().toString();
		beliar = frame.gui.weapon.jcheckBeliar.isSelected();
		
		weaponDamage = (Integer) frame.gui.weapon.jsDamage.getValue();
		skillBonus = (Integer) frame.gui.weapon.jsBonusSkill.getValue();
		lightningDamage = (Integer) frame.gui.weapon.jsLightningDmg.getValue();
		lightningChance = (Integer) frame.gui.weapon.jsLightningChance.getValue();

		health = (Integer) frame.gui.target.jsHealth.getValue();
		hits = (Integer) frame.gui.target.jsHits.getValue();
		meleeArmor = (Integer) frame.gui.target.jsMelee.getValue();
		rangedArmor = (Integer) frame.gui.target.jsRanged.getValue();
	}
}
