package com.market.repository;

import com.market.model.Costumer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CostumerRepository extends JpaRepository<Costumer, Long> {
    @Transactional(readOnly = true)
    @Query(value = "select * from costumer c" +
            " where c.name like %?1%", nativeQuery = true)
    Page<Costumer> findCustomers(String name, Pageable page);

    @Transactional(readOnly = true)
    Page<Costumer> findByNameContaining(String name, Pageable page);

    @Transactional(readOnly = true)
    Costumer findByEmail(String email);
}
