package mbooks.batch;

import mbooks.service.lending.ILendingService;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

public class MyTaskOne implements Tasklet {

    @Autowired
    private ILendingService lendingService;
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception
    {
        System.out.println("MyTaskOne start..");

        lendingService.revival();

        System.out.println("MyTaskOne done..");
        return RepeatStatus.FINISHED;
    }
}