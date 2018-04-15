/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.canvt.springtrestful;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jndi.JndiTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "br.canvt.springrestful" })
public class WebConfig extends WebMvcConfigurerAdapter {
 
 @Autowired
 DataSource dataSource;
 
 @Bean
 public NamedParameterJdbcTemplate geNamedParameterJdbcTemplate(){
  return new NamedParameterJdbcTemplate(dataSource);
 }
 
 @Bean
 public DataSource getDataSource() throws NamingException{
  JndiTemplate jndiTemplate = new JndiTemplate();
  DataSource dataSource = (DataSource) jndiTemplate.lookup("java:comp/env/jdbc/springmvc");
  
  return dataSource;
 }
 
}
