package nlw1.ecoleta.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="items")
@Data
public class Items  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String title;
	private String image;
	
	public Items() {
		
	}
	
	public Items(long id, String title, String image) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
	}
}
