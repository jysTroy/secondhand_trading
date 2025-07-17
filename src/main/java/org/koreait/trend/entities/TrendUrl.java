package org.koreait.trend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class TrendUrl {
    @Id
    @Column
    private String siteUrl;
}
