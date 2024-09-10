package com.baseball.infra.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	// select
	@RequestMapping(value="/xdm/v1/infra/member/memberXdmList")
	public String memberXdmList(Model model) {
		model.addAttribute("list", memberService.selectMember());
		return "/xdm/v1/infra/member/memberXdmList";
	}
	
	// insert
		// form
	@RequestMapping(value="/xdm/v1/infra/member/memberXdmForm")
	public String memberXdmForm() {
		return "/xdm/v1/infra/member/memberXdmForm";
	}
	
		// insert
	@RequestMapping(value="/xdm/v1/infra/member/memberXdmInst")
	public String memberXdmInst(MemberDto memberDto) {
		memberService.insert(memberDto);
		return "redirect:/xdm/v1/infra/member/memberXdmList";
	}
	
	// update
		// MFom
	@RequestMapping(value="/xdm/v1/infra/member/memberXdmMfom")
	public String memberXdmMfom(MemberDto memberDto, Model model) {
		model.addAttribute("item", memberService.selectOne(memberDto));
		return "/xdm/v1/infra/member/memberXdmMfom";
	}
	
		// update
	@RequestMapping(value="/xdm/v1/infra/member/memberXdmUpdt")
	public String memberXdmUpdt(MemberDto memberDto) {
		memberService.update(memberDto);
		System.out.println("update 했다~");
		return "redirect:/xdm/v1/infra/member/memberXdmList";
	}
	

}
