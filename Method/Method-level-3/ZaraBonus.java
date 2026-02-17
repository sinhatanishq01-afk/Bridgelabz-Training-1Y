public class ZaraBonus {

    public static void main(String[] args) {

        double[][] empData = generateEmployeeData(10);
        double[][] newData = calculateNewSalary(empData);

        displayTotals(empData, newData);
    }

    // b. Generate salary and years of service
    static double[][] generateEmployeeData(int size) {

        double[][] data = new double[size][2];

        for (int i = 0; i < size; i++) {
            data[i][0] = (int)(Math.random() * 90000) + 10000; // salary
            data[i][1] = (int)(Math.random() * 10) + 1;       // years
        }

        return data;
    }

    // c. Calculate new salary and bonus
    static double[][] calculateNewSalary(double[][] data) {

        double[][] result = new double[data.length][2];

        for (int i = 0; i < data.length; i++) {

            double salary = data[i][0];
            double years = data[i][1];
            double bonus;

            if (years > 5)
                bonus = salary * 0.05;
            else
                bonus = salary * 0.02;

            result[i][0] = salary + bonus; // new salary
            result[i][1] = bonus;          // bonus
        }

        return result;
    }

    // d. Display totals
    static void displayTotals(double[][] oldData, double[][] newData) {

        double oldSum = 0, newSum = 0, bonusSum = 0;

        System.out.println("Emp\tOldSal\tYears\tBonus\tNewSal");

        for (int i = 0; i < oldData.length; i++) {

            System.out.println((i + 1) + "\t" +
                    oldData[i][0] + "\t" +
                    oldData[i][1] + "\t" +
                    newData[i][1] + "\t" +
                    newData[i][0]);

            oldSum += oldData[i][0];
            newSum += newData[i][0];
            bonusSum += newData[i][1];
        }

        System.out.println("\nTotal Old Salary: " + oldSum);
        System.out.println("Total Bonus Paid: " + bonusSum);
        System.out.println("Total New Salary: " + newSum);
    }
}
