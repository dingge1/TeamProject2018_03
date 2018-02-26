package com.applicationStart;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component // Spring will search for components first and execute them
public class OrderSeeder implements CommandLineRunner{

  private OrderRepo orderRepo;
  
  @Autowired
  public OrderSeeder(OrderRepo orderRepo) {
    this.orderRepo = orderRepo;
  }

  @Override
  public void run(String... strings) throws Exception {
    List<CustomerOrder> orders = new ArrayList<>();
    
    Date seedTime = new Date();

    orders.add(new CustomerOrder(1, "jack", "Table 3", seedTime, true, false));
    orders.add(new CustomerOrder(1, "bob", "Table 5", seedTime, false, false));
    
    orderRepo.save(orders);
  }
  
  
}
