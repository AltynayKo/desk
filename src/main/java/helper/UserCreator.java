package helper;

import helper.TestDataReader;
import model.User;

public class UserCreator {
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    public static User generateUser(){
        return new User(TestDataReader.getTestData(USERNAME),
                TestDataReader.getTestData(PASSWORD));
    }
}
