package org.ourspring.admin.global.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

public abstract class CommonController {
    /**
     * 주 메뉴 코드, 각 컨트롤러에서 설정
     * @return
     */
    public abstract String mainCode();

    @ModelAttribute("subMenus")
    public List<org.ourspring.admin.global.menus.Menu> subMenus() {
        return org.ourspring.admin.global.menus.Menus.getMenus(mainCode());
    }
}
