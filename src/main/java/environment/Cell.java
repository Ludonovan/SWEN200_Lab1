package environment;

import lifeform.LifeForm;

/**
 * A Cell that can hold a LifeForm.
 */
public class Cell {

  private LifeForm lifeForm;

  public Cell() {
  }

  /**
   * @return the LifeForm in this Cell.
   */
  public LifeForm getLifeForm() {
    return lifeForm;
  }

  /**
   * Tries to add the LifeForm to the Cell. Will not add if a
   * LifeForm is already present.
   * @param entity the lifeform held in the cell
   * @return true if the LifeForm was added to the Cell, false otherwise.
   */
  public boolean addLifeForm(LifeForm entity) {
    if (lifeForm == null) {
      lifeForm = entity;
      return true;
    } else {
      return false;
    }
  }

  /**
   * Removes a LifeForm from a cell
   */
  public void removeLifeForm() {
    lifeForm = null;
  }

}