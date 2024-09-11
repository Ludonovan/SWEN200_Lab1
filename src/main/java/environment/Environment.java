package environment;

import lifeform.LifeForm;

public class Environment {
    int rows;
    int cols;
    Cell[][] cells;

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

    public LifeForm getLifeForm(int row, int col){
        return cells[row][col].getLifeForm();
    }

    public void addLifeForm(LifeForm lf, int row, int col) {
        cells[row][col].addLifeForm(lf);
    }

    public void removeLifeForm(int row, int col) {
        cells[row][col].removeLifeForm();
    }
}