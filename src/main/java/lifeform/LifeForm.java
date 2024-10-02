package lifeform;

/**
 * Keeps track of the information associated with a simple life form.
 * Also provides the functionality related to the life form.
 */
public abstract class LifeForm {
  private String myName;
  protected int currentLifePoints;
  protected int attackStrength;

  /**
   * Create an instance
   *
   * @param name the name of the life form
   * @param points the current starting life points of the life form
   */
  public LifeForm(String name, int points) {
    myName = name;
    currentLifePoints = points;
  }

  /**
   * Create an instance of a lifeform
   * @param name name of the life form
   * @param points starting life points of the life form
   * @param strength how much damage the lifeform does to other lifeforms
   */
  public LifeForm(String name, int points, int strength) {
    myName = name;
    currentLifePoints = points;
    attackStrength = strength;
  }

  /**
   * @return the name of the life form.
   */
  public String getName() {
    return myName;
  }

  /**
   * @return the amount of current life points the life form has.
   */
  public int getCurrentLifePoints() {
    return currentLifePoints;
  }

  /**
   * A LifeForm is hurt and takes damage
   * @param points the amount of LifePoints a LifeForm should lose
   */
  public void takeHit(int points) {
    if (currentLifePoints - points >= 0) {
      currentLifePoints -= points;
    } else {
      currentLifePoints = 0;
    }
  }

  /**
   * Set the attack strength
   * @param s the value to set the attack strenght to
   */
  public void setAttackStrength(int s) {
    attackStrength = s;
  }

  /**
   * Gets the attack strength of a life form
   * @return attackStrength the strength of a life form
   */
  public int getAttackStrength() {
    return attackStrength;
  }

  /**
   * Attack another life form
   * @param lf the life form to attack
   */
  public void attack(LifeForm lf) {
    if (currentLifePoints > 0) {
      lf.takeHit(attackStrength);
    }
  }
}
