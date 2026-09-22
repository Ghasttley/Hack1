package com.tuckersoft.branchengine.StoryNode;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class StoryNode {
    @Id
    @GeneratedValue
    private Long id;

    private String nodeCode;
    private String title;
    private String sceneText;
    private Integer branchCapacity;
    private Integer currentBranches;
    private String primaryBranchCode;
    private String glitchBranchCode;
    //createdAt;

}
