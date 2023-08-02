package chatgpt.chatgpt.repository;

import chatgpt.chatgpt.Entity.DatePlace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatePlaceRepository extends JpaRepository<DatePlace, Long> {

    List<DatePlace> findByKeywordContaining(String keyword);
}
