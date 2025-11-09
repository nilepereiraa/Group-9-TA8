import java.util.Scanner;

public class AlphaRoman {
    static String toRoman (int number) throws Exception {
        if (number < 1 || number > 3999) {
            throw new Exception("Inputted number should be in the range of 1-3999");
        }

        String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] romanValues = {1000,900,500,400,100,90,50,40,10,9,5,4,1};

        String result = "";
        for (int i = 0; i < romanValues.length; i++) {
            while (number >= romanValues[i]) {
                result += roman[i];
                number -= romanValues[i];
            }
        }
        return result;
    }
    
    static int toArabic(String roman) throws Exception {
    roman = roman.toUpperCase();

    if (!roman.matches("[IVXLCDM]+"))
        throw new Exception("ERROR: Invalid Roman numeral characters.");

    int total = 0;
    int prev = 0;

    for (int i = roman.length() - 1; i >= 0; i--) {
        char forCase = roman.charAt(i);
        int value;

        switch (forCase) {
            case 'I': 
                value = 1; 
            break;

            case 'V': 
                value = 5; 
            break;

            case 'X': 
                value = 10; 
            break;

            case 'L': 
                value = 50; 
            break;

            case 'C': 
                value = 100; 
            break;

            case 'D': 
                value = 500; 
            break;

            case 'M': 
                value = 1000;
            break;

            default: 
                value = 0;
        }

        if (value < prev)
            total -= value;
        else
            total += value;

        prev = value;
    }

    if (total < 1 || total > 3999)
        throw new Exception("ERROR: Roman numeral out of valid range (1–3999).");

    return total;
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a value (Arabic or Roman): ");
        String input = sc.nextLine();

        try {
            if (input.matches("\\d+")) {
                int number = Integer.parseInt(input);
                System.out.println("Roman: " + toRoman(number));
            } 

            else {
                System.out.println("Arabic: " + toArabic(input));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Conversion attempt complete.");
        }

        sc.close();
    }
}
