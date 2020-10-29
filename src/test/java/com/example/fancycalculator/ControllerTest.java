package com.example.fancycalculator;

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ControllerTest {
  import static org.mockito.Mockito.*;  // At top of file
  // In test method:
  Random random = mock(Random.class);
  when(random.nextDouble()).thenReturn(0.1);


  @Test
  void calculateBiNormalTest() {
    Controller calculator = new Controller();
    calculator.calculateBi(Controller.BiOperatorModes.normal, 2.0);
    assertEquals(NaN, calculator.calculateBi(Controller.BiOperatorModes.normal, 3.0));
  }

  @Test
  void calculateBiAddTest() {
    Controller calculator = new Controller();
    calculator.calculateBi(Controller.BiOperatorModes.add, 3.0);
    assertEquals(5.5, calculator.calculateBi(Controller.BiOperatorModes.normal, 2.5));
  }

  @Test
  void calculateBiMinusTest() {
    Controller calculator = new Controller();
    calculator.calculateBi(Controller.BiOperatorModes.minus, 3.1415);
    assertEquals(2.0415, calculator.calculateBi(Controller.BiOperatorModes.normal, 1.1));
  }

  @Test
  void calculateBiMultiplyTest() {
    Controller calculator = new Controller();
    calculator.calculateBi(Controller.BiOperatorModes.multiply, 3.2);
    assertEquals(6.4, calculator.calculateBi(Controller.BiOperatorModes.normal, 2.0));
  }

  @Test
  void calculateBiDivideTest() {
    Controller calculator = new Controller();
    calculator.calculateBi(Controller.BiOperatorModes.divide, 6.4);
    assertEquals(3.2, calculator.calculateBi(Controller.BiOperatorModes.normal, 2.0));
  }

  @Test
  void calculateEqualTest() {
    Controller calculator = new Controller();
    calculator.calculateBi(Controller.BiOperatorModes.add, 6.4);
    calculator.calculateBi(Controller.BiOperatorModes.add, 2.0);
    assertEquals(11.4, calculator.calculateEqual(3.0));
  }

  @Test
  void resetTest() {
    Controller calculator = new Controller();
    calculator.calculateBi(Controller.BiOperatorModes.add, 6.4);
    assertEquals(8.4, calculator.calculateBi(Controller.BiOperatorModes.add, 2.0));
    assertEquals(NaN, calculator.reset());
  }

  @Test
  void CalculateMonoSquareTest() {
    Controller calculator = new Controller();
    assertEquals(9.0, calculator.calculateMono(Controller.MonoOperatorModes.square, 3.0));
  }

  @Test
  void CalculateMonoSquareRootTest() {
    Controller calculator = new Controller();
    assertEquals(5.0, calculator.calculateMono(Controller.MonoOperatorModes.squareRoot, 25.0));
  }

  @Test
  void CalculateMonoOneDividedByTest() {
    Controller calculator = new Controller();
    assertEquals(0.10, calculator.calculateMono(Controller.MonoOperatorModes.oneDividedBy, 10.0));
  }

  @Test
  void CalculateMonoSinTest() {
    Controller calculator = new Controller();
    assertEquals(
        0.5, calculator.calculateMono(Controller.MonoOperatorModes.sin, Math.PI / 6), 0.0000000001);
  }

  @Test
  void CalculateMonoCosTest() {
    Controller calculator = new Controller();
    assertEquals(
        0.5, calculator.calculateMono(Controller.MonoOperatorModes.cos, Math.PI / 3), 0.0000000001);
  }

  @Test
  void CalculateMonoTanTest() {
    Controller calculator = new Controller();
    assertEquals(
        1.0, calculator.calculateMono(Controller.MonoOperatorModes.tan, Math.PI / 4), 0.0000000001);
  }

  @Test
  void CalculateMonoLogTest() {
    Controller calculator = new Controller();
    assertEquals(2.0, calculator.calculateMono(Controller.MonoOperatorModes.log, 100.0));
  }

  @Test
  void CalculateMonoRateTest() {
    Controller calculator = new Controller();
    assertEquals(.75, calculator.calculateMono(Controller.MonoOperatorModes.rate, 75.0));
  }

  @Test
  void CalculateMonoAbsTest() {
    Controller calculator = new Controller();
    assertEquals(3.0, calculator.calculateMono(Controller.MonoOperatorModes.abs, -3.0));
    assertEquals(3.0, calculator.calculateMono(Controller.MonoOperatorModes.abs, 3.0));
  }
}
