package com.movie.primepicks.repository;

import com.movie.primepicks.entity.Preference;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferenceRepository extends CrudRepository<Preference,Integer> {

    @Query(value="SELECT GREATEST(action, comedy, horror, suspense, thriller) AS max_rating FROM preference WHERE id = :userId", nativeQuery = true)
    Integer findMaxRatingByUserId(@Param("userId") Integer userId);
}
