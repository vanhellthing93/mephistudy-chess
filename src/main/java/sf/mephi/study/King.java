package sf.mephi.study;

public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (limitCheck(line, column, toLine, toColumn) == false)
            return false;
        else if (((Math.abs(toLine - line)) <= 1) && ((Math.abs(toColumn - column)) <= 1)) //проверка, что король двигается на одну клетку
            if ((chessBoard.board[toLine][toColumn] == null) && !isUnderAttack(chessBoard, toLine, toColumn)) // проверка, что клетка пустая и не под боем
                return true;
            else if (((chessBoard.board[toLine][toColumn] != null) && canEat(chessBoard, toLine, toColumn)) && !isUnderAttack(chessBoard, toLine, toColumn)) //проверка, что клетка не под боем, и король может съесть фигуру на ней
                return true;
            else
                return false;
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
        boolean underAttack = false;
        if (color.equals("White")) {
            for (int i = 0; i < 8; i++) {
                if (underAttack == true)
                    break;
                else {
                    for (int j = 0; j < 8; j++) {
                        if (board.board[i][j] != null && board.board[i][j].color.equals("Black") && board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                            underAttack = true;
                            break;
                        } else
                            underAttack = false;
                    }
                }
            }
            return underAttack;
        }
        if (color.equals("Black")) {
            for (int i = 0; i < 8; i++) {
                if (underAttack == true)
                    break;
                else {
                    for (int j = 0; j < 8; j++) {
                        if (board.board[i][j] != null && board.board[i][j].color.equals("White") && board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                            underAttack = true;
                            break;
                        } else
                            underAttack = false;
                    }
                }
            }
            return underAttack;
        } else
            return false;
    }

    private boolean canEat(ChessBoard chessBoard, int toLine, int toColumn) {
        if (color.equals("White") && chessBoard.board[toLine][toColumn].color.equals("Black"))
            return true;
        else if (color.equals("Black") && chessBoard.board[toLine][toColumn].color.equals("White"))
            return true;
        else
            return false;
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


}
