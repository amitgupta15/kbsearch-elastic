package com.ats.kbsearch.kbsearchelastic;

import com.ats.kbsearch.kbsearchelastic.domains.Topic;
import com.ats.kbsearch.kbsearchelastic.repositories.TopicRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by amit on 6/23/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicTests {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private ElasticsearchTemplate template;

    @Before
    public void before() {
        template.deleteIndex(Topic.class);
        template.createIndex(Topic.class);
        template.putMapping(Topic.class);
        template.refresh(Topic.class);
    }

    @Test
    public void saveTest() {
        Topic topic = new Topic("How do I Pay my bill?", "Go online at https://mysearch.socalgas.com");
        Topic testTopic = topicRepository.save(topic);

        assertThat(testTopic).isNotNull();
        assertThat(testTopic.getAnswer()).isEqualTo(topic.getAnswer());
    }

    @Test
    public void findOneTest() {
        Topic topic = topicRepository.save(new Topic(1L, "How do I Pay my bill?", "Go online at https://mysearch.socalgas.com"));

        Topic testTopic = topicRepository.findOne(topic.getId());

        assertThat(testTopic.getId()).isNotNull();
        assertThat(testTopic.getTitle()).isEqualTo(topic.getTitle());

    }

    @Test
    public void findByTitle() {
        Topic topic = topicRepository.save(new Topic(1L, "How do I Pay my bill?", "Go online at https://mysearch.socalgas.com"));

        List<Topic> testTopicList = topicRepository.findByTitle("my bill");
        assertThat(testTopicList.size()).isEqualTo(1);
    }
}


/**
 TODO:
 For a topic "How do I pay my bill?", search terms such as "how do I pay my bill online?" should match the topic
 */