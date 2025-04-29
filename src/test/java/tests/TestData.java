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
    public static String[] userDateOfBirthday = {"14", "1", "1996"};



    public static String getRandomUserCity(String state, Random random){

        switch (state) {
            case "NCR":
                return citiesNcr[random.nextInt(citiesNcr.length)];
            case "Uttar Pradesh":
                return citiesUttarPradesh[random.nextInt(citiesUttarPradesh.length)];
            case "Haryana":
                return citiesHaryana[random.nextInt(citiesHaryana.length)];
            case "Rajasthan":
                return citiesRajasthan[random.nextInt(citiesRajasthan.length)];
            default:
                return "Invalid state";

        }
    }
}
