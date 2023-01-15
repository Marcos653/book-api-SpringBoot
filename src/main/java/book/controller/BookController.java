package book.controller;

import book.dto.*;
import book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping
    public Page<BookResponse> getAll() {
        var books = service.getAll();
        return new PageImpl<>(books);
    }

    @GetMapping("{id}")
    public BookResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public BookResponse create(@RequestBody BookRequest request) {
        return service.create(request);
    }

    @PutMapping("{id}")
    public BookResponse update(@RequestBody BookRequest request, @PathVariable Long id) {
        return service.update(request, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
