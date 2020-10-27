package com.example.fancycalculator;

public class FancyCalculator {
  public static void main(String[] args) {
    try {
      Display display = new Display();
      display.init();
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }
}
