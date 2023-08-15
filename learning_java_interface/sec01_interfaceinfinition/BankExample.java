public class BankExample {
    public static void main(String[] args) {
        
        Bank bank = new KBBank();
        bank.withDraw(100);
        bank.deposit(100);
        bank.findDormancyAccount("763231");
        Bank.BCAuth("KBBank");

        System.out.println("\n**********인스턴스 교체!!**********\n");
        
        bank = new SHBank();
        bank.withDraw(200);
        bank.deposit(200);
        bank.findDormancyAccount("4311");
        Bank.BCAuth("SHBank");
        
        System.out.println("\n**********카카오은행 연동 실패!!**********\n");
        
        /*
        * 호환성 불가로 인한 사용 불가
        bank = new KakaoBank();
        bank.withDraw(300);
        bank.deposit(300);
        bank.findDormancyAccount("4311");
        Bank.BCAuth("KakaoBank");
        */
        
        System.out.println("\n**********대학교 주은행 교체!!**********\n");

        bank = new KBBank();
        bank.withDraw(20000);
        bank.deposit(1000);
        bank.findDormancyAccount("855512");
        Bank.BCAuth("SHBank");

        /**
         * JAVA의 다형성을 극대화 하여 개발 코드 수정을 줄일 수 있다.
         * 
         * 만약 이 메인 함수가 특정 대학교에 등록금 인출, 입금 등의 업무와 관련있는 소스라 하자.
         * 대학교는 간혹 등록금 납부 주관 은행을 교체하기도 한다.
         * 물론 가상계좌를 통해 납입하지만 주은행을 변경하게 되면 대락교 등록금 납부 시스템에
         * 기존은행에서 교체할 은행으로 변경을 해줘야한다.
         */

         /* 결과
         KB은행만의 인출 로직...
         100 원을 인출한다.
         KB은행만의 입금 로직...100원을 입금한다.
         **금융개정법안 00이후 고객의 휴면계좌 찾아주기 운동**
         **금융결제원에서 제공하는 로직**
         KBBank에서 블록체인 인증을 요청합니다.
         전 금융사 공통 블록체인 로직 수행
         
         **********인스턴스 교체!!**********
         
         SH은행만의 인출 로직...
         200 원을 인출한다.
         SH은행만의 입금 로직...200 원을 입금한다.
         SH은행은 별도의 후행처리 작업을 따로 한다.
         **금융개정법안 00이후 고객의 휴면계좌 찾아주기 운동**
         *SH은행만의 로직 적용*
         SHBank에서 블록체인 인증을 요청합니다.
         전 금융사 공통 블록체인 로직 수행
         
         **********카카오은행 연동 실패!!**********
         
         
         **********대학교 주은행 교체!!**********
         
         KB은행만의 인출 로직...
         20000 원을 인출한다.
         KB은행만의 입금 로직...1000원을 입금한다.
         **금융개정법안 00이후 고객의 휴면계좌 찾아주기 운동**
         **금융결제원에서 제공하는 로직**
         SHBank에서 블록체인 인증을 요청합니다.
         전 금융사 공통 블록체인 로직 수행
          */
    }
}
