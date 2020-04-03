package hh.swd20.bookstore2.webcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore2.domain.Friend;

@Controller
public class FriendController {

private List<Friend> friends = new ArrayList<Friend>();
	
	@RequestMapping(value = "/friendlist", method = RequestMethod.GET)
	public String getFriendList(Model model) {
		Friend friends = new Friend();
		model.addAttribute("friend", friends);
		return "friendlist";
	}
	
	@RequestMapping(value = "/friendlist", method = RequestMethod.POST)
	public String newFriend(@ModelAttribute Friend friend, Model model) {
		friends.add(friend);
		model.addAttribute("friends", friends);
		
		new Friend();
		model.addAttribute("friends", friends);
		
		return "friendlist";
	}
	
}
