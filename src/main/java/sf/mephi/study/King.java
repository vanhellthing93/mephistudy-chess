package sf.mephi.study;

public class King extends ChessPiece{

    public King(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if ((toLine < 0) || (toLine > 7)) // проверка, что фигура не выходит за пределы по вертикали
            return false;
        else if ((toColumn < 0) || (toColumn > 7)) // проверка, что фигура не выходит за пределы по горизонтали
            return false;
        else if ((toLine == line) && (toColumn == column)) // проверка, что фигура не стоит на месте
            return false;
        else if (((Math.abs(toLine - line)) <= 1) && ((Math.abs(toColumn - column)) <= 1))
            return true;
        else
            return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        return false;
    }

}
