package recovery;

import java.lang.Math;

public class RecoveryFractional implements RecoveryBehavior {
  double percentRecovery;

  public RecoveryFractional(double percent) {
        percentRecovery = percent;
  }

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