package com.capgemini.go.ui;

import com.capgemini.go.controller.ProductException;

public class Executor {

	public static void main(String[] args) {
		System.out.println("\t\t\t PRODUCT MANAGEMENT SYSTEM\n\n");
		ProductServiceExecutor ps=new ProductServiceExecutor();
		try {
		    ps.productServiceExecutor();
	    }
		catch(ProductException p)
		{
			p.getMessage();
		}

}
}