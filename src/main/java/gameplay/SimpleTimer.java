package gameplay;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to keep track of rounds
 */
public class SimpleTimer extends Thread implements Timer {
  private List<TimerObserver> theObservers;
  private int round;
  private int sleep;

  /**
   * Constructor
   */
  public SimpleTimer() {
    round = 0;
    theObservers = new ArrayList<>();
  }

  /**
   * Constructor for threads
   * @param sleep time in ms to wait
   */
  public SimpleTimer(int sleep) {
    round = 0;
    theObservers = new ArrayList<>();
    this.sleep = sleep;
  }

  /**
   * Run a thread
   */
  public void run() {
    for (int i = 0; i < 50; i++) {
      try {
        Thread.sleep(sleep);
        timeChanged();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

  /**
   * Add a time observer to theObservers
   * @param o TimerObserver to add
   */
  public void addTimeObserver(TimerObserver o) {
    theObservers.add(o);
    o.updateTime(round);
  }

  /**
   * Change the round to the next round
   */
  public void timeChanged() {
    round++;
    theObservers.forEach(o -> o.updateTime(round));
  }

  /**
   * Remove a time observer from theObservers
   * @param o observer to be removed
   */
  public void removeTimeObserver(TimerObserver o) {
    theObservers.remove(o);
  }

  /**
   * Get number of observers
   * @return the size of theObservers list
   */
  public int getNumObservers() {
    return theObservers.size();
  }

  /**
   * Get current round
   * @return round the current round
   */
  public int getRound() {
    return round;
  }


}
