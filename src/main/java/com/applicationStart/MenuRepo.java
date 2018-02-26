package com.applicationStart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepo extends JpaRepository<MenuItem, Long> {
    public List<MenuItem> findAllByOrderByContainsNutsAsc();
    public List<MenuItem> findAllByOrderByContainsNutsDesc();
    
    public List<MenuItem> findAllByOrderByPriceAsc();
    public List<MenuItem> findAllByOrderByPriceDesc();
    
    public List<MenuItem> findAllByOrderByIsVegAsc();
    public List<MenuItem> findAllByOrderByIsVegDesc();



}
