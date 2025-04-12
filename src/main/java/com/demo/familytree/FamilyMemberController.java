package com.demo.familytree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class FamilyMemberController {
    @Autowired
    private FamilyMemberRepository repo;

    @PostMapping
    public FamilyMember addMember(@RequestBody FamilyMember member) {
        return repo.save(member);
    }

    @GetMapping("/{id}")
    public FamilyMember getMember(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @GetMapping("/children/{parentId}")
    public List<FamilyMember> getChildren(@PathVariable Long parentId) {
        return repo.findByParentId(parentId);
    }

    @GetMapping
    public List<FamilyMember> getAll() {
        return repo.findAll();
    }
}

