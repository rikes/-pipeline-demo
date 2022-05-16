package henriquesantos.com.pipeline.service;

import org.springframework.stereotype.Service;

@Service
public class PipelineService {

    public String run(){
        throw new IllegalArgumentException("Fail ArgumentException");
    }
}
