package sf.mephi.study;

public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if ((toLine < 0) || (toLine > 7))
            return false;
        else if ((toColumn < 0) || (toColumn > 7))
            return false;
        else if ((toLine == line) && (toColumn == column))
            return false;
        else if (((toLine == (line + 3)) || (toLine == (line - 3))) && //проверяем ходит ли конь буквой "Г", т.е. на 3 клетки по горизонтали
                ((toColumn == (column + 1)) || (toColumn == (column - 1)))) // и одну по вертикли
            return true;
        else if (((toLine == (line + 1)) || (toLine == (line - 1))) && //проверяем ходит ли конь буквой "Г", т.е. на 1 клетку по горизонтали
                ((toColumn == (column + 3)) || (toColumn == (column - 3)))) // и 3 по вертикли
            return true;
        else
            return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}