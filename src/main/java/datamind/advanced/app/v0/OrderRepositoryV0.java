package datamind.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

// 컴포넌트 스캔

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV0 {

    public void save(String itemId) {
        // save logic
        if (itemId.equals("ex")) {
            throw new IllegalStateException("이미 존재하는 Order입니다.");
        }
        sleep(1000);
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace(); // printStackTrace()는 예외가 발생한 메서드의 호출 스택을 출력한다.
        }
    }
}
