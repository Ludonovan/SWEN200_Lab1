package gameplay;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * To test SimpleTimer
 */
public class TestSimpleTimer {

  /**
   * Test the initialization
   */
  @Test
  public void testInitialization() {
    SimpleTimer t = new SimpleTimer();
    assertEquals(0, t.getRound());
    assertEquals(0, t.getNumObservers());
  }

  /**
   * Test that time is updated correctly
   */
  @Test
  public void testTime() {
    SimpleTimer t = new SimpleTimer();
    t.timeChanged();
    assertEquals(1, t.getRound());
  }

  /**
   * Test that an observer can be added
   */
  @Test
  public void testAddObserver() {
    SimpleTimer t = new SimpleTimer();
    MockSimpleTimerObserver o = new MockSimpleTimerObserver();
    t.addTimeObserver(o);
    assertEquals(1, t.getNumObservers());
  }

  /**
   * Test that an observer can be removed
   */
  @Test
  public void testRemoveObserver() {
    SimpleTimer t = new SimpleTimer();
    MockSimpleTimerObserver o = new MockSimpleTimerObserver();
    t.addTimeObserver(o);
    assertEquals(1, t.getNumObservers());
    t.removeTimeObserver(o);
    assertEquals(0, t.getNumObservers());
  }

  /**
   * Test that timeChanged works properly
   */
  @Test
  public void testTimeChanged() {
    SimpleTimer t = new SimpleTimer();
    MockSimpleTimerObserver o = new MockSimpleTimerObserver();
    t.timeChanged();
    assertEquals(1, t.getRound());
    t.addTimeObserver(o);
    assertEquals(1, t.getNumObservers());
    t.timeChanged();
    assertEquals(2, t.getRound());
    assertEquals(2, o.myTime);
    t.timeChanged();
    assertEquals(3, t.getRound());
    assertEquals(3, o.myTime);
    t.removeTimeObserver(o);
    t.timeChanged();
    assertEquals(4, t.getRound());
    assertEquals(3, o.myTime);
  }

  /**
   * This tests that SimpleTimer will update time once
   * every second.
   */
  @Test
  public void testSimpleTimerAsThread() throws InterruptedException {
    SimpleTimer st = new SimpleTimer(1000);
    st.start();
    Thread.sleep(250); // So we are 1/4th a second different
    for (int x = 0; x < 5; x++) {
      assertEquals(x,st.getRound()); //assumes round starts at 0
      Thread.sleep(1000); // wait for the next time change
    }
  }

}
