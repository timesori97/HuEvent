package event;

import java.util.Scanner;

// 이벤트 관리 프로그램의 메인 클래스
public class Manager {
    // 최대 5개의 이벤트를 저장하는 Event 객체 배열
    Event[] EventList = new Event[5];
    // 최대 2개의 숨긴 이벤트를 저장하는 HideEvent 객체 배열
    HideEvent[] hideEvent = new HideEvent[2];
    // 사용자 입력을 받기 위한 Scanner 객체
    Scanner in = new Scanner(System.in);

    // 생성자: 프로그램 제목을 받아 초기화 및 메뉴 루프 실행
    Manager(String title) {
        // 프로그램 시작 메시지 출력
        System.out.println(title + "이벤트관리프로그램");
        // 새로운 Scanner 객체 생성 (클래스 필드 in과 중복)
        Scanner in = new Scanner(System.in);
        // 메뉴 선택을 반복하는 무한 루프
        while (true) {
            // 메뉴 출력
            menu();
            // 사용자에게 번호 입력 안내
            System.out.println("번호선택");
            // 입력된 번호 저장
            int k = in.nextInt();
            // 번호에 따라 해당 기능 호출
            if (k == 1) {
                add(); // 이벤트 추가
            } else if (k == 2) {
                alllist(); // 전체 이벤트 목록 보기
            } else if (k == 3) {
                update(); // 이벤트 수정
            } else if (k == 4) {
                delete(); // 이벤트 삭제
            } else if (k == 5) {
                hide(); // 숨긴 이벤트 보기
            }
        }
    }

    // 전체 이벤트 목록을 출력하는 메서드
    private void alllist() {
        // 기능 안내 메시지 출력
        System.out.println("전체보기 기능");
        // EventList 배열 순회
        for (int i = 0; i < EventList.length; i++) {
            // 이벤트가 null이 아닌 경우 이벤트 이름 출력
            if (EventList[i] != null) {
                System.out.println(EventList[i].EventN);
            }
        }
    }

    // 새로운 이벤트를 추가하는 메서드
    private void add() {
        // 기능 안내 메시지 출력
        System.out.println("추가");
        // 이벤트 이름 입력 안내
        System.out.println("이벤트를 입력하세요");
        // 사용자 입력 이벤트 이름 저장
        String EventN = in.nextLine();
        // 새로운 Event 객체 생성
        Event tempUser = new Event(EventN);
        // EventList 배열에서 빈 공간(null)을 찾아 이벤트 추가
        for (int i = 0; i < EventList.length; i++) {
            if (EventList[i] == null) {
                EventList[i] = tempUser;
                break;
            }
        }
    }

    // 메뉴를 출력하는 메서드
    private void menu() {
        // 메뉴 옵션 출력
        System.out.println("1.추가 2.전체보기 3.수정 4.삭제 4.숨긴이벤트 보기");
    }

    // 기존 이벤트를 수정하는 메서드
    private void update() {
        // 수정할 이벤트 이름 입력 안내
        System.out.println("수정할 이벤트를 입력하시오");
        // 사용자 입력 이벤트 이름 저장
        String saveEvent = in.nextLine();
        // 새로운 Event 객체 생성
        Event tempUser = new Event(saveEvent);
        // EventList 배열 순회
        for (int i = 0; i < EventList.length; i++) {
            // 입력한 이벤트 이름과 일치하는 이벤트 찾기
            if (EventList[i].EventN.equals(saveEvent) && EventList[i].EventN != null) {
                // 새 이벤트 이름 입력 안내
                System.out.println("새로 이벤트명를 입력하시오");
                // 새 이벤트 이름으로 tempUser 갱신
                tempUser.EventN = in.nextLine();
                // 기존 이벤트 대체
                EventList[i] = tempUser;
                break;
            } else if (EventList[i].EventN == null && !EventList[i].EventN.equals(saveEvent)) {
                // 이벤트가 없거나 이름이 일치하지 않는 경우 메시지 출력
                System.out.println("값이 없습니다");
            }
        }
    }

    // 이벤트를 삭제하는 메서드
    private void delete() {
        // 삭제할 이벤트 이름 입력 안내
        System.out.println("삭제할 이벤트를 입력하시오");
        // 사용자 입력 이벤트 이름 저장
        String saveEvent = in.nextLine();
        // 새로운 Event 객체 생성
        Event tempUser = new Event(saveEvent);
        // EventList 배열 순회
        for (int i = 0; i < EventList.length; i++) {
            // 입력한 이벤트 이름과 일치하는 이벤트 찾기
            if (EventList[i].EventN.equals(saveEvent) && EventList[i].EventN != null) {
                // 이벤트 이름 null로 설정하여 삭제
                EventList[i].EventN = null;
                break;
            } else if (EventList[i].EventN == null && !EventList[i].EventN.equals(saveEvent)) {
                // 이벤트가 없거나 이름이 일치하지 않는 경우 메시지 출력
                System.out.println("값이 없습니다");
            }
        }
    }

    // 숨긴 이벤트 목록을 출력하는 메서드
    private void hide() {
        // 숨긴 이벤트 배열 초기화 및 기본 이벤트 추가
        HideEvent hideEvent[] = { new HideEvent("자바"), new HideEvent("파이썬") };
        // 숨긴 이벤트 배열 순회
        for (int i = 0; i < hideEvent.length; i++) {
            // 숨긴 이벤트 이름 출력
            System.out.println(hideEvent[i].EventHN);
        }
    }
}