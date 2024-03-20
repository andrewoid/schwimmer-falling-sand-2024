package schwimmer.fallingsand;

import java.util.Random;

public class Sand {

    private final int[][] field;

    private final Random random;

    public Sand(int width, int height) {
        // call the other constructor to reduce code duplication
        this(width, height, new Random());
    }

    public Sand(int width, int height, Random random) {
        field = new int[height][width];
        this.random = random;
    }

    public int getWidth() {
        return field[0].length;
    }

    public int getHeight() {
        return field.length;
    }

    /**
     * Adds random sand to our field
     *
     * @param n the amount of sand to add.
     */
    public void randomSand(int n) {
        for (int i = 0; i < n; i++) {
            put(
                    random.nextInt(field[0].length),
                    random.nextInt(field.length)
            );
        }
    }

    /**
     * Sets the value in field to be 1
     */
    public void put(int x, int y) {
        field[y][x] = 1;
    }

    /**
     * Sets the field to be the values in s. The format of s should be the same as the format of the String in toString
     *
     * @param s
     */
    public void load(String s) {
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field[y].length; x++) {
                builder.append(field[y][x]);
            }
            builder.append("\n");
        }

        return builder.toString();
    }

    /**
     * @return the value in field
     */
    public int get(int x, int y) {
        return field[y][x];
    }

    /**
     * Moves all sand down one square if there is space
     */
    public void fall() {
        for (int y = field.length - 2; y >= 0; y--) {
            for (int x = 0; x < field[y].length; x++) {
                if (isSand(x, y)) {
                    moveSandDown(x, y);
                }
            }
        }
    }

    /**
     * @param x
     * @param y
     * @return true if there is sand at the coordinates, otherwise false
     */
    public boolean isSand(int x, int y) {
        return field[y][x] == 1;
    }

    /**
     * Moves the sand down one square, or diagonally to the right or left
     *
     * @param x
     * @param y
     */
    private void moveSandDown(int x, int y) {
        // move down
        if (move(x, y, x, y + 1)) {
            return;
        }

        // choose either left or right
        int direction = random.nextBoolean() ? +1 : -1;

        // move diagonally down in one direction
        if (move(x, y, x - direction, y + 1)) {
            return;
        }

        // move diagonally down in the other direction
        move(x, y, x + direction, y + 1);
    }

    /**
     * Attempts to move the sand from x1, y1 to x2, y2
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return true if the move was successful, otherwise false
     */
    public boolean move(int x1, int y1, int x2, int y2) {
        if (inBounds(x2, y2) && isSand(x1, y1) && !isSand(x2, y2)) {
            field[y1][x1] = 0;
            field[y2][x2] = 1;
            return true;
        }
        return false;
    }

    /**
     * @param x
     * @param y
     * @return true if the coordinates are in the field, otherwise false
     */
    public boolean inBounds(int x, int y) {
        return 0 <= x && x < field[y].length;
    }

    /**
     * Change the width and height of the field. Keep the contents.
     *
     * @param width
     * @param height
     */
    public void resize(int width, int height) {

    }

    /**
     * Add sand to field
     *
     * @param x
     * @param y
     * @param radius      the radius of the circle
     * @param probability that an empty spot in the circle will be sand.
     */
    public void put(int x, int y, int radius, double probability) {

    }

}
