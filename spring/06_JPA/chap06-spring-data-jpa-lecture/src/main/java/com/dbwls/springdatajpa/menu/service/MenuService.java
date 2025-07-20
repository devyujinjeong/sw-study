package com.dbwls.springdatajpa.menu.service;

import com.dbwls.springdatajpa.menu.dto.CategoryDTO;
import com.dbwls.springdatajpa.menu.dto.MenuDTO;
import com.dbwls.springdatajpa.menu.entity.Category;
import com.dbwls.springdatajpa.menu.entity.Menu;
import com.dbwls.springdatajpa.menu.repository.CategoryRepository;
import com.dbwls.springdatajpa.menu.repository.MenuRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    /* final은 위에 어노테이션을 통해서 의존성 주입(생성자 주입)이 되는 것 */
    private final MenuRepository menuRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    /* DTO와 Entity의 분리
    * DTO(Data Transfer Object)는 프레젠테이션 계층과의 데이터 교환을 위한 객체로,
    * 도메인 로직을 담고 있는 Entity와 분리해 사용함으로써 보안, 성능, 유지보수 측면의 이점을 얻을 수 있다.
    * 1. 보안 : 민감 데이터 / 과도 데이터 노출 방지, 과도한 바인딩 공격 방지 (의도하지 않은 값까지 들어와서 반영)
    * 2. 성능 : 데이터 전송 최적화(필요한 요소만 빼서 전송 : controller),
    *           지연 로딩 문제 완화(service에서 지연 로딩이 일어나야 하는데?),
    *           쿼리 최적화(dto 프로젝션을 사용하면 필요한 값만 보낼 수 있으니깐~!)
    * 3. 유지보수 : 명확한 계층 분리 (비즈니스 로직 수정이나 도메인 모델 변경이 클라이언트와의 API 계약에 영향 x)
    *             도메인 로직의 캡슐화 (Entity 관련 비즈니스 로직은 외부에 노출 X, 클라이언트는 DTO만 이용)
    *  */

    /* DTO - Entity의 변환 방법
    * 1. 수동 매핑 메서드 사용
    * 2. Spring BeanUtils.copyProperties()
    * 3. ModelMapper 라이브러리
    * 4. MapStruct 라이브러리
    * 5. Spring Data JPA Projection
    * */

    /* 1. findById 메소드 테스트*/
    public MenuDTO findMenuByMenuCode(int menuCode){

        /* findById는 Optional 객체이므로 바꿔서 반환 */
        Menu menu =  menuRepository.findById(menuCode)
                .orElseThrow(IllegalArgumentException::new);

        /* Menu 엔티티를 MenuDTO 타입으로 바꿔서 반환하고자 함*/
        /* 메뉴 엔티티의 필드 값을 menoDTO와 같은 명*/
        return modelMapper.map(menu, MenuDTO.class);
    }

    /* 2. findAll(Sort) 메소드 테스트 */
    public List<MenuDTO> findMenuList(){
        List<Menu> menuList = menuRepository.findAll(Sort.by("menuCode").descending());
        return menuList.stream()
                .map(menu -> modelMapper.map(menu, MenuDTO.class))
                .toList();
    }

    /* 3. findAll(Pageable) */
    public Page<MenuDTO> findMenuList(Pageable pageable) {

        /* page 파라미터가 Pageable의 number 값으로 넘어오는데
         * 해당 값이 조회시에는 인덱스 기준이 되어야 해서 -1 처리가 필요하다.
         * */
        pageable = PageRequest.of(
                /* 몇번 째 페이지?
                * 페이지 사이즈는? 페이지에서 몇 개 받아올 예정임?
                * 어떤 방식으로 정렬? */
                pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("menuCode").descending()
        );

        Page<Menu> menuList = menuRepository.findAll(pageable);

        return menuList.map(menu -> modelMapper.map(menu, MenuDTO.class));
    }

    /* 4. 쿼리 메소드 사용 */
    public List<MenuDTO> findByMenuPrice(Integer menuPrice) {
//        List<Menu> menuList = menuRepository.findByMenuPriceIsGreaterThan(menuPrice);
//        List<Menu> menuList = menuRepository.findByMenuPriceIsGreaterThanOrderByMenuPrice(menuPrice);
        List<Menu> menuList = menuRepository
                .findByMenuPriceIsGreaterThan(menuPrice, Sort.by("menuPrice").descending());

        return menuList.stream().map(menu -> modelMapper.map(menu, MenuDTO.class)).toList();
    }

    /* 5. JPQL or Native Query */
    public List<CategoryDTO> finAllCategory(){
        List<Category> categoryList = categoryRepository
                .findAllCategory();

        return categoryList.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .toList();
    }

    /* 6. save : 엔터티 저장 */
    @Transactional
    public void registMenu(MenuDTO menuDTO) {
        menuRepository.save(modelMapper.map(menuDTO, Menu.class));
    }

    /* 7. 메뉴 수정하기 : 엔티티 객체의 필드 값을 수정 */
    @Transactional
    public void modifyMenu(MenuDTO menuDTO){
        Menu foundMenu = menuRepository.findById(menuDTO.getMenuCode())
                .orElseThrow(IllegalArgumentException::new);

        // setter를 기계적으로 만들어 놓으면 에티티 객체가 수정에 열린 상태가 되므로
        // 필요한 기능에 맞춘 메소드를 별도로 구현해서 수정한다.
        foundMenu.modifyMenuName(menuDTO.getMenuName());
    }

    /* 8. 메뉴 삭제하기 : 메뉴 코드를 받아 메뉴 삭제하기 */
    @Transactional
    public void deleteMenu(int menuCode){
        menuRepository.deleteById(menuCode);
    }
}
