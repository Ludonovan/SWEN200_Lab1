package recovery;

import exceptions.RecoveryRateException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test the linear recovery of aliens
 */
public class TestRecoveryLinear {

  /**
   * Aliens cant recover if they aren't hurt
   */
  @Test
  public void noRecoveryWhenNotHurt() {
    RecoveryLinear rl = new RecoveryLinear(3);
    int maxLifePts = 30;
    int result = rl.calculateRecovery(maxLifePts, maxLifePts);
    assertEquals(maxLifePts,result);
  }

  /**
   * Test that recovery works correctly when hp is low
   */
  @Test
  public void testReallyHurts()  {
    RecoveryLinear rl = new RecoveryLinear(3);
    assertEquals(8, rl.calculateRecovery(5, 10));
  }

  /**
   * Test that recovery works correctly when only a little damage is done
   */
  @Test
  public void testHurtsALittle() {
    RecoveryLinear rl = new RecoveryLinear(1);
    assertEquals(10, rl.calculateRecovery(9, 10));
  }

  /**
   * Test that aliens cant come back from the dead
   */
  @Test
  public void testNoZombieAliens() {
    RecoveryLinear rl = new RecoveryLinear(100);
    assertEquals(0, rl.calculateRecovery(0, 10));
  }

  /**
   * Test perfect recovery
   */
  @Test
  public void testReturnMaxLifePoints() {
    RecoveryLinear rl = new RecoveryLinear(100);
    assertEquals(100, rl.calculateRecovery(1, 100));
  }
}
