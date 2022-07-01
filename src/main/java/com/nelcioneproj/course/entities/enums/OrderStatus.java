package com.nelcioneproj.course.entities.enums;

public enum OrderStatus {

	WATTING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	//construtor do enum
	private OrderStatus(int code) {
		this.code = code;
	}
	
	//retorna um codigo
	public int getCode() {
		return code;
	}
	
	// converte um numérico para um enum
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			} 
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
	
}
