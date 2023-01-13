package com.example.demo.controller;

import com.example.demo.model.News;
import com.example.demo.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/api/news")
    public ResponseEntity<List<News>> getAllNews(){
        return ResponseEntity.ok(newsService.getAll());
    }

    @GetMapping("api/news/{id}")
    public ResponseEntity<News> getNews(@PathVariable long id){
        return ResponseEntity.ok(newsService.getById(id));
    }

    @PostMapping("api/news")
    public ResponseEntity<News> postNews(@RequestBody News news){
        return ResponseEntity.status(HttpStatus.CREATED).body(newsService.saveNews(news));
    }

    @PutMapping("api/news/{id}")
    public ResponseEntity<News> putNews(@RequestBody News news, @RequestParam long id){
        news.setId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(newsService.saveNews(news));
    }
}