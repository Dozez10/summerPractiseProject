package game.model.placing;

import java.util.Objects;

public class Coordinate {
    private int x;
    private int y;
public Coordinate(int x,int y){
    this.x = x;
    this.y = y;
}
    public Coordinate(){
    this.x = 0;
    this.y = 0;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return getX() == that.getX() && getY() == that.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("x=").append(getX())
                .append("y=").append(getY())
                .toString();
    }
}

