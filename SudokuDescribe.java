package Sudoku;

public class SudokuDescribe implements SudokuSolver {
	private int[][] matrix;
	
	public SudokuDescribe() {
		this.matrix = new int[9][9];
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				matrix[r][c] = 0;
			}
		}
	}
	
	public boolean solve() {
		return solve(0, 0);
	}
	
	private boolean solve(int r, int c) {
		if (r == 9) {
			return true;
		}
		if (get(r, c) == 0) {
			for (int i = 1; i <= 9; i++) {
				set(r, c, i);
					if (isValid(r, c)) {
						if (c == 8) {
							if (solve(r+1, 0)) {
		                        return true;
		                    }
						} else {
							if (solve(r, c+1)) {
		                        return true;
		                    }
						}
					}
					clear(r, c);
			}
			return false;
		} else {
			if (isValid(r, c)) {
				if (c == 8) {
					return solve(r+1, 0);
				} else {
					return solve(r, c+1);
				}

			} else {
				return false;
			}
		}
	}
	
	public void set(int r, int c, int digit) {
		if (r < 0 || r > 8) {
			throw new IllegalArgumentException();
		}
		if (c < 0 || c > 8) {
			throw new IllegalArgumentException();
		}
		matrix[r][c] = digit;
	}
	
	public int get(int r, int c) {
		if (r < 0 || r > 8) {
			throw new IllegalArgumentException();
		}
		if (c < 0 || c > 8) {
			throw new IllegalArgumentException();
		}
		return matrix[r][c];
	}
	
	public void clear(int r, int c) {
		if (r < 0 || r > 8) {
			throw new IllegalArgumentException();
		}
		if (c < 0 || c > 8) {
			throw new IllegalArgumentException();
		}
		set(r, c, 0);
	}
	
	public void clearAll() {
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				set(r, c, 0);
			}
		}
	}
	
	public boolean isValid(int r, int c) {
		if (r < 0 || r > 8) {
			throw new IllegalArgumentException();
		}
		if (c < 0 || c > 8) {
			throw new IllegalArgumentException();
		}
		
		int n = get(r, c);
		
		int rStart = (r/3)*3;
		int rEnd = rStart +3;
		
		int cStart = (c/3)*3;
		int cEnd = cStart + 3;
		
		for (int r1 = rStart; r1 < rEnd; r1++) {
			for (int c1 = cStart; c1 < cEnd; c1++) {
				if (r1 != r || c1 != c) {
					if (get(r1, c1) == n) {
					return false;
					}
				}
		    }
		}
		
		for (int r1 = 0; r1 < 9; r1++) {
				if (r1 != r && get(r1, c) == n) {
					return false;
				}
		}
	
		for (int c1 = 0; c1 < 9; c1++) {
			if (c1 != c && get(r, c1) == n) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean isAllValid() {
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				if(!isValid(r, c)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void setGrid(int[][] m) {
		if (m.length != 9) {
			throw new IllegalArgumentException();
		}
		if (m[0].length != 9) {
			throw new IllegalArgumentException();
		}
		matrix = m;
	}
	
	public int[][] getGrid() {
		int[][] m = new int[9][9];
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				m[r][c] = get(r, c);			}
		}
		return m;
	}
	
}