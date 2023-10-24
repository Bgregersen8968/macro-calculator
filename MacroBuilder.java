import java.util.Scanner;
import java.text.*;

class MacroBuilder {
	static DecimalFormat df = new DecimalFormat("0");

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// Prompt user for the info and set to the corresponding variables.
		System.out.println("Ready to start your journey to better eating habits?\n"
				+ "Fill out the information below to get your personal macro plan!" + "\n Please Enter your name: ");
		String user = in.next();
		System.out.print("WELCOME " + user + "! \nPlease enter your weight in pounds: ");
		double weight = in.nextDouble();
		System.out.print("Please enter your height in inches: ");
		double height = in.nextDouble();
		System.out.print("Please enter your age in years: ");
		double age = in.nextDouble();
		System.out.print("Please enter your gender\nEnter Male, or Female: ");
		String gender = in.next();
		System.out.print(
				"Would you like to lose weight(1), gain weight(2), or maintain(3) your weight?" + "\n Enter digit:  ");
		int goal = in.nextInt();

		// Create object with values described.
		MacroUser userObj = new MacroUser(gender, weight, height, age, goal);
		userObj.setBMR();
		userObj.setTdee();
		userObj.setGoalCal();
		userObj.setGoalProtein();
		userObj.setGoalCarb();
		userObj.setGoalFat();
		// set macros to user macros
		double tdee = userObj.getBMR() * 1.2;
		double goalcal = userObj.getgoalcal();
		double goalprotein = userObj.getgoalprotein();
		double goalcarb = userObj.getgoalcarb();
		double goalfat = userObj.getgoalfat();

		// display daily macros
		String[] feedtimes = feedtimes(userObj, goalprotein, goalfat, goalcarb);
		System.out.println(
				"\n\nBased on your results, your daily caloric intake should be: " + df.format(goalcal) + " K/cals");
		System.out.print("Your daily macro count will be as follows:" + " \n Protein: " + df.format(goalprotein)
				+ " grams\n Carb: " + df.format(goalcarb) + " grams" + "\n Fat: " + df.format(goalfat) + " grams\n\n");
		System.out.println(
				"For optimal performance, we suggest eating six meals a day at the following" + " macros per meal:");
		for (int i = 0; i < feedtimes.length; i++) {
			System.out.println(feedtimes[i]);
		}
	}

	public static String[] feedtimes(MacroUser userObj, double goalprotein, double goalfat, double goalcarb) {
		// create array for hours of the day to eat
		String[] feedtimes = new String[6];
		final double tempProtein = goalprotein;
		final double tempCarbs = goalcarb;
		final double tempFat = goalfat;

		// calculate macros per meal and display
		goalprotein = (goalprotein * .14) / 100 * 100;
		goalcarb = (goalcarb * .25);
		goalfat = (goalfat * .2);
		feedtimes[0] = "Between 7 A.M. and 9 A.M. eat:\n" + df.format(goalprotein) + " grams of protein\n"
				+ df.format(goalcarb) + " grams of carbs\n" + df.format(goalfat) + " grams of fat\n";
		goalprotein = tempProtein;
		goalcarb = tempCarbs;
		goalfat = tempFat;
		goalprotein = (goalprotein * .15);
		goalcarb = (goalcarb * .25);
		goalfat = (goalfat * .2);
		feedtimes[1] = "Between 9 A.M. and 11 A.M. eat:\n" + df.format(goalprotein) + " grams of protein\n"
				+ df.format(goalcarb) + " grams of carbs\n" + df.format(goalfat) + " grams of fat\n";
		goalprotein = tempProtein;
		goalcarb = tempCarbs;
		goalfat = tempFat;
		goalprotein = (goalprotein * .16);
		goalcarb = (goalcarb * .25);
		goalfat = (goalfat * .2);
		feedtimes[2] = "Between 11 A.M. and 1 P.M. eat:\n" + df.format(goalprotein) + " grams of protein\n"
				+ df.format(goalcarb) + " grams of carbs\n" + df.format(goalfat) + " grams of fat\n";
		goalprotein = tempProtein;
		goalcarb = tempCarbs;
		goalfat = tempFat;
		goalprotein = (goalprotein * .17);
		goalcarb = (goalcarb * .15);
		goalfat = (goalfat * .2);
		feedtimes[3] = "Between 1 P.M. and 3 P.M. eat:\n" + df.format(goalprotein) + "grams of protein\n"
				+ df.format(goalcarb) + " grams of carbs\n" + df.format(goalfat) + " grams of fat\n";
		goalprotein = tempProtein;
		goalcarb = tempCarbs;
		goalfat = tempFat;
		goalprotein = (goalprotein * .18);
		goalcarb = (goalcarb * .1);
		goalfat = (goalfat * .1);
		feedtimes[4] = "Between 3 P.M. and 5 P.M. eat:\n" + df.format(goalprotein) + " grams of protein\n"
				+ df.format(goalcarb) + " grams of carbs\n" + df.format(goalfat) + " grams of fat\n";
		goalprotein = tempProtein;
		goalcarb = tempCarbs;
		goalfat = tempFat;
		goalprotein = (goalprotein * .2);
		goalcarb = (goalcarb * .1);
		goalfat = (goalfat * .1);
		feedtimes[5] = "Between 5 P.M. and 7 P.M. eat:\n" + df.format(goalprotein) + " grams of protein\n"
				+ df.format(goalcarb) + " grams of carbs\n" + df.format(goalfat) + " grams of fat\n";
		return feedtimes;
	}
}
