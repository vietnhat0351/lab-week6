package com.example.www_lab6.frontend.controller;

import com.example.www_lab6.backend.entities.Post;
import com.example.www_lab6.backend.entities.User;
import com.example.www_lab6.backend.repositories.PostRepository;
import com.example.www_lab6.backend.services.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/admin")
public class PostController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostService postService;

    @GetMapping("/test")
    public  String test(Model model){
        model.addAttribute("post", postRepository.findAll());
        return "admin/post/listing";
    }

    @GetMapping("/post")
    public String showPostListPaging(
            HttpSession session,
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size
            ){
        session.setAttribute("sample","this is sample");

        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        Page<Post> postPage = postService.findPostPaging(currentPage - 1,
                pageSize, "title", "desc");

        model.addAttribute("postPage", postPage);

        int totalPages = postPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "admin/post/listing";
    }
    @GetMapping("/show-add-form")
    public ModelAndView add(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        Post post = new Post();
        post.setUser(new User(1));
        modelAndView.addObject("post", post);
        modelAndView.addObject("user", post.getUser());
        modelAndView.setViewName("admin/post/add");
        return modelAndView;
    }

}
