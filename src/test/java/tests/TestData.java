package tests;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class TestData {

    static String[] genders = {"Male", "Female", "Other"};
    static String[] hobbies = {"Sports"};


    static Faker fakerRu = new Faker(new Locale("ru"));
    static Faker fakerEn = new Faker(new Locale("en"));

    static Random random = new Random();

    public static String firstName = fakerRu.name().firstName();
    public static String lastName = fakerRu.name().lastName();
    public static String email = fakerEn.internet().emailAddress();
    public static String userSex = genders[random.nextInt(genders.length)];
    public static String userNumber = fakerRu.numerify("77########");;
    public static String favoriteSubject = fakerRu.music().genre();
    public static String favoriteHobby = "Sports";
    public static String imgPath = fakerRu.avatar().image();
    public static String userAddress = fakerRu.address().cityName();
    public static String userState = "NCR";
    public static String userCity = "Delhi";
    public static String[] userDateOfBirthday = {"14", "1", "1996"};
}
