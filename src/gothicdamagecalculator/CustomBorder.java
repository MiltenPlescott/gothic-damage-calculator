/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gothicdamagecalculator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Milten Plescott
 */
public class CustomBorder implements ActionListener {
	
	public MyFrame frame;
	public Color defaultSpinnerColor;
	
	public CustomBorder(MyFrame frame) {
		this.frame = frame;
		defaultSpinnerColor = ((JSpinner.NumberEditor) frame.gui.namelessHero.jsDexterity.getEditor()).getTextField().getBackground();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Borders triggered");
		
		resetBorders();
		addBorders();
	}
	
	protected void addBorders() {
		Boolean gameG1 = frame.gui.rbG1.isSelected();
		String weaponType = frame.gui.weapon.jcomboWeaponType.getSelectedItem().toString();
		
		permanentBorder();
		
		if (weaponType.equals("1H") || weaponType.equals("2H")) {
			meleeBorder(weaponType);
		}
		else {
			if (gameG1 == true) {
				rangedG1Border(weaponType);
			}
			else {
				rangedG2Border();
			}
		}
	}
	
	private void permanentBorder() {
		createBorder(frame.gui.target.jsHealth);
		createBorder(frame.gui.target.jsHits);
		createBorder(frame.gui.weapon.jsDamage);
	}
	
	private void meleeBorder(String weaponType) {
		createBorder(frame.gui.namelessHero.jsStrength);
		createBorder(frame.gui.target.jsMelee);
		createBorder(frame.gui.weapon.jsBonusSkill);
		if (weaponType.equals("1H")) {
		createBorder(frame.gui.namelessHero.js1HSkill);
		}
		else {
		createBorder(frame.gui.namelessHero.js2HSkill);
		}
	}
	
	private void rangedG1Border(String weaponType) {
		createBorder(frame.gui.target.jsRanged);
		createBorder(frame.gui.weapon.jsBonusSkill);
		
		if (weaponType.equals("Bow")) {
			createBorder(frame.gui.namelessHero.jsBow);
		}
		else {
			createBorder(frame.gui.namelessHero.jsCrossbow);
		}
	}
	
	private void rangedG2Border() {
		createBorder(frame.gui.namelessHero.jsDexterity);
		createBorder(frame.gui.target.jsRanged);
	}
	
	public void createBorder(JSpinner spinner) {
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
	
	private void resetBorders() {
		resetSpinnerBorder(frame.gui.namelessHero.jsStrength);
		resetSpinnerBorder(frame.gui.namelessHero.jsDexterity);
		resetSpinnerBorder(frame.gui.namelessHero.js1HSkill);
		resetSpinnerBorder(frame.gui.namelessHero.js2HSkill);
		resetSpinnerBorder(frame.gui.namelessHero.jsBow);
		resetSpinnerBorder(frame.gui.namelessHero.jsCrossbow);
		resetSpinnerBorder(frame.gui.target.jsMelee);
		resetSpinnerBorder(frame.gui.target.jsRanged);
		resetSpinnerBorder(frame.gui.weapon.jsBonusSkill);
	}
	
	private void resetSpinnerBorder(JSpinner spinner) {
		spinner.setBorder(UIManager.getBorder("Spinner.border"));
		((JComponent) spinner.getComponent(0)).setBorder(UIManager.getBorder("Spinner.arrowButtonBorder"));
		((JComponent) spinner.getComponent(1)).setBorder(UIManager.getBorder("Spinner.arrowButtonBorder"));
		((JSpinner.NumberEditor) spinner.getEditor()).getTextField().setBackground(defaultSpinnerColor);
	}
}
