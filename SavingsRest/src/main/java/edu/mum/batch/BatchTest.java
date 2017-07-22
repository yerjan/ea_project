package edu.mum.batch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import edu.mum.domain.Savings;
import edu.mum.service.SavingsService;

@Component
@EnableScheduling
public class BatchTest {
	
	@Autowired
	public SavingsService savingService;
	
	// This function demonstrates batch processing at every 10 seconds
	@Scheduled(cron="*/10 * * * * *")
	public void testing(){
		System.out.println("*** This print demonstrates BATCH PROCESSING at every 10 seconds ***");
	}
	
	@Scheduled(cron="0 0 23 * * *")
	public void endOfDayBatch(){
		savingService.endOfDayCalculation();	
	}
}
