package com.jojoldu.book.springboot.domain.posts;


import com.fasterxml.jackson.databind.ser.Serializers;
import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // all field has getter method
@NoArgsConstructor // default constructor added
@Entity // linked with table(db)

//  Entity class never has Setter...

//  If field change required, define method
public class Posts extends BaseTimeEntity {

    @Id // table's PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK generation rules, auto increment
    private long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
