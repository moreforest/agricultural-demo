package com.example.service.impl.admin;

import com.example.exception.CustomerException;
import com.example.mapper.admin.AdminMapper;
import com.example.pojo.Admin;
import com.example.result.BuildResult;
import com.example.result.Result;
import com.example.service.admin.AdminService;
import com.example.utils.DateUtil;
import com.example.utils.PageUtil;
import com.example.vo.index.AdminVo;
import com.example.vo.index.QueryInfo;
import com.example.vo.index.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @Author: Cao
 * @Description:
 * @Date: 2020/9/7
 **/
@Service
public class AdminServiceImpl implements AdminService {
    // 盐值
    private static final String PASSWORD_SALT = "farming894fc5207f5d254product";

    @Autowired
    AdminMapper adminMapper;

    @Override
    public String insertAdmin(Admin admin) {
        // 添加数据
        adminMapper.addAdmin(admin);
        return "ok";
    }

    @Override
    public Result addAdmin(Admin admin) throws CustomerException {
        // 添加管理员账户
        if (admin == null) {
            throw new CustomerException("账户不能为空");
        }
        // 判断每一个字段是否为空
        if (admin.getUsername() == null || "".equals(admin.getUsername().trim())) {
            throw new CustomerException("账户名不能为空");
        }
        if (admin.getPassword() == null || "".equals(admin.getPassword().trim())) {
            throw new CustomerException("密码不能为空");
        }
        // 判断用户名是否使用
        AdminVo adminVo = new AdminVo();
        adminVo.setUsername(admin.getUsername());
        List<Admin> adminList = adminMapper.queryAdminByWhere(adminVo);
        //如果集合不等于空，就代表查到了数据
        if (!CollectionUtils.isEmpty(adminList)) {
            return BuildResult.buildFail("该用户名已存在，请不要重复添加", 500);
        }
        //密码加密
        String md5Password = DigestUtils.md5DigestAsHex((admin.getPassword() + PASSWORD_SALT).getBytes());
        // 覆盖原来的密码
        admin.setPassword(md5Password);
        admin.setStatus(1); // 启用
        admin.setCreated(new Date());
        admin.setIsDeleted(0); //未删除
        adminMapper.addAdmin(admin);
        return BuildResult.buildSuccess(null);
    }

    @Override
    public Admin loginIn(String username, String password) throws CustomerException {
        // 登录
        //判空
        if (StringUtils.isEmpty(username)) {
            throw new CustomerException("用户名不能为空！");
        }
        if (StringUtils.isEmpty(password)) {
            throw new CustomerException("密码不能为空！");
        }
        //用户输入的密码进行加密
        String md5Password = DigestUtils.md5DigestAsHex((password + PASSWORD_SALT).getBytes());

        AdminVo adminVo = new AdminVo();
        adminVo.setUsername(username);
        adminVo.setPassword(md5Password); //加密后的密码

        List<Admin> list = adminMapper.queryAdminByWhere(adminVo);

        if (CollectionUtils.isEmpty(list)) {
            throw new CustomerException("用户名或密码错误！");
        }

        Admin admin = list.get(0);

        // 修改最后登录时间
        admin.setLastLoginTime(new Date());
        adminMapper.updateAdmin(admin);

        return admin;
    }

//    @Override
//    public PageUtil<Admin> selectAllAdmin(QueryInfo queryInfo, SearchVo searchVo) {
//        // 查询所有管理员 -- 分页
//        //1.根据开始序号和分页大小查询页面需要显示数据
//        List<Admin> adminList = adminMapper.selectAllAdmin(queryInfo);
//
//        System.out.println(adminList.size());
//
//        //2.查询总记录数
//        Long count = adminMapper.allCount();
//
//        PageUtil<Admin> pageUtil = new PageUtil<>();
//        pageUtil.setContent(adminList);
//        pageUtil.setTotalNums(count);
//        pageUtil.setNowPage(queryInfo.getPage());
//        pageUtil.setPageSize(queryInfo.getPageSize());
//
//        return pageUtil;
//    }

    @Override
    public PageUtil<Admin> selectAllAdmin(QueryInfo queryInfo, SearchVo searchVo) {
        // 查询所有管理员 -- 分页
        System.out.println("进入分页");
        // 格式化日期
        String creatime = "";
        String endtime = "";
        if (searchVo.getStart() != null || "".equals(searchVo.getStart())) {
            creatime = DateUtil.formattedDate(searchVo.getStart());
        }
        if (searchVo.getEnd() != null || "".equals(searchVo.getEnd())) {
            endtime = DateUtil.formattedDate(searchVo.getEnd());
        }

        System.out.println(creatime);

        // map传参
        Map<String, Object> map = new HashMap<>();
        map.put("searchname", searchVo.getSearchname());
        map.put("start", creatime);
        map.put("end", endtime);
        map.put("startIndex", queryInfo.getStartIndex());
        map.put("pageSize", queryInfo.getPageSize());
        //1.根据开始序号和分页大小查询页面需要显示数据
        List<Admin> adminList = adminMapper.selectAllAdmin(map);
        System.out.println(adminList.size());
        //2.查询总记录数
        Long count = adminMapper.allCount(searchVo);

        PageUtil<Admin> pageUtil = new PageUtil<>();
        pageUtil.setContent(adminList);
        pageUtil.setTotalNums(count);
        pageUtil.setNowPage(queryInfo.getPage());
        pageUtil.setPageSize(queryInfo.getPageSize());

        System.out.println(pageUtil.getContent().size());

        return pageUtil;
    }

    @Override
    public Admin findAdminById(Integer id) {
        // 通过id查询用户
        Admin admin = adminMapper.findAdminById(id);
        admin.setId(id);
        System.out.println("通过id查询用户" + id);
        return admin;
    }

    @Override
    public Result editAdmin(Admin admin) throws CustomerException {
        // 修改管理员账户
        // 判断该账户是否存在
        if (admin.getId() == null || "".equals(admin.getId())) {
            throw new CustomerException("未选择任何用户");
        }
        if (StringUtils.isEmpty(admin.getUsername())) {
            throw new CustomerException("用户名不能为空！");
        }
        if (StringUtils.isEmpty(admin.getPassword())) {
            throw new CustomerException("密码不能为空！");
        }
        // 判断账号是否存在
        Admin adminById = adminMapper.findAdminById(admin.getId());
        if (StringUtils.isEmpty(adminById)) {
            throw new CustomerException("该管理员账号信息不存在，请重试");
        }
        // 修改管理员账号信息
        //密码加密
        String md5Password = DigestUtils.md5DigestAsHex((admin.getPassword() + PASSWORD_SALT).getBytes());
        // 覆盖原来的密码
        admin.setPassword(md5Password);

        Integer result = adminMapper.updateAdmin(admin);
        if (result <= 0) {
            throw new CustomerException("管理员信息修改失败，请重试");
        }
        return BuildResult.buildSuccess(null);
    }


    @Override
    public Result delAdminById(Integer[] data) throws CustomerException {
        //通过id删除管理员账号
        if (data.length <= 0) {
            throw new CustomerException("未选择任何用户");
        }
        boolean flag = true;
        // 判断账号是否存在
        for (int i = 0; i < data.length; i++) {
            Admin adminById = adminMapper.findAdminById(data[i]);
            if (StringUtils.isEmpty(adminById)) {
                throw new CustomerException("批量删除失败，请重试");
            }
        }
        Integer result = adminMapper.delAdminByIds(data);
        if (result <= 0) {
            throw new CustomerException("删除管理员信息操作失败，请重试");
        }

        return BuildResult.buildSuccess(null);
    }


}
