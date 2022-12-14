import category.Category;
import discount.Discount;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        DataGenerator.createCustomer();
        DataGenerator.createCategory();
        DataGenerator.createProduct();
        DataGenerator.createBalance();
        DataGenerator.createDiscount();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select Customer");

        for(int i=0; i<StaticConstants.CUSTOMER_LIST.size(); i++){
            System.out.println("Type " + i + " for customer: " + StaticConstants.CUSTOMER_LIST.get(i).getUserName());
        }

        Customer customer = StaticConstants.CUSTOMER_LIST.get(scanner.nextInt());

        while(true){

            System.out.println("What would you like to do? Just type id for selection");

            for(int i = 0; i<prepareMenuOption().length; i++){
                System.out.println(i+ "-" + prepareMenuOption()[i]);
            }

            int menuSelection = scanner.nextInt();

            switch(menuSelection){
                case 0:         //list category
                    for (Category category : StaticConstants.CATEGORY_LIST) {
                        System.out.println("Category Code: " + category.generateCategoryCode()+ "category name: "+category.getName());
                    }
                    break;
                case 1:     //list product  //product nam, product category name
                    try{
                        for (Product product : StaticConstants.PRODUCT_LIST) {
                            System.out.println("product name: "+ product.getName()+ "product category: "+ product.getCategoryName());
                        }
                    }catch(Exception e){
                        System.out.println("Product could not printed because category not found for product name: "+ e.getMessage().split(",")[1]);
                    }

                    break;
                case 2:         //list discounts

                    for (Discount discount : StaticConstants.DISCOUNT_LIST) {
                        System.out.println("Discount Name: "+ discount.getName()+ "discount threshold amount: "+ discount.getThresholdAmount());
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
            }
        }





    }

    private static String[] prepareMenuOption(){
        return new String[]{"list Categories", "List Product", "List Discount", "See Balance", "Add Balance",
        "Place an order", "See Cart", "See order details", "See your address", "Close App"};
    }
}
