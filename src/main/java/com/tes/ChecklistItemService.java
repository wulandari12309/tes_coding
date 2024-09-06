package com.tes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChecklistItemService {

    @Autowired
    private ChecklistItemRepository checklistItemRepository;

    @Autowired
    private ChecklistRepository checklistRepository;

    public ChecklistItem createChecklistItem(Long checklistId, ChecklistItem item) {
        Checklist checklist = checklistRepository.findById(checklistId).orElse(null);
        if (checklist != null) {
            item.setChecklist(checklist);
            return checklistItemRepository.save(item);
        }
        return null;
    }

    public ChecklistItem getChecklistItemById(Long id) {
        return checklistItemRepository.findById(id).orElse(null);
    }

    public ChecklistItem updateChecklistItem(Long id, ChecklistItem updatedItem) {
        return checklistItemRepository.findById(id)
                .map(item -> {
                    item.setItemName(updatedItem.getItemName());
                    item.setStatus(updatedItem.isStatus());
                    return checklistItemRepository.save(item);
                })
                .orElse(null);
    }

    public ChecklistItem updateChecklistItemStatus(Long id, boolean status) {
        return checklistItemRepository.findById(id)
                .map(item -> {
                    item.setStatus(status);
                    return checklistItemRepository.save(item);
                })
                .orElse(null);
    }

    public void deleteChecklistItem(Long id) {
        checklistItemRepository.deleteById(id);
    }
}
