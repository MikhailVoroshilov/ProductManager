package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smarthone;
import ru.netology.repository.ProductRepository;


import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductManager manager = new ProductManager(new ProductRepository());

    private Book book = new Book(1, "пес", 255, "Петров");
    private Book booking = new Book(3, "река", 195, "Петров");
    private Smarthone smart = new Smarthone(89, "notes", 25698, "samsung");
    private Smarthone smarthone = new Smarthone(99, "xfit", 99845, "apple");


    @Test
    public void shouldAdd() {
        manager.add(book);
        manager.add(booking);

        Product[] expected = new Product[]{book, booking};
        Product[] actual = manager.findAllProduct();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBy() {
        manager.add(book);
        manager.add(booking);
        manager.add(smart);
        manager.add(smarthone);

        Product[] expected = new Product[]{smart};
        Product[] actual = manager.searchBy("notes");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdProduct() {
        manager.add(book);
        manager.add(booking);

        manager.removeByIdProduct(3);

        Product[] expected = new Product[]{book};
        Product[] actual = manager.findAllProduct();

        assertArrayEquals(expected, actual);
    }

}