package com.neosoft.poc.foodjournal.dto.fooddto;

import com.neosoft.poc.foodjournal.entity.Image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodDto {
	private int id;

	   private String foodName;
	   
	   private String foodType;
	   
	   private String description;
	   
	   private int foodQuantity;
	   
	
}
