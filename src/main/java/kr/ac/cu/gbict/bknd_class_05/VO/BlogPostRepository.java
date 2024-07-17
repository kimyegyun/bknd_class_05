package kr.ac.cu.gbict.bknd_class_05.VO;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
    
}
