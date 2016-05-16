import java.util.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;

public class Calculate extends JPanel implements ActionListener {
  private static JFrame frame = null;
  private JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15;
  private String expression = " ";
  private String calculation = "";
  private static JTextPane panel = new JTextPane();
  
  public Calculate() {
    super(new GridLayout(0, 4));

    button1 = new JButton("1");
    button2 = new JButton("2");
    button3 = new JButton("3");
    button4 = new JButton("4");
    button5 = new JButton("5");
    button6 = new JButton("6");
    button7 = new JButton("7");
    button8 = new JButton("8");
    button9 = new JButton("9");
    button10 = new JButton("+");
    button11 = new JButton("-");
    button12 = new JButton("*");
    button13 = new JButton("/");
    button14 = new JButton("=");
    button15 = new JButton(".");

    button1.addActionListener(this);
    button2.addActionListener(this);
    button3.addActionListener(this);
    button4.addActionListener(this);
    button5.addActionListener(this);
    button6.addActionListener(this);
    button7.addActionListener(this);
    button8.addActionListener(this);
    button9.addActionListener(this);
    button10.addActionListener(this);
    button11.addActionListener(this);
    button12.addActionListener(this);
    button13.addActionListener(this);
    button14.addActionListener(this);
    button15.addActionListener(this);

    this.add(button1);
    this.add(button2);
    this.add(button3);
    this.add(button4);
    this.add(button5);
    this.add(button6);
    this.add(button7);
    this.add(button8);
    this.add(button9);
    this.add(button10);
    this.add(button11);
    this.add(button12);
    this.add(button13);
    this.add(button14);
    this.add(button15);

    this.setPreferredSize(new Dimension(500, 200));
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == button1) {
        panel.replaceSelection("1");
        calculation += "1";
    }
    if(e.getSource() == button2) {
        panel.replaceSelection("2");
        calculation += "2";
    }
    if(e.getSource() == button3) {
        panel.replaceSelection("3");
        calculation += "3";
    }
    if(e.getSource() == button4) {
        panel.replaceSelection("4");
        calculation += "4";
    }
    if(e.getSource() == button5) {
        panel.replaceSelection("5");
        calculation += "5";
    }
    if(e.getSource() == button6) {
        panel.replaceSelection("6");
        calculation += "6";
    }
    if(e.getSource() == button7) {
        panel.replaceSelection("7");
        calculation += "7"; 
    }
    if(e.getSource() == button8) {
        panel.replaceSelection("8");
        calculation += "8";
    }
    if(e.getSource() == button9) {
        panel.replaceSelection("9");
        calculation += "9";
    }
    if(e.getSource() == button10) {
        panel.replaceSelection(" + ");
        calculation += " + ";
    }
    if(e.getSource() == button11) {
        panel.replaceSelection(" - ");
        calculation += " - ";
    }
    if(e.getSource() == button12) {
        panel.replaceSelection(" * ");
        calculation += " * ";
    }
    if(e.getSource() == button13) {
        panel.replaceSelection(" / ");
        calculation += " / ";
    }
    if(e.getSource() == button14) {
        calculation.trim();
        double answer = Calculator.calculate(calculation);
        panel.replaceSelection(expression + "= " + answer);
    }
    if(e.getSource() == button15) {
        panel.replaceSelection(".");
        calculation += ".";
    }
  }

  private static void createAndShowUI() {
    frame = new JFrame("Calculator");
    frame.add(new Calculate(), BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JFrame.setDefaultLookAndFeelDecorated(true);
    frame.pack();
    frame.setVisible(true);
    frame.add(panel, BorderLayout.NORTH);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowUI();
      }
    });
  }
}
