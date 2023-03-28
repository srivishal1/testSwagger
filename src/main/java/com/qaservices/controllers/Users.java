package com.qaservices.controllers;

//import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/query")
//@Server(url = "http://localhost:8086")
public class Users {
	
	@RequestMapping(value="/pt/getappointmentdate/{timeOption}/{minutes}/{timezone}/{facilityid}/{trainerid}/{recurring}" ,method=RequestMethod.GET)
	//@Transactional(transactionManager="mrTransactionManager", timeout=1, rollbackFor= {Throwable.class})
	@ApiOperation(value="Get available appointment date to create,reschedule,cancel appointment"
			+ "Time options are as follows - with in 24 hours use 3"
			+ "after 24 hr any time - use 4, "
			+ "after 24 hr and within 48 hrs- use 5, "
			+ "after 90 dayes - user 90, "
			+ "after 72 hr for vj - use 72, "
			+ "after 48 hr for vj - use 48, "
			+ "after 24 hr for vj - use 24, " )
	String getAvailableDateTime(@PathVariable String timeOption, @PathVariable String minutes,@PathVariable String timezone,@PathVariable String facilityid,@PathVariable String trainerid,@PathVariable String recurring){
		return "vishal";
					
	}

}
