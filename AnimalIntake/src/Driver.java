import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    private static ArrayList<String> unreservedDogs = new ArrayList<String>();
    private static ArrayList<String> unreservedMonkeys = new ArrayList<String>();

    public static String animalToPrint;
    public static ArrayList<String> validMonkeySpeciesList = new ArrayList<String>();

    public static void main(String[] args) {


        initializeDogList();
        initializeMonkeyList();

        char input = ' ';
        Scanner scanner = new Scanner(System.in);
        displayMenu();
        while(input != 'q')
        {

            input = scanner.next().charAt(0);
            scanner.nextLine();
            switch(input) {

                case '1':
                    intakeNewDog(scanner);
                    break;
                case '2':
                    intakeNewMonkey(scanner);
                    break;
                case '3':
                    reserveAnimal(scanner);
                    break;
                case '4':
                    animalToPrint = "dog";
                    printAnimals();
                    displayMenu();
                    break;
                case '5':
                    animalToPrint = "monkey";
                    printAnimals();
                    displayMenu();
                    break;
                case '6':
                    printAllAvailableAnimals();
                    displayMenu();
                    break;
                default:
                    displayMenu();
                    break;
            }

        }


    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }

    //Print all of the unreserved animals
    public static void printAllAvailableAnimals()
    {
        for(Dog d : dogList)
            if(!d.getReserved())
                System.out.println(d.getName() + " the dog is available.");

        for(Monkey m : monkeyList)
            if(!m.getReserved())
                System.out.println(m.getName() + " the monkey is available.");
    }

    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds valid monkey types to valid monkey species
    public static void initializeMonkeyList() {
        validMonkeySpeciesList.add("capuchin");
        validMonkeySpeciesList.add("macaque");
        validMonkeySpeciesList.add("guenon");
        validMonkeySpeciesList.add("marmoset");
        validMonkeySpeciesList.add("spider monkey");
        validMonkeySpeciesList.add("tamarin");

    }


   //Asks all necessary questions to intake a new dog tyo system and assigns to variables to create a dog object
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name? ");
        String name = scanner.nextLine();
        System.out.println("What is the dog's breed? ");
        String breed = scanner.nextLine();
        System.out.println("What is the dog's gender(enter 'male' or 'female'): ");
        String gender = scanner.nextLine();
        System.out.println("What is the dog's age? ");
        String age = scanner.nextLine();
        System.out.println("What is the dog's weight? ");
        String weight = scanner.nextLine();
        System.out.println("Enter the acquisition date(XX-XX-XXXX): ");
        String acquisitionDate = scanner.nextLine();
        System.out.println("Enter the acquisition country: ");
        String acquisitionCountry = scanner.nextLine();
        System.out.println("Enter the training status: ");
        String trainingStatus = scanner.nextLine();
        System.out.println("Reserved True or False? (Enter 'true' or 'false'): ");
        boolean reserved = scanner.nextBoolean();
        scanner.nextLine();
        System.out.println("Enter the in service country: ");
        String inServiceCountry = scanner.nextLine();

        Dog tempDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);

        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(tempDog.getName())) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                dogList.remove(dog);
                displayMenu();
                return; //returns to menu
            }
            else{
                dogList.add(tempDog);
                System.out.println(tempDog.getName() + " has been added to the system! ");
                displayMenu();
                return;
            }
        }


    }


    // to make sure the monkey doesn't already exist and the species type is allowed
    public static void intakeNewMonkey(Scanner scanner) {
        System.out.println("What is the monkey's name: ");
        String name = scanner.nextLine();
        System.out.println("What is the monkey's species: ");
        String species = scanner.nextLine().toLowerCase();

        if(!validMonkeySpeciesList.contains(species.toLowerCase()))
        {
            System.out.println("That is not a valid monkey species for our system. Please start again.");
            displayMenu();
            return;
        }
        System.out.println("What is the monkey's gender? ");
        String gender = scanner.nextLine();
        System.out.println("What is the monkey's age: ");
        String age = scanner.nextLine();
        System.out.println("What is the monkey's weight: ");
        String weight = scanner.nextLine();
        System.out.println("What is the monkey's tail length in nearest inches? ");
        String tailLength = scanner.nextLine();
        System.out.println("What is the monkey's height in inches: ");
        String height = scanner.nextLine();
        System.out.println("What is the monkey's body length in nearest inches? ");
        String bodyLength = scanner.nextLine();
        System.out.println("What is the monkey's acquisition date?(XX-XX-XXXX): ");
        String acquisitionDate = scanner.nextLine();
        System.out.println("What is the monkey's acquisition country? ");
        String acquisitionCountry = scanner.nextLine();
        System.out.println("What is the monkey's training status? ");
        String trainingStatus = scanner.nextLine();
        System.out.println("Is the monkey reservered? 'true' or 'false': ");
        boolean reserved = scanner.nextBoolean();
        scanner.nextLine();
        System.out.println("What is the monkey's in service country? ");
        String inServiceCountry = scanner.nextLine();

        Monkey tempMonkey = new Monkey(name, species, gender, age, weight, tailLength, height, bodyLength, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);

        //If nothing in list, start with this monkey
        if(monkeyList.isEmpty()){
            monkeyList.add(tempMonkey);
            System.out.println(name + " has been added to the system! ");
            displayMenu();
            return;}

        //Iterate through list of monkeys to see if it is in the system already or not
        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(tempMonkey.getName())) {
                System.out.println("\n\nThis monkey is already in our system\n\n");
                monkeyList.remove(monkey);
                displayMenu();
                return; //returns to menu
            }
            else
            {
                monkeyList.add(tempMonkey);
                System.out.println(monkey.getName() + " has been added to the system! ");
                displayMenu();
                return;
            }

        }
    }

        //Method to handle reserving an animal
        public static void reserveAnimal (Scanner scanner){

            System.out.println("Would you like to reserve a dog or a monkey?");
            String reserveType = scanner.next();

            //Clear line
            scanner.nextLine();

            System.out.println("Which country will the animal be working in? ");
            String country = scanner.nextLine();

            if(reserveType.equalsIgnoreCase("dog"))
            {
                for(Dog dog: dogList)
                {
                    if(!dog.getReserved())
                    {
                        if(dog.getInServiceLocation().equalsIgnoreCase(country))
                        {
                            System.out.println(dog.getName() + " is available.");
                            unreservedDogs.add(dog.getName());
                        }
                        else
                        {
                            System.out.println("No dogs available to be reserved in " + country);
                        }
                    }
                }

                if(!unreservedDogs.isEmpty())
                {

                    System.out.println("Type the name of the dog to reserve: ");
                    String dogToReserve = scanner.nextLine();

                    if(unreservedDogs.contains(dogToReserve))
                    {

                        for(Dog dog: dogList)
                        {
                            if(dog.getName().equalsIgnoreCase(dogToReserve))
                            {
                                dog.setReserved(true);
                                unreservedDogs.remove(dogToReserve);
                                System.out.println("You have reserved the dog " + dog.getName() + ". Press Enter to continue... ");
                                dogToReserve = "";

                            }
                        }
                    }
                    else
                    {
                        System.out.println(dogToReserve + "Not a valid dog's name. Please restart.");
                        dogToReserve = "";
                        displayMenu();
                    }

                }
                else
                {
                    System.out.println("No dogs available to be reserved in." );
                    displayMenu();
                }

            }

            else if(reserveType.equalsIgnoreCase("monkey"))
            {
                for(Monkey monkey: monkeyList)
                {
                    if(!monkey.getReserved())
                    {
                        if(monkey.getInServiceLocation().equalsIgnoreCase(country))
                        {
                            System.out.println(monkey.getName() + " is available.");
                            unreservedMonkeys.add(monkey.getName());
                        }
                        else
                        {
                            System.out.println("No monkeys available to be reserved in " + country);
                        }
                    }
                    else
                    {
                        System.out.println("No monkeys available to be reserved.");
                    }
                }
                if(!unreservedMonkeys.isEmpty())
                {

                    System.out.println("Type the name of the monkey to reserve: ");
                    String monkeyToReserve = scanner.nextLine();

                    if(unreservedMonkeys.contains(monkeyToReserve))
                    {

                        for(Monkey m: monkeyList)
                        {
                            if(m.getName().equalsIgnoreCase(monkeyToReserve))
                            {
                                m.setReserved(true);
                                unreservedMonkeys.remove(monkeyToReserve);
                                System.out.println("You have reserved the monkey " + m.getName() + ". Press Enter to continue... ");
                                monkeyToReserve = "";

                            }
                        }
                    }
                    else
                    {
                        System.out.println(monkeyToReserve + "Not a valid monkey's name. Please restart.");
                        monkeyToReserve = "";
                        displayMenu();
                    }

                }
               else
                {
                    System.out.println("No monkeys available to be reserved.");
                    displayMenu();
                }

            }


        }

        //Prints the list of dogs or monkeys on the roster by name and if they are in service or not
        public static void printAnimals () {
            if (animalToPrint.equals("dog"))
            {
                if(dogList.isEmpty())
                    System.out.println("There are no dogs in our system currently. ");

                for (Dog dog : dogList) {
                    if (!dog.getReserved()) {
                        System.out.println(dog.getName() + " is available.");
                    } else {
                        System.out.println(dog.getName() + " is in service.");
                    }
                }
            }
            if (animalToPrint.equals("monkey"))
            {
                if(monkeyList.isEmpty())
                    System.out.println("There are no monkeys in our system currently. ");

                for (Monkey monkey : monkeyList) {
                    if (!monkey.getReserved()) {
                        System.out.println(monkey.getName() + " is available.");
                    } else {
                        System.out.println(monkey.getName() + " is in service.");
                    }
                }
            }

        }
    }

