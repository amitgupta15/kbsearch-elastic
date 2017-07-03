package com.ats.kbsearch.kbsearchelastic.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by amit on 6/23/17.
 */

@Document(indexName = "kbsearch", type = "topic")
public class Topic {

    @Id
    private Long id;
    private String title;
    private String answer;

    public Topic() {}

    public Topic(String title, String answer) {
        this.title = title;
        this.answer = answer;
    }

    public Topic(Long id, String title, String answer) {
        this.id = id;
        this.title = title;
        this.answer = answer;
    }

    public String getTitle() {
        return title;
    }

    public String getAnswer() {
        return answer;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
