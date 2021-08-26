package cn.jomoon.factory.core.io;


import cn.jomoon.factory.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ClassPathResource implements Resource{
    private final String path;
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        this.path = path;
        this.classLoader = classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();
    }



    @Override
    public InputStream getInputStream() throws IOException {
        final InputStream resourceAsStream = classLoader.getResourceAsStream(path);
        if (resourceAsStream == null) {
            throw new FileNotFoundException(this.path + " cannot be opened ");
        }
        return resourceAsStream;
    }
}
