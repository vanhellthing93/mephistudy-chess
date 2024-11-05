package sf.mephi.study;

public class Queen extends ChessPiece {

    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (limitCheck(line, column, toLine, toColumn) == false)
            return false;
        else if (canMoveDiagonal(chessBoard, line, column, toLine, toColumn) == true)
            return true;
        else if (canMoveHorizontal(chessBoard, line, column, toLine, toColumn) == true)
            return true;
        else if (canMoveVertical(chessBoard, line, column, toLine, toColumn) == true)
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
        if (chessBoard.board[toLine][toColumn] != null) {
            if (color.equals(chessBoard.board[toLine][toColumn].color))
                return false;
            else
                return true;
        } else
            return false;
    }

    private boolean canMoveDiagonal(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean canMove = true;
        if ((Math.abs(toLine - line)) == (Math.abs(toColumn - column))) { //проверка, ходит ли фигура по диагонали
            if (chessBoard.board[toLine][toColumn] == null || canEat(chessBoard, toLine, toColumn)) { // проверка, что поле назначения пустое или там стоит фигура, которую можно съесть
                if (toLine < line && toColumn < column) { // проверка, можно ли двигаться по диагонали вниз и влево
                    for (int i = 1; i < (line - toLine); i++) {
                        if (chessBoard.board[line - i][column - i] == null)
                            canMove = true;
                        else
                            canMove = false;
                    }
                } else if (toLine < line && toColumn > column) { // проверка, можно ли двигаться по диагонали вниз и вправо
                    for (int i = 1; i < (line - toLine); i++) {
                        if (chessBoard.board[line - i][column + i] == null)
                            canMove = true;
                        else
                            canMove = false;
                    }
                } else if (toLine > line && toColumn < column) { // проверка, можно ли двигаться по диагонали вверх и влево
                    for (int i = 1; i < (toLine - line); i++) {
                        if (chessBoard.board[line + i][column - i] == null)
                            canMove = true;
                        else
                            canMove = false;
                    }
                } else {
                    for (int i = 1; i < (toLine - line); i++) { // проверка, можно ли двигаться по диагонали вверх и вправо
                        if (chessBoard.board[line + i][column + i] == null)
                            canMove = true;
                        else
                            canMove = false;
                    }
                }
            } else
                canMove = false;
        } else
            canMove = false;
        return canMove;
    }

    private boolean canMoveHorizontal(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean canMove = true;
        if ((toLine == line) && (toColumn < column)) {
            for (int i = column - 1; i >= toColumn; i--) {
                if (i == toColumn) {
                    if ((chessBoard.board[toLine][toColumn] == null) || canEat(chessBoard, toLine, toColumn)) //проверка, можно ли съесть фигуру в поле назначения
                        canMove = true;
                    else
                        canMove = false;
                    break;
                } else if (chessBoard.board[line][i] == null)
                    canMove = true;
                else {
                    canMove = false;
                    break;
                }
            }
        } // проверка можно ли двигаться влево
        else if ((toLine == line) && (toColumn > column)) {
            for (int i = column + 1; i <= toColumn; i++) {
                if (i == toColumn) {
                    if ((chessBoard.board[toLine][toColumn] == null) || canEat(chessBoard, toLine, toColumn)) //проверка, можно ли съесть фигуру в поле назначения
                        canMove = true;
                    else
                        canMove = false;
                    break;
                } else if (chessBoard.board[line][i] == null)
                    canMove = true;
                else {
                    canMove = false;
                    break;
                }
            }
        } // проверка можно ли двигаться вправо
        else
            canMove = false;
        return canMove;
    }

    private boolean canMoveVertical(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean canMove = true;
        if ((toColumn == column) && (toLine < line)) {
            for (int i = line - 1; i >= toLine; i--) {
                if (i == toLine) {
                    if ((chessBoard.board[toLine][toColumn] == null) || canEat(chessBoard, toLine, toColumn)) //проверка, можно ли съесть фигуру в поле назначения
                        canMove = true;
                    else
                        canMove = false;
                    break;
                } else if (chessBoard.board[i][toColumn] == null)
                    canMove = true;

                else {
                    canMove = false;
                    break;
                }
            }
        } // проверка можно ли двигаться вниз
        else if ((toColumn == column) && (toLine > line)) {
            for (int i = line + 1; i <= toLine; i++) {
                if (i == toLine) {
                    if ((chessBoard.board[toLine][toColumn] == null) || canEat(chessBoard, toLine, toColumn)) //проверка, можно ли съесть фигуру в поле назначения
                        canMove = true;
                    else
                        canMove = false;
                    break;
                } else if (chessBoard.board[i][toColumn] == null)
                    canMove = true;
                else {
                    canMove = false;
                    break;
                }
            }
        } // проверка можно ли двигаться вверх
        else
            canMove = false;
        return canMove;
    }

}
