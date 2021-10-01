package nlw1.ecoleta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import nlw1.ecoleta.models.Items;
import nlw1.ecoleta.services.ItemsService;

@RestController
@CrossOrigin("http://localhost:3000")
public class ItemsController {

	@Autowired
	ItemsService is;
	
	@GetMapping("/items")
	public List<Items> index() {
		return is.listItems();
	}
}
