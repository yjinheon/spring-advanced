package datamind.advanced.pureproxy.proxy.code;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheProxy implements Subject {

    private Subject target; // real subject
    private String cacheValue;

    public CacheProxy(Subject target) {
        this.target = target;
    }

    @Override
    public String operation() {
        log.info("call proxy");
        if (cacheValue == null) {
            cacheValue = target.operation();
        }
        return cacheValue; // cacheValue 에 값이 있을 경우 실제 객체를 호충하지 않고 그대로 반환
      }
}
