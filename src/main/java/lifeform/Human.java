package lifeform;

/**
 * Create a Human
 */
public class Human extends LifeForm {
  int armorPoints;

  /**
   * Constructor for Human
   * @param name the name of the LifeForm
   * @param life the current life points of the LifeForm
   * @param armor the current armor of the LifeForm
   */
  public Human(String name, int life, int armor) {
    super(name, life);
    if (armor >= 0) {
      armorPoints = armor;
    } else {
      armorPoints = 0;
    }
  }

  /**
   * Gets the current armor points for a Human
   * @return armorPoints
   */
  public int getArmorPoints() {
    return armorPoints;
  }

  /**
   * Sets the armor points
   * If the input value is negative, armor = 0
   * @param val the value to set armor points to
   */
  public void setArmorPoints(int val) {
    if (val >= 0) {
      armorPoints = val;
    } else {
      armorPoints = 0;
    }
  }
}
