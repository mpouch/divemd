package org.mpouch.ui.config;

import java.util.Scanner;

public class AppConfig {
	static String workDirectory;
	
    public static String getWorkdir() {
        return workDirectory;
    }
	
	// Set testing working directory here
	public static void setWorkdir() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the work directory: ");
		String input = scan.nextLine();
		scan.close();
		workDirectory = input;
	}

}
