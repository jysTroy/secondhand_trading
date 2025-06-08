package org.ourspring.trend.entities;

import lombok.Data;
import java.util.Map;

@Data
public class TrendCrawling {
    private String image;
    private Map<String, Integer> keywords;
}
