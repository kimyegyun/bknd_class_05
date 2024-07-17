package kr.ac.cu.gbict.bknd_class_05.Service;

import kr.ac.cu.gbict.bknd_class_05.VO.BlogPost;

public interface BlogPostService {
    BlogPost addBlogPost(BlogPost blogPost);
    BlogPost findById(Long postid);
}
