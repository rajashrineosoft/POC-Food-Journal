package com.neosoft.poc.foodjournal.mapper;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neosoft.poc.foodjournal.dto.fooddto.FoodDto;
import com.neosoft.poc.foodjournal.entity.Food;


@Component
public class FoodMapper {

	ModelMapper modelMapper = new ModelMapper();
	
	
	public FoodDto entityToDto(Food food) {
		FoodDto foodDto =  new FoodDto();
		foodDto.setId(food.getId());
		foodDto.setFoodName(food.getFoodName());
		foodDto.setFoodType(food.getFoodType());
		foodDto.setDescription(food.getDescription());
		foodDto.setFoodQuantity(food.getFoodQuantity());
		
		return foodDto;
	}
	
	
	public Food dtoToEntity(FoodDto foodDto) {
		return modelMapper.map(foodDto, Food.class);
	}


	public List<FoodDto> entitiesToDtos(List<Food> food) {
		
		return food.stream().filter(Objects::nonNull).map(this::entityToDto).collect(Collectors.toList());
	}

	
	}
	
	
	

