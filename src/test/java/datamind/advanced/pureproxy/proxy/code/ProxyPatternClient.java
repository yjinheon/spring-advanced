package datamind.advanced.pureproxy.proxy.code;

import datamind.advanced.pureproxy.proxy.code.Subject;

public class ProxyPatternClient {

    private Subject subject;

    public ProxyPatternClient(Subject subject) {
        this.subject = subject;
    }

    public void execute() {
        subject.operation();
    }
}
