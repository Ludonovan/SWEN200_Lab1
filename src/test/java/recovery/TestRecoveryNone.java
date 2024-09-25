package recovery;

import exceptions.RecoveryRateException;
import lifeform.Alien;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Aliens cannot recover
 */
public class TestRecoveryNone {

  /**
   * Test that an Alien with this behavior will not recover
   * @throws RecoveryRateException
   */
  @Test
  public void testNoRecovery() throws RecoveryRateException {
    RecoveryBehavior rb = new RecoveryNone();
    Alien a = new Alien("ET", 100, rb);
    assertEquals(a.getCurrentLifePoints(), 100);
    a.takeHit(10);
    a.recover();
    assertEquals(a.getCurrentLifePoints(), 90);
  }



}
