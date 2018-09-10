package org.injae;

import org.injae.domain.MenuVO;
import org.injae.domain.ReviewVO;

public class Main {

    public static void main(String[] args) {

//        ReviewVO vo = new ReviewVO();
//        vo.setMid("injae");
//        vo.setmno(2);
//        vo.setScore(0);
//        vo.setCmt("냉면이 14000?? 안갑니다");
//
//        ReviewDAO dao = new ReviewDAO();
//        dao.add(vo);

//        MenuVO vo = new MenuVO();

        MenuDAO dao = new MenuDAO();
//        System.out.println(dao.getMenus(6));
        for (MenuVO menu:dao.getMenus(6)) {
            System.out.println(menu);
        }


    }
}
