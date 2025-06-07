package org.ourspring.trend.repositories;

import org.ourspring.trend.entities.Trend;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface TrendRepository extends ListCrudRepository<Trend, Long> {

    @Query("SELECT * FROM TREND WHERE category=:category ORDER BY createdAt DESC LIMIT 1")
    Optional<Trend> getLatest(@Param("category") String category);

    @Query("SELECT * FROM Trend t WHERE t.category=:category AND t.createdAt BETWEEN :sDate AND :eDate ORDER BY t.createdAt DESC")
    Optional<Trend> getPeriodTrend(String category, LocalDate date);

}
