package com.aa.books;

import com.aa.books.dto.BookDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.awt.print.Book;

@Mapper
public interface BookMapper {

    @Mapping(target = "pageCount", source = "numberOfPages")
    BookDTO bookToBookDto(Book book);
}
