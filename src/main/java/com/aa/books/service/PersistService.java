package com.aa.books.service;

import com.aa.books.dto.BookDTO;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class PersistService {

    //todo - switch out BookDTO for BookModel, DTO should not be directly tied to service layer
    private final Map<Integer, BookDTO> repo = new HashMap<>();
    private int idCounter = 0;

    public BookDTO create(final BookDTO pDTO) {
        val id = ++idCounter;
        pDTO.setId(id);
        repo.put(id, pDTO);

        return pDTO;
    }

    public Optional<BookDTO> read(final int pId) {

        return Optional.ofNullable(repo.get(pId));
    }


    public Optional<BookDTO> update(final int pId, final BookDTO pDTO) {
        if (repo.containsKey(pId)) {
            pDTO.setId(pId);
            repo.put(pId, pDTO);
            return Optional.of(pDTO);
        }
        return Optional.empty();
    }

    public boolean delete(final int pId) {
        if (repo.containsKey(pId)) {
            repo.remove(pId);
            return true;
        }
        return false;

    }
}
