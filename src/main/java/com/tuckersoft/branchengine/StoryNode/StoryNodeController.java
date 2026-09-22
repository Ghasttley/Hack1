package com.tuckersoft.branchengine.StoryNode;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/storynode")
public class StoryNodeController {
    private final StoryNodeService story_node_service;

    public StoryNodeController(StoryNodeService story_node_service) {
        this.story_node_service = story_node_service;
    }

    @GetMapping
    public ResponseEntity<PagedResponseDto<StoryNodeDto>> getAllProducts(
            @PageableDefault(page = 0, size = 10) Pageable pageable) {

        Page<StoryNodeDto> productsPage = story_node_service.get_all_story_node_services(pageable);

        // Crea la respuesta final usando tu DTO de paginación
        PagedResponseDto<StoryNodeDto> responseDto = new PagedResponseDto<>(story_node_page);

        return ResponseEntity.ok(responseDto);
    }
}
