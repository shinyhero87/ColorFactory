public class ColorFactory {
       /*
        * Code by: Blake Lacroix
        * Class:   CS-142
        * Date:    10/17/24
        *  
        */
    public static boolean productionOrder(int red, int orange, int yellow, int green, int blue, int violet) {
        boolean ruleBreaker = false;
        int primaryColor = red + yellow + blue; 
        int secondColor = orange + green + violet;
        int totalItems = primaryColor + secondColor;
        

        // Rule 1: None of the quantities of products in the order can be negative .
        if (red < 0 || orange < 0 || yellow < 0 || green < 0 || blue < 0 || violet < 0) {
            System.out.println("Error: Negative quantity found. No negative quantities are allowed.");
            return false; // Stop here, since no further rules make sense with negative values.
        }

        // Rule 2: The factory cannot produce more than 100 items total in a single order.
        if (totalItems > 100 ) {
            System.out.println("Error: Total items exceed the limit of 100.");
            ruleBreaker = true;
        } 

        // Rule 3: Must produce at least 3 distinct types of items but not all 6.
        int distinctTypes = 0;
        if (red > 0) distinctTypes++;
        if (orange > 0) distinctTypes++;
        if (yellow > 0) distinctTypes++;
        if (green > 0) distinctTypes++;
        if (blue > 0) distinctTypes++;
        if (violet > 0) distinctTypes++;

        if (distinctTypes < 3) {
            System.out.println("Error: Less than 3 distinct types of items.");
            ruleBreaker = true;
        } else if (distinctTypes == 6) {
            System.out.println("Error: All 6 distinct types of items are being produced.");
            ruleBreaker = true;
        }

        // Rule 4: The order must contain at least one primary color.
        boolean hasPrimaryColor = red > 0 || yellow > 0 || blue > 0;
        if (!hasPrimaryColor) {
            System.out.println("Error: No primary color is included.");
            ruleBreaker = true;
        }

        // Rule 5: The order must contain at least one secondary color.
        boolean hasSecondaryColor = orange > 0 || green > 0 || violet > 0;
        if (!hasSecondaryColor) {
            System.out.println("Error: No secondary color is included.");
            ruleBreaker = true;
        }

        // Rule 6: Check if the secondary colors have enough primary colors.
        if (orange > 0 && (red < orange || yellow < orange)) {
            System.out.println("Error: Not enough red or yellow to produce the orange.");
            ruleBreaker = true;
        }  else {
        	yellow -= orange;
        	red -= orange;
        		//System.out.println("Red: " + red);  // Output: Red: amount
        		//System.out.println("Yellow: " + yellow);  // Output: Yellow: amount
        }

        if (green > 0 && (yellow < green || blue < green)) {
            System.out.println("Error: Not enough yellow or blue to produce the green.");
            ruleBreaker = true;
        } else {
        	yellow -= green;
        	blue -= green;
        		//System.out.println("Green: " + green);  // Output: Green: amount
        		//System.out.println("Yellow: " + yellow);  // Output: Yellow: amount
        }

        if (violet > 0 && (blue < violet || red < violet)) {
            System.out.println("Error: Not enough blue or red to produce the violet.");
            ruleBreaker = true;
        } else {
        	blue -= violet;
        	red -= violet;
        		//System.out.println("Blue: " + blue);  // Output: Blue: amount
        		//System.out.println("Red: " + red);  // Output: Red: amount
        }
        
      
        

        // Return true if no rules were broken, otherwise return false without printing.
        return !ruleBreaker;
        
    }

    public static void main(String[] args) {
        
    	// Test cases to verify the function works as expected. Values retrieved from ColorFactoryTester
    	
        System.out.println(productionOrder(-10, -10, 10, 10, 10, 0)); // Expected: false (Negative inputs)errors = 1
        System.out.println(productionOrder(50, 50, 50, 0, 0, 0)); // Expected: false (Too many total products)errors = 1
        System.out.println(productionOrder(10, 5, 15, 10, 20, 1)); // Expected: false (Too many types of products)errors = 1
        System.out.println(productionOrder(20, 0, 30, 0, 40, 0)); // Expected: false (No secondary color)errors = 1
        System.out.println(productionOrder(10, 15, 15, 0, 0, 0)); // Expected: false (Not enough primary for one)errors = 1
        System.out.println(productionOrder(15, 10, 10, 0, 10, 10)); // Expected: false (Not enough primary for both)errors = 1
        System.out.println(productionOrder(0, 0, 0, 0, 0, 0)); // Expected: false (No items)errors = 3
        System.out.println(productionOrder(0, 10, 0, 20, 0, 30)); // Expected: false (No primary color)errors = 4
        System.out.println(productionOrder(100, -100, 100, 0, 0, 0)); // Expected: false (Negative and over 100)errors = 1
        System.out.println(productionOrder(-10, 0, 0, 200, 0, 0)); // Expected: false (Multiple errors with negative value)errors = 1
        System.out.println(productionOrder(0, 100, 0, 100, 0, 0)); // Expected: false (Multiple errors without negative value)errors = 5
        System.out.println(productionOrder(40, 20, 40, 0, 0, 0)); // Expected: true (Valid input with 3 colors)errors = 0
        System.out.println(productionOrder(30, 10, 30, 0, 30, 0)); // Expected: true (Valid input with 4 colors)errors = 0
        System.out.println(productionOrder(20, 10, 20, 10, 20, 0)); // Expected: true (Valid input with 5 colors)errors = 0
    }
}
