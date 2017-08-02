/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gothicdamagecalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Milten Plescott
 */
public class GothicDamageCalculator {
	MyJFrame frame;
	
	ButtonGroup rbGroup;
	
	JRadioButton rbG1;
	JRadioButton rbG2;
	
	LineBorder lBorder;
	TitledBorder tBorder;
	
	JPanel pGrid;
	JPanel pRadioButton;
	JPanel pNameless;
	JPanel pWeapon;
	JPanel pTarget;
	JPanel pResult;
	
	GothicDamageCalculator() {
		frame = new MyJFrame("Gothic Damage Calculator");
		frame.addWindowListener(new CloseWindow());
		frame.setLayout(new BorderLayout(0, 20));	// hgap, vgap
		
		rbG1 = new JRadioButton("Gothic 1", false);	// false - initially unselected
		rbG2 = new JRadioButton("Gothic 2", true);	// true - initially selected
		
		pRadioButton = new JPanel();
		pRadioButton.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));	// align, hgap, vgap
		frame.add(pRadioButton, BorderLayout.NORTH);
		
		pRadioButton.add(rbG1);
		pRadioButton.add(rbG2);
		
		rbGroup = new ButtonGroup();
		rbGroup.add(rbG1);
		rbGroup.add(rbG2);
		
		pGrid = new JPanel();
		frame.add(pGrid, BorderLayout.CENTER);
		
		
		pNameless = new JPanel();
		pWeapon = new JPanel();
		pTarget = new JPanel();
		pResult = new JPanel();
		
		pGrid.setLayout(new GridLayout(2, 2, 20, 20));	// rows, cols, hgap, vgap
								// row, col
		pGrid.add(pNameless);	//   0, 0
		pGrid.add(pTarget);		//   0, 1
		pGrid.add(pWeapon);		//   1, 0
		pGrid.add(pResult);		//   1, 1
		
		
		
		border(pNameless, "Nameless Hero");
		border(pTarget, "Target");
		border(pWeapon, "Weapon");
		border(pResult, "Result");
		
		
		
		
		
		
		
		namelessWidgets();
		targetWidgets();
		weaponWidgets();
		resultWidgets();
		
		/*
		COLOR CODING
		*/
		colorCoding();
	}
	
	private void border(JPanel jp, String str) {
		lBorder = new LineBorder(Colors.BLUE, 5);	// thickness
		tBorder = new TitledBorder(lBorder, str, TitledBorder.LEFT, TitledBorder.TOP);
		tBorder.setTitleColor(Colors.WHITE);
		//jp.setBorder(tBorder);
		
		
		jp.setBorder(new CompoundBorder(tBorder, new EmptyBorder(20, 20, 20, 20)));	// change dynamically
	}
	
	private void namelessWidgets() {
		/*
		in the listener that will handle getting the value from spinner:
		try----js1HSkill.commitEdit();
		error---- red color all over the place
		*/
		
		// FlowLayout - does not look very good
		/*
		JPanel pStr = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));	// align, hgap, vgap
		JPanel pDex = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		JPanel p1HSkill = new JPanel(new FlowLayout(FlowLayout.TRAILING, 10, 10));
		JPanel p2HSkill = new JPanel(new FlowLayout(FlowLayout.TRAILING, 10, 10));
		*/
		
		
		// BorderLayout - still kinda bad
		/*
		JPanel pStr = new JPanel(new BorderLayout(10, 10));
		JPanel pDex = new JPanel(new BorderLayout(10, 10));
		JPanel p1HSkill = new JPanel(new BorderLayout(10, 10));
		JPanel p2HSkill = new JPanel(new BorderLayout(10, 10));
		*/
		
		// BoxLayout - 
		/*
		JPanel pStr = new JPanel();
		JPanel pDex = new JPanel();
		JPanel p1HSkill = new JPanel();
		JPanel p2HSkill = new JPanel();
		
		pStr.setLayout(new BoxLayout(pStr, BoxLayout.X_AXIS));
		pDex.setLayout(new BoxLayout(pDex, BoxLayout.X_AXIS));
		p1HSkill.setLayout(new BoxLayout(p1HSkill, BoxLayout.X_AXIS));
		p2HSkill.setLayout(new BoxLayout(p2HSkill, BoxLayout.X_AXIS));
		
		JLabel jlStr = setJL("Strength");
		JLabel jlDex = setJL("Dexterity");
		JLabel jl1HSkill = setJL("1H Skill");
		JLabel jl2HSkill = setJL("2H Skill");
		
		JSpinner jsStrength = new JSpinner(new SpinnerNumberModel(10, 0, 5000, 1));
		JSpinner jsDexterity = new JSpinner(new SpinnerNumberModel(10, 0, 5000, 1));
		JSpinner js1HSkill = new JSpinner(new SpinnerNumberModel(10, 0, 100, 1));
		JSpinner js2HSkill = new JSpinner(new SpinnerNumberModel(10, 0, 100, 1));
		
		pStr.add(jlStr);
		pStr.add(jsStrength);
		
		pDex.add(jlDex);
		pDex.add(jsDexterity);
		
		p1HSkill.add(jl1HSkill);
		p1HSkill.add(js1HSkill);
		
		p2HSkill.add(jl2HSkill);
		p2HSkill.add(js2HSkill);
		
		pNameless.setLayout(new GridLayout(2, 2, 50, 50));
		pNameless.add(pStr);
		pNameless.add(p1HSkill);
		pNameless.add(pDex);
		pNameless.add(p2HSkill);
		*/
		
		pNameless.setLayout(new GridBagLayout());
		
		JLabel jlStr = setJL("Strength");
		JLabel jlDex = setJL("Dexterity");
		JLabel jl1HSkill = setJL("1H Skill");
		JLabel jl2HSkill = setJL("2H Skill");
		
		JSpinner jsStrength = new JSpinner(new SpinnerNumberModel(10, 0, 5000, 1));
		JSpinner jsDexterity = new JSpinner(new SpinnerNumberModel(10, 0, 5000, 1));
		JSpinner js1HSkill = new JSpinner(new SpinnerNumberModel(10, 0, 100, 1));
		JSpinner js2HSkill = new JSpinner(new SpinnerNumberModel(10, 0, 100, 1));
		
		pNameless.add(jlStr,       setGBC(0, 0, GridBagConstraints.EAST, 10));
		pNameless.add(jsStrength,  setGBC(1, 0, GridBagConstraints.WEST));
		pNameless.add(jl1HSkill,   setGBC(2, 0, GridBagConstraints.EAST, 10));
		pNameless.add(js1HSkill,   setGBC(3, 0, GridBagConstraints.WEST));
		
		pNameless.add(jlDex,       setGBC(0, 1, GridBagConstraints.EAST, 10));
		pNameless.add(jsDexterity, setGBC(1, 1, GridBagConstraints.WEST));
		pNameless.add(jl2HSkill,   setGBC(2, 1, GridBagConstraints.EAST, 10));
		pNameless.add(js2HSkill,   setGBC(3, 1, GridBagConstraints.WEST));
		
	}
	
	private void targetWidgets() {
		/*
		JPanel pHealth = new JPanel();
		JPanel pHits = new JPanel();
		JPanel pMelee = new JPanel();
		JPanel pRanged = new JPanel();
		
		pHealth.setLayout(new BoxLayout(pHealth, BoxLayout.X_AXIS));
		pHits.setLayout(new BoxLayout(pHits, BoxLayout.X_AXIS));
		pMelee.setLayout(new BoxLayout(pMelee, BoxLayout.X_AXIS));
		pRanged.setLayout(new BoxLayout(pRanged, BoxLayout.X_AXIS));
		
		
		// use panel instead of frame to get color ??? in case if frame color != panel color
		JLabel jlHealth = setJL("Health");
		JLabel jlHits = setJL("Number of hits");
		JLabel jlMelee = setJL("Melee armor");
		JLabel jlRanged = setJL("Ranged armor");
		
		JSpinner jsHealth = new JSpinner(new SpinnerNumberModel(1000, 1, 10000000, 1));
		JSpinner jsHits = new JSpinner(new SpinnerNumberModel(20, 1, 5000, 1));
		JSpinner jsMelee = new JSpinner(new SpinnerNumberModel(10, 0, 5000, 1));
		JSpinner jsRanged = new JSpinner(new SpinnerNumberModel(10, 0, 5000, 1));
		
		
		pHealth.add(jlHealth);
		pHealth.add(jsHealth);
		
		pHits.add(jlHits);
		pHits.add(jsHits);
		
		pMelee.add(jlMelee);
		pMelee.add(jsMelee);
		
		pRanged.add(jlRanged);
		pRanged.add(jsRanged);
		
		
		
		pTarget.setLayout(new GridLayout(2, 2, 50, 50));
		pTarget.add(pHealth);
		pTarget.add(pMelee);
		pTarget.add(pHits);
		pTarget.add(pRanged);
		*/
		
		// TEST USING GridBagLayout instead of BoxLayout
		pTarget.setLayout(new GridBagLayout());
		
		JLabel jlHealth = setJL("Health:");
		JLabel jlHits = setJL("Number of hits:");
		JLabel jlMelee = setJL("Melee armor:");
		JLabel jlRanged = setJL("Ranged armor:");
		
		JSpinner jsHealth = new JSpinner(new SpinnerNumberModel(1000, 1, 1000000, 1));
		JSpinner jsHits = new JSpinner(new SpinnerNumberModel(20, 1, 5000, 1));
		JSpinner jsMelee = new JSpinner(new SpinnerNumberModel(10, 0, 5000, 1));
		JSpinner jsRanged = new JSpinner(new SpinnerNumberModel(10, 0, 5000, 1));
		
		/*
		ALIGNMENT of number insdie JSpinner -- probably not gonna use it since the arrows of spinner are on the right
		and far away from the number (it would not look any better so there is no point in doing extra work)
		
		JComponent jc = jsMelee.getEditor();
		JSpinner.DefaultEditor foo = (JSpinner.DefaultEditor)jc;
		foo.getTextField().setHorizontalAlignment(JTextField.LEFT);
		*/
		
		pTarget.add(jlHealth, setGBC(0, 0, GridBagConstraints.EAST, 10));
		pTarget.add(jsHealth, setGBC(1, 0, GridBagConstraints.WEST));
		pTarget.add(jlHits,   setGBC(2, 0, GridBagConstraints.EAST, 10));
		pTarget.add(jsHits,   setGBC(3, 0, GridBagConstraints.WEST));
		
		pTarget.add(jlMelee,  setGBC(0, 1, GridBagConstraints.EAST, 10));
		pTarget.add(jsMelee,  setGBC(1, 1, GridBagConstraints.WEST));
		pTarget.add(jlRanged, setGBC(2, 1, GridBagConstraints.EAST, 10));
		pTarget.add(jsRanged, setGBC(3, 1, GridBagConstraints.WEST));
		
		
	}
	
	private void weaponWidgets() {
		
	}
	
	
	// gonna try GridBagLayout for this one
	private void resultWidgets() {
		
		// method default to reset the TBD jtfs, and method update to update them after pressing run button
		
		
		
		
		//    number of normal hits		normal dmg
		//          number of crits		crit dmg
		// number of lightning hits		lightning dmg
		//            target status		total dmg
		//              rest button		run button
		
		// reset (to default values) is only a filler so the run button is not all alone down there
		
		// example:
		// number of normal hits 125
		// (it is all gonna be one JTextField, but the number could have different color/font size)
		
		/*
		JTextField jtfNoNormalsLabel = setJTF("Number of normal hits:", frame.getBackground());
		JTextField jtfNoNormals = setJTF("TBD", frame.getBackground());
		JTextField jtfNormalDmgLabel = setJTF("Normal damage:", frame.getBackground());
		JTextField jtfNormalDmg = setJTF("TBD", frame.getBackground());
		
		JTextField jtfNoCritsLabel = setJTF("Number of critical hits:", frame.getBackground());
		JTextField jtfNoCrits = setJTF("TBD", frame.getBackground());
		JTextField jtfCritDmgLabel = setJTF("Critical damage:", frame.getBackground());
		JTextField jtfCritDmg = setJTF("TBD", frame.getBackground());
		
		JTextField jtfNoLightningsLabel = setJTF("Number of lightning hits:", frame.getBackground());
		JTextField jtfNoLightnings = setJTF("TBD", frame.getBackground());
		JTextField jtfLightningDmgLabel = setJTF("Lightning damage:", frame.getBackground());
		JTextField jtfLightningDmg = setJTF("TBD", frame.getBackground());
		
		JTextField jtfStatusLabel = setJTF("Health left:", frame.getBackground());
		JTextField jtfStatus = setJTF("TBD", frame.getBackground());
		JTextField jtfTotalDmgLabel = setJTF("Total damage:", frame.getBackground());
		JTextField jtfTotalDmg = setJTF("TBD", frame.getBackground());
		
		JButton jbReset = new JButton("Reset");
		JButton jbRun = new JButton("Run");
		
		pResult.setLayout(new GridBagLayout());
		
		
		pResult.add(jtfNoNormalsLabel,    setGBC(0, 0, GridBagConstraints.EAST));
		pResult.add(jtfNoNormals,         setGBC(1, 0));
		pResult.add(jtfNormalDmgLabel,    setGBC(2, 0, GridBagConstraints.EAST));
		pResult.add(jtfNormalDmg,         setGBC(3, 0));
		
		pResult.add(jtfNoCritsLabel,      setGBC(0, 1, GridBagConstraints.EAST));
		pResult.add(jtfNoCrits,           setGBC(1, 1));
		pResult.add(jtfCritDmgLabel,      setGBC(2, 1, GridBagConstraints.EAST));
		pResult.add(jtfCritDmg,           setGBC(3, 1));
		
		pResult.add(jtfNoLightningsLabel, setGBC(0, 2, GridBagConstraints.EAST));
		pResult.add(jtfNoLightnings,      setGBC(1, 2));
		pResult.add(jtfLightningDmgLabel, setGBC(2, 2, GridBagConstraints.EAST));
		pResult.add(jtfLightningDmg,      setGBC(3, 2));
		
		pResult.add(jtfStatusLabel,       setGBC(0, 3, GridBagConstraints.EAST));
		pResult.add(jtfStatus,            setGBC(1, 3));
		pResult.add(jtfTotalDmgLabel,     setGBC(2, 3, GridBagConstraints.EAST));
		pResult.add(jtfTotalDmg,          setGBC(3, 3));
		
		pResult.add(jbReset,              setGBC(1, 4, GridBagConstraints.WEST));
		pResult.add(jbRun,                setGBC(3, 4, GridBagConstraints.WEST));
		*/
		
		/*
		TEST USING JLabel instead of JTextField -- seems to work (gonna keep the JTextField version commented - JIC)
		*/
		
		
		JLabel jlNoNormalsLabel = setJL("Number of normal hits:");
		JLabel jlNoNormals = setJL("TBD");
		JLabel jlNormalDmgLabel = setJL("Normal damage:");
		JLabel jlNormalDmg = setJL("TBD");
		
		JLabel jlNoCritsLabel = setJL("Number of critical hits:");
		JLabel jlNoCrits = setJL("TBD");
		JLabel jlCritDmgLabel = setJL("Critical damage:");
		JLabel jlCritDmg = setJL("TBD");
		
		JLabel jlNoLightningsLabel = setJL("Number of lightning hits:");
		JLabel jlNoLightnings = setJL("TBD");
		JLabel jlLightningDmgLabel = setJL("Lightning damage:");
		JLabel jlLightningDmg = setJL("TBD");
		
		JLabel jlStatusLabel = setJL("Health left:");
		JLabel jlStatus = setJL("TBD");
		JLabel jlTotalDmgLabel = setJL("Total damage:");
		JLabel jlTotalDmg = setJL("TBD");
		
		JButton jbReset = new JButton("Reset");
		JButton jbRun = new JButton("Run");
		
		pResult.setLayout(new GridBagLayout());
		
		
		pResult.add(jlNoNormalsLabel,    setGBC(0, 0, GridBagConstraints.EAST));
		pResult.add(jlNoNormals,         setGBC(1, 0));
		pResult.add(jlNormalDmgLabel,    setGBC(2, 0, GridBagConstraints.EAST));
		pResult.add(jlNormalDmg,         setGBC(3, 0));
		
		pResult.add(jlNoCritsLabel,      setGBC(0, 1, GridBagConstraints.EAST));
		pResult.add(jlNoCrits,           setGBC(1, 1));
		pResult.add(jlCritDmgLabel,      setGBC(2, 1, GridBagConstraints.EAST));
		pResult.add(jlCritDmg,           setGBC(3, 1));
		
		pResult.add(jlNoLightningsLabel, setGBC(0, 2, GridBagConstraints.EAST));
		pResult.add(jlNoLightnings,      setGBC(1, 2));
		pResult.add(jlLightningDmgLabel, setGBC(2, 2, GridBagConstraints.EAST));
		pResult.add(jlLightningDmg,      setGBC(3, 2));
		
		pResult.add(jlStatusLabel,       setGBC(0, 3, GridBagConstraints.EAST));
		pResult.add(jlStatus,            setGBC(1, 3));
		pResult.add(jlTotalDmgLabel,     setGBC(2, 3, GridBagConstraints.EAST));
		pResult.add(jlTotalDmg,          setGBC(3, 3));
		
		pResult.add(jbReset,             setGBC(1, 4, GridBagConstraints.WEST));
		pResult.add(jbRun,               setGBC(3, 4, GridBagConstraints.WEST));
		
		
		
		
		// display single normal hit and crit hit dmg ???? or the user can just use 1 number of total hits ???
		// but it would be necessary to use high crit chance  ... or I can find a place to fit in two more JTextFields ...
		
		
	}
	
	private JLabel setJL(String str) {
		return new JLabel(str);
	}
	
	private JTextField setJTF(String str, Color color) {
		JTextField jtf = new JTextField(str);
		jtf.setBackground(color);
		jtf.setEditable(false);		// so far I do not want the user to be able to edit ANY JTextField
		return jtf;
	}
	
	private GridBagConstraints setGBC(int gridx, int gridy) {
		return setGBC(gridx, gridy, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, 0);
	}
	
	private GridBagConstraints setGBC(int gridx, int gridy, int anchor) {
		return setGBC(gridx, gridy, 1, 1, 1.0, 1.0, anchor, 0);
	}
	
	private GridBagConstraints setGBC(int gridx, int gridy, int anchor, int ipadx) {
		return setGBC(gridx, gridy, 1, 1, 1.0, 1.0, anchor, ipadx);
	}
	
	private GridBagConstraints setGBC(int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty) {
		return setGBC(gridx, gridy, gridwidth, gridheight, weightx, weighty, GridBagConstraints.CENTER, 0);
	}
	
	private GridBagConstraints setGBC(int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty, int anchor, int ipadx) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.gridwidth = gridwidth;
		gbc.gridheight = gridheight;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbc.anchor = anchor;
		gbc.ipadx = ipadx;
		return gbc;
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		GothicDamageCalculator gdc = new GothicDamageCalculator();
	}
	
	
	private void colorCoding() {
		frame.setBackground(Colors.GRAY);
		rbG1.setBackground(Colors.CYAN);
		rbG2.setBackground(Colors.YELLOW);
		pGrid.setBackground(Colors.PINK);
		pRadioButton.setBackground(Colors.BLUE);
		pNameless.setBackground(Colors.PURPLE);
		pWeapon.setBackground(Colors.RED);
		pTarget.setBackground(Colors.GREEN);
		pResult.setBackground(Colors.ORANGE);
	}
}
