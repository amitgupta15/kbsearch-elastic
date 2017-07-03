package com.ats.kbsearch.kbsearchelastic;

import com.ats.kbsearch.kbsearchelastic.domains.Topic;
import com.ats.kbsearch.kbsearchelastic.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

/**
 * Created by amit on 6/23/17.
 */

@Configuration
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Autowired
    TopicRepository topicRepository;

    @Override
    public void run(String... strings) throws Exception {

        topicRepository.save(new Topic(1L, "How do I Pay my bill?", "Go online at https://mysearch.socalgas.com"));
        topicRepository.save(new Topic(2L, "What kind of assistance programs are available?", "LiHEAP, GAF, Level Pay Plan"));
        topicRepository.save(new Topic(3L, "Are there rebates available for home owners?", "Low flow shower head rebate"));
        topicRepository.save(new Topic(4L, "How can I contact socalgas?", "online, mail, fax"));

        Page topicList = (Page) topicRepository.findAll();
        topicList.forEach(x -> System.out.println(x));
    }
}
