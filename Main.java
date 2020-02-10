package ascii_art;

import java.util.Scanner;


public class Main {

    public static void main(String [] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        Picture picture = null;

        do{
            String path = "/home/xeno/xWs/Java/ascii-art/src/ascii_art/img/";
            System.out.print("Enter the name of image file: ");
            String name = scanner.nextLine();
            path += name;
            ImageParser imageParser = new ImageParser(path);
            picture = imageParser.getPicture();

        } while (picture == null);


        boolean correctDecision;
        do {
            System.out.println("Chose one option:\n" +
                    "1) 'a' for animate\n" +
                    "2) 'p' for print");
            String decision = scanner.next();
            if (decision.equals("a")){
                picture.animate();
                correctDecision = true;
            }
            else if (decision.equals("p")){
                System.out.println(picture.toString());
                correctDecision = true;
            }
            else{
                System.err.println("\nIncorrect input.");
                System.out.println("Try one more time\n");
                correctDecision = false;
            }
        } while(!correctDecision);
    }
}
