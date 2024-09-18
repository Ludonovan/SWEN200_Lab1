package lifeform;

import exceptions.RecoveryRateException;

/**
 * Create an Alien
 */
public class Alien extends LifeForm{

  int maxLifePoints;

  /**
   * Constructor for only name and max hp
   * @param name name of the Alien
   * @param maxHitPoints maximum hp of the Alien
   * @throws RecoveryRateException should not throw
   */
  public Alien(String name, int maxHitPoints) throws RecoveryRateException {
    super(name, maxHitPoints);
    maxLifePoints = maxHitPoints;
  }

  /**
   * Gets the recovery rate of an Alien
   * @return recoveryRate
   */
  public int getRecoveryRate() {
    return 0;
  }

  /**
   * Gets the max hp of an Alien
   * @return maxLifePoints
   */
  public int getMaxLifePoints() {
    return maxLifePoints;
  }

}
