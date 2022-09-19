package com.aa.books.controller;

import com.aa.books.dto.BookDTO;
import com.aa.books.service.PersistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/books/v1")
public class Controller {
    @Autowired
    private PersistService persistService;

    @PostMapping("/")
    public BookDTO create(@RequestBody final BookDTO pDTO) {
        return persistService.create(pDTO);
    }

    @GetMapping("/{id}")
    public BookDTO read(@PathVariable("id") final int pId) {
        return persistService.read(pId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public BookDTO update(
            @PathVariable("id") final int pId,
            @RequestBody final BookDTO pDTO
            ) {
        return persistService.update(pId, pDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final int pId) {
        if (!persistService.delete(pId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
