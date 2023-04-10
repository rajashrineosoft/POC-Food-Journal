package com.neosoft.poc.foodjournal.dto.imagedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageDto {
	
	 private Long image_id;
	    private String name;
	  private byte[] image;


}
