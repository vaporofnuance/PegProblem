package com.vnuance.peg;

import org.junit.Assert;
import org.junit.Test;

public class ProblemSolverTest {

  // There are only two completely unique positions on the peg
  // board.  As such, every other position should map out the same.
  private int expectedPosition1 = 29760;
  private int expectedPosition2 = 14880;
  private int expectedPosition4 = 85258;
  private int expectedPosition5 = 1550;

  @Test
  public void testStartingPosition1() {
    Assert.assertEquals(ProblemSolver.solve(1).size(), expectedPosition1);
  }

  @Test
  public void testStartingPosition2() {
    Assert.assertEquals(ProblemSolver.solve(2).size(), expectedPosition2);
  }

  @Test
  public void testStartingPosition3() {
    Assert.assertEquals(ProblemSolver.solve(3).size(), expectedPosition2);
  }

  @Test
  public void testStartingPosition4() {
    Assert.assertEquals(ProblemSolver.solve(4).size(), expectedPosition4);
  }

  @Test
  public void testStartingPosition5() {
    Assert.assertEquals(ProblemSolver.solve(5).size(), expectedPosition5);
  }

  @Test
  public void testStartingPosition6() {
    Assert.assertEquals(ProblemSolver.solve(6).size(), expectedPosition4);
  }

  @Test
  public void testStartingPosition7() {
    Assert.assertEquals(ProblemSolver.solve(7).size(), expectedPosition2);
  }

  @Test
  public void testStartingPosition8() {
    Assert.assertEquals(ProblemSolver.solve(8).size(), expectedPosition5);
  }

  @Test
  public void testStartingPosition9() {
    Assert.assertEquals(ProblemSolver.solve(9).size(), expectedPosition5);
  }

  @Test
  public void testStartingPosition10() {
    Assert.assertEquals(ProblemSolver.solve(10).size(), expectedPosition2);
  }

  @Test
  public void testStartingPosition11() {
    Assert.assertEquals(ProblemSolver.solve(11).size(), expectedPosition1);
  }

  @Test
  public void testStartingPosition12() {
    Assert.assertEquals(ProblemSolver.solve(12).size(), expectedPosition2);
  }

  @Test
  public void testStartingPosition13() {
    Assert.assertEquals(ProblemSolver.solve(13).size(), expectedPosition4);
  }

  @Test
  public void testStartingPosition14() {
    Assert.assertEquals(ProblemSolver.solve(14).size(), expectedPosition2);
  }

  @Test
  public void testStartingPosition15() {
    Assert.assertEquals(ProblemSolver.solve(15).size(), expectedPosition1);
  }

}
