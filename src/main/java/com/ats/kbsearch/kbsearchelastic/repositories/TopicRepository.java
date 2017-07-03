package com.ats.kbsearch.kbsearchelastic.repositories;

import com.ats.kbsearch.kbsearchelastic.domains.Topic;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by amit on 6/23/17.
 */
public interface TopicRepository extends ElasticsearchRepository<Topic, Long> {

    List<Topic> findByTitle(String title);
}
