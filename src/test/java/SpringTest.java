import com.spring.study.aware.AwareService;
import com.spring.study.config.BeanConfig;
import com.spring.study.task.AsyncTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BeanConfig.class})
public class SpringTest {
    @Resource
    private AwareService awareService;

    @Test
    public void test1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        AwareService awareService = context.getBean(AwareService.class);
        awareService.outputResult();
    }

    @Test
    public void test2(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        AsyncTask asyncTask = context.getBean(AsyncTask.class);
        for(int i = 0;i < 5;i++){
            asyncTask.executeAsyncTask(i);
            asyncTask.executeAsyncTaskPlus(i);
        }
    }

    @Test
    public void test3(){
        awareService.outputResult();
    }
}
