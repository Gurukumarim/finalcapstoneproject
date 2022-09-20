package com.lifeinsurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifeinsurance.model.Insurance;
import com.lifeinsurance.repository.IInsuranceRepository;
@Service
public class InsuranceServiceImpl implements IInsuranceService{
	
	@Autowired
	IInsuranceRepository insuranceRepository;

	@Override
	public void addInsurance(Insurance insurance) {
		insuranceRepository.save(insurance);
	}

	@Override
	public void updateInsurance(Insurance insurance) {
		insuranceRepository.save(insurance);
	}

	@Override
	public void deleteInsurance(int insuranceId) {
		insuranceRepository.deleteById(insuranceId);
	}

	@Override
	public List<Insurance> getByName(String insuranceName) {
		return insuranceRepository.findByName(insuranceName);
	}

	@Override
	public Insurance getById(int insuranceId) {
		return insuranceRepository.findById(insuranceId);
	}

	@Override
	public List<Insurance> getAll() {
		return insuranceRepository.findAll();
	}
//
	@Override
	public List<Insurance> getByLessSumAssured(double sumAssured) {
		return insuranceRepository.findByLessSumAssured(sumAssured);
	}

	@Override
	public List<Insurance> getByHighSumAssured(double sumAssured) {
		return insuranceRepository.findByHighSumAssured(sumAssured);
	}

	@Override
	public List<Insurance> getByRangeOfSumAssured(double lessSumAssured, double highSumAssured) {
		return insuranceRepository.findByRangeOfSumAssured(lessSumAssured, highSumAssured);
	}

	@Override
	public List<Insurance> getByPlan(String plan) {
		return insuranceRepository.findByPlan(plan);
	}

	@Override
	public List<Insurance> getByClients( String clientName) {
		return insuranceRepository.findByClients(clientName);
	}

	@Override
	public double calculatePremium(double sumAssured, double duration) {
		double premiumAmount=0;
		if(sumAssured==100000) {
			if(duration==1)
				premiumAmount=(sumAssured*0.94)/12;
			if(duration==2)
				premiumAmount=(sumAssured*0.89)/24;
			if(duration==3)
				premiumAmount=(sumAssured*0.84)/36;
			if(duration==4)
				premiumAmount=(sumAssured*0.79)/48;
			if(duration==5)
				premiumAmount=(sumAssured*0.74)/60;
		}
		if(sumAssured==200000) {
			if(duration==1)
				premiumAmount=(sumAssured*0.94)/12;
			if(duration==2)
				premiumAmount=(sumAssured*0.89)/24;
			if(duration==3)
				premiumAmount=(sumAssured*0.84)/36;
			if(duration==4)
				premiumAmount=(sumAssured*0.79)/48;
			if(duration==5)
				premiumAmount=(sumAssured*0.74)/60;
		}
		if(sumAssured==300000) {
			if(duration==1)
				premiumAmount=(sumAssured*0.94)/12;
			if(duration==2)
				premiumAmount=(sumAssured*0.89)/24;
			if(duration==3)
				premiumAmount=(sumAssured*0.84)/36;
			if(duration==4)
				premiumAmount=(sumAssured*0.79)/48;
			if(duration==5)
				premiumAmount=(sumAssured*0.74)/60;
		}
		if(sumAssured==400000) {
			if(duration==1)
				premiumAmount=(sumAssured*0.94)/12;
			if(duration==2)
				premiumAmount=(sumAssured*0.89)/24;
			if(duration==3)
				premiumAmount=(sumAssured*0.84)/36;
			if(duration==4)
				premiumAmount=(sumAssured*0.79)/48;
			if(duration==5)
				premiumAmount=(sumAssured*0.74)/60;
		}
		if(sumAssured==500000) {
			if(duration==1)
				premiumAmount=(sumAssured*0.94)/12;
			if(duration==2)
				premiumAmount=(sumAssured*0.89)/24;
			if(duration==3)
				premiumAmount=(sumAssured*0.84)/36;
			if(duration==4)
				premiumAmount=(sumAssured*0.79)/48;
			if(duration==5)
				premiumAmount=(sumAssured*0.74)/60;
		}
		
		
		return premiumAmount ;
	}

	@Override
	public List<String> getAllPlan() {
		return insuranceRepository.findAllPlan();
	}

	@Override
	public List<String> getAllNames() {
		return insuranceRepository.findAllNames();
		
	}

	

}
