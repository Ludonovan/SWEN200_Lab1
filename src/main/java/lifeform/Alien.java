package lifeform;

import exceptions.RecoveryRateException;
import recovery.RecoveryBehavior;
import recovery.RecoveryNone;

/**
 * Create an Alien
 */
public class Alien extends LifeForm {

  int maxLifePoints;
  int recoveryRate;
  RecoveryBehavior rb;

  /**
   * Constructor for only name and max hp
   * @param name name of the Alien
   * @param maxHitPoints maximum hp of the Alien
   */
  public Alien(String name, int maxHitPoints) throws RecoveryRateException {
//    super(name, maxHitPoints);
//    maxLifePoints = maxHitPoints;
    this(name, maxHitPoints, new RecoveryNone());
  }

  /**
   * Constructor for name, hp, and rb
   * @param name name of the Alien
   * @param maxHitPoints maximum hp of the Alien
   * @param rb the recovery behavior of the Alien
   * @throws RecoveryRateException should not throw
   */
  public Alien(String name, int maxHitPoints, RecoveryBehavior rb) throws RecoveryRateException {
    super(name, maxHitPoints);
    maxLifePoints = maxHitPoints;
    this.rb = rb;
  }

//  /**
//   * Full constructor for Alien
//   * @param name name of the Alien
//   * @param maxHitPoints maximum hp of the Alien
//   * @param rb the recovery behavior of the Alien
//   * @param rate the rate at which an Alien can recover
//   * @throws RecoveryRateException should not throw
//   */
//  public Alien(String name, int maxHitPoints, RecoveryBehavior rb, int rate) throws RecoveryRateException {
//    super(name, maxHitPoints);
//    maxLifePoints = maxHitPoints;
//    this.rb = rb;
//    recoveryRate = rate;
//  }

  /**
   * Gets the recovery rate of an Alien
   * @return recoveryRate
   */
  public int getRecoveryRate() {
    return recoveryRate;
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
}
