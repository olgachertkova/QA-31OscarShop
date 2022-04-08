package helpers;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> languageCheck(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"ru", "Выполнить"});
        list.add(new Object[]{"de", "Ausführen"});
        list.add(new Object[]{"en-gb", "Go"});

        return list.iterator();
    }


}
