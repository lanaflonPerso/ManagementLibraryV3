package mbooks;

import mbooks.service.lending.ILendingService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableConfigurationProperties
@EnableDiscoveryClient
@EnableFeignClients("mbooks")
public class MbooksApplication implements CommandLineRunner {



	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job;


	@Autowired
	private ILendingService lendingService;
	public static void main(String[] args) {
		SpringApplication.run(MbooksApplication.class, args);
	}



	//@Scheduled(cron = "0 0 0 * * * *")
	@Override
	public void run(String... args) throws Exception
	{
		JobParameters params = new JobParametersBuilder()
				.addString("JobID", String.valueOf(System.currentTimeMillis()))
				.toJobParameters();
		jobLauncher.run(job, params);

	}

}
