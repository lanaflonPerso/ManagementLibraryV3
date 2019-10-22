package com.mlending.repository;



import com.mlending.model.Lending;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILendingRepository extends JpaRepository<Lending,Long> {
}
