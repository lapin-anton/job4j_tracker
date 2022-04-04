package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User founded = null;
        for (int i = 0; i < users.length; i++) {
            if (login.equals(users[i].getUsername())) {
                founded = users[i];
                break;
            }
        }
        if (founded == null) {
            throw new UserNotFoundException();
        }
        return founded;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException();
        }
        return user.isValid();
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            System.out.println("User is not valid");
        } catch (UserNotFoundException e) {
            System.out.println("User not found");
        }
    }
}
