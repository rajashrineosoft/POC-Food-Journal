package com.neosoft.poc.foodjournal.service;

import java.io.IOException;
import java.util.List;

import com.neosoft.poc.foodjournal.dto.imagedto.ImageDto;
import com.neosoft.poc.foodjournal.dto.response.Response;

public interface ImageService {

	public Response<List<ImageDto>> getImage(Integer PageNumber, Integer PageSize);

	public Response<ImageDto> addImage(ImageDto imageDto) throws IOException;
}
