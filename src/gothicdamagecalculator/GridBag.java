/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gothicdamagecalculator;

import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 *
 * @author Milten Plescott
 */
public class GridBag {
	
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
		return setGBC(gridx, gridy, 1, 1, 0.0, 0.0, anchor, 0);
	}
	
	public static GridBagConstraints setGBC(int gridx, int gridy, int anchor, int ipadx) {
		return setGBC(gridx, gridy, 1, 1, 0.0, 0.0, anchor, ipadx);
	}
}
