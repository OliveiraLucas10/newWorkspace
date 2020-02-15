package com.oliveiralucas.digital_shop;

import java.math.BigDecimal;
import java.nio.file.Path;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {

	private String name;

	private Path file;

	private BigDecimal price;

	@Override
	public String toString() {
		return this.name;
	}
}
