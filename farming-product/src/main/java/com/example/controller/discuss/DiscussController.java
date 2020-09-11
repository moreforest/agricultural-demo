package com.example.controller.discuss;

import com.example.pojo.Admin;
import com.example.service.discuss.DiscussService;
import com.example.utils.PageUtil;
import com.example.vo.index.QueryInfo;
import com.example.vo.index.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Cao
 * @Description:
 * @Date: 2020/9/8
 **/
@Controller
@RequestMapping("/discuss")
public class DiscussController {

    @Autowired
    DiscussService discussService;

    /**
     * -----------------页面跳转-----------------------
     */

    @RequestMapping("/list")
    public String toList(QueryInfo queryInfo, Model model, SearchVo searchVo) {
        // 要查看所有的管理员数据-分页
        PageUtil<Admin> pageUtil = discussService.selectAllDiscuss(queryInfo, searchVo);
        System.out.println("Controller:" + pageUtil.getContent().size());
        System.out.println(pageUtil.getContent().get(0).getUsername());
        System.out.println(pageUtil.getContent().get(1).getUsername());
        System.out.println(pageUtil.getContent().get(2).getUsername());
        System.out.println(pageUtil.getContent().get(3).getUsername());
        Model util = model.addAttribute("pageUtil", pageUtil);
        return "/discuss/discuss-list";
    }


    /**-----------------数据处理-----------------------*/
}
