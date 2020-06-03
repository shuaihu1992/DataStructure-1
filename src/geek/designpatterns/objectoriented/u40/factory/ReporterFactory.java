package geek.designpatterns.objectoriented.u40.factory;


import geek.designpatterns.objectoriented.u40.Aggregator;
import geek.designpatterns.objectoriented.u40.reporter.ConsoleReporter;
import geek.designpatterns.objectoriented.u40.storage.MetricsStorage;
import geek.designpatterns.objectoriented.u40.viewer.ConsoleViewer;

/**
 * Created by HuGuodong on 1/31/20.
 */
public class ReporterFactory {


  public static ConsoleReporter createConsoleReporter(MetricsStorage storage) {
    Aggregator aggregator = new Aggregator();
    return new ConsoleReporter(new ConsoleViewer(), aggregator, storage);
  }


}
