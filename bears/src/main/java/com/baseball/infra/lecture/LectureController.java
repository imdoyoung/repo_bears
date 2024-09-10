package com.baseball.infra.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LectureController {
	
	@Autowired
	LectureService lectureService;
	
	// select
		// List
	@RequestMapping(value="/xdm/v1/infra/lecture/lectureXdmList")
	public String lectureXdmList(Model model) {
		model.addAttribute("list", lectureService.selectLecture());
		return "/xdm/v1/infra/lecture/lectureXdmList";
	}
	
	// insert
		// form
	@RequestMapping(value="/xdm/v1/infra/lecture/lectureXdmForm")
	public String lectureXdmForm() {
		return "/xdm/v1/infra/lecture/lectureXdmForm";
	}
	
		// insert
	@RequestMapping(value="/xdm/v1/infra/lecture/lectureXdmInst")
	public String lectureXdmInst(LectureDto lectureDto) {
		lectureService.insert(lectureDto);
		return "redirect:/xdm/v1/infra/lecture/lectureXdmList";
	}
	
	// update
		// Mfom
	@RequestMapping(value="/xdm/v1/infra/lecture/lectureXdmMfom")
	public String lectureXdmMfom(LectureDto lectureDto, Model model) {
		model.addAttribute("item", lectureService.selectOne(lectureDto));
		return "/xdm/v1/infra/lecture/lectureXdmMfom";
	}
	
		// update
	@RequestMapping(value="/xdm/v1/infra/lecture/lectureXdmUpdt")
	public String lectureXdmUpdt(LectureDto lectureDto) {
		lectureService.update(lectureDto);
		return "redirect:/xdm/v1/infra/lecture/lectureXdmList";
	}

}
