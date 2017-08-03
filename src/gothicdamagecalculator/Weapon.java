/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gothicdamagecalculator;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;


/**
 *
 * @author Milten Plescott
 */
public class Weapon {

	/*	
	GUI will create weaponPanel and it will add weaponPanel to frame(or gridPanel or what)
	here the constructor will set layout, one method will create widgets (one meethod for each widget type)
	and one method will add the widgets into the weaponPanel using layout (prefferably gridbag)

	all other 'panel' classes will probably use gridbag and will need all them setGBC methods, so I could make a custom
	GridBagConstarints class .... taht could possibly inherit from the JDK gbc ?????
	*/

	public JLabel jlDamage;
	public JLabel jlWeaponType;
	public JLabel jlBonusSkill;
	public JLabel jlLightningDmg;
	public JLabel jlLightningChance;
	
	public JSpinner jsDamage;
	public JSpinner jsBonusSkill;
	public JSpinner jsLightningDmg;
	public JSpinner jsLightningChance;
	
	public JCheckBox jcheckBeliar;
	public JComboBox jcomboWeaponType;
	
	public Weapon(JPanel pWeapon) {
		pWeapon.setLayout(new GridBagLayout());
		createJLabels();
		createJSpinners();
		createOtherComponents();
		addComponentsToPanel(pWeapon);
	}
	
	private void createJLabels() {
		jlDamage = new JLabel("Damage:");
		jlWeaponType = new JLabel("Weapon type:");
		jlBonusSkill = new JLabel("Bonus skill (%):");			// enable = false when combobox == bow || xbow
		jlLightningDmg = new JLabel("Lightning damage:");			// enable = false when jcheckBeliar == false
		jlLightningChance = new JLabel("Lightning chance (%):");	// enable = false when jcheckBeliar == false
	}
	
	private void createJSpinners() {
		jsDamage = new JSpinner(new SpinnerNumberModel(10, 0, 5000, 1));
		jsBonusSkill = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));			// enable = false when combobox == bow || xbow
		jsLightningDmg = new JSpinner(new SpinnerNumberModel(100, 0, 5000, 1));	// enable = false when jcheckBeliar == false
		jsLightningChance = new JSpinner(new SpinnerNumberModel(12, 0, 100, 1));	// enable = false when jcheckBeliar == false
	}
	
	private void createOtherComponents() {
		jcheckBeliar = new JCheckBox("Claw of Beliar", false);	// false -> not checked by default
		String[] weaponTypes = {"1H", "2H", "Bow", "Crossbow"};
		jcomboWeaponType = new JComboBox(weaponTypes);
	}
	
	private void addComponentsToPanel(JPanel pWeapon) {
		pWeapon.add(jlDamage, GridBag.setGBC(0, 0, GridBagConstraints.EAST, 10));
		pWeapon.add(jsDamage, GridBag.setGBC(1, 0, GridBagConstraints.WEST));
		pWeapon.add(jlWeaponType, GridBag.setGBC(2, 0, GridBagConstraints.EAST, 10));
		pWeapon.add(jcomboWeaponType,   GridBag.setGBC(3, 0, GridBagConstraints.WEST));
		
		pWeapon.add(jcheckBeliar, GridBag.setGBC(0, 1, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER, 0)); // the center anchor has not been visually tested yet
		pWeapon.add(jlBonusSkill, GridBag.setGBC(2, 1, GridBagConstraints.EAST, 10));
		pWeapon.add(jsBonusSkill, GridBag.setGBC(3, 1, GridBagConstraints.WEST));
		
		pWeapon.add(jlLightningDmg,    GridBag.setGBC(0, 2, GridBagConstraints.EAST, 10));
		pWeapon.add(jsLightningDmg,    GridBag.setGBC(1, 2, GridBagConstraints.WEST));
		pWeapon.add(jlLightningChance, GridBag.setGBC(2, 2, GridBagConstraints.EAST, 10));
		pWeapon.add(jsLightningChance, GridBag.setGBC(3, 2, GridBagConstraints.WEST));
	}
}
