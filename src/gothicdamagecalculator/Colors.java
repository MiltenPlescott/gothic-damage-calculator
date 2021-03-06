/*
 * GothicDamageCalculator
 * 
 * Copyright (c) 2017, Milten Plescott. All rights reserved.
 * 
 * SPDX-License-Identifier:    BSD-3-Clause
 */

package gothicdamagecalculator;

import java.awt.Color;

import javax.swing.UIManager;

/**
 *
 * @author Milten Plescott
 */
public final class Colors {
	public static final Color BLACK = new Color(0, 0, 0);
	public static final Color GREY = new Color(240, 240, 240);
	public static final Color GREYISH = UIManager.getColor("Button.darkShadow");	// R:122 G:138 B:153
	public static final Color BLUISH = new Color(88, 139, 193);
	public static final Color GREENISH = new Color(156, 255, 147);
	
	private Colors() {
		throw new AssertionError();
	}
}
