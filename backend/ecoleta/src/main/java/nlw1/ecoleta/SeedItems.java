package nlw1.ecoleta;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import nlw1.ecoleta.models.Items;
import nlw1.ecoleta.repositories.ItemsRepository;

@Component
public class SeedItems implements CommandLineRunner{
	
	@Autowired
	ItemsRepository ir;
	
	@Override
	public void run(String... args) throws Exception {
		loadItems();
	}
	
	private void loadItems() {
		
		List<Items> itemsList = new ArrayList<>();
		if(ir.count() == 0) {
			itemsList.add(new Items(1, "Lâmpadas", "lampadas.svg"));
			itemsList.add(new Items(2, "Pilhas e baterias", "baterias.svg"));
			itemsList.add(new Items(3, "Papéis e papelão", "papeis-papelao.svg"));
			itemsList.add(new Items(4, "Resíduos eletrônicos", "eletronicos.svg"));
			itemsList.add(new Items(5, "Resíduos orgânicos", "organicos.svg"));
			itemsList.add(new Items(6, "Óleo de cozinha", "oleo.svg"));
			
			ir.saveAll(itemsList);
		}
	}
}
