package com.baseball.infra.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baseball.common.util.UtilDateTime;

@Controller
public class CodeGroupController {
	
	@Autowired
	CodeGroupService codeGroupService;
		
	// 방법1
//	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmList")
//	public String codeGroupXdmList(Model model) {
//		
//		List<CodeGroupDto> codeGroups = codeGroupService.selectList();
//		
//		System.out.println("codeGroups.size():" + codeGroups.size());
//		System.out.println("------------");
//		for(CodeGroupDto codeGroupDto : codeGroups) {
//			System.out.print(codeGroupDto.getIfcgSeq() + "|");
//			System.out.print(codeGroupDto.getIfcgName() + "|");
//			System.out.print(codeGroupDto.getIfcgUseNy() + "|");
//			System.out.print(codeGroupDto.getIfcgOrder() + "|");
//			System.out.print(codeGroupDto.getIfcgDesc() + "|");
//			System.out.print(codeGroupDto.getIfcgDelNy() + "|");
//			System.out.print(codeGroupDto.getIfcgRegist() + "|");
//			System.out.println(codeGroupDto.getIfcgEdit() + "|");
//		}
//		return "/xdm/v1/infra/codegroup/codeGroupXdmList";
//	}
	
	//	방법2
//	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmList")
//	public String codeGroupXdmList(Model model) {
//		
//		List<CodeGroupDto> codeGroups = codeGroupService.selectList();
//		
//		model.addAttribute("list", codeGroups);
//
//		return "/xdm/v1/infra/codegroup/codeGroupXdmList";
//	}

	// 방법3
	//LIST
	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmList")
	public String codeGroupXdmList(@ModelAttribute("vo") CodeGroupVo codeGroupVo, Model model) {
		
		// 날짜 필드에 시간 추가
//		codeGroupVo.setShDateStart(codeGroupVo.getShDateStart()+" 00:00:00");			
//		codeGroupVo.setShDateEnd(codeGroupVo.getShDateEnd()+" 23:59:59");			
		
		// 초기값 세팅이 없는 경우 사용
		codeGroupVo.setShDateStart(codeGroupVo.getShDateStart() == null || codeGroupVo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(codeGroupVo.getShDateStart()));
		codeGroupVo.setShDateEnd(codeGroupVo.getShDateEnd() == null || codeGroupVo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(codeGroupVo.getShDateEnd()));
		
		// paging
		codeGroupVo.setParamsPaging(codeGroupService.selectOneCount(codeGroupVo));
		System.out.println("StartRnumForMySql22: " + codeGroupVo.getStartRnumForMySql());
		
		if (codeGroupVo.getTotalRows() > 0) {
			model.addAttribute("list", codeGroupService.selectList(codeGroupVo));
//			model.addAttribute("vo", codeGroupVo);
		}
		
		return "/xdm/v1/infra/codegroup/codeGroupXdmList";
	}
	
	// Form
	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmForm")
	public String codeGroupXdmForm() {
		
		return "/xdm/v1/infra/codegroup/codeGroupXdmForm";
	}
	
	// INSERT
	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmInst")
	public String codeGroupXdmInst(CodeGroupDto codeGroupDto) {
		
//		System.out.println(codeGroupDto.getIfcgName());

		codeGroupService.insert(codeGroupDto);
		
		return "redirect:/xdm/v1/infra/codegroup/codeGroupXdmList";
	}
	
	// MfORM
//	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmMfom")
//	public String codeGroupXdmMfom(CodeGroupDto codeGroupDto, Model model) {
//		CodeGroupDto dto = codeGroupService.selectOne(codeGroupDto);
//		model.addAttribute("item", dto); // "html에서 쓸 변수명", 넘겨줄 객체
//		return "/xdm/v1/infra/codegroup/codeGroupXdmMfom";
//	}

	// MfORM
	// 축약형
	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmMfom")
	public String codeGroupXdmMfom(CodeGroupDto codeGroupDto, Model model) {
		model.addAttribute("item", codeGroupService.selectOne(codeGroupDto));
		return "/xdm/v1/infra/codegroup/codeGroupXdmMfom";
	}
	
	//UPDATE
	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmUpdt")
	public String codeGroupXdmUpdt(CodeGroupDto codeGroupDto) {
		codeGroupService.update(codeGroupDto);
		return "redirect:/xdm/v1/infra/codegroup/codeGroupXdmList";
	}
	
	// UELETE
	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmUel")
	public String codeGroupXdmUel(CodeGroupDto codeGroupDto) {
		codeGroupService.uelete(codeGroupDto);
		return "redirect:/xdm/v1/infra/codegroup/codeGroupXdmList";
	}
	
	// DELETE
	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmDel")
	public String codeGroupXdmDel(CodeGroupDto codeGroupDto) {
		codeGroupService.delete(codeGroupDto);
		return "redirect:/xdm/v1/infra/codegroup/codeGroupXdmList";
	}
	

	
}
