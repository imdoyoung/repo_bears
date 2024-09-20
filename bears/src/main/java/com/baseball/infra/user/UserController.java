package com.baseball.infra.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	// SELECTLIST
	@RequestMapping(value="/xdm/v1/infra/user/userXdmList")
	public String userXdmList(Model model, UserVo userVo) {
		userVo.setShStartDate(userVo.getShStartDate() + " 00:00:00");
		userVo.setShEndDate(userVo.getShEndDate() + " 23:59:59");
		model.addAttribute("usrList", userService.usrSelectList(userVo));
		return "/xdm/v1/infra/user/userXdmList";
	}
	
	// FROM
	@RequestMapping(value="/xdm/v1/infra/user/userXdmForm")
	public String userXdmFrom() {
		return "/xdm/v1/infra/user/userXdmForm";
	}
	
	// INSERT
	@RequestMapping(value="/xdm/v1/infra/user/userXdmInst")
	public String userXdmInst(UserDto userDto) {
		userService.usrInsert(userDto);
		return "redirect:/xdm/v1/infra/user/userXdmList";
	}
	
	// MFOM
	@RequestMapping(value="/xdm/v1/infra/user/userXdmMfom")
	public String userXdmMfom(UserDto userDto, Model model) {
		model.addAttribute("usrItem", userService.usrSelectOne(userDto));
		return "/xdm/v1/infra/user/userXdmMfom";
	}
	
	// UPDATE
	@RequestMapping(value="/xdm/v1/infra/user/userXdmUpdt")
	public String userXdmUpdt(UserDto userDto) {
		userService.usrUpdate(userDto);
		return "redirect:/xdm/v1/infra/user/userXdmList";
	}
	
	// UELETE
	@RequestMapping(value="/xdm/v1/infra/user/userXdmUel")
	public String userXdmUel(UserDto userDto) {	 
		userService.usrUelete(userDto);
		return "redirect:/xdm/v1/infra/user/userXdmList";
	}
	
	// DELETE
	@RequestMapping(value="/xdm/v1/infra/user/userXdmDel")
	public String userXdmDel(UserDto userDto) {
		System.out.println("delete 확인~");
		userService.usrDelete(userDto);
		return "redirect:/xdm/v1/infra/user/userXdmList";
	}

}
