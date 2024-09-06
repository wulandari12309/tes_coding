package com.tes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checklist")
public class ChecklistController {

    @Autowired
    private ChecklistService checklistService;

    @PostMapping
    public ResponseEntity<Checklist> createChecklist(@RequestBody Checklist checklist) {
        Checklist createdChecklist = checklistService.createChecklist(checklist);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdChecklist);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChecklist(@PathVariable Long id) {
        checklistService.deleteChecklist(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Checklist>> getAllChecklists() {
        List<Checklist> checklists = checklistService.getAllChecklists();
        return ResponseEntity.ok(checklists);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Checklist> getChecklistDetails(@PathVariable Long id) {
        Checklist checklist = checklistService.getChecklistById(id);
        if (checklist != null) {
            return ResponseEntity.ok(checklist);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
