package com.dbwls.springdatajpa.menu.repository;

import com.dbwls.springdatajpa.menu.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/* 내가 사용하는 엔티티와 그 엔티티의 아이디가 제네릭 타입으로 들어가야 한다. */
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    /* JPQL or Native Query를 작성하는 방법 */
    @Query(
//            value = "SELECT c FROM Category c ORDER BY c.categoryCode"
            value = "SELECT category_code, category_name, ref_category_code " +
                    "FROM tbl_category ORDER BY category_code",
            nativeQuery = true
    )
    List<Category> findAllCategory();

}
