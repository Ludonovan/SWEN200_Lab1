package lifeform;

import exceptions.RecoveryRateException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertFalse;

/**
 * Test the Alien class
 */
public class TestAlien {

  /**
   * Test that an Alien can be created
   * @throws RecoveryRateException should never throw
   */
  public void testInitialization() throws RecoveryRateException {
    Alien a = new Alien("ET", 100);
    assertEquals(a.getName(), "ET");
    assertEquals(a.getCurrentLifePoints(), 100);
  }

}
