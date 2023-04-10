package com.neosoft.poc.foodjournal.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.poc.foodjournal.dto.fooddto.FoodDto;
import com.neosoft.poc.foodjournal.dto.response.Response;
import com.neosoft.poc.foodjournal.service.FoodService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/food")
public class FoodController {


	@Autowired(required = true)
	private FoodService foodService;

	Logger logger = LoggerFactory.getLogger(FoodController.class);


	@Operation(summary = "Create New Food", security = @SecurityRequirement(name = "bearerAuth"))
	@PostMapping
	public ResponseEntity<Response<FoodDto>> addFood(@Valid @RequestBody FoodDto foodDto) throws IOException {
		Response<FoodDto> foodResponse = foodService.addFood(foodDto);
		return ResponseEntity.ok().body(foodResponse);

	}

	@Operation(summary = "Get All Food Details", security = @SecurityRequirement(name = "bearerAuth"))
	@GetMapping
	public ResponseEntity<Response<List<FoodDto>>> getFoodDetails(	
			@RequestParam(value = "PageNumber", defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "PageSize", defaultValue = "5", required = false) Integer pageSize) {
		Response<List<FoodDto>> response = foodService.getFoodDetails(pageNumber, pageSize);
		return ResponseEntity.ok().body(response);

	}
	@Operation(summary = "Delete Food By Id", security = @SecurityRequirement(name = "bearerAuth"))
	@DeleteMapping("/{id}")
	public ResponseEntity<Response<FoodDto>> deleteFood(@PathVariable("id") int id) 
	{
		Response<FoodDto> response = foodService.deleteFoodById(id);
		return ResponseEntity.ok().body(response);
	}
	
	@Operation(summary = "Get Single food", security = @SecurityRequirement(name = "bearerAuth"))
	@GetMapping("/{id}")
	public ResponseEntity<Response<FoodDto>> getSingleFood(@PathVariable int id) {
	  Response<FoodDto> response=foodService.getSingleFood(id);
	  return ResponseEntity.ok().body(response);
	}

	@Operation(summary = "Update Food By Id", security = @SecurityRequirement(name = "bearerAuth"))
	@PutMapping("/{foodId}")
	public ResponseEntity<Response<FoodDto>> updateTransferCertificate(@Valid @RequestBody FoodDto foodDto) throws ParseException { // NOSONAR
	  Response<FoodDto> response=foodService.updateFoodDetails(foodDto);
	  return ResponseEntity.ok().body(response);
	}

}
