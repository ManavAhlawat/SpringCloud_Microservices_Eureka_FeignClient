package com.projects.Projects.client;


//import com.projects.Projects.Entity.Project;
import com.projects.Projects.Entity.Resource;
import com.projects.Projects.Entity.ResourceVO;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@FeignClient(name="resources-service")
@Headers({"Content-type", "application/json"})
public interface ResourceClient {
    @GetMapping(value="/msg")
    String resourceMsg();

    @GetMapping(value="/resourceByID/{id}")
    public ResourceVO findResourceById(@PathVariable(value = "id") int id);

    @GetMapping("/resources")
    public List<ResourceVO> findResources();

    @PostMapping("/createResource")
    public ResponseEntity createResource(@RequestBody Resource resource);

    @PutMapping("/updateResource")
    public ResponseEntity updateResource(@RequestBody Resource resource);

    @DeleteMapping(value="/deleteResource/{id}")
    public ResponseEntity deleteResource(@PathVariable(value = "id") int id);


}
