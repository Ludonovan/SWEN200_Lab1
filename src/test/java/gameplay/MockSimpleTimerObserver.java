package gameplay;

/**
 * A mock class for testing Simple Timer
 */
public class MockSimpleTimerObserver implements TimerObserver {
  public int myTime = 0;

  public void updateTime(int time) {
    myTime = time;
  }
}