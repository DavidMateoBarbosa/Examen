package core;

import java.util.Objects;

public class Queen extends ChessPiece {
    @Override
    public void move(Orientation orientation, int squares) throws InvalidMovement {
        if (Objects.requireNonNull(orientation) == Orientation.N) {
            if (squares + this.y() > 8)
                throw new InvalidMovement();
            for (int index = 0; index < squares; index++)
                this.north();
        } else if (orientation == Orientation.E) {
            if (squares + this.x() > 72)
                throw new InvalidMovement();
            for (int index = 0; index < squares; index++)
                this.east();
        } else if (orientation == Orientation.S) {
            if (squares - this.y() < 1)
                throw new InvalidMovement();
            for (int index = 0; index < squares; index++)
                this.south();
        } else if (orientation == Orientation.W) {
            if (this.x() - squares < 65)
                throw new InvalidMovement();
            for (int index = 0; index < squares; index++)
                this.west();
        } else if (orientation == Orientation.NE) {
            if (squares + this.y() > 8 && squares + this.x() > 72)
                throw new InvalidMovement();
            for (int index = 0; index < squares; index++) {
                this.north();
                this.east();
            }
        } else if (orientation == Orientation.SE) {
            if (this.y() - squares < 1 && squares + this.x() > 72)
                throw new InvalidMovement();
            for (int index = 0; index < squares; index++) {
                this.south();
                this.east();
            }
        } else if (orientation == Orientation.SW) {
            if (squares - this.y() < 1 && this.x() - squares < 65)
                throw new InvalidMovement();
            for (int index = 0; index < squares; index++) {
                this.south();
                this.west();
            }
        } else if (orientation == Orientation.NW) {
            if (squares + this.y() > 8 && this.x() - squares < 65)
                throw new InvalidMovement();
            for (int index = 0; index < squares; index++) {
                this.north();
                this.west();
            }
        }
    }

    public Queen(char x, int y) {
        super(x, y);
    }
}
