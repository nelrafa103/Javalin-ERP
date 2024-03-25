package services;
class UserService {
    public static boolean authenticate(String username, String password) {
        return username.equals("admin") && password.equals("admin");
    }
}