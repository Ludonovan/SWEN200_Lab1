package lifeform;

import exceptions.RecoveryRateException;
import gameplay.TimerObserver;
import recovery.RecoveryBehavior;
import recovery.RecoveryNone;

/**
 * Create an Alien
 */
public class Alien extends LifeForm implements TimerObserver {

  private int maxLifePoints;
  private int recoveryRate;
  private RecoveryBehavior rb;
  private int roundsToRecovery;

  /**
   * Constructor for only name and max hp
   * @param name name of the Alien
   * @param maxHitPoints maximum hp of the Alien
   */
  public Alien(String name, int maxHitPoints) {
    this(name, maxHitPoints, new RecoveryNone());

  }

  /**
   * Constructor for name, hp, and rb
   * @param name name of the Alien
   * @param maxHitPoints maximum hp of the Alien
   * @param rb the recovery behavior of the Alien
   */
  public Alien(String name, int maxHitPoints, RecoveryBehavior rb) {
    super(name, maxHitPoints, 10);
    maxLifePoints = maxHitPoints;
    this.rb = rb;
  }

  public Alien(String name, int maxHitPoints, RecoveryBehavior rb, int recoveryRate) {
    super(name, maxHitPoints, 10);
    maxLifePoints = maxHitPoints;
    this.rb = rb;
    this.recoveryRate = recoveryRate;
    roundsToRecovery = recoveryRate;
  }

  /**
   * Gets the recovery rate of an Alien
   * @return recoveryRate
   */
  public int getRecoveryRate() throws RecoveryRateException {
    if (recoveryRate < 0) { throw new RecoveryRateException("Less than 0"); }
    else { return recoveryRate; }
  }

  /**
   * Gets the max hp of an Alien
   * @return maxLifePoints
   */
  public int getMaxLifePoints() {
    return maxLifePoints;
  }

  /**
   * Make an alien recover
   */
  public void recover() {
    if (currentLifePoints > 0) {
      currentLifePoints = rb.calculateRecovery(currentLifePoints, maxLifePoints);
    } else {
      currentLifePoints = 0;
    }
  }

  @Override
  public void updateTime(int time) {
    if (recoveryRate == 0) {
      //roundsToRecovery = 0;
    } else if (roundsToRecovery > 0) {
      roundsToRecovery--;
    } else if (roundsToRecovery == 0) {
      recover();
      roundsToRecovery = recoveryRate - 1;
    }

  }
}
