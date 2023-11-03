package edu.iastate.cs228.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author <<Steven Bui>>
 *
 */
public class Town {

	private int length, width; // Row and col (first and second indices)
	public TownCell[][] grid;

	/**
	 * Constructor to be used when user wants to generate grid randomly, with the
	 * given seed. This constructor does not populate each cell of the grid (but
	 * should assign a 2D array to it).
	 * 
	 * @param length
	 * @param width
	 */
	public Town(int length, int width) {
		// TODO: Write your code here.
		this.length = length;
		this.width = width;
		grid = new TownCell[width][length];
	}

	/**
	 * Constructor to be used when user wants to populate grid based on a file.
	 * Please see that it simple throws FileNotFoundException exception instead of
	 * catching it. Ensure that you close any resources (like file or scanner) which
	 * is opened in this function.
	 * 
	 * @param inputFileName
	 * @throws FileNotFoundException
	 */
	public Town(String inputFileName) throws FileNotFoundException {

		try {
			File f = new File(inputFileName);
			Scanner in = new Scanner(f);
			int length = in.nextInt();
			int width = in.nextInt();
			this.length = length;
			this.width = width;
			grid = new TownCell[length][width];
			in.nextLine();

			while (in.hasNextLine()) {

				for (int i = 0; i < length; i++) {
					String[] array = in.nextLine().split(" ");
					for (int j = 0; j < array.length; j++) {
						if (array[j] == "R") {
							grid[i][j] = new Reseller(this, i, j);
							break;
						} else if (array[j] == "E") {
							grid[i][j] = new Empty(this, i, j);
							break;
						} else if (array[j] == "C") {
							grid[i][j] = new Casual(this, i, j);
							break;
						} else if (array[j] == "E") {
							grid[i][j] = new Outage(this, i, j);
							break;
						} else if (array[j] == "") {
							grid[i][j] = new Streamer(this, i, j);
							break;
						} else if (array[j] == "R\t") {
							grid[i][j] = new Reseller(this, i, j);
							break;
						} else if (array[j] == "E\t") {
							grid[i][j] = new Empty(this, i, j);
							break;
						} else if (array[j] == "C\t") {
							grid[i][j] = new Casual(this, i, j);
							break;
						} else if (array[j] == "O\t") {
							grid[i][j] = new Outage(this, i, j);
							break;
						} else if (array[j] == "S\t") {
							grid[i][j] = new Streamer(this, i, j);
							break;

						}
					}
				}

			}
			in.close();

		} catch (FileNotFoundException e) {
			System.out.println("Bad input for file path");
		}
	}

	/**
	 * Returns width of the grid.
	 * 
	 * @return
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Returns length of the grid.
	 * 
	 * @return
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Initialize the grid by randomly assigning cell with one of the following
	 * class object: Casual, Empty, Outage, Reseller OR Streamer
	 */
	public void randomInit(int seed) {
		Random rand = new Random(seed);
		// TODO: Write your code here.

		// double for loop and a switch statement with cases of STATE to create a new
		// object
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < length; y++) {
				int randomValue = rand.nextInt(5);
				switch (randomValue) {
				case TownCell.CASUAL:
					grid[x][y] = new Casual(this, x, y);
					break;

				case TownCell.STREAMER:
					grid[x][y] = new Streamer(this, x, y);
					break;

				case TownCell.RESELLER:
					grid[x][y] = new Reseller(this, x, y);
					break;

				case TownCell.EMPTY:
					grid[x][y] = new Empty(this, x, y);
					break;

				case TownCell.OUTAGE:
					grid[x][y] = new Outage(this, x, y);
					break;
				}
			}
		}

	}

	/**
	 * Output the town grid. For each square, output the first letter of the cell
	 * type. Each letter should be separated either by a single space or a tab. And
	 * each row should be in a new line. There should not be any extra line between
	 * the rows.
	 */
	@Override
	public String toString() {
		String s = "";
		// TODO: Write your code here.
		// nested for loop, grid.who.toString.charAt(0)
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < length; j++) {
				// s += this.grid[x][y].who().toString().charAt(0) + " ";
				s += grid[i][j].who().toString().charAt(0) + " ";
			}
			s += "\n";

		}

		return s;
	}

}
