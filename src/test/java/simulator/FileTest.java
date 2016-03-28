package simulator;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.io.File;

/**
 * Created by wangzhenhua on 16/3/27.
 */
public class FileTest
{
    @Test
    public void  testFile(){
        File file = new File("/Users/wangzhenhua/software");
        if (file.isDirectory()){
            System.out.println("it's directory");
        }else{
            System.out.println("error ,it's not directory");
        }

        String path = "/User/wangzhenhua/software/../../photo";
        File testFile = new File(path);
        System.out.println(testFile.getPath() + testFile.isDirectory());

        String testPath = FilenameUtils.normalize(path);
        System.out.println(testPath);


        String homeTestPath = "/Users/wangzhenhua/Photo/../../Guest";
        System.out.println(FilenameUtils.normalize(homeTestPath));

        String pathWithWhiteSpace = "/Users/wangzhenhua/Public/Drop Box";
        //pathWithWhiteSpace = FilenameUtils.normalize(pathWithWhiteSpace);
        assert new File(pathWithWhiteSpace).isDirectory() == true;

        String cdWithWhiteSpace = "cd /Users/wangzhenhua/public/Drop Box";
        String[] inputArray = StringUtils.splitByWholeSeparator(cdWithWhiteSpace,null,2);
        assert "/Users/wangzhenhua/public/Drop Box".equals(inputArray[1]);
    }


}
