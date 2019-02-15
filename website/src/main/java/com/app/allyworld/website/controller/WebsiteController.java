package com.app.allyworld.website.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.app.allyworld.website.entity.Comments;
import com.app.allyworld.website.entity.Likes;
import com.app.allyworld.website.entity.Post;

@Controller
public class WebsiteController {

	@Autowired
	private RestTemplate restTemplate;
	private Post post;
	
	/*
	 * @RequestMapping(value="/home") public String homeSavings() { return "home"; }
	 * 
	 * @RequestMapping(value="/post", method=RequestMethod.POST) public String
	 * homeCurrent() { return "index"; }
	 */
	@RequestMapping(value="/home") 
	public String homeSavings() { 
		return "index"; 
	}
	
	
	@RequestMapping(value="/post", method=RequestMethod.POST)
	public String index() {
		return "index";
	}

	@RequestMapping("/addNewPost")
	public String addNewPost(Map map) {
		//map.put("post", new Post());
		return "AddPostForm";
	}

	@RequestMapping("/getAllPosts")
	public ModelAndView getAllposts(Model model) {
		List<Post> posts = restTemplate.getForObject("http://localhost:8989/posts", List.class);
		// model.addAttribute("p",posts);
		return new ModelAndView("PostDetails", "posts", posts);
	}

	@RequestMapping("/createNewPost")
	public String createNewAccount(
			/* @RequestParam("postId") Integer postId */@RequestParam("profileId") Integer profileId,
			@RequestParam("status") String status, @RequestParam("url") String url,
			/* @RequestParam("likes") Integer likes, */ @RequestParam("likesProfileId") List<Integer> likesProfileId,
			@RequestParam("commentProfileId") List<Integer> commentProfileId, @RequestParam("comment") String comment,
			/* @RequestParam("likesComment") Integer likesComment, */ Model model) {
		Post post = new Post(profileId, status, url, new Likes(/* likes */ likesProfileId),
				new Comments(commentProfileId, comment /* likesComment */));
		Integer likes = likesProfileId.size();
		post.getLikes().setLikes(likes);
		Integer likesComment = commentProfileId.size();
		post.getComments().setLikes(likesComment);
		ResponseEntity<Post> entityOne = restTemplate.postForEntity("http://localhost:8989/posts", post, Post.class);
		ResponseEntity<List> entity = restTemplate.getForEntity("http://localhost:8989/posts", List.class);
		model.addAttribute("posts", entity.getBody());
		return "PostDetails";
	}

	@RequestMapping("/getPostByPostId")
	public String getPostByPostId() {
		return "SearchByPost";
	}

	@RequestMapping("/searchByPostId")
	public String getPostById(@RequestParam("postId") Integer postId, Model model) {
		Post post = new Post();
		post.setPostId(postId);
		ResponseEntity<Post> post1 = restTemplate.getForEntity("http://localhost:8989/posts/?postId=" + postId,
				Post.class);
		model.addAttribute("post", post1.getBody());
		return "PostDetails";
	}

	@RequestMapping("/getPostByProfileId")
	public String getPostByProfileId() {
		return "SearchByProfile";
	}

	@RequestMapping("/searchByProfileId")
	public ModelAndView getPostByProfile(@RequestParam("profileId") Integer profileId) {
		List posts = restTemplate.getForObject("http://localhost:8989/posts/{profileId}", List.class, profileId);
		return new ModelAndView("PostDetails", "posts", posts);
	}

	@RequestMapping("/updatePost")
	public String update() {
		return "UpdateForm";
	}

	@RequestMapping("/searchByPostIdForUpdate")
	public String updateByPost(@RequestParam("postId") Integer postId, Model model) {
		post = new Post();
		post.setPostId(postId);
		ResponseEntity<Post> post1 = restTemplate.getForEntity("http://localhost:8989/posts/?postId=" + postId,
				Post.class);
		model.addAttribute("post", post1.getBody());
		return "UpdateDetails";
	}

	@RequestMapping("/updatePostForUpdate")
	public String updatePost(@RequestParam("postId") Integer postId,

			@RequestParam("profileId") Integer profileId, @RequestParam("status") String status,

			@RequestParam("url") String url,

			@RequestParam("likesProfileId") Integer likesProfileId,

			@RequestParam("commentProfileId") Integer commentProfileId, @RequestParam("comment") String comment

			, Model model) {

		// boolean isLikeProfileId=false;
		System.out.println("likeprofileId: " + likesProfileId);
		ResponseEntity<Post> updatePost = restTemplate.getForEntity("http://localhost:8989/posts/?postId=" + postId,
				Post.class);
		Post updatedPost = updatePost.getBody();
		System.out.println("nEW post object is: " + updatePost);
		System.out.println("nEW post object is: " + updatedPost.getLikes().getLikesProfileId());
		updatedPost.setPostId(postId);
		updatedPost.setProfileId(profileId);
		updatedPost.setStatus(status);
		updatedPost.setUrl(url);
		updatedPost.getComments().setComment(comment);
		List<Integer> ExistinglikesProfileId = updatedPost.getLikes().getLikesProfileId();
		System.out.println("before null" + ExistinglikesProfileId);
		if (likesProfileId == null) {
			updatedPost.getLikes().setLikesProfileId(ExistinglikesProfileId);
			// isLikeProfileId=true;
		} else {
			ExistinglikesProfileId.add(likesProfileId);
		}
		System.out.println("Existing list" + ExistinglikesProfileId);
		updatedPost.getLikes().setLikesProfileId(ExistinglikesProfileId);
		System.out.println("U post object is: " + updatedPost);

		Integer likes = ExistinglikesProfileId.size();
		updatedPost.getLikes().setLikes(likes);
		System.out.println("size of likes" + updatedPost.getLikes().getLikes());

		List<Integer> ExistingcommentsProfileId = updatedPost.getComments().getCommentProfileId();
		if (commentProfileId == null) {
			updatedPost.getComments().setCommentProfileId(ExistingcommentsProfileId);
		} else {
			ExistingcommentsProfileId.add(commentProfileId);
		}
		System.out.println("Existing list" + ExistingcommentsProfileId);
		updatedPost.getComments().setCommentProfileId(ExistingcommentsProfileId);
		System.out.println("U post object is: " + updatedPost);

		Integer likesComment = ExistingcommentsProfileId.size();
		updatedPost.getComments().setLikes(likesComment);
		System.out.println("size of likescomment" + updatedPost.getComments().getLikes());

		restTemplate.put("http://localhost:8989/posts/", updatedPost);
		model.addAttribute("post", updatedPost);
		return "PostDetails";

	}

	@RequestMapping("/deletePost")
	public String delete() {
		return "DeleteForm";
	}

	@RequestMapping("/deleteByPostId")
	public String deletePost(@RequestParam("postId") Integer postId) {
		restTemplate.delete("http://localhost:8989/posts/{postId}", postId);
		return "DisplayDelete";
	}
}
