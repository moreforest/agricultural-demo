package com.example.service.impl.admin;

import com.example.exception.CustomerException;
import com.example.mapper.admin.AdminMapper;
import com.example.pojo.Admin;
import com.example.result.Result;
import com.example.service.admin.AdminService;
import com.example.utils.PageUtil;
import com.example.vo.index.AdminVo;
import com.example.vo.index.QueryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @Author: Cao
 * @Description:
 * @Date: 2020/9/7
 **/
@Service
public class AdminServiceImpl implements AdminService {
    // 盐值
    private static final String PASSWORD_SALT = "";

    @Autowired
    AdminMapper adminMapper;

    @Override
    public String insertAdmin(Admin admin) {
        // 添加数据
        adminMapper.addAdmin(admin);
        return "ok";
    }

    @Override
    public String addAdmin(Admin admin) throws CustomerException {
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
            System.out.println("重复添加，不执行!");
            return "";
        }
        //密码加密
        String md5Password = DigestUtils.md5DigestAsHex((admin.getPassword() + PASSWORD_SALT).getBytes());
        // 覆盖原来的密码
        admin.setPassword(md5Password);
        admin.setStatus(1); // 启用
        admin.setCreated(new Date());
        admin.setIsDeleted(0); //未删除
        adminMapper.addAdmin(admin);
        return "添加成功";
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

    @Override
    public PageUtil<Admin> selectAllAdmin(QueryInfo queryInfo) {
        // 查询所有管理员 -- 分页
        //1.根据开始序号和分页大小查询页面需要显示数据
        List<Admin> adminList = adminMapper.selectAllAdmin(queryInfo);

        //2.查询总记录数
        Long count = adminMapper.allCount();

        PageUtil<Admin> pageUtil = new PageUtil<>();
        pageUtil.setContent(adminList);
        pageUtil.setTotalNums(count);
        pageUtil.setNowPage(queryInfo.getPage());
        pageUtil.setPageSize(queryInfo.getPageSize());

        return pageUtil;
    }

    @Override
    public Admin findAdminById(Long id) {
        // 通过id查询用户
        Admin admin = adminMapper.findAdminById(id);
        return admin;
    }

    @Override
    public String updateAdmin() {
        return null;
    }

    @Override
    public Result delAdminById(Long id) throws CustomerException {
        //通过id删除管理员账号
        if (id == null || "".equals(id)) {
            throw new CustomerException("id不能为空");
        }

        Integer result = adminMapper.delAdminById(id);
        return null;
    }


}
