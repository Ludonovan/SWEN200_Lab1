package lifeform;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test creation of a Human
 */
public class TestHuman {

  /**
   * Test that a Human can be properly initialized
   */
  @Test
  public void testInitialization() {
    Human h = new Human("Bob", 50, 10);
    assertEquals(h.getName(), "Bob");
    assertEquals(h.getCurrentLifePoints(), 50);
    assertEquals(h.getArmorPoints(), 10);

  }

  /**
   * Test that armor points can be set correctly
   */
  @Test
  public void testSetArmor() {
    Human h = new Human("Bob", 50, 10);
    h.setArmorPoints(20);
    assertEquals(h.getArmorPoints(), 20);
  }

  /**
   * Test that armor points can be gotten correctly
   */
  @Test
  public void testGetArmor() {
    Human h = new Human("Bob", 50, 10);
    h.setArmorPoints(-1);
    assertEquals(h.getArmorPoints(), 0);
    Human a = new Human("a", 1, -1);
    assertEquals(a.getArmorPoints(), 0);
  }
}
