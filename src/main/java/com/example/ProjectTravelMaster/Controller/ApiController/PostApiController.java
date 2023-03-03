package com.example.ProjectTravelMaster.Controller.ApiController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import com.example.ProjectTravelMaster.Model.Entity.EnterprisePost;
import com.example.ProjectTravelMaster.Model.Entity.EnterprisePostComment;
import com.example.ProjectTravelMaster.Model.Entity.User;
import com.example.ProjectTravelMaster.Model.Entity.UserPost;
import com.example.ProjectTravelMaster.Model.Entity.UserPostComment;
import com.example.ProjectTravelMaster.Model.Entity.UserPostImage;
import com.example.ProjectTravelMaster.Model.Repository.UserPostImageRepository;
import com.example.ProjectTravelMaster.Model.Repository.UserPostRepository;
import com.example.ProjectTravelMaster.Model.Repository.UserRepository;
import com.example.ProjectTravelMaster.Model.Service.EnterprisePostCommentService;
import com.example.ProjectTravelMaster.Model.Service.EnterprisePostService;
import com.example.ProjectTravelMaster.Model.Service.UserPostCommentService;
import com.example.ProjectTravelMaster.Model.Service.UserPostImageService;
import com.example.ProjectTravelMaster.Model.Service.UserPostService;
import com.example.ProjectTravelMaster.Model.Service.Impl.UserPostCommentServiceImpl;
import com.example.ProjectTravelMaster.Model.Service.Impl.UserPostServiceImpl;
import com.example.ProjectTravelMaster.util.Mappings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PostApiController {
        
    @Autowired
    UserPostImageService userpostimageService;
    
    @Autowired
    UserPostService userpostService;
    
    @Autowired
    UserPostCommentService userpostcommentService;
      
    @Autowired
    EnterprisePostService enterprisePostService;
    
    @Autowired
    EnterprisePostCommentService enterprisePostCommentService;
    
    
			/*
			 * POST USER
			 */
    
    //get all post user
    @GetMapping(Mappings.API_UserPost)
    public ResponseEntity<List<UserPost>> getAllPost(@RequestParam(required = false)String up_id , String up_name ) {

    	try {        	
        	List<UserPost> user_post = userpostService.getUserPost(up_id, up_name);
        	if (user_post != null ) {
        		return new ResponseEntity<> (user_post,HttpStatus.OK);
			}else {
				return new ResponseEntity<> (HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			 //TODO: handle exception
			return new ResponseEntity<> (null,HttpStatus.INTERNAL_SERVER_ERROR);
		}             
    }
    
    
    //add post user
    @PostMapping(Mappings.API_UserPost)
    public ResponseEntity<UserPost> createPostuser(@RequestParam("file") MultipartFile file, UserPost userpost,HttpSession session){
    	try { 		
    		if (userpost == null || file == null || session == null) {
    			return new ResponseEntity<> (HttpStatus.NO_CONTENT);
			}else {
				UserPost _userpost = userpostService.creatUserPost(userpost);				
				UserPostImage userPostImage = userpostimageService.uploadImage(file, _userpost.getUp_id(),session);
				if (userPostImage != null) {
					return new ResponseEntity<> (_userpost,HttpStatus.CREATED);					
				}else {
					return new ResponseEntity<> (HttpStatus.NO_CONTENT);
				}
			}   	 		
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<> (null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
        
    
    //update post user
    @PutMapping(Mappings.API_UserPostGetId)
    public ResponseEntity<UserPost> updatePostuser(@PathVariable("id") int id,int idi,UserPost userpost  ){
    	try {		   		
    		if (userpost == null || id == 0) {
    			return new ResponseEntity<> (HttpStatus.NO_CONTENT);
			}else {				
				UserPost _userpost = userpostService.updateUserPost(userpost,id);
				if (_userpost != null) {
					return new ResponseEntity<> (_userpost,HttpStatus.OK);
				}else {
					return new ResponseEntity<> (HttpStatus.NO_CONTENT);
				}
			}  	    		
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<> (null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    
    //delete post user
    @DeleteMapping(Mappings.API_UserPostGetId)
    public ResponseEntity<UserPost> deletePostuser(@PathVariable("id") int id) {
    	try {      	   			
    		userpostService.deleteUserPost(id);						
    		return new ResponseEntity<> (HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<> (null,HttpStatus.INTERNAL_SERVER_ERROR);
		}   
    }
    
    					/* POST User Comment*/
  
    // get comment by id post
    @GetMapping(Mappings.API_UserPostCommentGetId)
    public ResponseEntity<List<UserPostComment>> GetAllUserPostCommentByIdPost(@PathVariable("id") int id){
    	try {
			List<UserPostComment> userPostComments =   userpostcommentService.GetAllUserPostCommentByIdPost(id);
			return new ResponseEntity<> (userPostComments,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<> (null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    // create user post comment
    
    @PostMapping(Mappings.API_UserPostComment)
    public ResponseEntity<UserPostComment> createUserPostComment(@RequestBody(required = true) UserPostComment userpostcomment){
    	try {
			return new ResponseEntity<> (userpostcommentService.createUserPostComment(userpostcomment),HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<> (null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    //update user post comment
    @PutMapping(Mappings.API_UserPostCommentGetId)
    public ResponseEntity<UserPostComment> updateUserPostComment(@PathVariable("id") int id,UserPostComment userpostcomment){
    	try {
    		return new ResponseEntity<> (userpostcommentService.updatteUserPostCommnet(id, userpostcomment),HttpStatus.OK);		
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<> (null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	
    }
    // delete user post comment
    @DeleteMapping(Mappings.API_UserPostCommentGetId)
    public ResponseEntity<UserPostComment> deleteUserPostComment(@PathVariable("id") int id){
    	 try {
			userpostcommentService.deleteUserPostComment(id);
			return new ResponseEntity<> (HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<> (null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
			/*
			 * POST Enterprise
			 */
    // get post enterprise
    
    @GetMapping(Mappings.API_EnterprisePost)
    public ResponseEntity<List<EnterprisePost>> getEnterprisePost(@RequestParam(required = false) String ep_name,String en_id){
    	try {
			List<EnterprisePost> enterprisePosts = enterprisePostService.getEnterprisePostby(ep_name, en_id);
			return new ResponseEntity<> (enterprisePosts,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<> (null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    //create post enterprise
    
    @PostMapping(Mappings.API_EnterprisePost)
    public ResponseEntity<EnterprisePost> createEnterprisepost(@RequestBody(required = true) EnterprisePost enterprisePost){
    	try {
			EnterprisePost _enterprisePost = enterprisePostService.createEnterprisePost(enterprisePost);
			return new ResponseEntity<> (_enterprisePost,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<> (null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    
    //update post enterprise
    @PutMapping(Mappings.API_EnterprisePostGetId)
    public ResponseEntity<EnterprisePost> updateEnterprisePost(@PathVariable("id") int id, EnterprisePost enterprisePost){
    	try {
    		EnterprisePost _enterprisePost = enterprisePostService.updateEnterprisePost(id, enterprisePost);
    		return new ResponseEntity<> (_enterprisePost,HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<> (null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    // delete post enterprise
    @DeleteMapping(Mappings.API_EnterprisePostGetId)
    public ResponseEntity<String> deleteEnterprisePost(@PathVariable("id") int id){
    	try {
    		return new ResponseEntity<> (enterprisePostService.deleteEnterprisePost(id),HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<> (null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	
    }
    
         //    Comment Post Enterprise
    
    // get comment post enterprise
    @GetMapping(Mappings.API_EnterprisePostCommentGetId)
    public ResponseEntity<List<EnterprisePostComment>> GetEnterprisePostComment(@PathVariable("id") int id){
    	try {
    		List<EnterprisePostComment> comments = enterprisePostCommentService.getEnterpriserByIdEp(id);
    		if (comments != null) {
    			return new ResponseEntity<> (comments,HttpStatus.OK);
			}else {
				return new ResponseEntity<> (null,HttpStatus.NO_CONTENT);				
			}   		
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<> (null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	
    }
    
    // create comment post enterprise   
    @PostMapping(Mappings.API_EnterprisePostComment)
    public ResponseEntity<EnterprisePostComment> createEnterprisePostComment(@RequestParam EnterprisePostComment enterprisePostComment){
    	try {
			EnterprisePostComment comment = enterprisePostCommentService.createEnterprisePostComment(enterprisePostComment);
			if (comment != null) {
				return new ResponseEntity<> (comment,HttpStatus.OK);
			} else {
				return new ResponseEntity<> (null,HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<> (null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    // update comment post enterprise
    @PutMapping(Mappings.API_EnterprisePostCommentGetId)
    public ResponseEntity<EnterprisePostComment> updateEnterprisePostComment(@PathVariable("id") int id,EnterprisePostComment enterprisePostComment){
    	try {
			EnterprisePostComment _enterprisePostComment = enterprisePostCommentService.updateEnterprisePostComment(id, enterprisePostComment);
			if (_enterprisePostComment != null) {
				return new ResponseEntity<> (_enterprisePostComment,HttpStatus.OK);			
			} else {
				return new ResponseEntity<> (null,HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<> (null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    
    
    
}
