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
    assertEquals(h.getAttackStrength(), 5);

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

  /**
   * Test that attack works with no armor
   */
  @Test
  public void testAttackNoArmor() {
    Human h1 = new Human("Bob", 50, 0);
    Human h2 = new Human("Rob", 50, 0);
    h1.attack(h2);
    assertEquals(45, h2.getCurrentLifePoints());
  }

  /**
   * Test that an attack that hits less than armor
   * does not hurt the human
   */
  @Test
  public void testArmorTakesAll() {
    Human h1 = new Human("Bob", 50, 10);
    Human h2 = new Human("Rob", 50, 10);
    h1.attack(h2);
    assertEquals(50, h2.getCurrentLifePoints());
  }

  /**
   * Test that attack works with armor as expected
   */
  @Test
  public void testAttackWithArmor2() {
    Human h1 = new Human("Bob", 50, 10);
    Human h2 = new Human("Rob", 50, 1);
    h1.attack(h2);
    assertEquals(46, h2.getCurrentLifePoints());
  }

  /**
   * Test that an attack with power = armor does no damage
   */
  @Test
  public void testAttackEqualsArmor() {
    Human h1 = new Human("Bob", 50, 5);
    Human h2 = new Human("Rob", 50, 5);
    h1.attack(h2);
    assertEquals(50, h2.getCurrentLifePoints());
  }

}
