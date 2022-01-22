import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Config;
import domain.Subdomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.stream.Collectors;

public class JedisClient {
    private static Logger logger = LoggerFactory.getLogger(JedisClient.class);
    private Jedis jedis;
    private Config config;

    public JedisClient(Config config) {
        this.config = config;
        jedis = new Jedis();
    }

    public void exportContent() throws JsonProcessingException {
        if (config == null) {
            throw new NullPointerException("Config object cannot be null");
        } else {
            // Save domains to redis
            List<String> urls = config.getSubdomains().getSubdomains().stream()
                    .map(Subdomain::getUrl).collect(Collectors.toList());
            String subdomainsStr = new ObjectMapper().writeValueAsString(urls);
            jedis.set("subdomains", subdomainsStr);

            //  Save cookies to redis
            config.getCookies().getCookies().stream().forEach(cookie -> {
                jedis.set("cookie:" + cookie.getName() + ":" + cookie.getHost(), cookie.getValue());
            });
        }
    }

    public void printAllKeys() {
        logger.info("*** Keys stored in Redis ***");
        jedis.keys("*").forEach(key -> logger.info(key));
    }
}
