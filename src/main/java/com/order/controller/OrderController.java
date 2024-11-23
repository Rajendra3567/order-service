package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.dto.OrderDTO;
import com.order.dto.OrderDTOFromFE;
import com.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	/// save order in db 
	@PostMapping("/saveOrder")
	public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFE orderDetails) {
		OrderDTO orderSavedInDb = orderService.saveOrderInDb(orderDetails);
		return new ResponseEntity<>(orderSavedInDb, HttpStatus.CREATED);
	}

}
