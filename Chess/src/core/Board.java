package core;

import java.util.HashMap;

public class Board {
    public HashMap<Character, ChessPiece[]> board;
    public ChessPiece activePiece;
    public Board() {
        this.board = new HashMap<>();
        for (char c: "ABCDEFGH".toCharArray())
            this.board.put(c, new ChessPiece[8]);
    }
    public void setPiece(String name, String position) {
        int y = Integer.parseInt(String.valueOf(position.toCharArray()[1]));
        if (name.equalsIgnoreCase("king"))
            this.activePiece = new King(position.toCharArray()[0], y);
        else if (name.equalsIgnoreCase("queen"))
            this.activePiece = new Queen(position.toCharArray()[0], y);
        else if (name.equalsIgnoreCase("rook"))
            this.activePiece = new Rook(position.toCharArray()[0], y);
        board.get(this.activePiece.x())[this.activePiece.y() - 1] = this.activePiece;
    }
    public void move(Orientation orientation, int squares) throws InvalidMovement {
        char old_x = this.activePiece.x();
        int old_y = this.activePiece.y();
        this.activePiece.move(orientation, squares);
        board.get(old_x)[old_y - 1] = null;
        board.get(this.activePiece.x())[this.activePiece.y() - 1] = this.activePiece;
    }

    @Override
    public String toString() {
        String repr = "";
        for (ChessPiece[] column: this.board.values()) {
            for (ChessPiece chessPiece : column) {
                if (chessPiece == null)
                    repr = repr.concat("□ ");
                else
                    repr = repr.concat("■ ");
            }
            repr = repr.concat("\n");
        }
        String[] reverse = repr.split("\n");
        StringBuilder new_repr = new StringBuilder();
        for (String row: reverse)
            new_repr.insert(0, row + '\n');
        return new_repr.toString();
    }
}
