/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gothicdamagecalculator;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPanel;

/**
 *
 * @author Milten Plescott
 */
public class Result {
	
	/*
	display single normal hit and crit hit dmg ???? or the user can just use 1 number of total hits ???
	but it would be necessary to use high crit chance  ... or I can find a place to fit in two more JTextFields ...

	jbRun.addActionListener(new );
	*/
	
	public JLabel jlNoNormalsLabel;
	public JLabel jlNoNormals;
	public JLabel jlNormalDmgLabel;
	public JLabel jlNormalDmg;
	
	public JLabel jlNoCritsLabel;
	public JLabel jlNoCrits;
	public JLabel jlCritDmgLabel;
	public JLabel jlCritDmg;
	
	public JLabel jlNoLightningsLabel;
	public JLabel jlNoLightnings;
	public JLabel jlLightningDmgLabel;
	public JLabel jlLightningDmg;
	
	public JLabel jlStatusLabel;
	public JLabel jlStatus;
	public JLabel jlTotalDmgLabel;
	public JLabel jlTotalDmg;
	
	public JButton jbReset;
	public JButton jbRun;
	
	public Result(JPanel pResult) {
		pResult.setLayout(new GridBagLayout());
		createJLabels();
		createJButtons();
		addComponentsToPanel(pResult);
	}
	
	private void createJLabels() {
		jlNoNormalsLabel = new JLabel("Number of normal hits:");
		jlNoNormals = new JLabel("TBD");
		jlNormalDmgLabel = new JLabel("Normal damage:");
		jlNormalDmg = new JLabel("TBD");
		
		jlNoCritsLabel = new JLabel("Number of critical hits:");
		jlNoCrits = new JLabel("TBD");
		jlCritDmgLabel = new JLabel("Critical damage:");
		jlCritDmg = new JLabel("TBD");
		
		jlNoLightningsLabel = new JLabel("Number of lightning hits:");
		jlNoLightnings = new JLabel("TBD");
		jlLightningDmgLabel = new JLabel("Lightning damage:");
		jlLightningDmg = new JLabel("TBD");
		
		jlStatusLabel = new JLabel("Health left:");
		jlStatus = new JLabel("TBD");
		jlTotalDmgLabel = new JLabel("Total damage:");
		jlTotalDmg = new JLabel("TBD");
	}
	
	private void createJButtons() {
		jbReset = new JButton("Reset");
		jbRun = new JButton("Run");
	}
	

	// use west and padding ????
	// temporarily used CENTER to get rid of the error, but need further investigation (after getting rid of TBD)
	private void addComponentsToPanel(JPanel pResult) {
		pResult.add(jlNoNormalsLabel,    GridBag.setGBC(0, 0, GridBagConstraints.EAST));
		pResult.add(jlNoNormals,         GridBag.setGBC(1, 0, GridBagConstraints.CENTER));
		pResult.add(jlNormalDmgLabel,    GridBag.setGBC(2, 0, GridBagConstraints.EAST));
		pResult.add(jlNormalDmg,         GridBag.setGBC(3, 0, GridBagConstraints.CENTER));
		
		pResult.add(jlNoCritsLabel,      GridBag.setGBC(0, 1, GridBagConstraints.EAST));
		pResult.add(jlNoCrits,           GridBag.setGBC(1, 1, GridBagConstraints.CENTER));
		pResult.add(jlCritDmgLabel,      GridBag.setGBC(2, 1, GridBagConstraints.EAST));
		pResult.add(jlCritDmg,           GridBag.setGBC(3, 1, GridBagConstraints.CENTER));
		
		pResult.add(jlNoLightningsLabel, GridBag.setGBC(0, 2, GridBagConstraints.EAST));
		pResult.add(jlNoLightnings,      GridBag.setGBC(1, 2, GridBagConstraints.CENTER));
		pResult.add(jlLightningDmgLabel, GridBag.setGBC(2, 2, GridBagConstraints.EAST));
		pResult.add(jlLightningDmg,      GridBag.setGBC(3, 2, GridBagConstraints.CENTER));
		
		pResult.add(jlStatusLabel,       GridBag.setGBC(0, 3, GridBagConstraints.EAST));
		pResult.add(jlStatus,            GridBag.setGBC(1, 3, GridBagConstraints.CENTER));
		pResult.add(jlTotalDmgLabel,     GridBag.setGBC(2, 3, GridBagConstraints.EAST));
		pResult.add(jlTotalDmg,          GridBag.setGBC(3, 3, GridBagConstraints.CENTER));
		
		pResult.add(jbReset,             GridBag.setGBC(1, 4, GridBagConstraints.WEST));
		pResult.add(jbRun,               GridBag.setGBC(3, 4, GridBagConstraints.WEST));
	}
}
