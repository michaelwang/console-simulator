package simulator;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Inject;

public class Main {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new Module());
        LsCommand lsCommand = injector.getInstance(LsCommand.class);
        lsCommand.test();
    }

}
