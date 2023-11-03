package edu.iastate.cs228.hw1;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

/**
 * @author <<Steven Bui>>
 *
 *         The ISPBusiness class performs simulation over a grid plain with
 *         cells occupied by different TownCell types.
 *
 */
public class ISPBusiness {

	/**
	 * Returns a new Town object with updated grid value for next billing cycle.
	 * 
	 * @param tOld: old/current Town object.
	 * @return: New town object.
	 */
	public static Town updatePlain(Town tOld) {
		Town tNew = new Town(tOld.getLength(), tOld.getWidth());
		// TODO: Write your code here.
		// nested for loop to iterate through the first town and into the new one.
		for (int i = 0; i < tOld.getWidth(); i++) {
			for (int j = 0; j < tOld.getLength(); j++) {
				tNew.grid[i][j] = tOld.grid[i][j].next(tNew);
			}
		}
		return tNew;
	}

	/**
	 * Returns the profit for the current state in the town grid.
	 * 
	 * @param town
	 * @return
	 */
	public static int getProfit(Town town) {
		// TODO: Write/update your code here.
		int casual = 0;
		// double for loop to find all number of CASUAL

		for (int x = 0; x < town.getWidth(); x++) {
			for (int y = 0; y < town.getLength(); y++) {
				if (town.grid[x][y].who() == State.CASUAL) {
					casual += 1;
				}
			}
		}

		return casual;
	}

	/**
	 * Main method. Interact with the user and ask if user wants to specify elements
	 * of grid via an input file (option: 1) or wants to generate it randomly
	 * (option: 2).
	 * 
	 * Depending on the user choice, create the Town object using respective
	 * constructor and if user choice is to populate it randomly, then populate the
	 * grid here.
	 * 
	 * Finally: For 12 billing cycle calculate the profit and update town object
	 * (for each cycle). Print the final profit in terms of %. You should print the
	 * profit percentage with two digits after the decimal point: Example if profit
	 * is 35.5600004, your output should be:
	 *
	 * 35.56%
	 * 
	 * Note that this method does not throw any exception, so you need to handle all
	 * the exceptions in it.
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		// TODO: Write your code here.
		int input;
		double Money;
		final int year = 12;

		Scanner scnr = new Scanner(System.in);

		// ask user for a file search or random generation
		System.out.println("1. For file search 2. For random seed population");
		input = scnr.nextInt();
		Town town = null;

		if (input == 1) {
			String filePath = "";
			try {

				// asks for file path
				System.out.println("Enter the file name:");
				scnr.nextLine();
				filePath = scnr.nextLine();

				File file = new File(filePath);
				town = new Town(filePath);
			} catch (FileNotFoundException e) {
				System.out.println("Bad input for file name: " + e.toString());
			}

		}

		if (input == 2) {
			// ask for rows cols for the random generation
			int seed;
			int row;
			int col;
			System.out.println("Row, Col, and Seed for random generation");
			row = scnr.nextInt();
			col = scnr.nextInt();
			seed = scnr.nextInt();
			town = new Town(row, col);

			town.randomInit(seed);

		}

		double profit = 0.0;

		for (int m = 0; m < 12; m++) {

			// update profit every m
			profit += (getProfit(town) / ((double) town.getWidth() * (double) town.getLength())) * 100;
			town = updatePlain(town);

		}
		profit = profit / 12;

		// prints Profit
		System.out.printf("%.2f%c", profit, '%');

	}

}
