import core.Board;
import core.InvalidMovement;
import core.King;
import core.Orientation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        Board board = new Board();
        System.out.print("Write the piece to set: ");
        String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        System.out.print("Write the position like (A1): ");
        String pos = new BufferedReader(new InputStreamReader(System.in)).readLine();
        board.setPiece(input, pos);
        System.out.println(board);
        System.out.print("Orientation to move: (N, S, E, W, NE, SE, SW, NW): ");
        input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        System.out.println("Squares");
        int squares = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        try {
            board.move(Orientation.valueOf(input), squares);
        } catch (InvalidMovement ignore)
        {
            System.out.printf("Invalid movement %s, with squares %s", input, squares);
        }
        System.out.println(board);

    }
}