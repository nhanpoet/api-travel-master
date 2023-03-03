package com.example.ProjectTravelMaster.Model.Service;

import java.io.IOException;
import java.util.List;

import com.example.ProjectTravelMaster.Model.Entity.EnterprisePostComment;

public interface EnterprisePostCommentService{

	List<EnterprisePostComment> getEnterpriserByIdEp(int id) throws IOException;


	EnterprisePostComment createEnterprisePostComment(EnterprisePostComment enterprisePostComment) throws IOException;


	EnterprisePostComment updateEnterprisePostComment(int id, EnterprisePostComment enterprisePostComment);
    
}
