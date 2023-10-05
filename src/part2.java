import java.util.Scanner;

class Swimmer {
    private String name;
    private int age;
    private String favoriteType;
    private int totalDistanceSwum;

    public Swimmer(String name, int age, String favoriteStroke, int totalDistanceSwum) {
        this.name = name;
        this.age = age;
        this.favoriteType = favoriteStroke;
        this.totalDistanceSwum = totalDistanceSwum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFavoriteType() {
        return favoriteType;
    }

    public void setFavoriteStroke(String favoriteStroke) {
        this.favoriteType = favoriteType;
    }

    public int getTotalDistanceSwum() {
        return totalDistanceSwum;
    }

    public void setTotalDistanceSwum(int totalDistanceSwum) {
        this.totalDistanceSwum = totalDistanceSwum;
    }

    public double calculateSpeed() {
        // Assuming time is in minutes and distance is in meters
        return totalDistanceSwum / 2.0; // Speed = Distance / Time
    }

    public void printDescription() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Favorite Type: " + favoriteType);
        System.out.println("Total Distance Swum: " + totalDistanceSwum + " meters");
        System.out.println("Swimming Speed: " + calculateSpeed() + " meters per minute");
    }
}

class SwimmerCollection {
    private int count;
    private Swimmer[] swimmers;

    public SwimmerCollection(int capacity) {
        count = 0;
        swimmers = new Swimmer[capacity];
    }

    public void add(Swimmer swimmer) {
        if (count < swimmers.length) {
            swimmers[count] = swimmer;
            count++;
            System.out.println("Swimmer added to the collection.");
        } else {
            System.out.println("The collection is full. Cannot add more swimmers.");
        }
    }

    public void printOne(int i) {
        if (i >= 0 && i < count) {
            swimmers[i].printDescription();
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            swimmers[i].printDescription();
        }
    }

    public void find(String name) {
        System.out.println("Swimmers with the name '" + name + "':");
        for (int i = 0; i < count; i++) {
            if (swimmers[i].getName().equalsIgnoreCase(name)) {
                swimmers[i].printDescription();
            }
        }
    }

    public void sort() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (swimmers[j].calculateSpeed() > swimmers[j + 1].calculateSpeed()) {
                    Swimmer temp = swimmers[j];
                    swimmers[j] = swimmers[j + 1];
                    swimmers[j + 1] = temp;
                }
            }
        }
        System.out.println("Swimmers sorted by speed.");
    }
}

public class part2 {
    public static void main(String[] args) {
        SwimmerCollection collection = new SwimmerCollection(5);
        Scanner KeyBoard = new Scanner(System.in);

        System.out.println("Welcome to the swimmer collection!");
        int choice;
        do {
            System.out.println(" Choose an option to proceed:");
            System.out.println("1 - Add a swimmer to the collection");
            System.out.println("2 - Print all swimmers");
            System.out.println("3 - Sort swimmers by speed");
            System.out.println("4 - Search swimmers by name");
            System.out.println("0 - Exit");

            choice = KeyBoard.nextInt();
            KeyBoard.nextLine(); //

            switch (choice) {
                case 1:
                    inputItems(collection);
                    break;
                case 2:
                    collection.print();
                    break;
                case 3:
                    collection.sort();
                    break;
                case 4:
                    System.out.print("Enter a name to search for swimmers: ");
                    String name = KeyBoard.nextLine();
                    collection.find(name);
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        } while (choice != 0);

        KeyBoard.close();
    }

    public static void inputItems(SwimmerCollection collection) {
        Scanner KeyBoard = new Scanner(System.in);
        System.out.println("Adding a new swimmer to the collection:");

        System.out.print("Enter the swimmer's name: ");
        String name = KeyBoard.nextLine();

        System.out.print("Enter the swimmer's age: ");
        int age = KeyBoard.nextInt();
        KeyBoard.nextLine();

        System.out.print("Enter the swimmer's favorite type: ");
        String favoriteType = KeyBoard.nextLine();

        System.out.print("Enter the total distance swum (in meters): ");
        int totalDistanceSwum = KeyBoard.nextInt();
        KeyBoard.nextLine();

        Swimmer swimmer = new Swimmer(name, age, favoriteType, totalDistanceSwum);
        collection.add(swimmer);
    }
}