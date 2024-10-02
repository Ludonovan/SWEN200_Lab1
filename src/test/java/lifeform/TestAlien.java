package lifeform;

import exceptions.RecoveryRateException;
import gameplay.MockSimpleTimerObserver;
import gameplay.SimpleTimer;
import recovery.RecoveryBehavior;
import recovery.RecoveryLinear;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

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
    assertEquals(a.getAttackStrength(), 10);
  }

  /**
   * Test that linear recovery works properly
   * @throws RecoveryRateException should not throw
   */
  @Test
  public void testLinearRecovery() throws RecoveryRateException {
    RecoveryLinear rl = new RecoveryLinear(10); 
    Alien a = new Alien("ET", 100, rl);
    a.takeHit(40);
    a.recover();
    assertEquals(70, a.getCurrentLifePoints());
  }

  /**
   * Test that recoveryRate is set correctly
   * @throws RecoveryRateException should not throw
   */
  @Test
  public void testRecoveryRate() throws RecoveryRateException {
    SimpleTimer st = new SimpleTimer();
    Alien a = new Alien("ET", 100, new RecoveryLinear(5), 2);
    assertEquals(2, a.getRecoveryRate());
  }

  /**
   * Test that an alien that shouldnt recover doesnt recover
   */
  @Test
  public void testNoRecovery() {
    SimpleTimer st = new SimpleTimer();
    Alien a = new Alien("ET", 100, new RecoveryLinear(5), 0);
    st.addTimeObserver(a);
    st.timeChanged();
    a.takeHit(90);
    assertEquals(10, a.getCurrentLifePoints());
    st.timeChanged();
    st.timeChanged();
    st.timeChanged();
    assertEquals(10, a.getCurrentLifePoints());
  }

  /**
   * Test recovery in action
   */
  @Test
  public void testCombatRecovery() {
    SimpleTimer st = new SimpleTimer();
    Alien a = new Alien("ET", 100, new RecoveryLinear(5), 2);
    st.addTimeObserver(a);
    st.timeChanged();
    a.takeHit(90);
    assertEquals(10, a.getCurrentLifePoints());
    st.timeChanged();
    assertEquals(15, a.getCurrentLifePoints());
    st.timeChanged();
    assertEquals(15, a.getCurrentLifePoints());
    st.timeChanged();
    assertEquals(20, a.getCurrentLifePoints());
    a.takeHit(20);
    assertEquals(0, a.getCurrentLifePoints());
    st.timeChanged();
    st.timeChanged();
    assertEquals(0, a.getCurrentLifePoints());
  }

  /**
   * Test recovery in action
   */
  @Test
  public void testCombatRecovery2() {
    SimpleTimer st = new SimpleTimer();
    Alien a = new Alien("ET", 100, new RecoveryLinear(10), 5);
    st.addTimeObserver(a);
    st.timeChanged();
    a.takeHit(90);
    assertEquals(10, a.getCurrentLifePoints());
    st.timeChanged();
    st.timeChanged();
    st.timeChanged();
    st.timeChanged();
    assertEquals(20, a.getCurrentLifePoints());
  }

  /**
   * Can track passage of time
   */
  @Test
  public void testTimePasses() {
    SimpleTimer st = new SimpleTimer();
    MockSimpleTimerObserver a = new MockSimpleTimerObserver();
    st.addTimeObserver(a);
    st.timeChanged();
    assertEquals(1, a.myTime);
  }

  /**
   * Removed observers cant recover
   */
  @Test
  public void testRemovedCantRecover() {
    SimpleTimer st = new SimpleTimer();
    MockSimpleTimerObserver a = new MockSimpleTimerObserver();
    st.addTimeObserver(a);
    st.timeChanged();
    st.removeTimeObserver(a);
    st.timeChanged();
    st.timeChanged();
    st.timeChanged();
    assertEquals(1, a.myTime);
  }

  /**
   * Test negative recovery rates
   * @throws RecoveryRateException should throw if negative
   */
  @Test(expected = RecoveryRateException.class)
  public void testNegRecoveryRate() throws RecoveryRateException {
    SimpleTimer st = new SimpleTimer();
    RecoveryBehavior rb = new RecoveryLinear(5);
    Alien a = new Alien("ET", 100, rb, -5);
    a.getRecoveryRate();
  }
}
