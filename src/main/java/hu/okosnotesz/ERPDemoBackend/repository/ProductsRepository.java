/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.okosnotesz.ERPDemoBackend.repository;

import hu.okosnotesz.ERPDemoBackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author Bodnár Tamás <tms.bodnar@gmail.com> | www.kalandlabor.hu
 */
@CrossOrigin
public interface ProductsRepository extends JpaRepository<Product, Long>{
    
}
