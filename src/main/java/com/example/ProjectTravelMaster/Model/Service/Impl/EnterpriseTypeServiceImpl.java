package com.example.ProjectTravelMaster.Model.Service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjectTravelMaster.Model.Entity.EnterpriseType;
import com.example.ProjectTravelMaster.Model.Repository.EnterpriseTypeRepository;
import com.example.ProjectTravelMaster.Model.Service.EnterpriseTypeService;

@Service
public class EnterpriseTypeServiceImpl implements EnterpriseTypeService{

    @Autowired
	EnterpriseTypeRepository repEnterpriseType;

    @Override
	public EnterpriseType updateEnterpriseType(int id,EnterpriseType enterprisetype){
		try {
			String _id = String.valueOf(id);
			if (_id == null || enterprisetype == null) {
				return null;
			}else {
				Optional<EnterpriseType> enterData = repEnterpriseType.findById(id);
				EnterpriseType _enterprisetype = enterData.get();
				_enterprisetype.setEtId(enterprisetype.getEtId());
				_enterprisetype.setEtName(enterprisetype.getEtName());
				_enterprisetype.setEnId(enterprisetype.getEnId());
				return repEnterpriseType.save(_enterprisetype);
			}			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
    }
}
