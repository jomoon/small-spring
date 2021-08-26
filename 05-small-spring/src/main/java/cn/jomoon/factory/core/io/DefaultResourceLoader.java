package cn.jomoon.factory.core.io;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 最终在这个类中进行封装所有其他的类的相关信息
 */
public class DefaultResourceLoader implements ResourceLoader
{
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "location must not be null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }else {

            try {
                final URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}
