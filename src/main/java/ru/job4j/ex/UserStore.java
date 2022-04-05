package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User founded = null;
        for (User user: users) {
            if (login.equals(user.getUsername())) {
                founded = user;
                break;
            }
        }
        if (founded == null) {
            throw new UserNotFoundException("User not found");
        }
        return founded;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User is not valid");
        }
        return true;
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
