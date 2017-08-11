/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gothicdamagecalculator;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;


/**
 *
 * @author Milten Plescott
 */
public class Weapon {
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
	
	public Color defaultSpinnerColor;
	
	public Weapon(JPanel pWeapon, MyFrame frame) {
		pWeapon.setLayout(new GridBagLayout());
		createJLabels();
		createJSpinners();
		createOtherComponents(frame);
		addComponentsToPanel(pWeapon);
	}
	
	private void createJLabels() {
		jlDamage = new JLabel("Damage:");
		jlWeaponType = new JLabel("Weapon type:");
		jlBonusSkill = new JLabel("Bonus skill (%):");			// enable = false when combobox == bow || xbow
		jlLightningDmg = new JLabel("Lightning damage:");			// enable = false when jcheckBeliar == false
		jlLightningChance = new JLabel("Lightning chance (%):");	// enable = false when jcheckBeliar == false
		
		jlLightningDmg.setEnabled(false);
		jlLightningChance.setEnabled(false);
	}
	
	private void createJSpinners() {
		jsDamage = new JSpinner(new SpinnerNumberModel(10, 0, 5000, 1));
		jsBonusSkill = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));			// enable = false when combobox == bow || xbow
		jsLightningDmg = new JSpinner(new SpinnerNumberModel(100, 0, 5000, 1));	// enable = false when jcheckBeliar == false
		jsLightningChance = new JSpinner(new SpinnerNumberModel(12, 0, 100, 1));	// enable = false when jcheckBeliar == false
		
		jsLightningDmg.setEnabled(false);
		jsLightningChance.setEnabled(false);
		
		defaultSpinnerColor = ((JSpinner.NumberEditor) jsDamage.getEditor()).getTextField().getBackground();
	}
	
	private void createOtherComponents(MyFrame frame) {
		jcheckBeliar = new JCheckBox("Claw of Beliar", false);	// false -> initially unselected
		jcheckBeliar.setFocusable(false);
		
		jcheckBeliar.addItemListener(
			(ItemEvent e) -> {
				if (jcheckBeliar.isSelected() == true) {
					jlLightningDmg.setEnabled(true);
					jsLightningDmg.setEnabled(true);
					jlLightningChance.setEnabled(true);
					jsLightningChance.setEnabled(true);
					lightningBorders(jsLightningDmg);
					lightningBorders(jsLightningChance);
				}
				else {
					jlLightningDmg.setEnabled(false);
					jsLightningDmg.setEnabled(false);
					jlLightningChance.setEnabled(false);
					jsLightningChance.setEnabled(false);
					resetLightningBorders(jsLightningDmg);
					resetLightningBorders(jsLightningChance);
				}
			}
		);
		
		String[] weaponTypes = {"1H", "2H", "Bow", "Crossbow"};
		jcomboWeaponType = new JComboBox(weaponTypes);
		jcomboWeaponType.setFocusable(false);
	}
	
	private void lightningBorders(JSpinner spinner) {
		LineBorder lb = new LineBorder(Colors.BLUISH, 3);
																			// MatteBorder(top, left, bottom, right, color)
		MatteBorder mbTR = new MatteBorder(3, 0, 0, 3, Colors.BLUISH);		// top-right border for TOP BUTTON
		MatteBorder mbBR = new MatteBorder(0, 0, 3, 3, Colors.BLUISH);		// bottom-right border for BOTTOM button
		MatteBorder mbTL = new MatteBorder(2, 2, 0, 0, Colors.GREYISH);		// top-left border for BOTTOM button
		MatteBorder mbBL = new MatteBorder(0, 2, 2, 0, Colors.GREYISH);		// bottom-left border for TOP button
		CompoundBorder cbTB = new CompoundBorder(mbTR, mbBL);
		CompoundBorder cbBB = new CompoundBorder(mbBR, mbTL);
		
		spinner.setBorder(lb);
		((JComponent) spinner.getComponent(0)).setBorder(cbTB);		// top button
		((JComponent) spinner.getComponent(1)).setBorder(cbBB);		// bottom button
		
		((JSpinner.NumberEditor) spinner.getEditor()).getTextField().setBackground(Colors.GREENISH);
	}
	
	private void resetLightningBorders(JSpinner spinner) {
		spinner.setBorder(UIManager.getBorder("Spinner.border"));
		((JComponent) spinner.getComponent(0)).setBorder(UIManager.getBorder("Spinner.arrowButtonBorder"));
		((JComponent) spinner.getComponent(1)).setBorder(UIManager.getBorder("Spinner.arrowButtonBorder"));
		((JSpinner.NumberEditor) spinner.getEditor()).getTextField().setBackground(defaultSpinnerColor);
	}
	
	private void addComponentsToPanel(JPanel pWeapon) {
		pWeapon.add(jlDamage,         GridBag.setGBC(0, 0, GridBagConstraints.EAST, 10));
		pWeapon.add(jsDamage,         GridBag.setGBC(1, 0, GridBagConstraints.WEST));
		pWeapon.add(jlWeaponType,     GridBag.setGBC(2, 0, GridBagConstraints.EAST, 10));
		pWeapon.add(jcomboWeaponType, GridBag.setGBC(3, 0, GridBagConstraints.WEST));
		
		pWeapon.add(jcheckBeliar, GridBag.setGBC(0, 1, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER, 0));
		pWeapon.add(jlBonusSkill, GridBag.setGBC(2, 1, GridBagConstraints.EAST, 10));
		pWeapon.add(jsBonusSkill, GridBag.setGBC(3, 1, GridBagConstraints.WEST));
		
		pWeapon.add(jlLightningDmg,    GridBag.setGBC(0, 2, GridBagConstraints.EAST, 10));
		pWeapon.add(jsLightningDmg,    GridBag.setGBC(1, 2, GridBagConstraints.WEST));
		pWeapon.add(jlLightningChance, GridBag.setGBC(2, 2, GridBagConstraints.EAST, 10));
		pWeapon.add(jsLightningChance, GridBag.setGBC(3, 2, GridBagConstraints.WEST));
	}
}
