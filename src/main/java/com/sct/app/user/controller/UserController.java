package com.sct.app.user.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sct.app.user.model.UserVO;
import com.sct.app.user.services.UserService;

@RestController
@RequestMapping("/")
public class UserController {
	
	
    private static final String STATUS = "status";
    private static final String SUCCESS = "success";
    private static final String FAILURE = "fail";
    private static final String MSG = "msg";
    private static final String FAILUREERRORMSG =
            "There was an error processing your request.";
    private static final String VALIDATIONFAILURE = "validationfail";

  @Autowired UserService service;
  
	
	@RequestMapping(value = "/login", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional(propagation = Propagation.REQUIRED)
	public Map<String, Object> indexPage(
            @RequestBody final Map<String, Object> params,
            final HttpServletRequest request,
            final HttpServletResponse response
            ) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		 ObjectMapper mapper = new ObjectMapper()
	                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	       
		 
	        Map<String, Object>  mapped=(Map<String, Object>) params.get("sctdata");
	        
	        UserVO userVO = mapper.convertValue(mapped, UserVO.class);
	        
			 try 
	            {   
	            //	BeanPropertyBindingResult result = new BeanPropertyBindingResult(sampleBoostDTO, "sampleBoostDTO");
	            	 
	            //	ValidationUtils.invokeValidator(sampleBoostValidator, sampleBoostDTO, result);	               
	                	 Optional<UserVO> employee = this.service.getEmployeeByUserAndPass(userVO); 
	                	 if(employee.isPresent()) {
	                		 map.put(STATUS, SUCCESS);  
 					map.put(STATUS, SUCCESS);  

	                	 }
	                
	                else {
	                	
	                	map.put(STATUS, FAILURE);
	                    map.put(MSG, "Wrong User Name or Password");
	                }
	                 return map;
	            } 
	            
	            catch (final Exception e) {
	                System.out.println( "Error while retrieving data" + e.getMessage());
	                e.printStackTrace();
	                map.put(STATUS, FAILURE);
	                map.put(MSG, FAILUREERRORMSG);
	                return map;
	            }
		
		
	}
	
	@RequestMapping(value = "/getPersonalDetail", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String, Object> getShowDetail(
            @RequestBody final Map<String, Object> params,
            final HttpServletRequest request,
            final HttpServletResponse response) {
      
              
        return new HashMap<String, Object>();
    }

	

}
