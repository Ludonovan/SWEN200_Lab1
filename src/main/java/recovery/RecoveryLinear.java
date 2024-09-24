package recovery;

/**
 * Recover a set amount each time
 */
public class RecoveryLinear implements RecoveryBehavior {
  int recoveryStep;

  /**
   * Constructor for RecoveryLinear
   * @param step the amount to add to the current hp
   */
  public RecoveryLinear(int step) {
    recoveryStep = step;
  }

  /**
   * Calculate the recovery points to be added to the current health
   * @param currentLife current life points
   * @param maxLife maximum life points
   * @return the sum of currentLife and the recoveryStep
   *         0 if health is 0
   *         maxLife otherwise
   */
  public int calculateRecovery(int currentLife, int maxLife) {
    if (currentLife + recoveryStep <= maxLife && currentLife > 0) {
      return currentLife + recoveryStep;
    } else if (currentLife == 0) {
      return 0;
    } else {
      return maxLife;
    }

  }


}
