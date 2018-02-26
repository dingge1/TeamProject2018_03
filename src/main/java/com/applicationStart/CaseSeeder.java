package com.applicationStart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component // Spring will search for components first and execute them
public class CaseSeeder implements CommandLineRunner{

  private CaseRepo caseRepo;
  
  @Autowired
  public CaseSeeder(CaseRepo caseRepo) {
    this.caseRepo = caseRepo;
  }

  @Override
  public void run(String... strings) throws Exception {
    List<CaseItem> caseOrders = new ArrayList<>();
    
    caseOrders.add(new CaseItem(1, 3, "jack", "Table 3", "Extra Cheesy Tuna", 4.0, 7));
    caseOrders.add(new CaseItem(2, 638, "bob", "Table 5", "Extra Cheesy Chicken", 10.0, 8));
    
    caseRepo.save(caseOrders);
  }
  
  
}
