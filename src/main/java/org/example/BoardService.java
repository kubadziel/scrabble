package org.example;

import java.util.List;

public interface BoardService {
    int addWord (int row, int col, boolean isHorizontal, List<Letter> letters);

}
