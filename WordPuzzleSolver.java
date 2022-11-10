package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import hash.HashTable;

public class WordPuzzleSolver {

	public static void main(String[] args) {
		
		/* Kick everything off by calling solve() */
		try {
			Scanner in = new Scanner(System.in);
			//String dicFile = in.next();
			//String gridFile = in.next();
			in.close();
			new WordPuzzleSolver().solve("input/words.txt", "input/250x250.grid.txt");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/* Solve the puzzle */
	private void solve(String dictFile, String gridFile) throws IOException {
			
		/* Implement this method. Open the files and solve the word puzzle!! */
		HashTable <String,String> dictionary = new HashTable <String,String>();
		BufferedReader dict = new BufferedReader(new FileReader(dictFile));
		BufferedReader gridline = new BufferedReader(new FileReader(gridFile));
		
		int t1 = (int) System.currentTimeMillis();
		String word = dict.readLine();
		
		while(word != null) {
			dictionary.insert(word, word);
			//if(word.hashCode() == 104976) {
				//System.out.println(word);
			//}
			word = dict.readLine();
		}
		//System.out.println(("jag".hashCode()));
		//System.out.println(dictionary.contains("jag"));
		dict.close();
		
		int rows = Integer.parseInt(gridline.readLine());
		int cols = Integer.parseInt(gridline.readLine());
		char [][] grid = new char [rows] [cols];
		String letters = gridline.readLine();
		gridline.close();
		
		int k = 0;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				grid[i][j] = letters.charAt(k);
				k++;
			}
		}
		int max = Math.max(rows, cols);
		String gridString;
		//System.out.println(max);
		if(max > 22) {
			max = 22;
		}
		int numWords = 0;
		for(int col = 0; col < cols; col++) {
			for(int row = 0; row < rows; row++) {
				for(int direct = 0; direct <= 7; direct++) {
					for(int length = 3; length <= max; length++) {
						gridString = getString(row, col, direct, length, grid);
						if(gridString != "" && dictionary.contains(gridString)) {
							//System.out.println("valid word: " + gridString);
							numWords++;
						}
					}

				}
			}
		}
		System.out.println(numWords + " words found");
		System.out.println("Time = " + (((int) System.currentTimeMillis()) - t1));
		System.out.println(dictionary.Collisions());
		
	}
	
	private String getString(int row, int col, int direction, int length, char[][] grid) {
		String charSequence ="";
		// 0 = north, 1 = north east, 2 = east, 3 = southeast, 4 south
		//5 = south west, 6 = west, 7 = northwest
		
			switch (direction) {
				case 0:
					if(row + 1 >= length) {
						for(int i = 0; i < length; i++) {
							charSequence = charSequence + grid[row][col];
							row--;
						}
						//System.out.println(charSequence);
						return charSequence;
					}
					return "";
				case 1:
					if(row + 1 >= length && grid[0].length - col >= length) {
						for(int i = 0; i < length; i++) {
							charSequence = charSequence + grid[row][col];
							row--;
							col++;
						}
						//System.out.println(charSequence);
						return charSequence;
					}
					return "";
				case 2:
					if(grid[0].length - col >= length) {
						for(int i = 0; i < length; i++) {
							charSequence = charSequence + grid[row][col];
							col++;
						}
						//System.out.println(charSequence);
						return charSequence;
					}
					return "";
				case 3:
					if(grid.length - row >= length && grid[0].length - col >= length) {
						for(int i = 0; i < length; i++) {
							charSequence = charSequence + grid[row][col];
							col++;
							row++;
						}
						//System.out.println(charSequence);
						return charSequence;
					}
					return "";
				case 4:
					if(grid.length - row >= length) {
						for(int i = 0; i < length; i++) {
							charSequence = charSequence + grid[row][col];
							row++;
						}
						//System.out.println(charSequence);
						return charSequence;
					}
					return "";
				case 5:
					if(grid.length - row >= length && col + 1 >= length) {
						for(int i = 0; i < length; i++) {
							charSequence = charSequence + grid[row][col];
							row++;
							col--;
						}
						//System.out.println(charSequence);
						return charSequence;
					}
					return "";
				case 6:
					if(col + 1 >= length) {
						for(int i = 0; i < length; i++) {
							charSequence = charSequence + grid[row][col];
							col--;
						}
						//System.out.println(charSequence);
						return charSequence;
					}
					return "";
				case 7:
					if(col + 1 >= length && row + 1 >= length) {
						for(int i = 0; i < length; i++) {
							charSequence = charSequence + grid[row][col];
							row--;
							col--;
						}
						//System.out.println(charSequence);
						return charSequence;
					}
					return "";
			}
			return "";
		
		
	}
	
	
}
