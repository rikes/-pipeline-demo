package henriquesantos.com.pipeline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import henriquesantos.com.pipeline.domain.TimeLocal;
import henriquesantos.com.pipeline.service.PipelineService;

/**
 * PipelineController
 */

@RestController
@RequestMapping("api")
public class PipelineController {

    @Autowired
    PipelineService pipelineService;

	@GetMapping("/hello-world")
	public ResponseEntity<String> get() {
        return ResponseEntity.ok(pipelineService.run());
	}

    @GetMapping("/date")
	public ResponseEntity<TimeLocal> getDate() {
        return ResponseEntity.ok(pipelineService.dateTimeNow());
	}
}