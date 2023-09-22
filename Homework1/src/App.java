import static org.assertj.core.api.Assertions.*;

public class App {
    public static void main(String[] args) {
        
        // Задание1. Проверяем расчет скидки.
        CalculatorDiscountTest();

        // Задание2. Проверяем магазин и продукты.
        Product avocado = new Product(8, "avocado");
        Product potato = new Product(5, "potato");
        Product tomato = new Product(7, "tomato");
        Product cucumber = new Product(5, "cucumber");
        Product mango = new Product(10, "mango");

        Shop grocery = new Shop();

        grocery.add(avocado); 
        grocery.add(potato);
        grocery.add(tomato);
        grocery.add(cucumber);
        grocery.add(mango);

        System.out.println("Most expensive product is: " + grocery.getMostExpensiveProduct());
        System.out.println(grocery.getSortedListProducts());

        // Задание2. Тестируем новые методы класса Shop
        ShopTest();
        
    }

    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }


    public static void CalculatorTest() {
        assertThat(calculation(5, 8, '+')).isEqualTo(13);
        assertThat(calculation(2, 2, '-')).isEqualTo(0);
        assertThat(calculation(2, 7, '*')).isEqualTo(14);
        assertThat(calculation(100, 50, '/')).isEqualTo(2);

    }

    public static int calculateDiscount(int price, int discount) {
        int result;
        if (price >= 0 && discount<= 100 && discount>=0) {
            result = price * (100-discount)/100;
        }
        else {
            throw new ArithmeticException("Something wrong");
        }

        return result;

    }

        public static void CalculatorDiscountTest() {
        assertThat(calculateDiscount(100, 8)).isEqualTo(92);
        assertThat(calculateDiscount(200, 100)).isEqualTo(0);
        assertThat(calculateDiscount(300, 0)).isEqualTo(300);
        assertThat(calculateDiscount(400, 50)).isEqualTo(200);
        assertThatThrownBy(() ->
               calculateDiscount(5, -10)
        ).isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(() ->
               calculateDiscount(-5, 10)
        ).isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(() ->
               calculateDiscount(-5, 110)
        ).isInstanceOf(ArithmeticException.class);


    }

        public static void ShopTest() {
            Product product1 = new Product(8, "a");
            Product product2 = new Product(13, "b");
            Product product3 = new Product(7, "c");
            Product product4 = new Product(25, "d");
            Product product5 = new Product(10, "e");

            Shop shop = new Shop();

            shop.add(product1); 
            shop.add(product2); 
            shop.add(product3); 
            shop.add(product4); 
            shop.add(product5); 
            
            shop.getSortedListProducts();
            assertThat(shop.getProducts()).containsExactly(product3, product1, product5, product2, product4);
            assertThat(shop.size()).isEqualTo(5);

            assertThat(shop.getMostExpensiveProduct()).isEqualTo(product4);

        }
    
}

