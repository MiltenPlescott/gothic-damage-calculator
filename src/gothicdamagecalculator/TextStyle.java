/*
 * GothicDamageCalculator
 * 
 * Copyright (c) 2017, Milten Plescott. All rights reserved.
 * 
 * SPDX-License-Identifier:    BSD-3-Clause
 */

package gothicdamagecalculator;

import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JSpinner;
import javax.swing.JSpinner.NumberEditor;

/**
 *
 * @author Milten Plescott
 */
public class TextStyle extends ComponentAdapter {
	
	public MyFrame frame;
	
	public TextStyle(MyFrame frame) {
		this.frame = frame;
		updateFonts();
	}
	
	@Override
	public void componentResized(ComponentEvent e) {
		updateFonts();
	}
	
	private void updateFonts() {
		Font font = newFont();
		
		// Nameless Hero JLabels
		frame.gui.namelessHero.jlStr.setFont(font);
		frame.gui.namelessHero.jlDex.setFont(font);
		frame.gui.namelessHero.jl1HSkill.setFont(font);
		frame.gui.namelessHero.jl2HSkill.setFont(font);
		frame.gui.namelessHero.jlBow.setFont(font);
		frame.gui.namelessHero.jlCrossbow.setFont(font);
		
		// Nameless Hero JSpinners
		setFontSpinner(frame.gui.namelessHero.jsStrength, font);
		setFontSpinner(frame.gui.namelessHero.jsDexterity, font);
		setFontSpinner(frame.gui.namelessHero.js1HSkill, font);
		setFontSpinner(frame.gui.namelessHero.js2HSkill, font);
		setFontSpinner(frame.gui.namelessHero.jsBow, font);
		setFontSpinner(frame.gui.namelessHero.jsCrossbow, font);
		
		// Target JLabels
		frame.gui.target.jlHealth.setFont(font);
		frame.gui.target.jlHits.setFont(font);
		frame.gui.target.jlMelee.setFont(font);
		frame.gui.target.jlRanged.setFont(font);
		
		// Target JSpinners
		setFontSpinner(frame.gui.target.jsHealth, font);
		setFontSpinner(frame.gui.target.jsHits, font);
		setFontSpinner(frame.gui.target.jsMelee, font);
		setFontSpinner(frame.gui.target.jsRanged, font);
		
		// Weapon JLabels
		frame.gui.weapon.jlDamage.setFont(font);
		frame.gui.weapon.jlWeaponType.setFont(font);
		frame.gui.weapon.jlBonusSkill.setFont(font);
		frame.gui.weapon.jlLightningDmg.setFont(font);
		frame.gui.weapon.jlLightningChance.setFont(font);
		
		// Weapon JSpinners
		setFontSpinner(frame.gui.weapon.jsDamage, font);
		setFontSpinner(frame.gui.weapon.jsBonusSkill, font);
		setFontSpinner(frame.gui.weapon.jsLightningDmg, font);
		setFontSpinner(frame.gui.weapon.jsLightningChance, font);
		
		// Result JLabels
		frame.gui.result.jlNoNormalsLabel.setFont(font);
		frame.gui.result.jlNoNormals.setFont(font);
		frame.gui.result.jlNormalDmgLabel.setFont(font);
		frame.gui.result.jlNormalDmg.setFont(font);
		frame.gui.result.jlNoCritsLabel.setFont(font);
		frame.gui.result.jlNoCrits.setFont(font);
		frame.gui.result.jlCritDmgLabel.setFont(font);
		frame.gui.result.jlCritDmg.setFont(font);
		frame.gui.result.jlNoLightningsLabel.setFont(font);
		frame.gui.result.jlNoLightnings.setFont(font);
		frame.gui.result.jlLightningDmgLabel.setFont(font);
		frame.gui.result.jlLightningDmg.setFont(font);
		frame.gui.result.jlStatusLabel.setFont(font);
		frame.gui.result.jlStatus.setFont(font);
		frame.gui.result.jlTotalDmgLabel.setFont(font);
		frame.gui.result.jlTotalDmg.setFont(font);
		
		// Other components
		frame.gui.rbG1.setFont(font);
		frame.gui.rbG2.setFont(font);
		frame.gui.weapon.jcomboWeaponType.setFont(font);
		frame.gui.weapon.jcheckBeliar.setFont(font);
		frame.gui.result.jbReset.setFont(font);
		frame.gui.result.jbRun.setFont(font);
	}
	
	private Font newFont() {
		int w = frame.getSize().width;
		int h = frame.getSize().height;
		int fontSize = (w + h) / 90;
		
		return new Font(Font.SANS_SERIF, Font.PLAIN, fontSize);
	}
	
	private void setFontSpinner(JSpinner js, Font font) {
		((NumberEditor) js.getEditor()).getTextField().setFont(font);
	}
}
