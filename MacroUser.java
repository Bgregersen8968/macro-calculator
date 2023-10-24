
public class MacroUser {

	private String user = "";
	private String gender = "";
	private double weight = 0;
	private double height = 0;
	private double age = 0;
	private int goal = 0;
	private double bmr = 0;
	private double tdee = 0;
	private double goalcal = 0;
	private double goalprotein = 0;
	private double goalcarb = 0;
	private double goalfat = 0;

	MacroUser() {
	}

	MacroUser( String gender, double weight, double height, double age, int goal) {
		this.gender = gender;
		this.weight = weight;
		this.height = height;
		this.age = age;
		this.goal = goal;
	}

//get&set input of user and calculate goal macros
	String getuser() {
		return this.user;
	}

	String getgender() {
		return this.gender;
	}

	double getweight() {
		return this.weight;
	}

	double getheight() {
		return this.height;
	}

	double getage() {
		return this.age;
	}

	double getBMR() {
		return this.bmr;
	}

	double getTdee() {
		return this.tdee;
	}

	double getgoalprotein() {
		return this.goalprotein;
	}

	double getgoalcal() {
		return this.goalcal;
	}

	double getgoalcarb() {
		return this.goalcarb;
	}

	double getgoalfat() {
		return this.goalfat;
	}

	int getgoal() {
		return this.goal;
	}

	void setUser(String user) {
		this.user = user;
	}

	void setGender(String gender) {
		this.gender = gender;
	}

	void setWeight(double weight) {
		this.weight = weight;
	}

	void setHeight(double height) {
		this.height = height;
	}

	void setAge(double age) {
		this.age = age;
	}

	void setGoal(int goal) {
		this.goal = goal;
	}

	void setBMR() {
		if (this.gender.equalsIgnoreCase("male")) {
			this.bmr = 655 + (4.35 * weight) + (4.7 * height) - (4.7 * age);
		} else if (this.gender.equalsIgnoreCase("female")) {
			this.bmr = 66 + (6.23 * weight) + (12.7 * height) - (6.8 * age);
		}
	}

	void setTdee() {
		this.tdee = this.bmr * 1.2;
	}

	void setGoalCal() {
		if (this.goal == 1) {
			this.goalcal = this.tdee * 0.8;
		} else if (goal == 2) {
			this.goalcal = this.tdee * 1.4;
		} else {
			this.goalcal = this.tdee;
		}
	}

	void setGoalProtein() {
		if (this.goal == 1) {
			this.goalprotein = (goalcal * 0.4) / 4;

		} else if (this.goal == 2) {
			this.goalprotein = (goalcal * 0.5) / 4;
		} else {
			this.goalprotein = (goalcal * 0.4) / 4;
		}
	}

	void setGoalCarb() {
		if (this.goal == 1) {
			this.goalcarb = (goalcal * 0.3) / 4;
		} else if (this.goal == 2) {
			this.goalcarb = (goalcal * 0.5) / 4;
		} else {
			this.goalcarb = (goalcal * 0.2) / 4;
		}
	}

	void setGoalFat() {
		switch (this.goal) {
		case 1:
			this.goalfat = (this.goalcal * 0.1) / 9;
		case 2:
			this.goalfat = (this.goalcal * 0.4) / 9;
		default:
			this.goalfat = (this.goalcal * 0.4) / 9;
		}
	}
}
