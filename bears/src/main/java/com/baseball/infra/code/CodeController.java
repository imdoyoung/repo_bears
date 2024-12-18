	package com.baseball.infra.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baseball.common.util.UtilDateTime;
import com.baseball.infra.codegroup.CodeGroupDto;
import com.baseball.infra.codegroup.CodeGroupService;

@Controller
public class CodeController {
	
	@Autowired
	CodeService codeService;
	@Autowired
	CodeGroupService codeGroupService;
	
	// selectList
	@RequestMapping(value="/xdm/v1/infra/code/codeXdmList")
	public String codeXdmList(@ModelAttribute("vo") CodeVo codeVo, Model model) {
		
		// 날짜
//		codeVo.setShcdDateStart(codeVo.getShcdDateStart() + " 00:00:00");
//		codeVo.setShcdDateEnd(codeVo.getShcdDateEnd() + " 23:59:59");
		// 초기값 세팅이 없는 경우 사용
		codeVo.setShcdDateStart(codeVo.getShcdDateStart() == null || codeVo.getShcdDateStart() == "" ? null : UtilDateTime.add00TimeString(codeVo.getShcdDateStart()));
		codeVo.setShcdDateEnd(codeVo.getShcdDateEnd() == null || codeVo.getShcdDateEnd() == "" ? null : UtilDateTime.add59TimeString(codeVo.getShcdDateEnd()));
		
		codeVo.setParamsPaging(codeService.selectOneCount(codeVo));
		if(codeVo.getTotalRows() > 0) {
			model.addAttribute("list", codeService.selectList(codeVo));
//			model.addAttribute("vo", codeVo);
		}
		
		return "xdm/v1/infra/code/codeXdmList";
	}

	// Form
	// code - codegroup 연결
	@RequestMapping(value="/xdm/v1/infra/code/codeXdmForm")
	public String codeXdmFom(Model model) {
		
		// 코드그룹 정보를 불러와야함
		List<CodeDto> codeGroups = codeService.selectListCodeGroup();
		
		// 불러온 코드그룹 정보를 codeXdmForm에 전달해주어야함
		model.addAttribute("listCodeGroup", codeService.selectListCodeGroup());
		
		return "xdm/v1/infra/code/codeXdmForm";
	}
	
	// Inst
	@RequestMapping(value="/xdm/v1/infra/code/codeXdmInst")
	public String codeXdmInst(CodeDto codeDto) {
		codeService.insert(codeDto);
		return "redirect:/xdm/v1/infra/code/codeXdmList";
	}
	
	// Mfom - selectOne
	@RequestMapping(value="/xdm/v1/infra/code/codeXdmMfom")
	public String codeXdmMfom(CodeDto codeDto, Model model) {
		
		// 코드의 정보를 codeXdmForm.html에 전달함
		model.addAttribute("item", codeService.selectOne(codeDto));
		
		// 코드그룹 정보를 불러와야함
		List<CodeDto> codeGroups = codeService.selectListCodeGroup();

		// 불러온 코드그룹 정보를 codeXdmForm.html에 전달함
		model.addAttribute("listCodeGroup", codeService.selectListCodeGroup());
		return "xdm/v1/infra/code/codeXdmMfom";
	}
	
	// Updt - update
	@RequestMapping(value="/xdm/v1/infra/code/codeXdmUpdt")
	public String codeXdmUpdt(CodeDto codeDto) {
		codeService.update(codeDto);
		return "redirect:/xdm/v1/infra/code/codeXdmList";
	}
	
	// Uel - uelete
	@RequestMapping(value="/xdm/v1/infra/code/codeXdmUel")
	public String codeXdmUel(CodeDto codeDto) {
		codeService.uelete(codeDto);
		return "redirect:/xdm/v1/infra/code/codeXdmList";
	}
	
	// Del - delete
	@RequestMapping(value="/xdm/v1/infra/code/codeXdmDel")
	public String codeXdmDel(CodeDto codeDto) {
		codeService.delet(codeDto);
		return "redirect:/xdm/v1/infra/code/codeXdmList";
	}
	
}
