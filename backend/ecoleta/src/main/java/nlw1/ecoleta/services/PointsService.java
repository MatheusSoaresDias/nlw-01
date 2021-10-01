package nlw1.ecoleta.services;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import nlw1.ecoleta.models.Points;
import nlw1.ecoleta.repositories.PointsRepository;

@Service
public class PointsService {

	@Autowired
	PointsRepository pr;
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/static/points";
	
	public void createPoint(Points point, MultipartFile img) throws IOException {
		Points savedPoint = pr.save(point);
		String nameImg = Long.toString(savedPoint.getId());
		Path fileNameAndPath = Paths.get(uploadDirectory, nameImg);
		try {
			Files.write(fileNameAndPath, img.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		File input = new File(uploadDirectory, nameImg);
        File output = new File(uploadDirectory, nameImg+".jpeg");
        BufferedImage image = ImageIO.read(input);
        BufferedImage result = new BufferedImage(
                image.getWidth(),
                image.getHeight(),
                BufferedImage.TYPE_INT_ARGB);
        result.createGraphics().drawImage(image, 0, 0, Color.WHITE, null);
        ImageIO.write(result, "png", output);
        input.delete();
	}

	public Points showPoint(Long id) {
		return pr.findById(id).get();
	}

	public List<Points> indexPoints(String city, String uf, List<Integer> items) {
		return pr.findByFilters(city, uf, items);
	}
}
