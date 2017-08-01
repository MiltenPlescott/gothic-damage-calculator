/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gothicdamagecalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
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
		lBorder = new LineBorder(Colors.RED, 5);	// thickness
		tBorder = new TitledBorder(lBorder, str, TitledBorder.LEFT, TitledBorder.TOP);
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
		JPanel pStr = new JPanel();
		JPanel pDex = new JPanel();
		JPanel p1HSkill = new JPanel();
		JPanel p2HSkill = new JPanel();
		
		pStr.setLayout(new BoxLayout(pStr, BoxLayout.X_AXIS));
		pDex.setLayout(new BoxLayout(pDex, BoxLayout.X_AXIS));
		p1HSkill.setLayout(new BoxLayout(p1HSkill, BoxLayout.X_AXIS));
		p2HSkill.setLayout(new BoxLayout(p2HSkill, BoxLayout.X_AXIS));
		
		
		
		JTextField jtfStr = jtfSet("Strength", frame.getBackground());
		JTextField jtfDex = jtfSet("Dexterity", frame.getBackground());
		JTextField jtf1HSkill = jtfSet("1H Skill", frame.getBackground());
		JTextField jtf2HSkill = jtfSet("2H Skill", frame.getBackground());
		
		JSpinner jsStrength = new JSpinner(new SpinnerNumberModel(10, 0, 5000, 1));
		JSpinner jsDexterity = new JSpinner(new SpinnerNumberModel(10, 0, 5000, 1));
		JSpinner js1HSkill = new JSpinner(new SpinnerNumberModel(10, 0, 100, 1));
		JSpinner js2HSkill = new JSpinner(new SpinnerNumberModel(10, 0, 100, 1));
		
		pStr.add(jtfStr);
		pStr.add(jsStrength);
		
		pDex.add(jtfDex);
		pDex.add(jsDexterity);
		
		p1HSkill.add(jtf1HSkill);
		p1HSkill.add(js1HSkill);
		
		p2HSkill.add(jtf2HSkill);
		p2HSkill.add(js2HSkill);
		
		
		
		
		pNameless.setLayout(new GridLayout(2, 2, 50, 50));
		pNameless.add(pStr);
		pNameless.add(p1HSkill);
		pNameless.add(pDex);
		pNameless.add(p2HSkill);
		
	}
	
	private void targetWidgets() {
		JPanel pHealth = new JPanel();
		JPanel pHits = new JPanel();
		JPanel pMelee = new JPanel();
		JPanel pRanged = new JPanel();
		
		pHealth.setLayout(new BoxLayout(pHealth, BoxLayout.X_AXIS));
		pHits.setLayout(new BoxLayout(pHits, BoxLayout.X_AXIS));
		pMelee.setLayout(new BoxLayout(pMelee, BoxLayout.X_AXIS));
		pRanged.setLayout(new BoxLayout(pRanged, BoxLayout.X_AXIS));
		
		
		// use panel instead of frame to get color ??? in case if frame color != panel color
		JTextField jtfHealth = jtfSet("Health", frame.getBackground());
		JTextField jtfHits = jtfSet("Number of hits", frame.getBackground());
		JTextField jtfMelee = jtfSet("Melee armor", frame.getBackground());
		JTextField jtfRanged = jtfSet("Ranged armor", frame.getBackground());
		
		JSpinner jsHealth = new JSpinner(new SpinnerNumberModel(1000, 1, 10000000, 1));
		JSpinner jsHits = new JSpinner(new SpinnerNumberModel(20, 1, 5000, 1));
		JSpinner jsMelee = new JSpinner(new SpinnerNumberModel(10, 0, 5000, 1));
		JSpinner jsRanged = new JSpinner(new SpinnerNumberModel(10, 0, 5000, 1));
		
		
		pHealth.add(jtfHealth);
		pHealth.add(jsHealth);
		
		pHits.add(jtfHits);
		pHits.add(jsHits);
		
		pMelee.add(jtfMelee);
		pMelee.add(jsMelee);
		
		pRanged.add(jtfRanged);
		pRanged.add(jsRanged);
		
		
		
		pTarget.setLayout(new GridLayout(2, 2, 50, 50));
		pTarget.add(pHealth);
		pTarget.add(pMelee);
		pTarget.add(pHits);
		pTarget.add(pRanged);
	}
	
	private void weaponWidgets() {
		
	}
	
	
	// gonna try GridBagLayout for this one
	private void resultWidgets() {
		
		//    number of normal hits		normal dmg
		//          number of crits		crit dmg
		// number of lightning hits		lightning dmg
		//            target status		total dmg
		//              rest button		run button
		
		// reset (to default values) is only a filler so the run button is not all alone down there
		
		// example:
		// number of normal hits 125
		// (it is all gonna be one JTextField, but the number could have different color/font size)
		
		JTextField jtfNoHitsLabel = jtfSet("Number of normal hits:", frame.getBackground());
		JTextField jtfNoHits = jtfSet("TBD", frame.getBackground());
		JTextField jtfNoCritsLabel = jtfSet("Number of critical hits:", frame.getBackground());
		JTextField jtfNoCrits = jtfSet("TBD", frame.getBackground());
		JTextField jtfNoLightningsLabel = jtfSet("Number of lightning hits:", frame.getBackground());
		JTextField jtfNoLightnings = jtfSet("TBD", frame.getBackground());
		
		JTextField jtfNormalDmgLabel = jtfSet("Normal damage:", frame.getBackground());
		JTextField jtfNormalDmg = jtfSet("TBD", frame.getBackground());
		JTextField jtfCritDmgLabel = jtfSet("Critical damage:", frame.getBackground());
		JTextField jtfCritDmg = jtfSet("TBD", frame.getBackground());
		JTextField jtfLightningDmgLabel = jtfSet("Lightning damage:", frame.getBackground());
		JTextField jtfLightningDmg = jtfSet("TBD", frame.getBackground());
		
		JTextField jtfStatusLabel = jtfSet("Health left:", frame.getBackground());
		JTextField jtfStatus = jtfSet("TBD", frame.getBackground());
		JTextField jtfTotalDmgLabel = jtfSet("Total damage:", frame.getBackground());
		JTextField jtfTotalDmg = jtfSet("TBD", frame.getBackground());
		
		JButton jbReset = new JButton("Reset");
		JButton jbRun = new JButton("Run");
		
		pResult.setLayout(new GridBagLayout());
		
		
		// display single normal hit and crit hit dmg ???? or the user can just use 1 number of total hits ???
		// but it would be necessary to use high crit chance  ... or I can find a place to fit in two more JTextFields ...
		
		
	}
	
	private JTextField jtfSet(String str, Color color) {
		JTextField jtf = new JTextField(str);
		jtf.setBackground(color);
		return jtf;
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
		pNameless.setBackground(Colors.BROWN);
		pWeapon.setBackground(Colors.RED);
		pTarget.setBackground(Colors.GREEN);
		pResult.setBackground(Colors.ORANGE);
	}
}
