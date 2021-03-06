/*
 * GothicDamageCalculator
 * 
 * Copyright (c) 2017, Milten Plescott. All rights reserved.
 * 
 * SPDX-License-Identifier:    BSD-3-Clause
 */

package gothicdamagecalculator;

import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 *
 * @author Milten Plescott
 */
public class GridBag {
	/*
	BASIC LAYOUT CONSTRAINTS SETTINGS:
	JSpinner (col, row, noCol, noRow, 1.0, 1.0, EAST, NONE, insets(0,0,0,0), 10, 0)
	JLabel   (col, row, noCol, noRow, 1.0, 1.0, WEST, NONE, insets(0,0,0,0),  0, 0)
	*/
	
	public static GridBagConstraints setGBC(int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty, int anchor, int ipadx) {
		return new GridBagConstraints(
				gridx,
				gridy,
				gridwidth,
				gridheight,
				weightx,
				weighty,
				anchor,
				GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0),
				ipadx,
				0
			);
	}
	
	public static GridBagConstraints setGBC(int gridx, int gridy, int anchor) {
		return setGBC(gridx, gridy, 1, 1, 1.0, 1.0, anchor, 0);
	}
	
	public static GridBagConstraints setGBC(int gridx, int gridy, int anchor, int ipadx) {
		return setGBC(gridx, gridy, 1, 1, 1.0, 1.0, anchor, ipadx);
	}
}
