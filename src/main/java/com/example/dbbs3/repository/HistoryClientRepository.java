package com.example.dbbs3.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.dbbs3.entity.HistoryClient;

@Repository
public interface HistoryClientRepository extends JpaRepository<HistoryClient, Integer> {

	@Query(value = "SELECT * FROM tbl_history_client h WHERE h.acc_number=:accNumber", nativeQuery = true)
	List<HistoryClient> getAllHistoriesbyAccNumber(int accNumber);
	
	@Query(value = "SELECT * FROM tbl_history_client h WHERE h.acc_number=:accNumber AND h.date BETWEEN :startDate AND :endDate", nativeQuery = true)
	List<HistoryClient> getAllHistoriesByAccNumberAndDates(int accNumber, String startDate, String endDate);
}
