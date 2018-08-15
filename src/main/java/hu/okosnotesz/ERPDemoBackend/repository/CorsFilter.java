/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.okosnotesz.ERPDemoBackend.repository;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Bodnár Tamás <tms.bodnar@gmail.com> | www.kalandlabor.hu
 */
public class CorsFilter implements Filter{

        @Override
        public void init(FilterConfig fc) throws ServletException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void doFilter(ServletRequest srq, ServletResponse srs, FilterChain fc) throws IOException, ServletException {
            HttpServletRequest req = (HttpServletRequest) srq;
            HttpServletResponse res = (HttpServletResponse) srs;
            res.setHeader("Access-Contoll-Allow-Origin", "http://localhost:4200");
            res.setHeader("Access-Contoll-Allow-Methods", "POST, GET, OPTIONS, DELETE");
            res.setHeader("Access-Contoll-Max-Age", "3600");
            res.setHeader("Access-Contoll-Allow-Headers", "getProducts");
            res.setHeader("Access-Contoll-Expose-Headers", "*");
            res.setHeader("Access-Contoll-Allow-Credentials", "true");
            fc.doFilter(req, res);
        }

        @Override
        public void destroy() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
