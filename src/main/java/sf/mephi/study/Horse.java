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
        if (limitCheck(line, column, toLine, toColumn) == false)
            return false;
        else if (((toLine == (line + 2)) || (toLine == (line - 2))) && //проверяем ходит ли конь буквой "Г", т.е. на 2 клетки по горизонтали
                ((toColumn == (column + 1)) || (toColumn == (column - 1)))) // и одну по вертикли
            if (chessBoard.board[toLine][toColumn] == null) // проверка пустая ли клетка
                return true;
            else if ((chessBoard.board[toLine][toColumn] == null) && canEat(chessBoard, toLine, toColumn)) //проверка может ли конь съесть фигуру в точке назначения
                return true;
            else
                return false;
        else if (((toLine == (line + 1)) || (toLine == (line - 1))) && //проверяем ходит ли конь буквой "Г", т.е. на 1 клетку по горизонтали
                ((toColumn == (column + 2)) || (toColumn == (column - 2)))) // и 3 по вертикли
            if (chessBoard.board[toLine][toColumn] == null) // проверка пустая ли клетка
                return true;
            else if ((chessBoard.board[toLine][toColumn] == null) && canEat(chessBoard, toLine, toColumn)) //проверка может ли конь съесть фигуру в точке назначения
                return true;
            else
                return false;
        else
            return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }

    private boolean limitCheck(int line, int column, int toLine, int toColumn) {
        if ((toLine < 0) || (toLine > 7)) // проверка, что фигура не выходит за пределы по вертикали
            return false;
        else if ((toColumn < 0) || (toColumn > 7)) // проверка, что фигура не выходит за пределы по горизонтали
            return false;
        else if ((toLine == line) && (toColumn == column)) // проверка, что фигура не стоит на месте
            return false;
        else
            return true;
    }

    private boolean canEat(ChessBoard chessBoard, int toLine, int toColumn) {
        if (color.equals("White") && chessBoard.board[toLine][toColumn].color.equals("Black"))
            return true;
        else if (color.equals("Black") && chessBoard.board[toLine][toColumn].color.equals("White"))
            return true;
        else
            return false;
    }

}
