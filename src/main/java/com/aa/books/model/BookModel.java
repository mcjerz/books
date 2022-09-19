package com.aa.books.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookModel {

    private static int idCounter;

    private int id;
    private String title;
    private String author;
    private String genre;
    private String isbn;
    private Integer numberOfPages;

    public BookModel toModel() {
        return BookModel.of(getTitle(),getAuthor(),getIsbn(),getNumberOfPages());
    }

    public static BookModel of(final String pTitle, final String pAuthor, final String pIsbn, final int pPages)
    {
        final BookModel book = new BookModel();
        book.setId(++idCounter);
        book.setTitle(pTitle);
        book.setAuthor(pAuthor);
        book.setIsbn(pIsbn);
        book.setNumberOfPages(pPages);

        return book;
    }
}
