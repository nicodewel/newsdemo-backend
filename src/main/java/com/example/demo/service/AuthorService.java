package com.example.demo.service;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAll(){return authorRepository.findAll();}

    public Author getById(long id){return authorRepository.findById(id).get();}

    public Author saveAuthor(Author author){return authorRepository.save(author);}
}