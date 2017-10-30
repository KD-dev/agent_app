package com.board.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;

@Entity
@Data
@Table(name = "board")
@Getter @Setter
@ToString
public class BoardPost {

    @Id
    @GeneratedValue
    @Column(name = "seqNo")
    private long seqNo;

    @Column(name = "title")
    @NotEmpty
    private String title;

    @Column(name = "content")
    @NotEmpty
    private String content;

    @Column(name = "hit_count")
    private int hit_count;

    @Column(name = "regDate")
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private int regDate;

    @Column(name = "updateDate")
    private int updateDate;

}
