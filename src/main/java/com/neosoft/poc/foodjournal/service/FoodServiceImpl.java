package com.neosoft.poc.foodjournal.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.neosoft.poc.foodjournal.dto.fooddto.FoodDto;
import com.neosoft.poc.foodjournal.dto.response.Response;
import com.neosoft.poc.foodjournal.entity.Food;
import com.neosoft.poc.foodjournal.error.CustomException;
import com.neosoft.poc.foodjournal.error.HttpStatusCode;
import com.neosoft.poc.foodjournal.error.Result;
import com.neosoft.poc.foodjournal.mapper.FoodMapper;
import com.neosoft.poc.foodjournal.repository.FoodRepository;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodRepository foodRepository;

	@Autowired
	private FoodMapper foodMapper;

	 Logger logger = LoggerFactory.getLogger(FoodServiceImpl.class);
	
	
	

	 @Override
		public Response<FoodDto> addFood(FoodDto foodDto) throws IOException {
		
	    	Result<FoodDto> res=new Result<>();
			Response<FoodDto> response = new Response<>();
			Optional<FoodDto> tempFood =Optional.empty();
			
		res.setData(null);
			  if(tempFood.isPresent()){
		            throw new CustomException(HttpStatusCode.RESOURCE_ALREADY_EXISTS.getCode(),HttpStatusCode.RESOURCE_ALREADY_EXISTS, HttpStatusCode.RESOURCE_ALREADY_EXISTS.getMessage(),res);
			  }
			  
			  Food savedFood = foodRepository.save(foodMapper.dtoToEntity(foodDto));
				response.setStatusCode(HttpStatusCode.RESOURCE_CREATED_SUCCESSFULLY.getCode());
				response.setMessage(HttpStatusCode.RESOURCE_CREATED_SUCCESSFULLY.getMessage());
				response.setResult(new Result<FoodDto>(foodMapper.entityToDto(savedFood)));
				return response;
		}
		

	 @Override
		public Response<List<FoodDto>> getFoodDetails(Integer PageNumber, Integer PageSize) {
		
	    	Result<List<FoodDto>> res=new Result<>();
	    	res.setData(null);
			Pageable paging = PageRequest.of(PageNumber, PageSize);
			Response<List<FoodDto>> getListofFood = new Response<>();
			Page<Food> list = this.foodRepository.findAll(paging);

			List<FoodDto> foodDtos =foodMapper.entitiesToDtos(list.toList());

			res.setData(foodDtos);
			if (list.getSize() == 0) {
				throw new CustomException(HttpStatusCode.NO_ENTRY_FOUND.getCode(), HttpStatusCode.NO_ENTRY_FOUND,
						HttpStatusCode.NO_ENTRY_FOUND.getMessage(), res);
			}
			getListofFood.setStatusCode(200);
			getListofFood.setResult(res);
			return getListofFood;
		}

	  @Override
			public Response<FoodDto> getSingleFood(int id) {
			
	    	Result<FoodDto> res=new Result<>();
	    	res.setData(null);
	    		Response<FoodDto> getFood = new Response<FoodDto>();
	    		Optional<Food> food = null;
	    		food = this.foodRepository.findById(id);
	    		Result<FoodDto> foodResult = new Result<>();
	    		if (!food.isPresent()) {
	    			throw new CustomException(HttpStatusCode.NO_FOOD_MATCH_WITH_ID.getCode(),
	    					HttpStatusCode.NO_FOOD_MATCH_WITH_ID, HttpStatusCode.NO_FOOD_MATCH_WITH_ID.getMessage(), res);
	    		}
	    		foodResult.setData(foodMapper.entityToDto(food.get()));
	    		getFood.setStatusCode(200);
	    		getFood.setResult(foodResult);
	    		return getFood;
	    	}
	    	
	    	
	 	  

	    @Override
		public Response<FoodDto> updateFoodDetails(FoodDto foodDto) throws ParseException {
			Result<FoodDto> res=new Result<>();
			res.setData(null);
			
			Optional<Food> existingFoodContainer = foodRepository.findById(foodDto.getId());
			if (!existingFoodContainer.isPresent()) {
				throw new CustomException(HttpStatusCode.NO_FOOD_FOUND.getCode(), HttpStatusCode.NO_FOOD_FOUND,
						HttpStatusCode.NO_FOOD_FOUND.getMessage(), res);
			}
			FoodDto existingFood =foodMapper.entityToDto(existingFoodContainer.get());

			existingFood.setFoodName(foodDto.getFoodName());
			existingFood.setFoodType(foodDto.getFoodType());
			existingFood.setDescription(foodDto.getDescription());
			existingFood.setFoodQuantity(foodDto.getFoodQuantity());
			Food updateFood = foodRepository.save(foodMapper.dtoToEntity(existingFood));
			Response<FoodDto> response = new Response<>();
			response.setMessage(HttpStatusCode.FOOD_UPDATED.getMessage());
			response.setStatusCode(HttpStatusCode.FOOD_UPDATED.getCode());
			response.setResult(new Result<>(foodMapper.entityToDto(updateFood)));
			return response;
		}
	   
	     	
		
		
		
	    @Override
		public Response<FoodDto> deleteFoodById(int id) {
		
	  	Result<FoodDto> res=new Result<>();
			res.setData(null);
			Optional<Food> food = foodRepository.findById(id);
			if (!food.isPresent()) {
				throw new CustomException(HttpStatusCode.RESOURCE_NOT_FOUND.getCode(), HttpStatusCode.RESOURCE_NOT_FOUND,
						HttpStatusCode.RESOURCE_NOT_FOUND.getMessage(), res);
			}
			foodRepository.deleteById(id);
			Response<FoodDto> response = new Response<>();
			response.setMessage(HttpStatusCode.FOOD_DELETED.getMessage());
			response.setStatusCode(HttpStatusCode.FOOD_DELETED.getCode());
			response.setResult(new Result<FoodDto>(foodMapper.entityToDto(food.get())));
			return response;	

		}
		
	}