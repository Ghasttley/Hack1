package com.tuckersoft.branchengine.Playthrough;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/playthroughs")
public class PlaythroughController {

    private final PlaythroughService playthroughService;

    public PlaythroughController(PlaythroughService playthroughService) {
        this.playthroughService = playthroughService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlaythroughDTO.Response create(@Valid @RequestBody PlaythroughDTO.CreateRequest request) {
        return playthroughService.create(request);
    }

    @GetMapping
    public List<PlaythroughDTO.Response> list() {
        return playthroughService.listarParaUsuarioActual();
    }

    @GetMapping("/{id}")
    public PlaythroughDTO.Response getById(@PathVariable Long id) {
        return playthroughService.getById(id);
    }

    @GetMapping("/{id}/path")
    public PlaythroughDTO.PathResponse getPath(@PathVariable Long id) {
        return playthroughService.getPath(id);
    }
}