package com.baseball.infra.kakaopay;

public class OrderCreateFormDto {

	private String name;       // 주문 상품 이름
    private int totalPrice;    // 총 결제 금액

    // 기본 생성자
    public OrderCreateFormDto() {}

    // 매개변수가 있는 생성자 (필요하면 추가)
    public OrderCreateFormDto(String name, int totalPrice) {
        this.name = name;
        this.totalPrice = totalPrice;
    }

    // Getter 메서드
    public String getName() {
        return name;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    // Setter 메서드
    public void setName(String name) {
        this.name = name;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }    
	
}
