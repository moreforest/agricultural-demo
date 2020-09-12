package com.example.controller.discuss;

import com.example.exception.CustomerException;
import com.example.result.Result;
import com.example.service.discuss.DiscussService;
import com.example.utils.PageUtil;
import com.example.vo.discuss.DiscussVo;
import com.example.vo.discuss.DiscussVoResult;
import com.example.vo.index.QueryInfo;
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
    /**
     * 跳转到所有评论列表
     *
     * @param queryInfo
     * @param model
     * @param discussVo
     * @return
     */
    @RequestMapping("/list")
    public String toList(QueryInfo queryInfo, Model model, DiscussVo discussVo) {
        // 要查看所有的评论列表数据-分页
        PageUtil<DiscussVoResult> pageUtil = discussService.selectAllDiscuss(queryInfo, discussVo);
        model.addAttribute("pageUtil", pageUtil);
        return "/discuss/discuss-list";
    }

    @RequestMapping("/nameList")
    public String toNameList(QueryInfo queryInfo, Model model, DiscussVo discussVo) {
        // 要查看所有的评论列表数据-分页
        discussVo.setStatus(0);
        PageUtil<DiscussVoResult> pageUtil = discussService.selectAllDiscuss(queryInfo, discussVo);
        model.addAttribute("pageUtil", pageUtil);
        return "/discuss/discuss-list";
    }


    /**-----------------数据处理-----------------------*/


    /**
     * 拉黑评论
     *
     * @param id
     * @return
     */
    @RequestMapping("/blackDiscuss")
    @ResponseBody
    public Result blackDiscuss(Integer id) throws CustomerException {
        return discussService.blackDiscuss(id, 0);
    }

    /**
     * 删除评论
     *
     * @param id
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/delDiscuss")
    @ResponseBody
    public Result delDiscuss(Integer id) throws CustomerException {
        return discussService.delDiscuss(id);
    }

}
