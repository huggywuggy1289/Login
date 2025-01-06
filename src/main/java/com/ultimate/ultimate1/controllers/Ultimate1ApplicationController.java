package com.ultimate.ultimate1.controllers;

import com.ultimate.ultimate1.model.Product;
import com.ultimate.ultimate1.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Ultimate1ApplicationController {
    //자바 언어에서 final은 오직 한번만 할당할 수 있는 entity 정의할 때 사용
   private final ProductService productService;
   public Ultimate1ApplicationController(ProductService productService){
       this.productService = productService;
   }
   // 상품 조회
   @RequestMapping("/products")
    public String viewProducts(Model model){
       var products = productService.findAll(); // 서비스에서 제품목록을 얻는다.
       model.addAttribute("products", products);// 컨트롤러가 제품목록을 뷰로 전송한다.
       return "products.html";
   }
   // 상품 초과
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String addProduct(Product p, Model model){
       //만약 매개변수에 @RequestParam String name, @RequestParam double price게 쓴다면
//        Product p = new Product();
//        p.setName(name);
//        p.setPrice(price); >> 모두 생략가능. 요청 매개변수가 Product클래스의 속성이름과 동일하기 때문
        productService.addProduct(p);

        var products = productService.findAll(); // 서비스에서 제품목록을 얻는다.
        model.addAttribute("products", products);
        return "products.html";
    }
}
