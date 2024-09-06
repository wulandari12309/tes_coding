package com.tes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checklist/{checklistId}/item")
public class ChecklistItemController {

    @Autowired
    private ChecklistItemService checklistItemService;

    @PostMapping
    public ResponseEntity<ChecklistItem> createChecklistItem(
            @PathVariable Long checklistId,
            @RequestBody ChecklistItem item) {
        ChecklistItem createdItem = checklistItemService.createChecklistItem(checklistId, item);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChecklistItem> getChecklistItemDetails(@PathVariable Long id) {
        ChecklistItem item = checklistItemService.getChecklistItemById(id);
        if (item != null) {
            return ResponseEntity.ok(item);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChecklistItem> updateChecklistItem(
            @PathVariable Long id, @RequestBody ChecklistItem updatedItem) {
        ChecklistItem item = checklistItemService.updateChecklistItem(id, updatedItem);
        if (item != null) {
            return ResponseEntity.ok(item);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChecklistItem(@PathVariable Long id) {
        checklistItemService.deleteChecklistItem(id);
        return ResponseEntity.noContent().build();
    }

}
