package org.ourspring.trend.entities;

import lombok.Data;
import org.ourspring.global.entities.BaseEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("TREND")
public class Trend extends BaseEntity {
    @Id
    private Long seq;
    private String category;

    @Column("wordCloud")
    private String wordCloud;

    private String keywords;
}
