package simulator;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Main {


    private static final String USER_HOME = System.getProperty("user.home");

    private static File currentPath = new File(USER_HOME);

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("please input:");

        while (true) {
            String input = br.readLine();
            if (StringUtils.equals("exit", input)) {
                break;
            }

            if (StringUtils.equals(StringUtils.EMPTY, input)) {
                continue;
            }

            String[] params  = StringUtils.splitByWholeSeparator(input, null);
            String cmd = params[0];
            if (StringUtils.equals("cd", cmd)) {
                String path = params[1];

                if (!StringUtils.startsWith(path, File.separator) && !StringUtils.startsWith(path, "~")) {
                    path = currentPath.getPath() + File.separator + path;
                    path = FilenameUtils.normalize(path);
                }

                if (StringUtils.startsWith(path, "~")) {
                    path = path.replace("~", USER_HOME);//home path
                }

                File tmp = new File(path);//set path

                if (tmp.isDirectory()){
                    System.out.println(tmp.getPath());
                    currentPath = tmp;
                }else{
                    System.out.println(String.format("cd: %s No such file or directory", tmp.getPath()));
                }

            } else if (StringUtils.equals("ls", cmd)) {
                String[] files = currentPath.list();
                for (String currentFile : files) {
                    System.out.println(String.format("%s/%s", currentPath.getPath(),currentFile));
                }
            } else if (StringUtils.equals("pwd", cmd)) {
                System.out.println(currentPath.getPath());
            }

        }

    }

}
