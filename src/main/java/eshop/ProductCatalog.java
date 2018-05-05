package eshop;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ProductCatalog {
    private Map<Integer, Product> products;
    private IDataService dataService;

    ProductCatalog() {
        this(new ProductFileDataService());
    }

    protected ProductCatalog(IDataService dataService) {
        this.products = new HashMap<>();
        this.dataService = dataService;
    }

    public Product getProduct(int id) {
        return products.get(id);
    }

    public void addProduct(Product product) {
        this.products.put(product.getId(), product);
    }

    public void addAllProducts() {
        Iterator<Product> itr = dataService.getAllObjects();
        while (itr.hasNext()) {
            addProduct(itr.next());
        }
    }
}
