package com.cher.blog.controller;

import com.cher.blog.pojo.Blog;
import com.cher.blog.pojo.Type;
import com.cher.blog.pojo.User;
import com.cher.blog.service.BlogService;
import com.cher.blog.service.TypeService;
import com.cher.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final Integer PAGE_LIMIT = 7;  // 管理界面每页显示条数

    private static final Integer PAGE_NUM = 5;  // 翻页区域显示的最多页数

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @RequestMapping({"", "/", "/login"})
    public String login(Model model) {
        return "admin/login";
    }

    @RequestMapping("/blogManage/{offset}")
    public String blogManage(@PathVariable("offset") Integer offset,
                             @RequestParam(value = "title", required = false) String title,
                             @RequestParam(value = "type", required = false) Integer typeId,
                             Model model) {

        List<Blog> blogs = null;
        Integer count = null;
        // 计算翻页条
        if (typeId == null && (title == null || title.equals(""))) {
            blogs = blogService.getBlogsByPage(offset, PAGE_LIMIT);
            count = blogService.getCount();

        } else if (typeId != null && (title == null || title.equals(""))) {
            blogs = blogService.getBlogsByTypeIdByPage(typeId, offset, PAGE_LIMIT);
            count = blogService.getCountByTypeId(typeId);

        } else if(typeId == null && !title.equals("")) {
            blogs = blogService.getBlogsByTitleLikeByPage(title, offset, PAGE_LIMIT);
            count = blogService.getCountByTitleLike(title);

        } else {
            blogs = blogService.getBlogsByTitleLikeAndTypeIdByPage(title, typeId, offset, PAGE_LIMIT);
            count = blogService.getCountByTitleLikeAndTypeId(title, typeId);
        }

        Integer maxPage = (count - 1) / PAGE_LIMIT + 1;
        ArrayList<Integer> pages = new ArrayList<>();
        for (int i = 0; (i <= PAGE_NUM / 2) && (offset - i > 0); i++) {
            pages.add(0, offset - i);
        }
        for (int i = 1; (pages.size() < PAGE_NUM) && (offset + i <= maxPage); i++) {
            pages.add(offset + i);
        }
        for (int i = PAGE_NUM / 2 + 1; pages.size() < PAGE_NUM && (offset - i >= 1); i++) {
            pages.add(0, offset - i);
        }

        model.addAttribute("blogs", blogs);
        model.addAttribute("offset", offset);
        model.addAttribute("maxPage", maxPage);
        model.addAttribute("pages", pages);

        List<Type> types = typeService.getTypes();
        model.addAttribute("types", types);

        return "admin/blog-manage";
    }

    @RequestMapping("/blogInput")
    public String blogInput(Model model) {
        List<Type> types = typeService.getTypes();
        model.addAttribute("types", types);

        return "admin/blog-input";
    }

    @RequestMapping("/blogUpdate")
    public String blogUpdate(@RequestParam("id") Integer id, Model model) {
        Blog blog = blogService.getBlog(id);
        model.addAttribute("blog", blog);
        List<Type> types = typeService.getTypes();
        model.addAttribute("types", types);

        return "admin/blog-update";
    }

    @RequestMapping("/typeManage/{offset}")
    public String typeManage(@PathVariable("offset") Integer offset,
                             Model model) {

        // 计算翻页条
        List<Type> types = typeService.getTypesByPage(offset, PAGE_LIMIT);
        Integer count = typeService.getCount();
        Integer maxPage = (count - 1) / PAGE_LIMIT + 1;
        ArrayList<Integer> pages = new ArrayList<>();
        for (int i = 0; (i <= PAGE_NUM / 2) && (offset - i > 0); i++) {
            pages.add(0, offset - i);
        }
        for (int i = 1; (pages.size() < PAGE_NUM) && (offset + i <= maxPage); i++) {
            pages.add(offset + i);
        }
        for (int i = PAGE_NUM / 2 + 1; pages.size() < PAGE_NUM && (offset - i >= 1); i++) {
            pages.add(0, offset - i);
        }

        model.addAttribute("types", types);
        model.addAttribute("offset", offset);
        model.addAttribute("maxPage", maxPage);
        model.addAttribute("pages", pages);

        return "admin/type-manage";
    }

    @RequestMapping("/typeInput")
    public String typeInput(Model model) {
        return "admin/type-input";
    }

    @RequestMapping("/typeUpdate")
    public String typeUpdate(@RequestParam("id") Integer id, Model model) {
        Type type = typeService.getType(id);
        model.addAttribute("id", type.getId());
        model.addAttribute("name", type.getName());

        return "admin/type-update";
    }

    /**
     * 登录操作
     */
    @RequestMapping("/doLogin")
    public String doLogin(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          HttpSession session,
                          RedirectAttributes attributes) {

        User user = userService.getUserByUsername(username);
        if (user == null) {
            // 没有查询到用户
            logger.info("登陆失败，用户名不存在：" + username);
            attributes.addFlashAttribute("message", "用户名不存在");

        } else if (!password.equals(user.getPassword())) {
            // 用户密码错误
            logger.info("登陆失败，密码输入错误：" + username + ":" + password);
            attributes.addFlashAttribute("message", "密码输入错误");

        } else {
            logger.info("登陆成功：" + user);
            session.setAttribute("user", user);
            return "redirect:/admin/blogManage/1";
        }
        return "redirect:/admin";
    }

    /**
     * 注销操作
     */
    @RequestMapping("/doLogout")
    public String doLogout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }

    /**
     * 新增分类
     */
    @RequestMapping("doTypeInput")
    public String doTypeInput(@RequestParam("name") String name, RedirectAttributes attributes) {
        if (name == null) {
            attributes.addFlashAttribute("message", "类别名称不能为空");

        } else {

            Type type = typeService.getTypeByName(name);

            if (type != null) {
                attributes.addFlashAttribute("message", "此类别已存在");

            } else {
                Boolean res = typeService.addType(new Type(null, name));
                if (res) {
                    attributes.addFlashAttribute("message", "新增分类成功");
                    return "redirect:/admin/typeManage/1";

                } else {
                    attributes.addFlashAttribute("message", "新增分类失败");

                }
            }
        }

        return "redirect:/admin/typeInput";
    }

    /**
     * 编辑分类
     */
    @RequestMapping("doTypeUpdate")
    public String doTypeUpdate(@RequestParam("id") Integer id,
                               @RequestParam("name") String name,
                               RedirectAttributes attributes) {

        if (name == null) {
            attributes.addFlashAttribute("message", "类别名称不能为空");

        } else {

            Type type = typeService.getTypeByName(name);

            if (type != null && !type.getId().equals(id)) {
                // 如果查询到了同名Type，且这个Type和当前Type的id不相同
                attributes.addFlashAttribute("message", "此类别已存在");

            } else {
                Boolean res = typeService.updateType(new Type(id, name));
                if (res) {
                    attributes.addFlashAttribute("message", "编辑分类成功");
                    return "redirect:/admin/typeManage/1";

                } else {
                    attributes.addFlashAttribute("message", "编辑分类失败");
                }
            }
        }

        return "redirect:/admin/typeUpdate?id=" + id;
    }

    /**
     * 删除分类
     */
    @RequestMapping("/doTypeDelete")
    public String doTypeDelete(@RequestParam("id") Integer id, RedirectAttributes attributes) {
        Boolean res = typeService.deleteType(id);

        if (res) {
            attributes.addFlashAttribute("message", "删除分类成功");

        } else {
            attributes.addFlashAttribute("message", "删除分类失败");

        }

        return "redirect:/admin/typeManage/1";
    }

    /**
     * 发布博客
     */
    @RequestMapping("/doBlogInput")
    public String doBlogInput(@RequestParam("statement") Integer statement,
                              @RequestParam("type") Integer typeId,
                              @RequestParam("title") String title,
                              @RequestParam("description") String description,
                              @RequestParam("content") String content,
                              @RequestParam("picUrl") String picUrl,
                              @RequestParam(value = "recommend", required = false) Boolean recommend,
                              @RequestParam(value = "appreciate", required = false) Boolean appreciate,
                              HttpSession session,
                              RedirectAttributes attributes) {

        Blog blog = new Blog();
        blog.setStatement(statement);
        blog.setType(new Type(typeId));
        blog.setTitle(title);
        blog.setDescription(description);
        blog.setContent(content);
        blog.setPicUrl(picUrl);
        blog.setRecommend(recommend);
        blog.setAppreciate(appreciate);
        blog.setUser((User) session.getAttribute("user"));
        blog.setViewCount(0);
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setStatus(2);

        Boolean res = blogService.addBlog(blog);

        if (res) {
            attributes.addFlashAttribute("message", "发布博客成功");
        } else {
            attributes.addFlashAttribute("message", "发布博客失败");
        }

        return "redirect:/admin/blogManage/1";
    }

    /**
     * 编辑博客
     */
    @RequestMapping("/doBlogUpdate")
    public String doBlogUpdate(@RequestParam("id") Integer id,
                               @RequestParam("statement") Integer statement,
                               @RequestParam("type") Integer typeId,
                               @RequestParam("title") String title,
                               @RequestParam("description") String description,
                               @RequestParam("content") String content,
                               @RequestParam("picUrl") String picUrl,
                               @RequestParam(value = "recommend", required = false) Boolean recommend, @RequestParam(value = "appreciate", required = false) Boolean appreciate,
                               RedirectAttributes attributes) {

        Blog blog = new Blog();
        blog.setId(id);
        blog.setStatement(statement);
        blog.setType(new Type(typeId));
        blog.setTitle(title);
        blog.setDescription(description);
        blog.setContent(content);
        blog.setPicUrl(picUrl);
        blog.setRecommend(recommend);
        blog.setAppreciate(appreciate);
        blog.setUpdateTime(new Date());

        Boolean res = blogService.updateBlog(blog);

        if (res) {
            attributes.addFlashAttribute("message", "编辑博客成功");
        } else {
            attributes.addFlashAttribute("message", "编辑博客失败");
        }

        return "redirect:/admin/blogManage/1";
    }

    /**
     * 删除博客
     */
    @RequestMapping("/doBlogDelete")
    public String doBlogDelete(@RequestParam("id") Integer id, RedirectAttributes attributes) {
        Boolean res = blogService.deleteBlog(id);

        if (res) {
            attributes.addFlashAttribute("message", "删除博客成功");

        } else {
            attributes.addFlashAttribute("message", "删除博客失败");

        }

        return "redirect:/admin/blogManage/1";
    }

}
