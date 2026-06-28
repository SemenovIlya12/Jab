package ru.Semenov.Geometry;


/**
 * Точка на плоскости с целочисленными координатами.
 */
public class Point {
    private final int x;
    private final int y;

    /**
     * Создаёт точку.
     *
     * @param x координата X
     * @param y координата Y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Сравнивает точки по координатам.
     *
     * @param obj объект для сравнения
     * @return true, если координаты совпадают
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }

        final Point pt = (Point) obj;

        if (this.x == pt.x && this.y == pt.y) {
            return true;
        } else {
            return false;
        };

    }

    /**
     * Возвращает строковое представление точки.
     *
     * @return строка вида {x;y}
     */
    @Override
    public String toString() {
        return "{" + this.x + ";" + this.y + "}";
    }
}
