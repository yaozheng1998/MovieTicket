import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author YZ
 * @Date 2018/3/28
 * ribbon的配置类
 */
@Configuration
public class RibbonConfiguration {
    @Bean
    public IRule ribbonRule(){
        // 负载均衡规则，改为随机
        return new RandomRule();
    }
}
