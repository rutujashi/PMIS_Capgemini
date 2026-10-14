package string_example.com;

public class String2 {

	public static void main(String[] args) {
		
		String text = "Pass@1234_Mumbai";


        int upper = 0, lower = 0, digits = 0, special = 0;

        for (char ch : text.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                upper++;
            } else if (Character.isLowerCase(ch)) {
                lower++;
            } else if (Character.isDigit(ch)) {
                digits++;
            } else {
                special++;
            }
        }

        System.out.println("Uppercase: " + upper);
        System.out.println("Lowercase: " + lower);
        System.out.println("Digits: " + digits);
        System.out.println("Special: " + special);

	}

}
