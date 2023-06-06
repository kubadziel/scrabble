package org.example;

import java.util.List;

public class BoardServiceImpl implements BoardService {

    final static int BOARD_SIZE = 15;
    Letter[][] board = new Letter[BOARD_SIZE][BOARD_SIZE];

    @Override
    public int addWord(int row, int col, boolean isHorizontal, List<Letter> letters) {

        if (row + letters.size() >= BOARD_SIZE) {
            throw new OutOfBoardException();
        }

        for (int i = 0; i < letters.size(); i++) {
            if (board[row + i][col] != null && letters.get(i) != board[row + i][col]) {
                throw new OccupiedPositionException(col, row + i);
            }
        }

        for (int i = 0; i < letters.size(); i++) {
            board[row + i][col] = letters.get(i);
        }

        return 0;
    }
}
