package com.example.ProjectTravelMaster.Model.Service.Impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjectTravelMaster.Model.Entity.EnterprisePostComment;
import com.example.ProjectTravelMaster.Model.Repository.EnterprisePostCommentRepository;
import com.example.ProjectTravelMaster.Model.Service.EnterprisePostCommentService;

@Service
public class EnterprisePostCommentServiceImpl implements EnterprisePostCommentService {

	@Autowired
	EnterprisePostCommentRepository rep;

	// get enterprise post comment
	@Override
	public List<EnterprisePostComment> getEnterpriserByIdEp(int id) throws IOException {
		try {
			if (id != 0) {
				List<EnterprisePostComment> comments = rep.findByEpId(id);
				return comments;
			} else {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	// create enterprise post comment
	@Override
	public EnterprisePostComment createEnterprisePostComment(EnterprisePostComment enterprisePostComment)
			throws IOException {
		try {
			if (enterprisePostComment != null) {
				return rep.save(enterprisePostComment);
			} else {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	// update enterprise post comment

	@Override
	public EnterprisePostComment updateEnterprisePostComment(int id, EnterprisePostComment enterprisePostComment) {
		try {

			if (id != 0 && enterprisePostComment != null) {
				Optional<EnterprisePostComment> data = rep.findById(id);
				EnterprisePostComment _enterprisePostComment = data.get();
				_enterprisePostComment.setEpc_detail(enterprisePostComment.getEpc_detail());
				_enterprisePostComment.setEpc_report(enterprisePostComment.getEpc_report());
				_enterprisePostComment.setEpId(enterprisePostComment.getEpId());
				_enterprisePostComment.setUserId(enterprisePostComment.getUserId());
				rep.save(_enterprisePostComment);
				return _enterprisePostComment;
			} else {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
