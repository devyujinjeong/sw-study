package com.dbwls.jpql.section03.projection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectionService {

    private final ProjectionRepository projectionRepository;

    public ProjectionService(ProjectionRepository projectionRepository){
        this.projectionRepository = projectionRepository;
    }

    /* 영속성 컨텍스트에서 관리되는지 확인 */
    // 현재 이 객체가 엔티티이며 영속성 컨텍스트에서 관리하고 있는 객체이기 때문에
    //
    @Transactional
    public List<Menu> singleEntityProjection(){
        List<Menu> menus = projectionRepository.singleEntityProjection();
        // 객체의 이름을 변경!
        menus.get(0).setMenuName("세상에서 제일 맛있는 냠냠 고기");
        return menus;
    }

//    이 경우에는 영속성 컨텍스트에서 관리하고 있지 않아서 값이야 수정 되지만, 이게 실제로 DB에 반영되지 않는다.
//    @Transactional
//    public List<MenuInfo> embeddedTypeProjection() {
//        List<MenuInfo> menus = projectionRepository.embeddedTypeProjection();
//        menus.get(0).setMenuName("세상에서 제일 맛있는 냠냠 고기");
//        return menus;
//    }

}
