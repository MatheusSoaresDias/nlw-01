package nlw1.ecoleta.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nlw1.ecoleta.models.Points;

@Repository
public interface PointsRepository extends JpaRepository<Points, Long>{

		@Query(value = "select * from point_items join points on point_items.point_id = points.id where point_items.item_id in :items and points.city = :city and points.uf = :uf", nativeQuery = true)
		List<Points> findByFilters(@Param("city") String city, @Param("uf") String uf, @Param("items") List<Integer> items);
}
