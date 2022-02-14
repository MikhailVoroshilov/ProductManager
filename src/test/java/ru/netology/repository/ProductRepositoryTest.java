package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smarthone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    private Book book = new Book(1, "пес", 255, "Петров");
    private Book booking = new Book(3, "река", 195, "Петров");
    private Smarthone smart = new Smarthone(89, "notes", 25698, "samsung");
    private Smarthone smarthone = new Smarthone(99, "xfit", 99845, "apple");

    @Test
    void shouldSave() {
        repository.save(book);
//        repository.save(smart);

        Product[] expected = new Product[]{book};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAll() {
        repository.save(book);
//        repository.save(smart);

        Product[] expected = new Product[]{book};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        repository.save(smarthone);

        repository.findById(99);

        Product[] expected = new Product[]{smarthone};
        Product actual = repository.findById(99);
        assertArrayEquals(expected, new Product[]{actual});
    }

    @Test
    void shouldFindByIdNull() {
        repository.save(smarthone);

        Product expected = null;
        Product actual = repository.findById(100);
        assertEquals(expected, actual);
    }

    @Test
    void shouldDeleteByID() {
        repository.save(booking);
        repository.save(smarthone);

        repository.removeByID(99);

        Product[] expected = new Product[]{booking};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}