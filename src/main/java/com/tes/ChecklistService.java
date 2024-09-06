package com.tes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChecklistService {

    @Autowired
    private ChecklistRepository checklistRepository;

    public Checklist createChecklist(Checklist checklist) {
        return checklistRepository.save(checklist);
    }

    public void deleteChecklist(Long id) {
        checklistRepository.deleteById(id);
    }

    public List<Checklist> getAllChecklists() {
        return checklistRepository.findAll();
    }

    public Checklist getChecklistById(Long id) {
        return checklistRepository.findById(id).orElse(null);
    }
}
