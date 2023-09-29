package core;


import java.util.Objects;

public class King extends ChessPiece
{
    public King(char x, int y) {
        super(x, y);
    }

    public void move(Orientation orientation, int squares) throws InvalidMovement {
        if (squares != 1)
            throw new InvalidMovement();
        if (Objects.requireNonNull(orientation) == Orientation.N) {
            this.north();
        } else if (orientation == Orientation.E) {
            this.east();
        } else if (orientation == Orientation.S) {
            this.south();
        } else if (orientation == Orientation.W) {
            this.west();
        } else if (orientation == Orientation.NE) {
            this.north();
            this.east();
        } else if (orientation == Orientation.SE) {
            this.south();
            this.east();
        } else if (orientation == Orientation.SW) {
            this.south();
            this.west();
        } else if (orientation == Orientation.NW) {
            this.north();
            this.west();
        }
    }
}
