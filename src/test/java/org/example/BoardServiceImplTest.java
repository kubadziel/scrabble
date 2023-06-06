package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class BoardServiceImplTest {
    //TODO - add the same tests for columns

    @Test
    void shouldThrowExceptionWhenWordStartingPointIsOutsideOfBoardHorizontally(){
        BoardService boardService = new BoardServiceImpl();

        assertThrows(OutOfBoardException.class, () -> boardService.addWord(100, 1, true, Collections.emptyList()));
    }

    @Test
    void shouldThrowExceptionWhenWordExceedsTheBoardHorizontally(){
        BoardService boardService = new BoardServiceImpl();

        assertThrows(OutOfBoardException.class, () -> boardService.addWord(14, 1, true, Arrays.asList(new Letter(), new Letter())));
    }

    //Add the same for columns

    @Test
    void shouldThrowExceptionWhenOneLetterInOccupiedPosition(){
        BoardService boardService = new BoardServiceImpl();

        boardService.addWord(10, 1, true, Arrays.asList(new Letter(), new Letter()));

        assertThrows(OccupiedPositionException.class, () -> boardService.addWord(11, 1, true, Arrays.asList(new Letter())));
    }

    @Test
    void shouldAllowAddingWordWithMatchingLetter(){
        BoardService boardService = new BoardServiceImpl();

        Letter letter = new Letter();
        boardService.addWord(10, 1, true, Arrays.asList(new Letter(), letter));

        assertDoesNotThrow(() -> boardService.addWord(11, 1, true, Arrays.asList(letter)));
    }

    @Test
    void shouldAllowAddingWordWithMatchingLetter2(){
        BoardService boardService = new BoardServiceImpl();

        Letter letter = new Letter();
        boardService.addWord(10, 1, true, Arrays.asList(letter, new Letter()));

        assertDoesNotThrow(() -> boardService.addWord(9, 1, true, Arrays.asList(new Letter(), letter)));
    }

    @Test
    void shouldThrowExceptionWhenWordIsInOccupiedPosition(){
        BoardService boardService = new BoardServiceImpl();

        Letter letter = new Letter();
        boardService.addWord(10, 1, true, Arrays.asList(letter, new Letter()));

        OccupiedPositionException exception = assertThrows(OccupiedPositionException.class, () -> boardService.addWord(9, 1, true, Arrays.asList(new Letter(), new Letter())));

        assertEquals(1,exception.col);
        assertEquals(10,exception.row);
    }
}