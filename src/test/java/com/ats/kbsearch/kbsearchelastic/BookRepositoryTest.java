package com.ats.kbsearch.kbsearchelastic;

import com.ats.kbsearch.kbsearchelastic.domains.Book;
import com.ats.kbsearch.kbsearchelastic.repositories.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by amit on 6/14/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ElasticsearchTemplate template;

    @Before
    public void before() {
        template.deleteIndex(Book.class);
        template.createIndex(Book.class);
        template.putMapping(Book.class);
        template.refresh(Book.class);
    }

    @Test
    public void saveTest() {
        Book book = new Book("1001","Elasticsearch Basics", "Rambabu Posa", "23-Feb-2017");
        Book testBook = bookRepository.save(book);

        assertNotNull(testBook.getId());
        assertEquals(testBook.getTitle(), book.getTitle());
    }
}
