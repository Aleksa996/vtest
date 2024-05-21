package com.benefitseller.repositories;

import com.benefitseller.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends JpaRepository<Transaction, Long> {
}
