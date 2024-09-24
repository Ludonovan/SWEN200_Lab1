package recovery;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * When an alien can only recover a given percentage of their current LifePoints
 */
public class TestRecoveryFractional {

  /**
   * Test that an alien at max health cannot recover
   */
  @Test
  public void testNoRecovery() {
    RecoveryFractional rf = new RecoveryFractional(.1);
    assertEquals(100, rf.calculateRecovery(100, 100), 0.01);
  }

  /**
   * Test small amounts of recovery
   */
  @Test
  public void testSomeRecovery() {
    RecoveryFractional rf = new RecoveryFractional(.1);
    assertEquals(88, rf.calculateRecovery(80, 100), 0.01);
  }

  /**
   * Test recovery when LifePoints are low
   */
  @Test
  public void testLowHp() {
    RecoveryFractional rf = new RecoveryFractional(.1);
    assertEquals(2, rf.calculateRecovery(1, 100), 0.01);
  }

  /**
   * Test that Aliens cannot come back to life
   */
  @Test
  public void testNoZombieAliens() {
    RecoveryFractional rf = new RecoveryFractional(.1);
    assertEquals(0, rf.calculateRecovery(0, 100), 0.01);
  }

  /**
   * Make sure that health cannot go above max health points
   */
  @Test
  public void testReturnMaxHp() {
    RecoveryFractional rf = new RecoveryFractional(100);
    assertEquals(100, rf.calculateRecovery(99, 100), 0.01);
  }

}