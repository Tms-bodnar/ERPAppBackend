/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.okosnotesz.ERPDemoBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

/**
 *
 * @author Bodnár Tamás <tms.bodnar@gmail.com> | www.kalandlabor.hu
 */
@Entity
@Table(name = "products")
public class Product {
    
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;
    
    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
