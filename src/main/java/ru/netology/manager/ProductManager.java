package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Product[] searchBy(String text) {
        Product[] items = repository.findAll();
        Product[] findProduct = new Product[0];
        for (int i = 0; i < items.length; i++) {
            if (items[i].matches(text)) {
                Product[] tmp = new Product[findProduct.length + 1];
                System.arraycopy(findProduct, 0, tmp,0, findProduct.length);
                tmp[tmp.length - 1] = items[i];
                findProduct = tmp;
            }
        }
        return findProduct;
    }
}
