/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class NamelessHero {
	
	public JLabel jlStr;
	public JLabel jlDex;
	public JLabel jl1HSkill;
	public JLabel jl2HSkill;
	
	public JSpinner jsStrength;
	public JSpinner jsDexterity;
	public JSpinner js1HSkill;
	public JSpinner js2HSkill;
	
	public NamelessHero(JPanel pNameless) {
		pNameless.setLayout(new GridBagLayout());
		createJLabels();
		createJSpinners();
		addComponentsToPanel(pNameless);
	}
	
	private void createJLabels() {
		jlStr = new JLabel("Strength:");
		jlDex = new JLabel("Dexterity:");
		jl1HSkill = new JLabel("1H Skill (%):");
		jl2HSkill = new JLabel("2H Skill (%):");
	}
		
	private void createJSpinners() {
		jsStrength = new JSpinner(new SpinnerNumberModel(10, 0, 5000, 1));
		jsDexterity = new JSpinner(new SpinnerNumberModel(10, 0, 5000, 1));
		js1HSkill = new JSpinner(new SpinnerNumberModel(10, 0, 100, 1));
		js2HSkill = new JSpinner(new SpinnerNumberModel(10, 0, 100, 1));
	}
			
	private void addComponentsToPanel(JPanel pWeapon) {
		pWeapon.add(jlStr,       GridBag.setGBC(0, 0, GridBagConstraints.EAST, 10));
		pWeapon.add(jsStrength,  GridBag.setGBC(1, 0, GridBagConstraints.WEST));
		pWeapon.add(jl1HSkill,   GridBag.setGBC(2, 0, GridBagConstraints.EAST, 10));
		pWeapon.add(js1HSkill,   GridBag.setGBC(3, 0, GridBagConstraints.WEST));
		
		pWeapon.add(jlDex,       GridBag.setGBC(0, 1, GridBagConstraints.EAST, 10));
		pWeapon.add(jsDexterity, GridBag.setGBC(1, 1, GridBagConstraints.WEST));
		pWeapon.add(jl2HSkill,   GridBag.setGBC(2, 1, GridBagConstraints.EAST, 10));
		pWeapon.add(js2HSkill,   GridBag.setGBC(3, 1, GridBagConstraints.WEST));
	}
}
