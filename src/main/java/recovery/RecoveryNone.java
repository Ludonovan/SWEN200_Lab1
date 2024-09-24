package recovery;

/**
 *
 */
public class RecoveryNone implements RecoveryBehavior {

  /**
   * Empty Constructor
   */
  public RecoveryNone() {}

  /**
   * Aliens with this behavior should not recover
   * @param currentLife current life points
   * @param maxLife maximum life points
   * @return currentLife
   */
  @Override
  public int calculateRecovery(int currentLife, int maxLife) {
    return currentLife;
  }
}
