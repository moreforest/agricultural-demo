package com.example.controller.admin;

import com.example.exception.CustomerException;
import com.example.pojo.Admin;
import com.example.result.BuildResult;
import com.example.result.Result;
import com.example.service.admin.AdminService;
import com.example.utils.PageUtil;
import com.example.vo.index.QueryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Cao
 * @Description:
 * @Date: 2020/9/7
 **/
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    /**
     * 管理员页面列表
     *
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(QueryInfo queryInfo, Model model) {
        // 要查看所有的管理员数据-分页
//        List<Admin> adminList = adminService.findAll();
//        model.addAttribute("adminList", adminList);
        PageUtil<Admin> pageUtil = adminService.selectAllAdmin(queryInfo);
//        System.out.println(pageUtil.getContent().get(0).getUsername());
        model.addAttribute("pageUtil", pageUtil);
        return "/admin/admin-list";
    }

    /**
     * 跳转到添加管理员页面
     *
     * @return
     */
    @RequestMapping("/addPage")
    public String addPage() {
        return "/admin/admin-add";
    }

    /**
     * 跳转到修改管理员页面
     *
     * @return
     */
    @RequestMapping("/editPage")
    public String editPage(Long id, Model model) {
        Admin admin = adminService.findAdminById(id);
        model.addAttribute("admin", admin);
        return "/admin/admin-edit";
    }

    /**
     * 添加管理员
     *
     * @param admin
     * @return
     */
//    @RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
    @PostMapping(value = "/addAdmin")
    @ResponseBody //返回JSON数据
    public Result addAdmin(Admin admin) throws CustomerException {
        adminService.addAdmin(admin);
        return BuildResult.buildSuccess(null);
    }

    /**
     * 通过id 删除管理员账号
     *
     * @param id 管理员id
     * @return
     */
    @PostMapping(value = "/delAdmin")
    public Result delAdmin(Long id) {
        try {
            adminService.delAdminById(id);
            return BuildResult.buildSuccess("删除成功!!");
        } catch (CustomerException e) {
            e.printStackTrace();
            return BuildResult.buildFail("删除失败", 200);
        }
    }


}
