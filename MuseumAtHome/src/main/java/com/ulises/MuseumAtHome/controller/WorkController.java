package com.ulises.MuseumAtHome.controller;

import com.ulises.MuseumAtHome.Service.WorkService;
import com.ulises.MuseumAtHome.entity.Work;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping("/works")
    public Work createWork(@RequestBody Work newWork){
        return this.workService.saveWork(newWork);
    }

    @PutMapping("/works/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    public void editWork(@PathVariable long id, @RequestBody Work work){
        workService.editNameOfWork(id, work);
    }

    @DeleteMapping("/works/{id}")
    public void deleteWork(@PathVariable long id){
        workService.deleteWork(id);
    }

    private ResponseEntity<Void> entityWithLocation(Object resourceId) {

        // TODO-07: Set the 'location' header on a Response to URI of
        //          the newly created resource and return it.
        // a. You will need to use 'ServletUriComponentsBuilder' and
        //     'ResponseEntity' to implement this - Use ResponseEntity.created(..)
        // b. Refer to the POST example in the slides for more information

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(resourceId)
                .toUri();
        return ResponseEntity.created(uri).build();
        //return null; // Return something other than null
    }


}
