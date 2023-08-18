package shop.mtcoding.ajax.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> { // 엔티티, pk의타입형

}
