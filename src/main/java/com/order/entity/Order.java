package com.order.entity;

import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

import com.order.dto.FoodItemsDTO;
import com.order.dto.Restaurant;
import com.order.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Document("order")
public class Order {

	private Integer orderId;
	private List<FoodItemsDTO> foodItemsList;
	private Restaurant restaurantDTO;
	private UserDTO userDTO;


	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Integer orderId, List<FoodItemsDTO> foodItemsList, Restaurant restaurantDTO, UserDTO userDTO) {
		super();
		this.orderId = orderId;
		this.foodItemsList = foodItemsList;
		this.restaurantDTO = restaurantDTO;
		this.userDTO = userDTO;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public List<FoodItemsDTO> getFoodItemsList() {
		return foodItemsList;
	}

	public void setFoodItemsList(List<FoodItemsDTO> foodItemsList) {
		this.foodItemsList = foodItemsList;
	}

	public Restaurant getRestaurantDTO() {
		return restaurantDTO;
	}

	public void setRestaurantDTO(Restaurant restaurantDTO) {
		this.restaurantDTO = restaurantDTO;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

}
