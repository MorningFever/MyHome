package com.practice.myhome;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MyPostsController {
    private final MyPostsService myPostsService;
    @RequestMapping("/bbs")
    public String bbsList(Model model) {
        List<MyPosts> myPostsList = this.myPostsService.getBbsList();
        model.addAttribute("myPostsList", myPostsList);
        return "bbs";
    }

    @GetMapping(value = "/bbs/view/{id}")
    public String view(Model model, @PathVariable("id") Integer id) {
        MyPosts myPosts = this.myPostsService.getMyPosts(id);
        model.addAttribute("myPosts", myPosts);
        return "bbs_view";
    }
    @GetMapping("bbs/create")
    public String myPostsCreate() {
        return "bbs_form";
    }
    @PostMapping("bbs/create")
    public String myPostsCreate(@RequestParam String userName, @RequestParam String subject, @RequestParam String content) {
        this.myPostsService.create(userName, subject, content);
        return "redirect:/bbs";
    }
    @GetMapping("bbs/edit/{id}")
    public String myPostsEditForm(Model model, @PathVariable("id") Integer id) {
        MyPosts myPosts = this.myPostsService.getMyPosts(id);
        model.addAttribute("myPosts", myPosts);
        return "bbs_edit";
    }
    @PostMapping("bbs/edit/{id}")
    public String myPostsEdit(@PathVariable("id") Integer id, @RequestParam String subject, @RequestParam String content) {
        this.myPostsService.updateById(id, subject, content);
        return "redirect:/bbs/view/{id}";
    }

    @GetMapping("bbs/delete/{id}")
    public String myPostsDelete(@PathVariable("id") Integer id) {
        this.myPostsService.delete(id);
        return "redirect:/bbs";
    }
}
