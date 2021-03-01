package ru.netology.repository;

import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp,0, items.length);
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }

    public Product[] findById(int id) {
        Product[] tmp = new Product[1];
        for (Product item : items) {
            if (item.getId() == id) {
                tmp[0] = item;
            }
        }
        if (tmp[0] == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        else { return tmp; }
    }

    public void removeById(int id) {
        try {
            findById(id);
            int length = items.length - 1;
            Product[] tmp = new Product[length];
            int index = 0;
            for (Product item : items) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            items = tmp;
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }
}
