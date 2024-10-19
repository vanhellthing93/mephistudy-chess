package sf.mephi.study;

public class Queen extends ChessPiece{

    public Queen(String color) {
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
        else if ((Math.abs(toLine - line)) == (Math.abs(toColumn - column)))
            return true;
        else if (toLine == line)
            return true;
        else if (toColumn == column)
            return true;
        else
            return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }

    @Override
    public String getColor() {
        return super.getColor();
    }
}
