package recovery;

public class RecoveryLinear implements RecoveryBehavior {
  int recoveryStep;

  public RecoveryLinear(int step) {
    recoveryStep = step;
  }

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
