import java.util.Scanner;

class Lab1Try{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int totalItems;
        double subtotal, discount, orderTotal, beforeDiscount, totalDiscount, finalAmount;
        char orderAgain, is_Student;

        System.out.println("=====     M E N U     =====");
        System.out.printf("%-15s - $%.2f\n", "1. Burger", 80.00);
        System.out.printf("%-15s - $%.2f\n", "2. Pizza", 120.00);
        System.out.printf("%-15s - $%.2f\n", "3. Pasta", 100.00);
        System.out.printf("%-15s - $%.2f\n", "4. Sandwich", 70.00);
        System.out.printf("%-15s - $%.2f\n", "5. Milk Tea", 90.00);
    


//=============== Test Data Only ========================//
    /*
        subtotal = 80.00;
        discount = 90.00;
        orderTotal = 100.00;

        totalItems = 10;
        beforeDiscount = 110.00;
        totalDiscount = 120.00;
        finalAmount = 130.00;
*/

totalItems = 0;
beforeDiscount = 0;
totalDiscount = 0;
finalAmount = 0;
subtotal = 0;
//==================================================//



//============================================================================================
    do{
        System.out.print("\nEnter item number: ");
        int itemNumber = input.nextInt();
        if (itemNumber >= 1 && itemNumber<=5){
            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();
                System.out.print("Are you a student? (Y/N): ");
                is_Student = input.next().charAt(0);

                switch(itemNumber){
                   case 1: 
                        subtotal += 80.00 * quantity;
                        break;
                   case 2: 
                        subtotal += 120.00 * quantity;
                        break;
                   case 3: 
                        subtotal += 100.00 * quantity;
                        break;
                   case 4: 
                        subtotal += 70.00 * quantity;
                        break;
                   case 5: 
                        subtotal += 90.00 * quantity;
                        break;
                   default:
                        if(quantity < 1){
                            System.out.println("Quantity is not within the range 1 - 10");
                            System.out.println("Please enter a quantity above 0");
                        }
                        if(quantity > 1){
                            System.out.println("Quantity is not within the range 1 - 10");
                            System.out.println("Please enter a quantity only up to 10");
                        }
                }
                beforeDiscount = subtotal;
                
                totalItems += quantity; //============== Total Items ===========

                //======== Discount ==================
                if (is_Student == 'Y' && subtotal > 500){
                    discount = subtotal * 0.15;
                }
                else if (is_Student == 'Y'){
                    discount = subtotal * 0.10;
                }
                else if (subtotal > 500){
                    discount = subtotal * 0.05;
                }
                else{
                    discount = 0;
                }

                totalDiscount += discount; // Total discount

                //========== Order total ===============
                orderTotal = subtotal - discount;

                System.out.printf("\nSubtotal: $%.2f\n", subtotal);
                System.out.printf("Discount: $%.2f\n", discount);
                System.out.printf("Order total: $%.2f\n", orderTotal);

                finalAmount += orderTotal; // Final amount
            }
        else{
            System.out.println("\nInvalid order! Please enter a valid item and quantity.");
        }

        System.out.print("\nDo you want to order again? (Y/N): ");
        orderAgain = input.next().charAt(0);
    
    }
    while(orderAgain == 'Y');
//=====================================================================================================

        System.out.printf("\n===== ORDER SUMMARY =====\n");
        System.out.printf("Total items: %d\n", totalItems);
        System.out.printf("Total before discount: $%.2f\n", beforeDiscount);
        System.out.printf("Total Discount: $%.2f\n", totalDiscount);
        System.out.printf("Final amount: $%.2f\n", finalAmount);
        System.out.printf("Thank you for ordering!");
    
        input.close();
    }
}

