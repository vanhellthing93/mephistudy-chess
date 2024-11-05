package sf.mephi.study;

abstract class ChessPiece {
    String color;
    boolean check = true;

    ChessPiece(String color) {
        this.color = color;
    }


    public String getColor() {
        return color;
    }

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();

}