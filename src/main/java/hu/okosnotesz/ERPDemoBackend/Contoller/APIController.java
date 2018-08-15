/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.okosnotesz.ERPDemoBackend.Contoller;

import hu.okosnotesz.ERPDemoBackend.model.Product;
import hu.okosnotesz.ERPDemoBackend.repository.ProductsRepository;
import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bodnár Tamás <tms.bodnar@gmail.com> | www.kalandlabor.hu
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class APIController {
    
    @Autowired
    ProductsRepository repo;
    List<Product> allProducts = null;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    
    @RequestMapping(value = "/api/addProduct", method = RequestMethod.POST, produces = "application/json")
    public Product addProduct(@RequestBody String name){
        System.out.println(name);
        Product prod = new Product();
        prod.setName(name);
        repo.save(prod);
        return prod;
    }
    
    @RequestMapping(value = "/api/getAllProducts", produces = "application/json")
    public List<Product> getAllProduct(){
        allProducts = repo.findAll();
    return allProducts;
    }
    
    @RequestMapping(value = "/api/updateProduct", produces = "application/json")
    public Product updateProduct(String name, String id){
        for (Product prod : allProducts) {
            if(prod.getId() == Long.parseLong(id)){
            prod.setName(name);
            repo.save(prod);
            return prod;
            }
        }
       return null;
    }
    
    @RequestMapping(value = "/api/deleteProduct", method = RequestMethod.DELETE, produces = "application/json")
    public int deleteProduct(String id){
        System.out.println(id);
            repo.deleteById(Long.parseLong(id));
            return Integer.valueOf(id);
    }
    
    static class CORSFilter implements Filter{

        @Override
        public void init(FilterConfig fc) throws ServletException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void doFilter(ServletRequest srq, ServletResponse srs, FilterChain fc) throws IOException, ServletException {
            HttpServletRequest req = (HttpServletRequest) srq;
            HttpServletResponse res = (HttpServletResponse) srs;
            res.setHeader("Access-Contoll-Allow-Origin", "*");
            res.setHeader("Access-Contoll-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
            res.setHeader("Access-Contoll-Max-Age", "3600");
            res.setHeader("Access-Contoll-Allow-Headers", "Content-Type");
            res.setHeader("Access-Contoll-Expose-Headers", "*");
            res.setHeader("Access-Contoll-Allow-Credentials", "true");
            fc.doFilter(req, res);
        }

        @Override
        public void destroy() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
