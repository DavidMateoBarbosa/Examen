package core;

public abstract class ChessPiece
{
    private char x;
    private int y;
    public char x()
    {
        return this.x;
    }
    public abstract void move(Orientation orientation, int squares) throws InvalidMovement;
    public int y()
    {
        return this.y;
    }
    public ChessPiece(char x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public ChessPiece() {
        this('A', 1);
    }
    protected void north() throws InvalidMovement
    {
        if (this.y == 8)
            throw new InvalidMovement();
        this.y ++;
    }
    protected void east() throws InvalidMovement
    {
        if (this.x == 72)
            throw new InvalidMovement();
        this.x ++;
    }
    protected void south() throws InvalidMovement
    {
        if (this.y == 1)
            throw new InvalidMovement();
        this.y --;
    }
    protected void west() throws InvalidMovement
    {
        if (this.x == 65)
            throw new InvalidMovement();
        this.x --;
    }
}
