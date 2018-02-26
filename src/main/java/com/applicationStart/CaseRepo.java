package com.applicationStart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseRepo extends JpaRepository<CaseItem, Long> {

}
