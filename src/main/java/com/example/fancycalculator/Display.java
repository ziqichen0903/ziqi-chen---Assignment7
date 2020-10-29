package com.example.fancycalculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Display implements ActionListener {

  private final JFrame frame;

  private final JPanel panel;
  private final JPanel panelSub1;
  private final JPanel panelSub2;
  private final JPanel panelSub3;
  private final JPanel panelSub4;
  private final JPanel panelSub5;
  private final JPanel panelSub6;
  private final JPanel panelSub7;
  private final JPanel panelSub8;

  private final JTextArea text;
  private final JButton[] but;
  private final JButton butAdd;
  private final JButton butMinus;
  private final JButton butMultiply;
  private final JButton butDivide;
  private final JButton butEqual;
  private final JButton butCancel;
  private final JButton butSquareRoot;
  private final JButton butSquare;
  private final JButton butOneDividedBy;
  private final JButton butCos;
  private final JButton butSin;
  private final JButton butTan;
  private final JButton butxpowerofy;
  private final JButton butlog;
  private final JButton butrate;
  private final JButton butabs;
  private final JButton butBinary;
  private final Controller calc;

  private final String[] buttonValue = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

  private final Font font;
  private final Font textFont;

  public Display() throws IOException {
    frame = new JFrame("Fancy Calculator");

    panel = new JPanel();

    panelSub1 = new JPanel(new FlowLayout());
    panelSub2 = new JPanel(new FlowLayout());
    panelSub3 = new JPanel(new FlowLayout());
    panelSub4 = new JPanel(new FlowLayout());
    panelSub5 = new JPanel(new FlowLayout());
    panelSub6 = new JPanel(new FlowLayout());
    panelSub7 = new JPanel(new FlowLayout());
    panelSub8 = new JPanel(new FlowLayout());

    font = new Font("Consolas", Font.PLAIN, 12);

    text = new JTextArea(1, 30);

    textFont = new Font("Consolas", Font.BOLD, 14);

    but = new JButton[10];
    for (int i = 0; i < 10; i++) {
      but[i] = new JButton(String.valueOf(i));
    }
    butAdd = new JButton("+");
    butMinus = new JButton("-");
    butMultiply = new JButton("*");
    butDivide = new JButton("/");
    butEqual = new JButton("=");
    butSquareRoot = new JButton("sqrt");
    butSquare = new JButton("x*x");
    butOneDividedBy = new JButton("1/x");
    butCos = new JButton("Cos");
    butSin = new JButton("Sin");
    butTan = new JButton("Tan");
    butxpowerofy = new JButton("x^y");
    butlog = new JButton("log10(x)");
    butrate = new JButton("x%");
    butabs = new JButton("abs(x)");
    butCancel = new JButton("C");
    butBinary = new JButton("Bin");

    calc = new Controller();
  }

  public void init() {
    frame.setSize(450, 450);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    text.setFont(textFont);
    text.setEditable(false);

    for (int i = 0; i < 10; i++) {
      but[i].setFont(font);
    }
    butAdd.setFont(font);
    butMinus.setFont(font);
    butMultiply.setFont(font);
    butDivide.setFont(font);
    butEqual.setFont(font);
    butSquareRoot.setFont(font);
    butSquare.setFont(font);
    butOneDividedBy.setFont(font);
    butCos.setFont(font);
    butSin.setFont(font);
    butTan.setFont(font);
    butxpowerofy.setFont(font);
    butlog.setFont(font);
    butrate.setFont(font);
    butabs.setFont(font);
    butCancel.setFont(font);
    butBinary.setFont(font);

    panel.add(Box.createHorizontalStrut(100));
    panelSub1.add(text);
    panel.add(panelSub1);

    panelSub2.add(but[1]);
    panelSub2.add(but[2]);
    panelSub2.add(but[3]);
    panelSub2.add(Box.createHorizontalStrut(15));
    panelSub2.add(butAdd);
    panelSub2.add(butMinus);
    panel.add(panelSub2);

    panelSub3.add(but[4]);
    panelSub3.add(but[5]);
    panelSub3.add(but[6]);
    panelSub3.add(Box.createHorizontalStrut(15));
    panelSub3.add(butMultiply);
    panelSub3.add(butDivide);
    panel.add(panelSub3);

    panelSub4.add(but[7]);
    panelSub4.add(but[8]);
    panelSub4.add(but[9]);
    panelSub4.add(Box.createHorizontalStrut(15));
    panelSub4.add(butEqual);
    panelSub4.add(butCancel);
    panel.add(panelSub4);

    panelSub5.add(Box.createHorizontalStrut(92));
    panelSub5.add(but[0]);
    panelSub5.add(Box.createHorizontalStrut(210));
    panel.add(panelSub5);

    panelSub6.add(butSquare);
    panelSub6.add(butSquareRoot);
    panelSub6.add(butOneDividedBy);
    panelSub6.add(butxpowerofy);
    panel.add(panelSub6);

    panelSub7.add(butCos);
    panelSub7.add(butSin);
    panelSub7.add(butTan);
    panel.add(panelSub7);

    panelSub8.add(butlog);
    panelSub8.add(butrate);
    panelSub8.add(butabs);
    panelSub8.add(butBinary);
    panel.add(panelSub8);

    for (int i = 0; i < 10; i++) {
      but[i].addActionListener(this);
    }
    butAdd.addActionListener(this);
    butMinus.addActionListener(this);
    butMultiply.addActionListener(this);
    butDivide.addActionListener(this);
    butSquare.addActionListener(this);
    butSquareRoot.addActionListener(this);
    butOneDividedBy.addActionListener(this);
    butCos.addActionListener(this);
    butSin.addActionListener(this);
    butTan.addActionListener(this);
    butxpowerofy.addActionListener(this);
    butlog.addActionListener(this);
    butrate.addActionListener(this);
    butabs.addActionListener(this);
    butBinary.addActionListener(this);

    butEqual.addActionListener(this);
    butCancel.addActionListener(this);

    frame.add(panel);
    frame.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    final Object source = e.getSource();

    for (int i = 0; i < 10; i++) {
      if (source == but[i]) {
        text.replaceSelection(buttonValue[i]);
        return;
      }
    }

    if (source == butAdd) {
      writeToDisplay(calc.calculateBi(Controller.BiOperatorModes.add, readFromDisplay()));
    }

    if (source == butMinus) {
      writeToDisplay(calc.calculateBi(Controller.BiOperatorModes.minus, readFromDisplay()));
    }

    if (source == butMultiply) {
      writeToDisplay(calc.calculateBi(Controller.BiOperatorModes.multiply, readFromDisplay()));
    }

    if (source == butDivide) {
      writeToDisplay(calc.calculateBi(Controller.BiOperatorModes.divide, readFromDisplay()));
    }
    if (source == butxpowerofy) {
      writeToDisplay(calc.calculateBi(Controller.BiOperatorModes.xpowerofy, readFromDisplay()));
    }

    if (source == butSquare) {
      writeToDisplay(calc.calculateMono(Controller.MonoOperatorModes.square, readFromDisplay()));
    }

    if (source == butSquareRoot) {
      writeToDisplay(
          calc.calculateMono(Controller.MonoOperatorModes.squareRoot, readFromDisplay()));
    }

    if (source == butOneDividedBy) {
      writeToDisplay(
          calc.calculateMono(Controller.MonoOperatorModes.oneDividedBy, readFromDisplay()));
    }

    if (source == butCos) {
      writeToDisplay(calc.calculateMono(Controller.MonoOperatorModes.cos, readFromDisplay()));
    }

    if (source == butSin) {
      writeToDisplay(calc.calculateMono(Controller.MonoOperatorModes.sin, readFromDisplay()));
    }

    if (source == butTan) {
      writeToDisplay(calc.calculateMono(Controller.MonoOperatorModes.tan, readFromDisplay()));
    }
    if (source == butlog) {
      writeToDisplay(calc.calculateMono(Controller.MonoOperatorModes.log, readFromDisplay()));
    }
    if (source == butrate) {
      writeToDisplay(calc.calculateMono(Controller.MonoOperatorModes.rate, readFromDisplay()));
    }
    if (source == butabs) {
      writeToDisplay(calc.calculateMono(Controller.MonoOperatorModes.abs, readFromDisplay()));
    }

    if (source == butEqual) {
      writeToDisplay(calc.calculateEqual(readFromDisplay()));
    }

    if (source == butCancel) {
      writeToDisplay(calc.reset());
    }

    if (source == butBinary) {
      parsetoBinary();
    }

    text.selectAll();
  }

  private void parsetoBinary() {
    try {
      text.setText("" + Long.toBinaryString(Long.parseLong(text.getText())));
    } catch (NumberFormatException ex) {
      System.err.println("Error while parse to binary." + ex.toString());
    }
  }

  public Double readFromDisplay() {
    return Double.valueOf(text.getText());
  }

  public void writeToDisplay(final Double num) {
    if (Double.isNaN(num)) {
      text.setText("");
    } else {
      text.setText(Double.toString(num));
    }
  }
}
