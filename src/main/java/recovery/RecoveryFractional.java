package recovery;

import java.lang.Math; //Math.ceil()

/**
 * Aliens with this behavior can only recover a percentage of their current LifePoints
 */
public class RecoveryFractional implements RecoveryBehavior {
  double percentRecovery;

  /**
   * Constructor for RecoveryFractional
   * @param percent the percentage an Alien can recover
   */
  public RecoveryFractional(double percent) {
    percentRecovery = percent;
  }

  /**
   * Calculate the recovery points of an Alien
   * @param currentLife current life points
   * @param maxLife maximum life points
   * @return 0 if current HP is 0
   *         the recovery points to be added to the current hp
   *         maximum hp if health is already at max
   */
  public int calculateRecovery(int currentLife, int maxLife) {
    double recover = currentLife * percentRecovery;
    if (currentLife + recover < 0) {
      return 0;
    } else if (currentLife + recover <= maxLife) {
      return (int) (currentLife + Math.ceil(recover));
    } else {
      return maxLife;
    }
  }

}