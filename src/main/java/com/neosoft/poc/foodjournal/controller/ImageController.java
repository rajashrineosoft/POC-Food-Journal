package com.neosoft.poc.foodjournal.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.poc.foodjournal.dto.fooddto.FoodDto;
import com.neosoft.poc.foodjournal.dto.imagedto.ImageDto;
import com.neosoft.poc.foodjournal.dto.response.Response;
import com.neosoft.poc.foodjournal.service.FoodService;
import com.neosoft.poc.foodjournal.service.ImageService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/image")
public class ImageController {

	@Autowired(required = true)
	private ImageService imageService;

	Logger logger = LoggerFactory.getLogger(ImageController.class);


	@Operation(summary = "Create New Image", security = @SecurityRequirement(name = "bearerAuth"))
	@PostMapping
	public ResponseEntity<Response<ImageDto>> addImage(@Valid @RequestBody ImageDto imageDto) throws IOException {
		Response<ImageDto> imageResponse = imageService.addImage(imageDto);
		return ResponseEntity.ok().body(imageResponse);

	}

	@Operation(summary = "Get All Image Details", security = @SecurityRequirement(name = "bearerAuth"))
	@GetMapping
	public ResponseEntity<Response<List<ImageDto>>> getImage(	
			@RequestParam(value = "PageNumber", defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "PageSize", defaultValue = "5", required = false) Integer pageSize) {
		Response<List<ImageDto>> response = imageService.getImage(pageNumber, pageSize);
		return ResponseEntity.ok().body(response);

	}
	
	
	
}
