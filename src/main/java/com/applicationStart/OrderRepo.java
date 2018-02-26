package com.applicationStart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<CustomerOrder, Long> {
  public List<CustomerOrder> findAllByOrderByOrdrTimeAsc();
}
