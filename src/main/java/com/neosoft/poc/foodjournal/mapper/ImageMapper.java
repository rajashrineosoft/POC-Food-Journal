package com.neosoft.poc.foodjournal.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.neosoft.poc.foodjournal.dto.imagedto.ImageDto;
import com.neosoft.poc.foodjournal.entity.Image;
@Component
public class ImageMapper {
ModelMapper modelMapper = new ModelMapper();
	
	
	public ImageDto entityToDto(Image image) {
	ImageDto imageDto =  new ImageDto();
		imageDto.setImage_id(image.getImage_id());
		imageDto.setName(image.getName());
		imageDto.setImage(image.getImage());
		
		return imageDto;
	}
	
	
	public Image dtoToEntity(ImageDto imageDto) {
		return modelMapper.map(imageDto, Image.class);
	}


	public List<ImageDto> entitiesToDtos(List<Image> image) {
		
		return image.stream().filter(Objects::nonNull).map(this::entityToDto).collect(Collectors.toList());
	}

	
	}
	

