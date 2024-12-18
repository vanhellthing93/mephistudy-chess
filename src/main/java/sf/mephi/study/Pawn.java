package sf.mephi.study;

public class Pawn extends ChessPiece {

    public Pawn(String color) {
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
        else if (Math.abs(toColumn - column) == 1) { //проверка возможности съесть фигуру по диагонали
            if (color.equals("White") && ((toLine - line) == 1)) {
                if (canEat(chessBoard, toLine, toColumn) == true)
                    return true;
                else return false;
            }
            if (color.equals("Black") && ((toLine - line) == -1)) {
                if (canEat(chessBoard, toLine, toColumn) == true)
                    return true;
                else return false;
            } else
                return false;
        } else if (toColumn == column) { //проверка, что фигура двигается не по горизонтали
            if ((color.equals("White") && (toLine > line))) { //проверка, что фигура белая и она двигается вперёд, а не назад
                if (toLine == (line + 2)) { //проверка, может ли фигура двигаться на 2 клетки вперёд
                    if (line == 1) {//проверка двигалась ли фигура
                        if ((chessBoard.board[line + 1][column] == null) && (chessBoard.board[line + 2][column] == null)) // проверка, есть ли фигуры на пути
                            return true;
                        else
                            return false;
                    } else
                        return false;
                } else if (toLine == (line + 1)) { //проверка, двигается ли фигура на 1 клетку вперёд
                    if (chessBoard.board[line + 1][column] == null)
                        return true;
                    else
                        return false;
                } else
                    return false;
            } else if ((color.equals("Black") && (toLine < line))) { //проверка, что фигура черная и она двигается вперёд, а не назад
                if (toLine == (line - 2)) { //проверка, может ли фигура двигаться на 2 клетки вперёд
                    if (line == 6) {//проверка двигалась ли фигура
                        if ((chessBoard.board[line - 1][column] == null) && (chessBoard.board[line - 2][column] == null)) // проверка, есть ли фигуры на пути
                            return true;
                        else
                            return false;
                    } else
                        return false;
                } else if (toLine == (line - 1)) { //проверка, двигается ли фигура на 1 клетку вперёд
                    if (chessBoard.board[line - 1][column] == null)
                        return true;
                    else
                        return false;
                } else
                    return false;
            } else
                return false;
        } else
            return false;
    }

    @Override
    public String getSymbol() {
        return "P";
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
