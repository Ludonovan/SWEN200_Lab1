package gameplay;

import java.util.ArrayList;
import java.util.List;

public class SimpleTimer extends Thread implements Timer {
  private List<TimerObserver> theObservers;
  private int round;
  private int sleep;

  public SimpleTimer() {
    round = 0;
    theObservers = new ArrayList<>();
  }

  public SimpleTimer(int sleep) {
    round = 0;
    theObservers = new ArrayList<>();
    this.sleep = sleep;
  }

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

  public void addTimeObserver(TimerObserver o) {
    theObservers.add(o);
    o.updateTime(round);
  }

  public void timeChanged() {
    round++;
    theObservers.forEach(o -> o.updateTime(round));
  }

  public void removeTimeObserver(TimerObserver o) {
    theObservers.remove(o);
  }

  public int getNumObservers() {
    return theObservers.size();
  }

  public int getRound() {
    return round;
  }


}
