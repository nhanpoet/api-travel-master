package com.example.ProjectTravelMaster.Model.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjectTravelMaster.Model.Entity.Enterprise;
import com.example.ProjectTravelMaster.Model.Repository.EnterpriseRepository;
import com.example.ProjectTravelMaster.Model.Service.EnterpriseService;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

	@Autowired
	EnterpriseRepository rep;

	@Override
	public List<Enterprise> getAllEnterprise() {
		try {
			List<Enterprise> enterprise = new ArrayList<Enterprise>();
			enterprise = rep.findAll();
			return enterprise;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public Enterprise getEnterpriseById(String en_id) {
		try {
			Enterprise enterprise = new Enterprise();
			if (en_id != null) {
				int id = Integer.valueOf(en_id);
				enterprise = rep.findByEnId(id);
				return enterprise;
			} else {
				return null;

			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public List<Enterprise> createEnterprise(Enterprise enterprise) {
		try {
			if (enterprise != null) {
				enterprise.setEnStatus(true);
				return (List<Enterprise>) rep.save(enterprise);
			} else {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public Enterprise updateEnterprise(int id, Enterprise enterprise) {
		try {
			String _id = String.valueOf(id);
			if (_id == null || enterprise == null) {
				return null;
			} else {
				Optional<Enterprise> enterData = rep.findById(id);
				Enterprise _enterprise = enterData.get();
				_enterprise.setEnNamecompany(enterprise.getEnNamecompany());
				_enterprise.setEnDetail(enterprise.getEnDetail());
				_enterprise.setEnCode(enterprise.getEnCode());
				_enterprise.setEnEmail(enterprise.getEnEmail());
				_enterprise.setEnPhone(enterprise.getEnPhone());
				_enterprise.setEnAddress(enterprise.getEnAddress());
				_enterprise.setEnWard(enterprise.getEnWard());
				_enterprise.setEnDistrict(enterprise.getEnDistrict());
				_enterprise.setEnProvince(enterprise.getEnProvince());
				_enterprise.setEnCountry(enterprise.getEnCountry());
				_enterprise.setEnPostalcode(enterprise.getEnPostalcode());
				_enterprise.setEnStatus(enterprise.getEnStatus());
				// _enterprise.setEnterprise_type(enterprise.getEnterprise_type());
				return rep.save(_enterprise);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	@Override
	public String deleteEnterprise(int id) {
		try {
			// rep.deleteById(id);
			Enterprise enterprise = rep.findByEnId(id);
			rep.delete(enterprise);
			return "OK";
		} catch (Exception e) {
			// TODO: handle exception
			return "Faild";
		}
	}

}
