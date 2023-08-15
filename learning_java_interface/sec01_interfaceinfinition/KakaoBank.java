public class KakaoBank {
    
    public void kakaoWithDraw(int price) {
        System.out.println("Kakao은행만의 인출 로직...");
        System.out.println(price + " 원을 인출한다.");
    }

    public void kakaoDeposit(int price) {
        System.out.println("Kakao은행만의 입금 로직...");
    }

    public void kakaoFindDormancyAccount() {
        System.out.println("Kakao은행만의 휴면계좌 찾아주기 로직");
    }

    /**
     * 인터페이스를 상속받지 않고 자신만의 메소드를 구현
     * 
     * 문제점 : 
     * - KB / SH은행과 다르게 금융결제원에서 제공해주는 어떠한 서비스도 사용할 수 없음
     * - 또한 호환성도 없으며 연동이 불가함
     */
}
