package nlw1.ecoleta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nlw1.ecoleta.models.Items;
import nlw1.ecoleta.repositories.ItemsRepository;

@Service
public class ItemsService {

	@Autowired
	ItemsRepository ir;
	
	public List<Items> listItems() {
		return ir.findAll();
	}
}
