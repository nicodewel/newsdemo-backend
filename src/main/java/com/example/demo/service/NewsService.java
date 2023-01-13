package com.example.demo.service;

import com.example.demo.model.News;
import com.example.demo.repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<News> getAll(){return newsRepository.findAll();}

    public News getById(long id){return newsRepository.findById(id).get();}

    public News saveNews(News news){return newsRepository.save(news);}
}