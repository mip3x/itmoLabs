package collection.data;

import collection.Invokable;
import exception.InvalidInputException;

public class Coordinates implements Invokable {
    private long x; //Максимальное значение поля: 224
    private Double y; //Поле не может быть null

    public Coordinates() {}

    public boolean setX(Long x) throws InvalidInputException {
        if (x == null) throw new InvalidInputException("Поле 'координата X' не должно быть пустым!");
        if (x > 224) throw new InvalidInputException("Координата 'X' должна быть меньше либо равна 224!");
        this.x = x;
        return true;
    }

    public boolean setY(Double y) throws InvalidInputException {
        if (y == null) throw new InvalidInputException("Поле 'координата Y' не должно быть пустым!");
        this.y = y;
        return true;
    }

    @Override
    public String toString() {
        return "\tx: " + x + "; y: " + y;
    }
}
