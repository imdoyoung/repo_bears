package com.baseball.infra.codegroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baseball.common.util.UtilDateTime;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	public String codeGroupXdmList(@ModelAttribute("vo") CodeGroupVo codeGroupVo, Model model) throws IOException {
		
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
		
		// 공공데이터 REST API
		// 전체 데이터 가져오기
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1471000/CovidDagnsRgntProdExprtStusService/getCovidDagnsRgntProdExprtStusInq"); /*URL*/
//		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1471000/CovidDagnsRgntProdExprtStusService/getMmCovidDagnsRgntExprtStusInq"); /*URL*/
		urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=lEP%2BZgaHSqQAZ2T0lM%2BjBoe1sqgGebCsGYrS2jsOIzBKoK4kEssbeXwXDlAzRek2iTqlvPcrtiKYizBn1GVymg%3D%3D"); /*Service Key*/
		urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
		urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("3", "UTF-8")); /*한 페이지 결과 수*/
		urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*응답데이터 형식(xml/json) default : xml*/
		urlBuilder.append("&" + URLEncoder.encode("YYYY","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*년도*/
		urlBuilder.append("&" + URLEncoder.encode("MM","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*실적월*/
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
		    rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
		    sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());
		        
		// 원하는 데이터 뽑아오기
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode node = objectMapper.readTree(sb.toString());
				
		System.out.println("node.get(\"header\").get(\"resultCode\").asText(): " + node.get("header").get("resultCode").asText());
		System.out.println("node.get(\"header\").get(\"resultMsg\").asText(): " + node.get("header").get("resultMsg").asText());
		System.out.println("node.get(\"header\").get(\"resultMsg\").asText(): " + node.get("body").get("items").get(0).get("KIT_PROD_QTY").asText());
				
		
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
