import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Product> products;

    public Shop() {
        products = new ArrayList<>();
    }

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * @return отсортированный по возрастанию и цене список продуктов
     */
    public List<Product> getSortedListProducts() {
        for (int i = 0; i < products.size() -1; i++) {
            for (int j = 0; j < products.size() -i -1; j++) {
                if (products.get(j).getCost() > products.get(j+1).getCost()) {
                    Product temp = products.get(j);
                    products.set(j, products.get(j+1));
                    products.set(j+1, temp);
                }
            }
        }
        return products;
        
    }

    /**
     * @return самый дорогой продукт
     */
    public Product getMostExpensiveProduct() {
        if (products == null || products.isEmpty()) {
            return null;
        } 
        Product finalProduct = products.get(0);
        
        for (Product product: products) {
            if (product.getCost() > finalProduct.getCost()) {
                finalProduct = product;
            }
        }

        return finalProduct;
    }

    public void add(Product product) {
        if (product != null) {
            products.add(product);
        }
        
    }

    @Override
    public String toString(){
    StringBuilder sb = new StringBuilder(null);

    for (int i = 0; i < products.size(); i++) {
        sb.append(products.get(i));
        if (i< products.size() -1) {
            sb.append(", ");
        }
    }


    return sb.toString();
    }


    public int size(){
    int result = 0;
    for (Product product: products) {
        result++;
        }
    


    return result;
    }

    






}
