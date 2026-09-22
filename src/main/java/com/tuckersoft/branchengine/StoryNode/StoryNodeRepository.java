package com.tuckersoft.branchengine.StoryNode;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public class StoryNodeRepository {
    public Page<StoryNode> findAll(Pageable pageable) {
    }

    public interface StoryNodeRepository extends JpaRepository<StoryNode, Long> {}
}
