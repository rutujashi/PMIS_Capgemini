package com.microwarehouse.model;

public class OrderItemRequest {
	
	    private int skuId;
	    private int quantity;

	    public OrderItemRequest(int skuId, int quantity) {
	        this.skuId = skuId;
	        this.quantity = quantity;
	    }

	    public int getSkuId() {
	        return skuId;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

}
