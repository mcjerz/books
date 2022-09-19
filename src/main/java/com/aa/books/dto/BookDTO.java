package com.aa.books.dto;

import com.aa.books.model.BookModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {
    private int id;
    private String title;
    private String author;
    private String genre;
    private String isbn;
    private Integer pageCount;

    public BookModel toModel() {return BookModel.of(getTitle(), getAuthor(), getIsbn(), getPageCount());}

    public BookModel toModel(final int pId) {return BookModel.of(getTitle(), getAuthor(), getIsbn(), getPageCount());}

    public static BookDTO of(final BookModel pModel) {
        final BookDTO dto = new BookDTO();
        dto.setId(pModel.getId());
        dto.setTitle(pModel.getTitle());
        dto.setAuthor(pModel.getAuthor());
        dto.setIsbn(pModel.getIsbn());
        dto.setPageCount(pModel.getNumberOfPages());

        return dto;
    }
}
