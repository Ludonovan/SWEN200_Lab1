package recovery;

import exceptions.RecoveryRateException;
import lifeform.Alien;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestRecoveryNone {

  @Test
  public void testNoRecovery() throws RecoveryRateException {
    RecoveryBehavior rb = new RecoveryNone();
    Alien a = new Alien("ET", 100, rb);
    assertEquals(a.getCurrentLifePoints(), 100);
    a.takeHit(10);
    a.recover();
    assertEquals(a.getCurrentLifePoints(), 90);

  }

}
