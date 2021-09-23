package com.cher.blog.controller;

import com.cher.blog.pojo.Blog;
import com.cher.blog.pojo.TypeWithCount;
import com.cher.blog.pojo.User;
import com.cher.blog.service.BlogService;
import com.cher.blog.service.TypeService;
import com.cher.blog.service.UserService;
import com.cher.blog.utils.CommonMarkUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class IndexController {

    private static final Integer PAGE_LIMIT = 10;
    private static final Integer PAGE_NUM = 10;

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @RequestMapping({"", "/", "/index"})
    public String index(Model model, HttpSession session) {
        List<Blog> newBlogs = blogService.getBlogsByNew(3);
        ServletContext context = session.getServletContext();
        context.setAttribute("newBlogs", newBlogs);
        return "redirect:/index/1";
    }

    @RequestMapping("/index/{offset}")
    public String index2(@PathVariable("offset") Integer offset, Model model) {
        List<Blog> blogs = blogService.getBlogsByPage(offset, PAGE_LIMIT);
        Integer count = blogService.getCount();
        model.addAttribute("blogs", blogs);
        model.addAttribute("count", count);

        // 计算翻页条
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

        model.addAttribute("offset", offset);
        model.addAttribute("maxPage", maxPage);
        model.addAttribute("pages", pages);

        // 分类信息
        List<TypeWithCount> types = typeService.getTypesWithCount();
        model.addAttribute("types", types);

        // 推荐博客
        List<Blog> recommendBlogs = blogService.getBlogsByRecommend();
        model.addAttribute("recommendBlogs", recommendBlogs);

        return "index";
    }

    @RequestMapping("/blog")
    public String blog(@RequestParam("id") Integer id, Model model) {

        Blog blog = blogService.getBlog(id);
        blogService.updateBlog(new Blog(blog.getId(), blog.getViewCount()+1));
        model.addAttribute("blog", blog);

        User user = blog.getUser();
        model.addAttribute("user", user);

        String content = CommonMarkUtils.parseToHtml(blog.getContent());
//        String content = blog.getContent();
        model.addAttribute("content", content);

        return "blog";
    }

    @RequestMapping("/type")
    public String type(@RequestParam("id") Integer id,
                       @RequestParam("offset") Integer offset,
                       Model model) {

        Integer typeCount = typeService.getCount();
        model.addAttribute("count", typeCount);

        List<TypeWithCount> types = typeService.getTypesWithCount();
        model.addAttribute("types", types);

        model.addAttribute("id", id);

        List<Blog> blogs = blogService.getBlogsByTypeId(id);
        model.addAttribute("blogs", blogs);

        // 翻页
        // 计算翻页条
        Integer count = blogService.getCount();
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
        model.addAttribute("count", count);
        model.addAttribute("offset", offset);
        model.addAttribute("maxPage", maxPage);
        model.addAttribute("pages", pages);

        return "type";
    }

    @RequestMapping("/archive")
    public String archive(Model model) {

        Integer startYear = 2021;
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        Integer endYear = cal.get(Calendar.YEAR);

        HashMap<String, List<Blog>> blogMapByYear = new HashMap<>();

        for (int i = startYear; i <= endYear; i++) {

            List<Blog> blogList = new ArrayList<>();
            blogMapByYear.put(String.valueOf(i), blogList);

            List<Blog> blogs = blogService.getBlogsByYear(String.valueOf(i));
            blogList.addAll(blogs);
        }

        model.addAttribute("map", blogMapByYear);

        Integer count = blogService.getCount();
        model.addAttribute("count", count);

        return "archive";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        return "about";
    }

    @RequestMapping("/search")
    public String search(@RequestParam("title") String title,
                       @RequestParam("offset") Integer offset,
                       Model model) {

        List<Blog> blogs = blogService.getBlogsByTitleLikeByPage(title, offset, PAGE_LIMIT);
        model.addAttribute("blogs", blogs);

        // 翻页
        // 计算翻页条
        Integer count = blogService.getCountByTitleLike(title);
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
        model.addAttribute("count", count);
        model.addAttribute("offset", offset);
        model.addAttribute("maxPage", maxPage);
        model.addAttribute("pages", pages);

        return "search";
    }

}
