package com.tuckersoft.branchengine.StoryNode;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

package com.tuckersoft.branchengine.securityconfig.SecurityConfig;

@Service
public class StoryNodeService<ModelMapper> {
    private final StoryNodeRepository story_node_repository;
    private final ModelMapper modelMapper;

    public StoryNodeService(StoryNodeRepository story_node_repository,
                          ModelMapper modelMapper) {
        this.story_node_repository = story_node_repository;
        this.modelMapper = modelMapper;
    }

    public Page<StoryNodeDto> getAllProducts(Pageable pageable) {
        Page<StoryNode> productsPage = story_node_repository.findAll(pageable);

        // Transforma la Page de entidades a una Page de DTOs
        Page<StoryNodeDto> map = productsPage.map(product -> modelMapper.map(product, StoryNodeDto.class));
        return map;

    }



    public List<StoryNode> listAll() {
        return story_node_repository.findAll();
    }
}