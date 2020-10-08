package com.projects.Projects.Controller;

import java.util.List;


import com.projects.Projects.Entity.Project;
import com.projects.Projects.Entity.Resource;
import com.projects.Projects.Entity.ResourceVO;
import com.projects.Projects.client.ResourceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class ClientController{

    @Autowired
    private ResourceClient resourceClient;


    @GetMapping("/resourceByID/{id}")
    public ResourceVO getResourceById(@PathVariable int id){
        ResourceVO response = resourceClient.findResourceById(id);
        return response;

    }

    @GetMapping("/resources")
    public List<ResourceVO> getResources(){
        return resourceClient.findResources();
    }

    @PostMapping("/createResource")
    public ResponseEntity createResource(@RequestBody Resource resource) {

        try {
            ResponseEntity response= resourceClient.createResource(resource);
            if(response.getStatusCode().is2xxSuccessful())return new ResponseEntity<>(HttpStatus.OK);
            else return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/updateResource")
    public ResponseEntity updateResource(@RequestBody Resource resource) {
        try {
            ResponseEntity response= resourceClient.updateResource(resource);
            if(response.getStatusCode().is2xxSuccessful())return new ResponseEntity<>(HttpStatus.OK);
            else return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/deleteResource/{id}")
    public ResponseEntity deleteResource(@PathVariable int id) {
        try {
            ResponseEntity response= resourceClient.deleteResource(id);
            if(response.getStatusCode().is2xxSuccessful()) return new ResponseEntity<>(HttpStatus.OK);
            else return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/msg")
    public String msgTest() {
        String response = resourceClient.resourceMsg();
        return response;
    }


}