package com.ats.kbsearch.kbsearchelastic.repositories;

import com.ats.kbsearch.kbsearchelastic.domains.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by amit on 6/13/17.
 */
public interface BookRepository extends ElasticsearchRepository<Book, String> {

    Page<Book> findByAuthor(String author, Pageable pageable);
    List<Book> findByTitle(String title);
}
