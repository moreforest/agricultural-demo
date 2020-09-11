package com.example.controller.admin;

import com.example.exception.CustomerException;
import com.example.pojo.Admin;
import com.example.result.BuildResult;
import com.example.result.Result;
import com.example.service.admin.AdminService;
import com.example.utils.PageUtil;
import com.example.vo.index.QueryInfo;
import com.example.vo.index.SearchVo;
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

    /**-----------------页面跳转-----------------------*/

    /**
     * 管理员页面列表 -- 搜索功能
     *
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(QueryInfo queryInfo, Model model, SearchVo searchVo) {
        // 要查看所有的管理员数据-分页
        PageUtil<Admin> pageUtil = adminService.selectAllAdmin(queryInfo, searchVo);
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
    public String editPage(Integer id, Model model) {
        Admin admin = adminService.findAdminById(id);
        model.addAttribute("admin", admin);
        return "/admin/admin-edit";
    }

    /**-----------------数据操作-----------------------*/


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
        return adminService.addAdmin(admin);
    }

    /**
     * 修改管理员
     *
     * @param admin
     * @return
     * @throws CustomerException
     */
    @PostMapping(value = "/editAdmin")
    @ResponseBody //返回JSON数据
    public Result editAdmin(Admin admin) throws CustomerException {
        return adminService.editAdmin(admin);
    }


    /**
     * 通过id 删除管理员账号
     *
     * @param data 管理员id数组
     * @return
     */
    @PostMapping(value = "/delAdmin")
    @ResponseBody
    public Result delAdmin(Integer[] data) throws CustomerException {
        return adminService.delAdminById(data);
    }


}
