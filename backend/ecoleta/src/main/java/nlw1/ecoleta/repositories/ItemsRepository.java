package nlw1.ecoleta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nlw1.ecoleta.models.Items;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Long>{

}
