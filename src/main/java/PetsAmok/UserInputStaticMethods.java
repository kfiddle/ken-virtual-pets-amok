package PetsAmok;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UserInputStaticMethods {
    Scanner input = new Scanner(System.in);

    public static void exitGame() {
        System.out.println("Thanks for playing. See ya!");
        System.exit(0);
    }

    public static String capitalize(String name) {
        String firstLetter = name.substring(0, 1);
        String remainder = name.substring(1);

        String caps = firstLetter.toUpperCase();
        String remainderToLower = remainder.toLowerCase();
        String capitalizedName = caps + remainderToLower;

        return capitalizedName;
    }

    public static boolean twoOptionVerify(String one, String two) {
        Scanner input = new Scanner(System.in);
        while (true) {
            String reply = (input.nextLine().toLowerCase());
            if (reply.equals(one)) {
                return true;
            } else if (reply.toLowerCase().equals(two)) {
                return false;
            } else {
                System.out.println("I didn't quite catch that. " + one + " or " + two + "please.");
            }
        }
    }


    public static int validInteger(int range) {
        Scanner input = new Scanner(System.in);
        int response = 0;
        while (!input.hasNextInt()) {
            System.out.println("come on now...just a number.");
            response = input.nextInt();
        }
        response = input.nextInt();

        while (response > range) {
            System.out.println("nice try. That's not an option I can deal with.");
            response = input.nextInt();
        }
        return response;
    }

    static void displayTime(int tickCounter) {
        String[] times = new String[]{"9:00", "10:00", "11:00", "noon", "1:00", "2:00", "3:00", "4:00", "5:00"};
        System.out.println("                                " + times[tickCounter]);
    }


}





