package com.neosoft.poc.foodjournal.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
import com.neosoft.poc.foodjournal.dto.imagedto.ImageDto;
import com.neosoft.poc.foodjournal.dto.response.Response;
import com.neosoft.poc.foodjournal.entity.Food;
import com.neosoft.poc.foodjournal.entity.Image;
import com.neosoft.poc.foodjournal.error.CustomException;
import com.neosoft.poc.foodjournal.error.HttpStatusCode;
import com.neosoft.poc.foodjournal.error.Result;
import com.neosoft.poc.foodjournal.mapper.FoodMapper;
import com.neosoft.poc.foodjournal.mapper.ImageMapper;
import com.neosoft.poc.foodjournal.repository.FoodRepository;
import com.neosoft.poc.foodjournal.repository.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {
	@Autowired
	private ImageMapper imageMapper;

	 Logger logger = LoggerFactory.getLogger(FoodServiceImpl.class);
	
	
	 @Autowired
		private ImageRepository imageRepository;


	 @Override
		public Response<ImageDto> addImage(ImageDto imageDto) throws IOException {
		
	    	Result<ImageDto> res=new Result<>();
			Response<ImageDto> response = new Response<>();
			Optional<ImageDto> tempImage =Optional.empty();
			
		res.setData(null);
			  if(tempImage.isPresent()){
		            throw new CustomException(HttpStatusCode.RESOURCE_ALREADY_EXISTS.getCode(),HttpStatusCode.RESOURCE_ALREADY_EXISTS, HttpStatusCode.RESOURCE_ALREADY_EXISTS.getMessage(),res);
			  }
//			  byte[] imageData = Files.readAllBytes(new File("C:\\Users\\Neosoft\\Desktop\\1.jpg").toPath());
//			  Image image = new Image();
//			  
//			  image.setImage(imageData);
//			  imageRepository.save(image);
			  Image savedImage = imageRepository.save(imageMapper.dtoToEntity(imageDto));
				response.setStatusCode(HttpStatusCode.RESOURCE_CREATED_SUCCESSFULLY.getCode());
				response.setMessage(HttpStatusCode.RESOURCE_CREATED_SUCCESSFULLY.getMessage());
				response.setResult(new Result<ImageDto>(imageMapper.entityToDto(savedImage)));
				return response;
		}
		

	 @Override
		public Response<List<ImageDto>> getImage(Integer PageNumber, Integer PageSize) {
		
	    	Result<List<ImageDto>> res=new Result<>();
	    	res.setData(null);
			Pageable paging = PageRequest.of(PageNumber, PageSize);
			Response<List<ImageDto>> getListofImage = new Response<>();
			Page<Image> list = this.imageRepository.findAll(paging);

			List<ImageDto> imageDtos =imageMapper.entitiesToDtos(list.toList());
//			Optional<Image> result = imageRepository.findById(1L);
//			if (result.isPresent()) {
//			    Image image = result.get();
//			    byte[] imageData = image.getImage();
//			    Files.write(new File("C:\\Users\\Neosoft\\Desktop\\1.jpg").toPath(), imageData);
//			}
			res.setData(imageDtos);
			if (list.getSize() == 0) {
				throw new CustomException(HttpStatusCode.NO_ENTRY_FOUND.getCode(), HttpStatusCode.NO_ENTRY_FOUND,
						HttpStatusCode.NO_ENTRY_FOUND.getMessage(), res);
			}
			getListofImage.setStatusCode(200);
			getListofImage.setResult(res);
			return getListofImage;
		}
	

}
