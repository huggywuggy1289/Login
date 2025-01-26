package com.ultimate.ultimate1.services;

import com.ultimate.ultimate1.model.LoginProcessor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<LoginProcessor> products = new ArrayList<>();

    public void addProduct(LoginProcessor p){
        products.add(p);
    }

    public List<LoginProcessor> findAll(){
        return products;
    }
}
