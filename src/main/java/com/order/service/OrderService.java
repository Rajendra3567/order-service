package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.dto.OrderDTO;
import com.order.dto.OrderDTOFromFE;
import com.order.dto.UserDTO;
import com.order.entity.Order;
import com.order.mapper.OrderMapper;
import com.order.repo.OrderRepo;

@Service
public class OrderService {

	@Autowired
	OrderRepo orderRepo;

	@Autowired
	SequenceGenerator sequenceGenerator;

	@Autowired
	RestTemplate restTemplate;

	public OrderDTO saveOrderInDb(OrderDTOFromFE orderDetails) {
		Integer newOrderId = sequenceGenerator.generateNextOrderId();

		UserDTO userDetails = fetchUserDetailsFromUserId(orderDetails.getUserId());

		Order orderToBeSaved = new Order(newOrderId, orderDetails.getFoodItemsList(), orderDetails.getRestaurant(),
				userDetails);

		orderRepo.save(orderToBeSaved);
		return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);
	}

	private UserDTO fetchUserDetailsFromUserId(Integer userId) {
		return restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/" + userId, UserDTO.class);
	}
}
