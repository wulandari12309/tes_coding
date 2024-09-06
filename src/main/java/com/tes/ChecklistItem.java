package com.tes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "checklist_item")
public class ChecklistItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;

    private boolean status;

    @ManyToOne
    @JoinColumn(name = "checklist_id")
    @JsonBackReference // Back reference to avoid loop
    private Checklist checklist;

    public ChecklistItem() {
    }

    public ChecklistItem(String itemName, boolean status, Checklist checklist) {
        this.itemName = itemName;
        this.status = status;
        this.checklist = checklist;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Checklist getChecklist() {
        return checklist;
    }

    public void setChecklist(Checklist checklist) {
        this.checklist = checklist;
    }
}
