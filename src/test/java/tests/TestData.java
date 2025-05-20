package tests;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class TestData {

    static String[] genders = {"Male", "Female", "Other"};
    static String[] hobbies = {"Sports", "Reading", "Music"};
    static String[] subjects = {"English", "Maths", "Arts"};
    static String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
    static String[] citiesNcr = {"Delhi", "Gurgaon", "Noida"};
    static String[] citiesUttarPradesh = {"Agra", "Merrut", "Lucknow"};
    static String[] citiesHaryana = {"Karnal", "Panipat"};
    static String[] citiesRajasthan = {"Jaipur", "Jaiselmer"};


    static Faker fakerRu = new Faker(new Locale("ru"));
    static Faker fakerEn = new Faker(new Locale("en"));

    static Random random = new Random();

    public static String firstName = fakerRu.name().firstName();
    public static String lastName = fakerRu.name().lastName();
    public static String email = fakerEn.internet().emailAddress();
    public static String userSex = genders[random.nextInt(genders.length)];
    public static String userNumber = fakerRu.numerify("77########");;
    public static String favoriteSubject = subjects[random.nextInt(subjects.length)];
    public static String favoriteHobby = hobbies[random.nextInt(hobbies.length)];
    public static String imgPath = "files/img.png";
    public static String userAddress = fakerRu.address().cityName();
    public static String userState = states[random.nextInt(states.length)];
    public static String userCity = getRandomUserCity(userState, random);

    public static String[] months = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};


    public static int randomMonth = random.nextInt(0,12);
    public static int userDayOfBirthday = getUserDayOfBirthday(randomMonth);
    public static int userYearOfBirthday = fakerRu.number().numberBetween(1950,2001);

    public static String[] userDateOfBirthday =
            {Integer.toString(userDayOfBirthday),
                    Integer.toString(randomMonth),
                    Integer.toString(userYearOfBirthday)};


    public static int getUserDayOfBirthday(int number){
        if (number != 1)
            return fakerRu.number().numberBetween(1,29);
        else
            return fakerRu.number().numberBetween(1,32);
    }


    public static String getRandomUserCity(String state, Random random){

        return switch (state) {
            case "NCR" -> citiesNcr[random.nextInt(citiesNcr.length)];
            case "Uttar Pradesh" -> citiesUttarPradesh[random.nextInt(citiesUttarPradesh.length)];
            case "Haryana" -> citiesHaryana[random.nextInt(citiesHaryana.length)];
            case "Rajasthan" -> citiesRajasthan[random.nextInt(citiesRajasthan.length)];
            default -> "Invalid state";
        };
    }
}
