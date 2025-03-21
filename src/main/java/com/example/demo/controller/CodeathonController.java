package com.example.demo.controller;

import com.example.demo.model.Codeathon;
import com.example.demo.service.CodeathonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/codeathons")
public class CodeathonController {

    private final CodeathonService codeathonService;

    public CodeathonController(CodeathonService codeathonService) {
        this.codeathonService = codeathonService;
    }

    @GetMapping
    public List<Codeathon> getAllCodeathons() {
        return codeathonService.getAllCodeathons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Codeathon> getCodeathonById(@PathVariable Long id) {
        return ResponseEntity.ok(codeathonService.getCodeathonById(id));
    }

    @PostMapping
    public ResponseEntity<Codeathon> createCodeaathon(@RequestBody Codeathon codeathon) {
        return ResponseEntity.ok(codeathonService.createCodeathon(codeathon));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Codeathon> updateCodeathon(@PathVariable Long id, @RequestBody Codeathon codeathon) {
        return ResponseEntity.ok(codeathonService.updateCodeathon(id, codeathon));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCodeathon(@PathVariable Long id) {
        codeathonService.deleteCodeathon(id);
        return ResponseEntity.noContent().build();
    }
}
