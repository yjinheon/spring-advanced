package datamind.advanced.proxy.config;

import datamind.advanced.proxy.app.v1.*;
import datamind.advanced.proxy.app.v2.OrderControllerV2;
import datamind.advanced.proxy.app.v2.OrderRepositoryV2;
import datamind.advanced.proxy.app.v2.OrderServiceV2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// Bean을 등록한다는 것은 기본적으로는 의존성 주입을 받을 수 있게 해주는 것이며 Spring 이 관리하는 객체가 된다는 것이다.
// Spring Container 가 관리하는 객체가 되면 Spring 이 알아서 객체를 생성하고, 의존성 주입을 해준다.
@Configuration
public class AppV2Config {

    @Bean
    public OrderControllerV2 orderControllerV2() {
        return new OrderControllerV2(orderServiceV2());
    }

    @Bean
    public OrderServiceV2 orderServiceV2() {
        return new OrderServiceV2(orderRepositoeyV2());
    }

    @Bean
    public OrderRepositoryV2 orderRepositoeyV2() {
        return new OrderRepositoryV2();
    }
}
