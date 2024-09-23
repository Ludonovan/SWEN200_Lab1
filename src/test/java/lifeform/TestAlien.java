package lifeform;

import exceptions.RecoveryRateException;
//import recovery.RecoveryBehavior;
import recovery.RecoveryLinear;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test the Alien class
 */
public class TestAlien {

  /**
   * Test that an Alien can be created
   * @throws RecoveryRateException should never throw
   */
  @Test
  public void testInitialization() throws RecoveryRateException {
    Alien a = new Alien("ET", 100);
    assertEquals(a.getName(), "ET");
    assertEquals(a.getCurrentLifePoints(), 100);
  }

  @Test
  public void testLinearRecovery() throws RecoveryRateException {
    RecoveryLinear rl = new RecoveryLinear(10); 
    Alien a = new Alien("ET", 100, rl);
    a.takeHit(40);
    a.recover();
    assertEquals(70, a.getCurrentLifePoints());
  }

}
