

public class Table {

    double[][] values;

    public Table(int rows, int columns) throws IllegalArgumentException {
        if (rows < 1 || columns < 1) {
            throw new IllegalArgumentException("Rows and Columns cannot be 0 or negative.");
        }
        values = new double[rows][columns];
    }

    public int getNumRows() {
        return values.length;
    }

    public int getNumColumns() {
        return values[0].length;
    }

    public double getValue(int row, int column) throws IllegalArgumentException {
        if (row >= this.values.length || column >= this.values[0].length || row < 1 || columns < 1) {
            throw new IllegalArgumentException("The index for rows & columns must be in bounds.");
        }
        return values[row][column];
    }

    public void setValue(double value, int row, int column) throws IllegalArgumentException {
        if (row >= this.values.length || column >= this.values[0].length || row < 1 || columns < 1) {
            throw new IllegalArgumentException("The index for rows & columns must be in bounds.");
        }
        values[row][column] = value;
    }

    public double getRowMax(int row)throws IllegalArgumentException {
        if (row >= this.values.length || row < 1) {
            throw new IllegalArgumentException("The index for rows & columns must be in bounds.");
        }

        double max = Double.MIN_VALUE;
        for (int j = 0; j < values[0].length; j++) {
            if (values[row][j] > max) {
                max = values[row][j];
            }
        }
        return max;
    }

    public double getRowMin(int row)throws IllegalArgumentException {
        if (row >= this.values.length || row < 1) {
            throw new IllegalArgumentException("The index for rows & columns must be in bounds.");
        }

        double min = Double.MAX_VALUE;
        for (int j = 0; j < values[0].length; j++) {
            if (values[row][j] < min) {
                min = values[row][j];
            }
        }
        return min;
    }

    public double getColumnMax(int column)throws IllegalArgumentException {
        if (column >= this.values.length || column < 1) {
            throw new IllegalArgumentException("The index for rows & columns must be in bounds.");
        }

        double max = Double.MIN_VALUE;
        for (int j = 0; j < values[0].length; j++) {
            if (values[j][column] > max) {
                max = values[j][column];
            }
        }
        return max;
    }

    public double getColumnMin(int column)throws IllegalArgumentException {
        if (column >= this.values.length || column < 1) {
            throw new IllegalArgumentException("The index for rows & columns must be in bounds.");
        }

        double min = Double.MAX_VALUE;
        for (int j = 0; j < values[0].length; j++) {
            if (values[j][column] < min) {
                min = values[j][column];
            }
            }
        return min;
    }

}