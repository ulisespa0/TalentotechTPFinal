package com.ulises.MuseumAtHome.controller;

import com.ulises.MuseumAtHome.Service.WorkService;
import com.ulises.MuseumAtHome.entity.Work;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkController {

    private WorkService workService;

    public WorkController(WorkService workService){
        this.workService = workService;
    }


    @GetMapping("/works")
    public List<Work> getWorks(){
        return this.workService.listWork();
    }

    @GetMapping("/works/{id}")
    public Work getWork(@PathVariable long id){
        return this.workService.getWork(id);
    }

    @PostMapping
    public ResponseEntity<Void> createWork(@RequestBody Work newWork){
        //guardaenelsrevice
        return null;
    }

    @PutMapping("/works/{id}")
    public Work editWork(@PathVariable long id, @RequestBody Work work){
        return null;
    }

    @DeleteMapping("/works/{id}")
    public void deleteWork(@PathVariable long id){
        workService.deleteWork(id);
    }



}
