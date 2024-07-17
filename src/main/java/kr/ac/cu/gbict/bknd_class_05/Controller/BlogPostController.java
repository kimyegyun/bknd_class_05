package kr.ac.cu.gbict.bknd_class_05.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.cu.gbict.bknd_class_05.Service.BlogPostService;
import kr.ac.cu.gbict.bknd_class_05.VO.BlogPost;




@Controller
public class BlogPostController {

    @Autowired
    private BlogPostService service;

    @PostMapping("/addpost")
    @ResponseBody
    public Long addpost(Model model, @RequestBody BlogPost entity) {
        BlogPost saved = service.addBlogPost(entity);
        return saved.getId();
    }
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("bgimage", "home-bg.jpg");
        model.addAttribute("heading", "블로그");
        model.addAttribute("subheading", "블로그를 만들어 봅시다");
        return "index";
    }
    
    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("bgimage", "about-bg.jpg");
        model.addAttribute("heading", "블로그 정보");
        model.addAttribute("subheading", "블로그 정보를 보여줍니다");
        return "about";
    }
    
    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("bgimage", "contact-bg.jpg");
        model.addAttribute("heading", "연락처");
        model.addAttribute("subheading", "연락처를 보여줍니다");
        return "contact";
    }
    
    @GetMapping("/post/{postid}")
    public String post(Model model, @PathVariable("postid") Long postid) {
        BlogPost found = service.findById(postid);
        model.addAttribute("article", found);
        model.addAttribute("bgimage", "post-bg.jpg");
        model.addAttribute("heading", "블로그");
        model.addAttribute("subheading", postid.toString());
        return "post";
    }
        
}
