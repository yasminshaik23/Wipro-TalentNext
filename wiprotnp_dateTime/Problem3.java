import java.time.*;
import java.time.temporal.*;

public class Problem3 {
    public static void main(String[] args) {

        // Change this to your joining date
        LocalDate joiningDate = LocalDate.of(2023, 7, 15);

        LocalDate today = LocalDate.now();

        Period experience = Period.between(joiningDate, today);

        System.out.println("Experience:");
        System.out.println(experience.getYears() + " Years "
                + experience.getMonths() + " Months "
                + experience.getDays() + " Days");
    }
}