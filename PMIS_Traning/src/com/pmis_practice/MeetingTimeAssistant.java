package meetingtimeassistant.com;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MeetingTimeAssistant {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        DateTimeFormatter dateFormat =
                DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a");

        System.out.println("========== MEETING TIME ASSISTANT ==========");

        System.out.print("Enter meeting date (yyyy-MM-dd): ");
        LocalDate date = LocalDate.parse(sc.nextLine());

        System.out.print("Enter meeting time (HH:mm): ");
        LocalTime time = LocalTime.parse(sc.nextLine());

        System.out.print("Enter meeting duration in minutes: ");
        int duration = Integer.parseInt(sc.nextLine());

        LocalDateTime start = LocalDateTime.of(date, time);
        LocalDateTime end = start.plusMinutes(duration);

        int choice;

        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Display meeting date and time");
            System.out.println("2. Display meeting end time");
            System.out.println("3. Display meeting time in another zone");
            System.out.println("4. Check whether the meeting is in the future");
            System.out.println("5. Exit");

            System.out.print("\nEnter choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.println("Meeting date and time: "
                            + start.format(dateFormat));
                    break;

                case 2:
                    System.out.println("Meeting starts at: "
                            + start.format(dateFormat));
                    System.out.println("Meeting ends at:   "
                            + end.format(dateFormat));
                    break;

                case 3:
                    System.out.print("Enter time zone (e.g. America/New_York): ");
                    String zone = sc.nextLine();

                    try {
                        ZonedDateTime zonedStart = start
                                .atZone(ZoneId.of("Asia/Kolkata"))
                                .withZoneSameInstant(ZoneId.of(zone));

                        System.out.println("Meeting time in " + zone + ": "
                                + zonedStart.format(dateFormat));
                    } catch (DateTimeException e) {
                        System.out.println("Invalid time zone!");
                    }
                    break;

                case 4:
                    if (start.atZone(ZoneId.of("Asia/Kolkata"))
                            .isAfter(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")))) {
                        System.out.println("The meeting is in the future.");
                    } else {
                        System.out.println("The meeting is not in the future.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using Meeting Time Assistant!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);

        sc.close();

	}

}
