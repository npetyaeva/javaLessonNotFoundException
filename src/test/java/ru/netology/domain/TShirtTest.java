package ru.netology.domain;

import com.sun.security.auth.NTSid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TShirtTest {
    private TShirt emptyTShirt = new TShirt();

    private TShirt first = new TShirt(
            1, "Google T-Shirt for Mens", 17_60,"white", "L"
    );
    private TShirt second = new TShirt(
            2, "Tommy Hilfiger Boys Short Sleeve Crew-Neck T-Shirt", 23_21, "grey", "M"
    );
    private TShirt third = new TShirt(
            1, "Google T-Shirt for Mens", 17_60,"white", "L"
    );
    private TShirt fourth = new TShirt(
            1, "Google T-Shirt for Mens", 17_60,"black", "L"
    );
    private TShirt fifth = new TShirt(
            1, "Google T-Shirt for Mens", 17_60,"white", "M"
    );
    private Product sixth = new Product();

    //Constructor without parameters
    @Test
    void shouldGetColorNoArg() {
        String expected = null;
        String actual = emptyTShirt.getColor();

        assertEquals(expected, actual);
    }

    @Test
    void shouldGetSizeNoArg() {
        String expected = null;
        String actual = emptyTShirt.getSize();

        assertEquals(expected, actual);
    }

    //Constructor with parameters
    @Test
    void shouldGetColorAllArg() {
        String expected = "white";
        String actual = first.getColor();

        assertEquals(expected, actual);
    }

    @Test
    void shouldGetSizeAllArg() {
        String expected = "L";
        String actual = first.getSize();

        assertEquals(expected, actual);
    }

    @Test
    void shouldSetColor() {
        String expected = "black";
        first.setColor("black");
        String actual = first.getColor();

        assertEquals(expected, actual);
    }

    @Test
    void shouldSetSize() {
        String expected = "XXL";
        first.setSize("XXL");
        String actual = first.getSize();

        assertEquals(expected, actual);
    }

    @Test
    void shouldTestToString() {
        String expected = "TShirt(color=white, size=L)";
        String actual = first.toString();

        assertEquals(expected, actual);
    }

    @Test
    void shouldUseEqualcTrue() {
        boolean expected = true;
        boolean actual = first.equals(third);
        assertEquals(expected, actual);
    }

    @Test
    void shouldUseEqualcFalse() {
        boolean expected = false;
        boolean actual = first.equals(second);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCanEqualcLink() {
        boolean expected = true;
        boolean actual = first.equals(first);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCanEqualcNull() {
        boolean expected = false;
        boolean actual = first.equals(null);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCanEqualcClass() {
        boolean expected = false;
        boolean actual = first.equals(sixth);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCanEqualcReturn() {
        boolean expected = false;
        boolean actual = first.equals(fourth);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCanEqualcReturn1() {
        boolean expected = false;
        boolean actual = first.equals(fifth);
        assertEquals(expected, actual);
    }

    @Test
    void shouldTestHashCode() {
        int expected = -1655029532;
        int actual = first.hashCode();

        assertEquals(expected, actual);
    }
}