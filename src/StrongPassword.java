import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrongPassword {

    public static void main(String[] args){
        System.out.println(minimumNumber(6,"#HackerRank"));
    }

    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong

        //to make it faster you can use pattern match for them all
        StringBuilder upper = new StringBuilder();
        StringBuilder lower = new StringBuilder();
        StringBuilder digit = new StringBuilder();
        StringBuilder specialC = new StringBuilder();

        Pattern special = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher hasSpecial = special.matcher(password);
        boolean check = hasSpecial.find();


        if(check){
            specialC.append("y");
        }

        for(int i =0; i < password.length(); i++){

            Character c = password.charAt(i);
            if(Character.isAlphabetic(c) && Character.isLowerCase(c)){
                lower.append(c);
            }

            if(Character.isAlphabetic(c) && Character.isUpperCase(c)){
                upper.append(c);
            }

            if(Character.isDigit(c)){
                digit.append(c);
            }
        }

        int add = 0;

        if(upper.isEmpty()) {
            add += 1;
        }

        if(lower.isEmpty()) {
            add += 1;
        }

        if(digit.isEmpty()) {
            add += 1;
        }

        if(specialC.isEmpty()) {
            add += 1;
        }

        if(password.length() < 6) {

            if ((6 - password.length()) <= add) {
                return add;
            }
        }

        if(password.length() > 6){
            return add;
        }

        if ((6 - password.length()) <= add) {
            return add;
        }

        int tmp = add + ((6 - password.length()) - add);


        return tmp;

    }
}