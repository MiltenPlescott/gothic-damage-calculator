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
	
	public Result(JPanel pResult, MyFrame frame) {
		pResult.setLayout(new GridBagLayout());
		createJLabels();
		createJButtons(frame);
		addComponentsToPanel(pResult);
	}
	
	private void createJLabels() {
		jlNoNormalsLabel = new JLabel("Number of normal hits:");
		jlNoNormals = new JLabel("");
		jlNormalDmgLabel = new JLabel("Normal damage:");
		jlNormalDmg = new JLabel("");
		
		jlNoCritsLabel = new JLabel("Number of critical hits:");
		jlNoCrits = new JLabel("");
		jlCritDmgLabel = new JLabel("Critical damage:");
		jlCritDmg = new JLabel("");
		
		jlNoLightningsLabel = new JLabel("Number of lightning hits:");
		jlNoLightnings = new JLabel("");
		jlLightningDmgLabel = new JLabel("Lightning damage:");
		jlLightningDmg = new JLabel("");
		
		jlStatusLabel = new JLabel("Health left:");
		jlStatus = new JLabel("");
		jlTotalDmgLabel = new JLabel("Total damage:");
		jlTotalDmg = new JLabel("");
	}
	
	private void createJButtons(MyFrame frame) {
		jbReset = new JButton("Reset");
		jbReset.setFocusable(false);
		jbReset.addActionListener(new ResetButton(frame));
		jbRun = new JButton("Run");
		jbRun.setFocusable(false);
		jbRun.addActionListener(new Calculator(frame));
	}
	
	private void addComponentsToPanel(JPanel pResult) {
		pResult.add(jlNoNormalsLabel,    GridBag.setGBC(0, 0, GridBagConstraints.EAST));
		pResult.add(jlNoNormals,         GridBag.setGBC(1, 0, GridBagConstraints.EAST));
		pResult.add(jlNormalDmgLabel,    GridBag.setGBC(2, 0, GridBagConstraints.EAST));
		pResult.add(jlNormalDmg,         GridBag.setGBC(3, 0, GridBagConstraints.EAST));
		
		pResult.add(jlNoCritsLabel,      GridBag.setGBC(0, 1, GridBagConstraints.EAST));
		pResult.add(jlNoCrits,           GridBag.setGBC(1, 1, GridBagConstraints.EAST));
		pResult.add(jlCritDmgLabel,      GridBag.setGBC(2, 1, GridBagConstraints.EAST));
		pResult.add(jlCritDmg,           GridBag.setGBC(3, 1, GridBagConstraints.EAST));
		
		pResult.add(jlNoLightningsLabel, GridBag.setGBC(0, 2, GridBagConstraints.EAST));
		pResult.add(jlNoLightnings,      GridBag.setGBC(1, 2, GridBagConstraints.EAST));
		pResult.add(jlLightningDmgLabel, GridBag.setGBC(2, 2, GridBagConstraints.EAST));
		pResult.add(jlLightningDmg,      GridBag.setGBC(3, 2, GridBagConstraints.EAST));
		
		pResult.add(jlStatusLabel,       GridBag.setGBC(0, 3, GridBagConstraints.EAST));
		pResult.add(jlStatus,            GridBag.setGBC(1, 3, GridBagConstraints.EAST));
		pResult.add(jlTotalDmgLabel,     GridBag.setGBC(2, 3, GridBagConstraints.EAST));
		pResult.add(jlTotalDmg,          GridBag.setGBC(3, 3, GridBagConstraints.EAST));
		
		pResult.add(jbReset,             GridBag.setGBC(1, 4, GridBagConstraints.CENTER));
		pResult.add(jbRun,               GridBag.setGBC(3, 4, GridBagConstraints.CENTER));
	}
}
