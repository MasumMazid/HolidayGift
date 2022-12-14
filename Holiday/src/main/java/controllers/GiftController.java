package controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import models.Gift;
import services.GiftService;

@RestController
@RequestMapping("/gift")
public class GiftController {
	
	@Autowired
	 GiftService giftservice;

	
	//putting data up
@PostMapping	
public GiftService addGift(@RequestBody Gift gift) {
	return giftservice;
	
}
@DeleteMapping
public GiftService deleteGift(@RequestBody Gift gift) {
	return giftservice;
}

	
}


