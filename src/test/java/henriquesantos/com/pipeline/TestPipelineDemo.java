package henriquesantos.com.pipeline;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import henriquesantos.com.pipeline.domain.TimeLocal;
import henriquesantos.com.pipeline.service.PipelineService;

public class TestPipelineDemo {

    Logger logger = LoggerFactory.getLogger(TestPipelineDemo.class);
    
    PipelineService pipelineService;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


    public TestPipelineDemo(){
        this.pipelineService = new PipelineService();
    };


    @Test
    @DisplayName("Test number 1")
    void testSucessOne(){

        LocalDateTime dateTime = LocalDateTime.of(2020, Month.JUNE, 5, 16, 30, 10);
        LocalDateTime dateTimeNow = LocalDateTime.parse(pipelineService.dateTimeFormat(), dateTimeFormatter);
        long qtdDias = ChronoUnit.DAYS.between(dateTime, dateTimeNow);
        assertTrue(qtdDias > 365);
    }

    @Test
    @DisplayName("Test number 2")
    void testSucessTwo(){
        TimeLocal timeLocalNow = pipelineService.dateTimeNow();
        LocalDateTime dateTimeNow = LocalDateTime.now();

        assertEquals(LocalDateTime.parse(timeLocalNow.dateTime(), dateTimeFormatter).toLocalDate(), dateTimeNow.toLocalDate());
    }

}


