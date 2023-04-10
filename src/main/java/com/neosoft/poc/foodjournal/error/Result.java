package com.neosoft.poc.foodjournal.error;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Result<T> implements Serializable {
	private static final long serialVersionUID = 2405172041950251807L;
	private T data;
}
