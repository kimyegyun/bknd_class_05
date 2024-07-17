package kr.ac.cu.gbict.bknd_class_05.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.cu.gbict.bknd_class_05.VO.BlogPost;
import kr.ac.cu.gbict.bknd_class_05.VO.BlogPostRepository;

@Service
public class BlogPostServiceImpl implements BlogPostService {

    @Autowired
    private BlogPostRepository repository;

    @Override
    public BlogPost addBlogPost(BlogPost blogPost) {
        // blogPost 의 데이터가 정상인 지 검증 작업 수행
        BlogPost added = repository.save(blogPost);
        return added;
    }

    @Override
    public BlogPost findById(Long postid) {
        BlogPost found = repository.findById(postid).orElse(null);
        return found;
    }
    
}
