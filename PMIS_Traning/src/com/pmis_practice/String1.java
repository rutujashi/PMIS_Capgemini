package string_example.com;

public class String1 {

	public static void main(String[] args) {
		
		String input = "10,20,30,40";
        String[] parts = input.split(",");
        int total = 0;
        for(String part: parts){
            total += Integer.parseInt(part);
        }
        System.out.println(total);

	}

}
