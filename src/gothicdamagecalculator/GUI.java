/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gothicdamagecalculator;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;

import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;



/**
 *
 * @author Milten Plescott
 */
public class GUI extends ComponentAdapter {
	public MyFrame frame;
	
	// do I really need these ??? appart from frame
	
	public NamelessHero namelessHero;
	public Weapon weapon;
	public Target target;
	public Result result;
	
	public Menu menu;
	
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
	
	public GUI(MyFrame frame) {
		this.frame = frame;

		frame.setLayout(new BorderLayout(0, 20));	// hgap, vgap
		
		rbG1 = new JRadioButton("Gothic 1", false);	// false - initially unselected
		rbG2 = new JRadioButton("Gothic 2", true);	// true - initially selected
		
		rbG1.setFocusPainted(false);
		rbG2.setFocusPainted(false);
		
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
		
		
		namelessHero = new NamelessHero(pNameless);
		weapon = new Weapon(pWeapon, frame);
		target = new Target(pTarget);
		result = new Result(pResult, frame);
		
		menu = new Menu(frame);
		
		//frame.addComponentListener(menu);
		
		
		/*
		COLOR CODING
		*/
		//colorCoding();
	}
	
	private void border(JPanel jp, String str) {
		lBorder = new LineBorder(Colors.BLUISH, 5);	// thickness
		tBorder = new TitledBorder(lBorder, str, TitledBorder.CENTER, TitledBorder.TOP);
		tBorder.setTitleColor(Colors.BLACK);
		
		tBorder.setTitleFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		//jp.setBorder(tBorder);
		
		jp.setBorder(new CompoundBorder(tBorder, new EmptyBorder(20, 20, 20, 20)));	// change dynamically
	}
	
	/*
	in the listener that will handle getting the value from spinner:
	try----js1HSkill.commitEdit();
	error---- red color all over the place
	*/
	
	/*
	ALIGNMENT of number insdie JSpinner -- probably not gonna use it since the arrows of spinner are on the right
	and far away from the number (it would not look any better so there is no point in doing extra work)
	
	// MIGHT BE USEFUL IN THE FUTURE:
	JComponent jc = jsMelee.getEditor();
	JSpinner.DefaultEditor foo = (JSpinner.DefaultEditor)jc;
	foo.getTextField().setHorizontalAlignment(JTextField.LEFT);
	*/
	

	// reset (to default values) is only a filler so the run button is not all alone down there

	// example:
	// number of normal hits 125
	// (it is all gonna be one JTextField, but the number could have different color/font size)





	// display single normal hit and crit hit dmg ???? or the user can just run app using calculation only for 1 hit ???
	// but it would be necessary to use high crit chance  ... or I can find a place to fit in two more JTextFields ...



	//jbRun.addActionListener(new );

	private void colorCoding() {
		frame.setBackground(Colors.GREY);
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
