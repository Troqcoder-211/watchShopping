import java.util.Scanner;

import function.GeneralFunction;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		GeneralFunction.createDataDir();
		// GeneralFunction.register(scanner);
		GeneralFunction.login(scanner);
	}

}
