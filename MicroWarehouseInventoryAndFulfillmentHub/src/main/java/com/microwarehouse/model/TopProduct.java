package com.microwarehouse.model;

public class TopProduct {

	    private String productName;
	    private int totalQuantity;

	    public TopProduct(String productName, int totalQuantity) {
	        this.productName = productName;
	        this.totalQuantity = totalQuantity;
	    }

	    public String getProductName() {
	        return productName;
	    }

	    public int getTotalQuantity() {
	        return totalQuantity;
	    }

	    @Override
	    public String toString() {
	        return productName +
	               " | Sold Quantity: " + totalQuantity;
	    }
}
