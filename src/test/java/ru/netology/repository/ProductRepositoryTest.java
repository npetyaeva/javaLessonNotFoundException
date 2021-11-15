package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    private final Product emptyProduct = new Product();
    private final Book emptyBook = new Book();
    private final TShirt emptyTShirt = new TShirt();

    private final Product first = new Product(1, "Java: A Beginner's Guide", 19_94);
    private final Book second = new Book(
            2, "Google It!: A History of Google", 14_62, "Anna Crowley Redding", 300, 2015
    );
    private final TShirt third = new TShirt(
            3, "Google T-Shirt for Mens", 17_60,"white", "L"
    );

    //-----------removeById-----------
    @Test
    void shouldRemoveById() {
        repository.save(first);
        repository.save(second);
        repository.save(third);

        Product[] expected = { second, third };
        repository.removeById(1);
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldThrowNotFoundException() {
        repository.save(first);
        repository.save(second);
        repository.save(third);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(10);
        });
    }

    //--------------Save---------------
    //--------------NoArg--------------
    @Test
    void shouldSaveOneItemProductNoArg() {
        repository.save(emptyProduct);

        Product[] expected = { emptyProduct };
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveOneItemBookNoArg() {
        repository.save(emptyBook);

        Product[] expected = { emptyBook };
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveOneItemSmartphoneNoArg() {
        repository.save(emptyTShirt);

        Product[] expected = { emptyTShirt };
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveNoArg() {
        repository.save(emptyProduct);
        repository.save(emptyBook);
        repository.save(emptyTShirt);

        Product[] expected = { emptyProduct, emptyBook, emptyTShirt };
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    //  -------------AllArg--------------
    @Test
    void shouldSaveOneItemProductAllArg() {
        repository.save(first);

        Product[] expected = { first };
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveOneItemBookAllArg() {
        repository.save(second);

        Product[] expected = { second };
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveOneItemSmartphoneAllArg() {
        repository.save(third);

        Product[] expected = {third};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveAllArg() {
        repository.save(first);
        repository.save(second);
        repository.save(third);

        Product[] expected = { first, second, third };
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    //-------------findAll-------------
    @Test
    void shouldFindAllEmptyRepo() {
        Product[] expected = {};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllNotEmptyRepo() {
        repository.save(second);
        repository.save(third);

        Product[] expected = { second, third };
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    //------------findById------------
    @Test
    void shouldFindByIdExistItem() {
        repository.save(first);
        repository.save(second);
        repository.save(third);

        Product actual = repository.findById(2);
        assertEquals(second, actual);
    }

    @Test
    void shouldFindByIdNotExistItem() {
        repository.save(first);
        repository.save(second);
        repository.save(third);

        Product actual = repository.findById(4);
        assertNull(actual);
    }
}