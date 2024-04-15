package datamind.advanced.proxy.app.v1;

import org.springframework.stereotype.Repository;


// 컴포넌트 스캔

@Repository
public class OrderRepositoryV1Impl implements OrderRepositoryV1 {

    @Override
    public void save(String itemId) {

        // save logic
        if (itemId.equals("ex"))

        {
            throw new IllegalStateException("Exception Occured");
        }
        sleep(1000);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
