package nlw1.ecoleta.models;

import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="points")
@Data
public class Points {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToMany
	@JoinTable(name="point_items", joinColumns=@JoinColumn(
			name="pointId", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(
				name="itemId", referencedColumnName="id"))
	private List<Items> items;
	
	private String name;
	
	private String email;
	
	private String whatsapp;
	
	private double latitude;
	
	private double longitude;
	
	private String city;
	
	private String uf;
	
	private String image;
}
