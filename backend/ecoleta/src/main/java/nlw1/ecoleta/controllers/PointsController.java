package nlw1.ecoleta.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import nlw1.ecoleta.models.Points;
import nlw1.ecoleta.services.PointsService;

@RestController
@CrossOrigin("http://localhost:3000")
public class PointsController {

	@Autowired
	PointsService ps;
	
	@PostMapping(value = "/points", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public void create(@RequestPart("point") String point, @RequestPart("image") MultipartFile image) throws IOException {
		Points pointClass = new Gson().fromJson(point, Points.class);
		
		ps.createPoint(pointClass, image);
		
	}
	
	@GetMapping("/point/{id}")
	public Points show(@PathVariable Long id) {
		 return ps.showPoint(id);
	}
	
	@GetMapping("/points")
	public List<Points> index(@RequestParam("city") String city, @RequestParam("uf") String uf, @RequestParam("items") List<Integer> items) {
		return ps.indexPoints(city, uf, items);
	}
}
