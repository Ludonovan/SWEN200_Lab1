package environment;

import lifeform.LifeForm;

/**
 * The Environment sets up a 2D array of cells
 */
public class Environment {
  int rows;
  int cols;
  Cell[][] cells;

  /**
   * Constructor for Environment class
   * @param rows number of rows
   * @param cols number of columns
   */
  public Environment(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    cells = new Cell[rows][cols];
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        cells[row][col] = new Cell();
      }
    }
  }

  /**
   * Get the life form at a specific cell
   * @param row the desired row of the matrix
   * @param col the desired column of the matrix
   * @return the LifeForm at the cell
   */
  public LifeForm getLifeForm(int row, int col) {
    return cells[row][col].getLifeForm();
  }

  /**
   * Adds a LifeForm to a cell
   * @param lf the LifeForm to be added
   * @param row the row the LifeForm should be placed
   * @param col the column the LifeForm should be placed
   * @return true if added, otherwise false
   */
  public boolean addLifeForm(LifeForm lf, int row, int col) {
    if (cells[row][col].getLifeForm() == null) {
      cells[row][col].addLifeForm(lf);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Remove a LifeForm from a cell
   * @param row row of LifeForm to be removed
   * @param col column of LifeForm to be removed
   */
  public void removeLifeForm(int row, int col) {
    cells[row][col].removeLifeForm();
  }
}