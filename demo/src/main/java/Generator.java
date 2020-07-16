import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Generator {
    public static void main(String[] args){
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        String genCfg = "/generatorConfig.xml";
        String file = Generator.class.getResource(genCfg).getFile();
        try {
            file = URLDecoder.decode(file, "utf8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        File configFile = new File(file);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = null;
        try {
            config = cp.parseConfiguration(configFile);
        } catch (IOException | XMLParserException e) {
            e.printStackTrace();
        }
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = null;
        try {
            assert config != null;
            myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
        try {
            assert myBatisGenerator != null;
            myBatisGenerator.generate(null);
        } catch (SQLException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}