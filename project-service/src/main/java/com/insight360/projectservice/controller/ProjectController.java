
package com.insight360.projectservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private static Map<Long, Map<String, Object>> store = new HashMap<>();
    private static long seq = 1;

    @GetMapping
    public Collection<Map<String, Object>> list() { return store.values(); }

    @PostMapping
    public Map<String, Object> create(@RequestBody Map<String, Object> body) {
        long id = seq++;
        body.put("id", id);
        store.put(id, body);
        return body;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> get(@PathVariable Long id) {
        Map<String, Object> p = store.get(id);
        if (p == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(p);
    }
}
