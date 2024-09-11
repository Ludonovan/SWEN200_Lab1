package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import lifeform.LifeForm;
import org.junit.Test;

/**
 * Tests for the Environment class
 */
public class TestEnvironment {

  /**
   * Test that the environment is set up properly
   */
  @Test
  public void testInitialization() {
    Environment env = new Environment(1,1);
    assertNull(env.getLifeForm(0,0));
  }

  /**
   * Test that lifeforms can be added to the environment
   */
  @Test
  public void testAddLifeForm() {
    Environment env = new Environment(2,3);
    LifeForm lf = new LifeForm("Name", 100);
    assertTrue(env.addLifeForm(lf, 1, 2));
    LifeForm actual = env.getLifeForm(1, 2);
    assertEquals("Name", actual.getName());
    assertEquals(100, actual.getCurrentLifePoints());
  }

  /**
   * Test that lifeforms can be removed from the environment
   */
  @Test
  public void testRemoveLifeForm() {
    Environment env = new Environment(2,3);
    LifeForm lf = new LifeForm("Bob", 100);
    assertTrue(env.addLifeForm(lf, 1, 2));
    env.removeLifeForm(1, 2);
    assertNull(env.getLifeForm(1,2));
  }
}