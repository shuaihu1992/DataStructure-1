package geek.designpatterns.objectoriented.u40;

import geek.designpatterns.objectoriented.u40.reporter.ConsoleReporter;
import geek.designpatterns.objectoriented.u40.reporter.EmailReporter;
import geek.designpatterns.objectoriented.u40.storage.MetricsStorage;
import geek.designpatterns.objectoriented.u40.storage.RedisMetricsStorage;
import geek.designpatterns.objectoriented.u40.viewer.ConsoleViewer;
import geek.designpatterns.objectoriented.u40.viewer.EmailViewer;

/**
 * Created by HP on 2020/6/3.
 */
public class PerfCounterTest {
    public static void main(String[] args) {
        MetricsStorage storage = new RedisMetricsStorage();
        Aggregator aggregator = new Aggregator();
// 定时触发统计并将结果显示到终端
        ConsoleViewer consoleViewer = new ConsoleViewer();
        ConsoleReporter consoleReporter = new ConsoleReporter(consoleViewer, aggregator,storage);
        consoleReporter.startRepeatedReport(60, 60);
// 定时触发统计并将结果输出到邮件
        EmailViewer emailViewer = new EmailViewer();
        emailViewer.addToAddress("wangzheng@xzg.com");
        EmailReporter emailReporter = new EmailReporter(emailViewer, aggregator,storage);
// 收集接口访问数据
        MetricsCollector collector = new MetricsCollector(storage);
        collector.recordRequest(new RequestInfo("register", 123, 10234)); collector.recordRequest(new RequestInfo("register", 223, 11234)); collector.recordRequest(new RequestInfo("register", 323, 12334)); collector.recordRequest(new RequestInfo("login", 23, 12434)); collector.recordRequest(new RequestInfo("login", 1223, 14234));
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}