import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import Calculator.EnterListener;
import Calculator.OpListener;

import java.util.*;
import java.text.*;

public class CreatureGame extends JFrame {
	private JButton btnPlus, btnMinus, btnMult, btnDiv, btnEnter;
	private JTextField txtNumber;
	private JLabel lblInstructions;
	private JPanel pnlButtons, pnlTextEnter;
	
	public CreatureGame(String title) {
		super(title);
		
		lblInstructions = new JLabel("Use Reverse Polish Noatation");
		pnlTextEnter = new JPanel( new GridLayout(1, 2, 10, 10));
		pnlButtons = new JPanel( new GridLayout(2, 2, 20, 20));
		
		setLayout (new BorderLayout(20, 10));
		add(pnlTextEnter, BorderLayout.NORTH );
		add(pnlButtons, BorderLayout.CENTER);
		add(lblInstructions, BorderLayout.SOUTH);
		
		btnEnter = new JButton("Enter");
		txtNumber = new JTextField("0.0", 15);

	    pnlTextEnter.add(txtNumber);
	    pnlTextEnter.add(btnEnter);
	    
	    btnPlus = new JButton("Attack");
	    btnMinus = new JButton("Defend");
	    btnMult = new JButton("*");
	    btnDiv = new JButton("/");
	    
	    pnlButtons.add(btnPlus);
	    pnlButtons.add(btnMinus);
	    pnlButtons.add(btnMult);
	    pnlButtons.add(btnDiv);
	    
	    pnlTextEnter.setBorder(new TitledBorder("Entry and Result"));
	    pnlButtons.setBorder(new TitledBorder("Operator Buttons"));
	    
	    ActionListener enterListener = new EnterListener();
	    btnEnter.addActionListener( enterListener );
	    txtNumber.addActionListener( enterListener );
	    
	    ActionListener opListener = new OpListener();
	    btnPlus.addActionListener( opListener );
	    btnMinus.addActionListener( opListener );
	    btnMult.addActionListener( opListener );
	    btnDiv.addActionListener( opListener );
	}
	
	class EnterListener implements ActionListener {
	     // event handler for JButton or Enter Key
	     public void actionPerformed(ActionEvent e) {
	     double dblA = 0;
	     String strA;

	     // read value from text fields into local variables
	     strA = txtNumber.getText();
	     txtNumber.setText("");  // clear
	     txtNumber.requestFocus();

	     // try to convert from String to double, return if fail
	     try {
	        dblA = Double.parseDouble(strA);
	     }
	     catch (NumberFormatException error) {
	        return;
	     }
	   
	     if ( !stk.push(dblA) )
	        txtNumber.setText( "Stack Overflow");
	  }
	}
	
	class OpListener implements ActionListener
	{
	   // event handler for JButton or Enter Key
	   public void actionPerformed(ActionEvent e)
	   {
	      String strResult;
	      Double dbl1, dbl2, dblResult;

	      // pop two items
	      if (!stk.testStack(2))
	         return;
	      dbl2 = stk.pop();
	      dbl1 = stk.pop();

	      // do the math
	      if (e.getSource() == btnPlus)  // add "if"  for other ops
	    	  dblResult = dbl1 + dbl2;

	      // convert from double to  String
	      NumberFormat tidy = NumberFormat.getInstance(Locale.US);
	      tidy.setMaximumFractionDigits(10);
	      strResult = tidy.format(dblResult);


	      // write result back to TextA and push
	      txtNumber.setText(strResult);
	      stk.push(dblResult);
	   }
	}
}
