package recovery;

/**
 * The way Aliens can recover
 */
public interface RecoveryBehavior {
  /**
   * Calculates the recovery of an alien
   * @param currentLife current life points
   * @param maxLife maximum life points
   * @return the life points to be recovered
   */
  public int calculateRecovery(int currentLife, int maxLife);
}
