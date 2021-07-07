package com.example.backend.repository;

import com.example.backend.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document,Integer> {
    @Query("Select d.id from Document d where d.customer.id = :id")
    List<Integer> findByCustomerId(@Param("id")int id);
    @Query("Select d from Document d where d.customer.id = :id")
    List<Document> findAllByCustomerId(@Param("id")int id);
}
