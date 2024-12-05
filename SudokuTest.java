package Sudoku;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SudokuTest {
	private SudokuSolver sudoku;

	@BeforeEach
	void setUp() {
		sudoku = new SudokuDescribe();
	}

	@AfterEach
	void tearDown() {
		sudoku = null;
	}

	@Test
	void SolveEmptySudoku() {
		assertTrue(sudoku.solve(), "Solve empty do not work");
	}
	
	@Test
	void SolveSudoku() {
		int[][] m1 = {
	            {0, 0, 8, 0, 0, 9, 0, 6, 2},
	            {0, 0, 0, 0, 0, 0, 0, 0, 5},
	            {1, 0, 2, 5, 0, 0, 0, 0, 0},
	            {0, 0, 0, 2, 1, 0, 0, 9, 0},
	            {0, 5, 0, 0, 0, 0, 6, 0, 0},
	            {6, 0, 0, 0, 0, 0, 0, 2, 8},
	            {4, 1, 0, 6, 0, 8, 0, 0, 0},
	            {8, 6, 0, 0, 3, 0, 1, 0, 0},
	            {0, 0, 0, 0, 0, 0, 4, 0, 0}
	        };
		int[][] easyPuzzle = {
			    {5, 3, 0, 0, 7, 0, 0, 0, 0},
			    {6, 0, 0, 1, 9, 5, 0, 0, 0},
			    {0, 9, 8, 0, 0, 0, 0, 6, 0},
			    {8, 0, 0, 0, 6, 0, 0, 0, 3},
			    {4, 0, 0, 8, 0, 3, 0, 0, 1},
			    {7, 0, 0, 0, 2, 0, 0, 0, 6},
			    {0, 6, 0, 0, 0, 0, 2, 8, 0},
			    {0, 0, 0, 4, 1, 9, 0, 0, 5},
			    {0, 0, 0, 0, 8, 0, 0, 7, 9}
			};
		int[][] hardPuzzle = {
			    {0, 0, 0, 0, 0, 0, 0, 0, 1},
			    {0, 0, 0, 0, 0, 0, 0, 7, 0},
			    {0, 0, 0, 0, 0, 0, 2, 0, 0},
			    {0, 0, 0, 2, 0, 0, 0, 0, 0},
			    {0, 0, 0, 0, 7, 0, 0, 0, 0},
			    {0, 0, 0, 0, 0, 1, 0, 0, 0},
			    {0, 0, 0, 0, 0, 0, 0, 0, 0},
			    {0, 0, 0, 0, 0, 0, 0, 0, 0},
			    {0, 0, 0, 0, 0, 0, 0, 0, 0}
			};
		int[][] veryHardPuzzle = {
			    {0, 0, 0, 0, 0, 0, 0, 0, 0},
			    {0, 0, 0, 0, 0, 0, 0, 0, 0},
			    {0, 0, 0, 0, 0, 0, 0, 0, 0},
			    {0, 0, 0, 0, 0, 0, 0, 0, 0},
			    {0, 0, 0, 0, 0, 0, 0, 0, 0},
			    {0, 0, 0, 0, 0, 0, 0, 0, 0},
			    {0, 0, 0, 0, 0, 0, 0, 0, 0},
			    {0, 0, 0, 0, 0, 0, 0, 0, 0},
			    {0, 0, 0, 0, 0, 0, 0, 0, 0}
			};
		sudoku.setGrid(m1);
		assertTrue(sudoku.solve(), "Solve not empty do not work");
		int[][] m1Solved = {
			    {5, 4, 8, 1, 7, 9, 3, 6, 2},
			    {3, 7, 6, 8, 2, 4, 9, 1, 5},
			    {1, 9, 2, 5, 6, 3, 8, 7, 4},
			    {7, 8, 4, 2, 1, 6, 5, 9, 3},
			    {2, 5, 9, 3, 8, 7, 6, 4, 1},
			    {6, 3, 1, 9, 4, 5, 7, 2, 8},
			    {4, 1, 5, 6, 9, 8, 2, 3, 7},
			    {8, 6, 7, 4, 3, 2, 1, 5, 9},
			    {9, 2, 3, 7, 5, 1, 4, 8, 6}
			};
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				assertEquals(sudoku.get(r, c), m1Solved[r][c], "Did not solve correctly");
			}
		}
		sudoku.setGrid(easyPuzzle);
		assertTrue(sudoku.solve(), "Solve not empty do not work");
		sudoku.setGrid(hardPuzzle);
		assertTrue(sudoku.solve(), "Solve not empty do not work");
		sudoku.setGrid(veryHardPuzzle);
		assertTrue(sudoku.solve(), "Solve not empty do not work");
		int[][] m2 = {
	            {0, 0, 8, 0, 0, 9, 0, 6, 2},
	            {0, 0, 0, 0, 9, 0, 0, 0, 5},
	            {1, 0, 2, 5, 0, 0, 0, 0, 0},
	            {0, 0, 0, 1, 1, 0, 0, 9, 0},
	            {0, 5, 0, 0, 0, 0, 6, 0, 0},
	            {6, 0, 0, 0, 0, 0, 0, 2, 9},
	            {4, 1, 0, 6, 0, 8, 0, 0, 0},
	            {8, 6, 0, 0, 3, 0, 1, 0, 0},
	            {0, 0, 0, 0, 0, 0, 4, 0, 0}
	        };
		sudoku.setGrid(m2);
		assertFalse(sudoku.solve(), "Solve not empty did work");
		int[][] m3 = new int[9][9];
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				m3[r][c] = 1;
			}
		}
		sudoku.setGrid(m3);
		assertFalse(sudoku.solve(), "Solve not empty did work");
	}
	
	@Test
	void setAndSetGridAndGet() {
		int[][] m = {
	            {0, 0, 8, 0, 0, 9, 0, 6, 2},
	            {0, 0, 0, 0, 0, 0, 0, 0, 5},
	            {1, 0, 2, 5, 0, 0, 0, 0, 0},
	            {0, 0, 0, 2, 1, 0, 0, 9, 0},
	            {0, 5, 0, 0, 0, 0, 6, 0, 0},
	            {6, 0, 0, 0, 0, 0, 0, 2, 8},
	            {4, 1, 0, 6, 0, 8, 0, 0, 0},
	            {8, 6, 0, 0, 3, 0, 1, 0, 0},
	            {0, 0, 0, 0, 0, 0, 4, 0, 0}
	        };
		sudoku.setGrid(m);
		int[][] m1 = sudoku.getGrid();
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				assertEquals(sudoku.get(r, c), m1[r][c], "Did not getGrid correctly");
			}
		}
		assertEquals(8, sudoku.get(0,2), "Did not get");
		assertThrows(IllegalArgumentException.class, () -> sudoku.get(0, 9));
		sudoku.set(0, 2, 0);
		assertEquals(0, sudoku.get(0,2), "Did not set right");
	}
	
	@Test
	void clearAndClearALl() {
		int[][] m = {
	            {0, 0, 8, 0, 0, 9, 0, 6, 2},
	            {0, 0, 0, 0, 0, 0, 0, 0, 5},
	            {1, 0, 2, 5, 0, 0, 0, 0, 0},
	            {0, 0, 0, 2, 1, 0, 0, 9, 0},
	            {0, 5, 0, 0, 0, 0, 6, 0, 0},
	            {6, 0, 0, 0, 0, 0, 0, 2, 8},
	            {4, 1, 0, 6, 0, 8, 0, 0, 0},
	            {8, 6, 0, 0, 3, 0, 1, 0, 0},
	            {0, 0, 0, 0, 0, 0, 4, 0, 0}
	        };
		sudoku.setGrid(m);
		sudoku.clear(0, 2);
		assertEquals(0, sudoku.get(0,2), "Did not Clear");
		sudoku.clearAll();
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				assertEquals(0, sudoku.get(r,c), "Did not ClearALl");
			}
		}
	}
	
	@Test
	void ValidAndAllValid() {
		int[][] m1 = {
	            {0, 0, 8, 0, 0, 9, 0, 6, 2},
	            {0, 0, 0, 0, 9, 0, 0, 0, 5},
	            {1, 0, 2, 5, 0, 0, 0, 0, 0},
	            {0, 0, 0, 2, 1, 0, 0, 9, 0},
	            {0, 5, 0, 0, 0, 0, 6, 0, 0},
	            {6, 0, 0, 0, 0, 0, 0, 2, 8},
	            {4, 1, 0, 6, 0, 8, 0, 0, 0},
	            {8, 6, 0, 0, 3, 0, 1, 0, 0},
	            {0, 0, 0, 0, 0, 0, 4, 0, 0}
	        };
		sudoku.setGrid(m1);
		assertFalse(sudoku.isValid(0,5), "Said valid but was not");
		int[][] m2 = {
	            {0, 0, 8, 0, 0, 9, 0, 6, 2},
	            {0, 0, 0, 0, 0, 0, 0, 0, 5},
	            {1, 0, 2, 5, 0, 0, 0, 0, 0},
	            {0, 0, 0, 2, 1, 0, 0, 9, 0},
	            {0, 5, 0, 0, 0, 0, 6, 0, 0},
	            {6, 0, 0, 0, 0, 0, 0, 2, 8},
	            {4, 1, 0, 6, 0, 8, 0, 0, 0},
	            {8, 6, 0, 0, 3, 0, 1, 0, 0},
	            {0, 0, 0, 0, 0, 0, 4, 0, 0}
	        };
		sudoku.setGrid(m2);
		assertTrue(sudoku.isValid(0,5), "Not valid before solved");
		sudoku.solve();
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				System.out.println(sudoku.get(r,c));
			}
		}
		int[][] m3 = {
			    {5, 4, 8, 1, 7, 9, 3, 6, 2},
			    {3, 7, 6, 8, 2, 4, 9, 1, 5},
			    {1, 9, 2, 5, 6, 3, 8, 7, 4},
			    {7, 8, 4, 2, 1, 6, 5, 9, 3},
			    {2, 5, 9, 3, 8, 7, 6, 4, 1},
			    {6, 3, 1, 9, 4, 5, 7, 2, 8},
			    {4, 1, 5, 6, 9, 8, 2, 3, 7},
			    {8, 6, 7, 4, 3, 2, 1, 5, 9},
			    {9, 2, 3, 7, 5, 1, 4, 8, 6}
			};
		sudoku.setGrid(m3);
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				assertTrue(sudoku.isValid(0,6), "Not valid");
			}
		}
		assertTrue(sudoku.isAllValid(), "Nor everything was valid");
	}

}

