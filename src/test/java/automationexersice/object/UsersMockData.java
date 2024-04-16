package automationexersice.object;

public class UsersMockData {
    public static Users getCorrectUserData(){
        Users userCorrect = new Users ("Anush1991","anush2001@gmail.com");
                return userCorrect;
    }

    public static Users getIncorrectCorrectUserData(){
        Users userIncorrect = new Users ("Anush1991","sara2001@gmail.com");
        return userIncorrect;
    }




}
