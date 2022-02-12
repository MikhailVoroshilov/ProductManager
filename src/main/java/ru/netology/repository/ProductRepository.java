package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product product) {
        int lenght = this.items.length + 1;
        Product[] tmp = new Product[lenght];
        System.arraycopy(this.items, 0, tmp, 0, this.items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        this.items = tmp;
    }

    public Product[] findAll() {
        return this.items;
    }

    public Product findById(int id) {
        for (Product product : this.items) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void deleteByID(int id) {
        int length = this.items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : this.items) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        this.items = tmp;
    }
}
