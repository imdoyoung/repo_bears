package com.baseball.infra.shop;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.baseball.common.util.UtilDateTime;

@Service
public class ShopService {
	
	@Autowired
	ShopDao shopDao;
	
	@Autowired
	AmazonS3Client amazonS3Client;
	
	// 목록 - selectList
	public List<ShopDto> shopSelectList(ShopVo shopVo){
		return shopDao.shopSelectList(shopVo);
	}
	
	// 등록 - insert
	public int shopInsert(ShopDto shopDto, int type) throws Exception {
		
		for(int i=0; i<shopDto.getUploadFiles().length; i++) {
			
			// S3
			if(!shopDto.getUploadFiles()[i].isEmpty()) {
				
				String className = shopDto.getClass().getSimpleName().toString().toLowerCase();		
				String fileName = shopDto.getUploadFiles()[i].getOriginalFilename();
				String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
				String uuid = UUID.randomUUID().toString();
				String uuidFileName = uuid + "." + ext;
				String pathModule = className;
				String nowString = UtilDateTime.nowString();
				String pathDate = nowString.substring(0,4) + "/" + nowString.substring(5,7) + "/" + nowString.substring(8,10); 
				String path = pathModule + "/" + type + "/" + pathDate + "/";
//				String pathForView = Constants.UPLOADED_PATH_PREFIX_FOR_VIEW_LOCAL + "/" + pathModule + "/" + type + "/" + pathDate + "/";
				
				
		        ObjectMetadata metadata = new ObjectMetadata();
		        metadata.setContentLength(shopDto.getUploadFiles()[i].getSize());
		        metadata.setContentType(shopDto.getUploadFiles()[i].getContentType());
		        
		        amazonS3Client.putObject("lovelybears", path + uuidFileName, shopDto.getUploadFiles()[i].getInputStream(), metadata);
				
		        String objectUrl = amazonS3Client.getUrl("lovelybears", path + uuidFileName).toString();
		        System.out.println("objectUrl 확인 : "+ objectUrl);
		        shopDto.setNsfPath(objectUrl);
		        shopDto.setNsfOriginalName(fileName);
		        shopDto.setNsfUuidName(uuidFileName);
		        shopDto.setNsfExt(ext);
		        shopDto.setNsfSize(shopDto.getUploadFiles()[i].getSize());
				
//		        shopDto.setNsfTableName(tableName);
		        shopDto.setNsfType(type);
//				shopDto.setNsfDefaultNy();
//		        shopDto.setNsfSort(maxNumber + i);
		        shopDto.setNsfPseq(shopDto.getNsfPseq());		
				
		        shopDao.insertUploaded(shopDto);
			}
		}
		
		return shopDao.shopInsert(shopDto);
	}
	
	
	// 수정 - selectOne
	public ShopDto shopSelectOne(ShopDto shopDto) {
		return shopDao.shopSelectOne(shopDto);
	}
	
	// 수정 - update
	public int shopUpdate(ShopDto shopDto) {
		return shopDao.shopUpdate(shopDto);
	}
	
	// 삭제 - uelete
	public int shopUelete(ShopDto shopDto) {
		return shopDao.shopUelete(shopDto);
	}
	
	// 삭제 - delete
	public int shopDelete(ShopDto shopDto) {
		return shopDao.shopDelete(shopDto);
	}
	
	// 페이징 - selectOneCount
	public int shopSelectOneCount(ShopVo shopVo) {
		return shopDao.shopSelectOneCount(shopVo);
	}
	
	// 리뷰List - shopReviewSelectList
	public List<ShopDto> shopReviewSelectList(ShopDto shopDto){
		return shopDao.shopReviewSelectList(shopDto);
	}
	
	// 리뷰 - 별점 평균
	public ShopDto getAverageStar(ShopDto shopDto) {
		return shopDao.getAverageStar(shopDto);
	}
	
	// 메뉴목록 - shopMenuSelectList
	public List<ShopDto> shopMenuSelectList(ShopVo shopVo){
		return shopDao.shopMenuSelectList(shopVo);
	}
	
	// 페이징 - selectOneCount
	public int shopMenuSelectOneCount(ShopVo shopVo) {
		return shopDao.shopMenuSelectOneCount(shopVo);
	}
	
	// Shop-ShopMenu 연결 - selectListShop
	public List<ShopDto> selectListShop(){
		return shopDao.selectListShop();
	}
	
	// 등록 - insert
	public int shopMenuInsert(ShopDto shopDto) throws Exception {
		return shopDao.shopMenuInsert(shopDto);
	}
	
	// shopDetail에서 Menu 리스트 띄우기
	public List<ShopDto> menuSelectList(ShopDto shopDto){
		return shopDao.menuSelectList(shopDto);
	}
	
	// ===== booking ===== //
	// 예약 등록 - shopBookingInsert
	public int shopBookingInsert(ShopDto shopDto) {
		return shopDao.shopBookingInsert(shopDto);
	};
	public int shopBookingMenuInsert(ShopDto shopDto) {
		return shopDao.shopBookingMenuInsert(shopDto);
	};
	
	// ===== ShopPayment ===== //
	// booking+user 정보 출력
	public ShopDto paymentBookingSelectOne(ShopDto shopdto) {
		return shopDao.paymentBookingSelectOne(shopdto);
	};
	
	// bookingMenu+menu 정보 출력
	public List<ShopDto> paymentBookingMenuSelectList(ShopDto shopDto){
		return shopDao.paymentBookingMenuSelectList(shopDto);
	};
	
	// shop 정보 출력
	public ShopDto paymentShopSelectOne(ShopDto shopDto) {
		return shopDao.paymentShopSelectOne(shopDto);
	};
	
	// booking 정보 update
	public int bookingUpdate(ShopDto shopDto) {
		return shopDao.bookingUpdate(shopDto);
	};
	
	// usr메인페이지에서 예약 많은 순
	public List<ShopDto> bestBookingList(ShopDto shopDto){
		return shopDao.bestBookingList(shopDto);
	};
	
	// usr메인페이지에서 리뷰 리스트 출력
	public List<ShopDto> reviewList(ShopDto shopDto){
		return shopDao.reviewList(shopDto);
	};
	
	// usr 예약내역페이지 리스트 출력
	public List<ShopDto> userBookingSelectList(ShopVo shopVo) {
	    return shopDao.userBookingSelectList(shopVo);
	}
	
	// paging
	public int userBookingSelectOneCount(ShopVo shopVo) {
		return shopDao.userBookingSelectOneCount(shopVo);
	};
	
	// usr 예약내역 상세 페이지 출력
	public ShopDto userBookingDetailSelectOne(ShopDto shopDto) {
		return shopDao.userBookingDetailSelectOne(shopDto);
	};

	// shop 예약내역 상세 페이지 출력
	public ShopDto shopBookingDetailSelectOne(ShopDto shopDto) {
		return shopDao.shopBookingDetailSelectOne(shopDto);
	};

	// shop 예약내역 상세 페이지 출력
	public List<ShopDto> menuBookingDetailSelectList(ShopDto shopDto) {
		return shopDao.menuBookingDetailSelectList(shopDto);
	};
	
	// shop상세페이지 review insert
	public int reviewInsert(ShopDto shopDto) {
		return shopDao.reviewInsert(shopDto);
	};
}
