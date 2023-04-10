package com.neosoft.poc.foodjournal.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.neosoft.poc.foodjournal.dto.fooddto.FoodDto;
import com.neosoft.poc.foodjournal.dto.response.Response;

public interface FoodService {

	

	//Response<PaginationResponse<List<FoodDto>>> getFoodDetails(String fieldName, String searchByField ,Integer PageSize,Integer PageNumber );

  
	
	public Response<List<FoodDto>> getFoodDetails(Integer PageNumber, Integer PageSize);

	public Response<FoodDto> addFood(FoodDto foodDto) throws IOException;

	public Response<FoodDto> deleteFoodById(int id);

	public Response<FoodDto> getSingleFood(int id);

	public Response<FoodDto> updateFoodDetails(FoodDto foodDto) throws ParseException;

	

	

	

}

