package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/api/authors")
    public ResponseEntity<List<Author>> getAllAuthors(){
        return ResponseEntity.ok(authorService.getAll());
    }

    @GetMapping("api/authors/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable long id){
        return ResponseEntity.ok(authorService.getById(id));
    }

    @PostMapping("api/authors")
    public ResponseEntity<Author> postAuthor(@RequestBody Author author){
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.saveAuthor(author));
    }

    @PutMapping("api/authors/{id}")
    public ResponseEntity<Author> putAuthor(@RequestBody Author author, @RequestParam long id){
        author.setId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.saveAuthor(author));
    }
}