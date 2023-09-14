package legacy;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import legacy.service.HelloService;

public class Main {

  HelloService helloService;

  public Main(HelloService helloService) {
    this.helloService = helloService;
  }

  public static void main(String[] args) {
    ConfigurableApplicationContext context //
        = new ClassPathXmlApplicationContext("main.xml");
    Main main = context.getBean("main", Main.class);
    main.execute();
    context.close();
  }

  public void execute() {
    helloService.sayHello();
  }
}
