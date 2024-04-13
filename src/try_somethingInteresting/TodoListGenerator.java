package try_somethingInteresting;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TodoListGenerator {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2024, 4, 13);
        LocalDate endDate = LocalDate.of(2024, 11, 1);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        int startNumber = 1;
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            int endNumber = startNumber + 4;
            System.out.printf("- [ ] %s %d ~ %d\n", date.format(dateFormatter), startNumber, endNumber);
            startNumber += 5;
        }
    }
}
