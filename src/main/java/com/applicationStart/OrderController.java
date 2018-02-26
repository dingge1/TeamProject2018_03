package com.applicationStart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController // Returns objects, not views 
public class OrderController {

  OrderRepo orderRepo;
  CaseRepo caseRepo;

//
  @Autowired
  private SimpMessagingTemplate template;

  @Autowired
  public OrderController(OrderRepo orderRepo, CaseRepo caseRepo ) {
    this.orderRepo = orderRepo;
    this.caseRepo = caseRepo;
  }
  
  // /menu
  @RequestMapping(value = "/order", method=RequestMethod.GET)
  public List<CustomerOrder> getOrders() {
    return orderRepo.findAllByOrderByOrdrTimeAsc();
  }
  
  @RequestMapping(value = "/makeorder", method=RequestMethod.POST)
  public List<CustomerOrder> addItem(@RequestBody CustomerOrder customerOrder){
    orderRepo.save(customerOrder);
    return orderRepo.findAllByOrderByOrdrTimeAsc();
  }
  
  @RequestMapping(value = "/caseorder", method=RequestMethod.GET)
  public List<CaseItem> getCaseOrders() {
    return caseRepo.findAll();
  }
  
  @RequestMapping(value = "/makecaseorder", method=RequestMethod.POST)
  public List<CaseItem> addCaseItem(@RequestBody CaseItem caseOrder){
    caseRepo.save(caseOrder);
    return caseRepo.findAll();
  }
  
  @RequestMapping(value = "/remove/{id}", method=RequestMethod.POST)
  public List<CaseItem> deleteCaseOrdr(@PathVariable long id){
    caseRepo.delete(id);
    return caseRepo.findAll();
  }
  
  @RequestMapping(value = "/removeordr/{id}", method=RequestMethod.POST)
  public List<CustomerOrder> deleteOrdr(@PathVariable long id){
    orderRepo.delete(id);
    return orderRepo.findAllByOrderByOrdrTimeAsc();
  }
  
  @RequestMapping(value = "/confirmordr/{id}", method=RequestMethod.POST)
  public List<CustomerOrder> confirmOrdr(@PathVariable long id){
    CustomerOrder customerOrder = orderRepo.findOne(id);
    customerOrder.setConfirmed(true);
    
    orderRepo.save(customerOrder);
    return orderRepo.findAllByOrderByOrdrTimeAsc();
  }
  
  @RequestMapping(value = "/readyordr/{id}", method=RequestMethod.POST)
  public List<CustomerOrder> readyOrdr(@PathVariable long id){
    CustomerOrder customerOrder = orderRepo.findOne(id);
    customerOrder.setReady(true);
    template.convertAndSend("/topic/kitchenStaffNotify","Order "+customerOrder.getId()+" is ready!");
    
    orderRepo.save(customerOrder);
    return orderRepo.findAllByOrderByOrdrTimeAsc();
  }
  
  @RequestMapping(value = "/call", method=RequestMethod.POST)
  public List<CustomerOrder> call(@RequestBody CustomerOrder customerOrder){
    orderRepo.save(customerOrder);
    template.convertAndSend("/topic/waiterNotify",customerOrder.getTable()+" is calling");
    return orderRepo.findAllByOrderByOrdrTimeAsc();
  }
  
  
}
