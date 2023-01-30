import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Server {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Server Started, please wait for few seconds..");

            Processor p1 = new Processor(1001, 1);
            p1.start();

            Processor p2 = new Processor(1002, 3);
            p2.start();

            Processor p3 = new Processor(1003, 2);
            p3.start();

            Processor p4 = new Processor(1004, 1);
            p4.start();

            TimeUnit.SECONDS.sleep(5);
            System.out.println("Enter the number of random events to be genereated:");
            int number = scanner.nextInt();

            for (int i = 1; i <= number; i++) {
                Random ran = new Random();
                int from = ran.nextInt(4) + 1001;
                int to = ran.nextInt(4) + 1001;

                switch (from) {
                    case 1001:
                        p1.sendMessage();
                        break;
                    case 1002:
                        p2.sendMessage();
                        break;
                    case 1003:
                        p3.sendMessage();
                        break;
                    case 1004:
                        p4.sendMessage();
                        break;
                    default:
                        break;
                }

                Event event = new Event(
                    from == 1001 ? p1.getId() : (from == 1002 ? p2.getId() : (from == 1003 ? p3.getId() : p4.getId())), 
                    to == 1001 ? p1.getId() : (to == 1002 ? p2.getId() : (to == 1003 ? p3.getId() : p4.getId())),
                    from == 1001 ? p1.getCurrentTimeStamp() : (from == 1002 ? p2.getCurrentTimeStamp() : (from == 1003 ? p3.getCurrentTimeStamp() : p4.getCurrentTimeStamp()))
                    );

                switch (to) {
                    case 1001:
                        p1.receiveMessage(event);
                        break;
                    case 1002:
                        p2.receiveMessage(event);
                        break;
                    case 1003:
                        p3.receiveMessage(event);
                        break;
                    case 1004:
                        p4.receiveMessage(event);
                        break;
                    default:
                        break;
                }
                event.PrintEvent(event);
            }

            p1.printTimeStamps();
            p2.printTimeStamps();
            p3.printTimeStamps();
            p4.printTimeStamps();

        } catch (Exception ex) {
            System.out.println("Server error: " + ex.getMessage());
        }
    }
}