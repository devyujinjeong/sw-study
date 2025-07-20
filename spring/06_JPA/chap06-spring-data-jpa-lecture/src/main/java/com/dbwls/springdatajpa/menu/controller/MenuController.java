package com.dbwls.springdatajpa.menu.controller;

import com.dbwls.springdatajpa.common.Pagenation;
import com.dbwls.springdatajpa.common.PagingButton;
import com.dbwls.springdatajpa.menu.dto.CategoryDTO;
import com.dbwls.springdatajpa.menu.dto.MenuDTO;
import com.dbwls.springdatajpa.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Controller
@RequestMapping("/menu")
@RequiredArgsConstructor
@Slf4j // log라는 변수명으로 Logger 객체 타입의 필드가 선언되고 생성된다.
public class MenuController {

    /* lombok을 통해서 생성자를 사용하고 있음*/
    private final MenuService menuService;

    /* 1. 메뉴 조회하기*/
    @GetMapping("/{menuCode}")
    public String findMenuByCode(@PathVariable int menuCode, Model model){
            MenuDTO resultMenu = menuService.findMenuByMenuCode(menuCode);
            model.addAttribute("menu", resultMenu);
        return "menu/detail";
    }

    @GetMapping("/list")
    public String findMenuList(Model model, @PageableDefault Pageable pageable){
        /* 페이징 처리 이전 정렬 처리만 반영된 목록 조회 */
//        List<MenuDTO> menuList = menuService.findMenuList();
//        model.addAttribute("menuList", menuList);

        /* System.out.print 계열의 메소드보다 효율적으로 로그 출력을 할 수 있다.
        * 로그 레벨에 맞춘 메소드를 통해 출력 처리한다.
        * {}를 통해 값이 입력 될 위치를 포매팅 한다. */
        log.info("pageable : {} ", pageable);

        /* 페이징 처리가 반영 된 목록 조회 (number, size, sort도 존재) */
        Page<MenuDTO> menuList = menuService.findMenuList(pageable);
        PagingButton paging = Pagenation.getPagingButtonInfo(menuList);
        model.addAttribute("menuList", menuList);
        model.addAttribute("paging", paging);

        /* number, size, sort 도 존재 */
        log.info("getContent : {} ", menuList.getContent());
        log.info("getTotalPages : {} ", menuList.getTotalPages());
        log.info("getTotalElements : {} ", menuList.getTotalElements());
        log.info("getNumberOfElements : {} ", menuList.getNumberOfElements());
        log.info("isFirst : {} ", menuList.isFirst());
        log.info("isLast : {} ", menuList.isLast());


        return "menu/list";
    }

    @GetMapping("/querymethod")
    public void queryMethodPage() {}

    @GetMapping("/search")
    public String findByMenuPrice(@RequestParam Integer menuPrice, Model model){

        List<MenuDTO> menuList = menuService.findByMenuPrice(menuPrice);
        model.addAttribute("menuList",menuList);

        return "menu/searchResult";
    }

    @GetMapping("/category")
    @ResponseBody //응답 데이터 body에 반환 값을 그대로 전달하겠다는 의미 (ViewResolver 사용 x)
    public List<CategoryDTO> findCategoryList(){
        return menuService.finAllCategory();
    }

    /* 2. 메뉴 등록하기 */
    // void로 선언되어 있기 때문에 뷰 이름이 "regist"인 템플릿을 찾아서 보여준다.
    // 우리의 경우 Thymeleaf를 사용하기 때문에 regist.html을 찾아서 렌더링 해준다.

    // PostMapping은 입력을 처리하기 위한 역할이므로!!
    @GetMapping("/regist")
    public void registPage(){}

    @PostMapping("/regist")
    public String registMenu(@ModelAttribute MenuDTO menuDTO) {
        menuService.registMenu(menuDTO);
        // redirect 방식을 사용하기 위해서는 redirect:라는 방식을 사용하면 된다.
        return "redirect:/menu/list";
    }

    /* 3. 메뉴 수정하기 */
    @GetMapping("/modify")
    public void modifyPage() {}

    @PostMapping("/modify")
    public String modifyPage(@ModelAttribute MenuDTO menuDTO) {
        menuService.modifyMenu(menuDTO);
        return "redirect:/menu/" + menuDTO.getMenuCode();
    }

    /* 4. 메뉴 삭제하기 */
    @GetMapping("/delete")
    public void deleltePage(){}

    @PostMapping("/delete")
    public String deleltePage(@RequestParam int menuCode){
        menuService.deleteMenu(menuCode);
        return "redirect:/menu/list";
    }
}
