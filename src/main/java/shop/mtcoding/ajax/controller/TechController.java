package shop.mtcoding.ajax.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import shop.mtcoding.ajax.dto.TechResponse;
import shop.mtcoding.ajax.model.Category;
import shop.mtcoding.ajax.model.CategoryRepository;
import shop.mtcoding.ajax.model.Tech;
import shop.mtcoding.ajax.model.TechRepository;

@Controller
public class TechController {
    @Autowired
    private TechRepository techRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/v1/test/tech")
    public @ResponseBody TechResponse.MainDTO techV1() {
        List<Category> categoryList = categoryRepository.findAll();
        List<Tech> techList = techRepository.findByCategoryId(1);
        System.out.println("=================================");
        TechResponse.MainDTO mainDTO = new TechResponse.MainDTO(categoryList, techList);
        return mainDTO; // messageconverter 발동 - json 변환
        // 실무는 디티오를 만들어서 전달
    }

    @GetMapping("/v2/test/tech")
    public @ResponseBody List<Tech> techV2() {// 엔티티 노출시고 레이지 안타는 법
        List<Tech> techList = techRepository.findByCategoryId(1);
        return techList; // messageconverter 발동 - json 변환
    }// JSONIGNORE
     // JSON직렬화 하지말라고 발동함-> SELECT 안함 -> 레이지 안탐

    // 1. 빈껍데기 디자인을 준다 (데이터 없음)
    @GetMapping("/tech")
    public String tech() {

        return "main";
    }

    // 리스펀스 바디라고 붙은애들은 api를 붙여서 구분해준다
    @GetMapping("/api/category")
    public @ResponseBody List<Category> category() {
        return categoryRepository.findAll();
    }

    @GetMapping("/api/tech") // 카테고리 아이디 필요함
    public @ResponseBody List<Tech> techApi(@RequestParam(defaultValue = "1") Integer categoryId) {
        return techRepository.findByCategoryId(categoryId);
    }
}