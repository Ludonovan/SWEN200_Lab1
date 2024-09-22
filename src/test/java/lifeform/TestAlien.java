package lifeform;

import exceptions.RecoveryRateException;
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

}
